package com.company.GuardedSuspension;
import java.util.Random;

/**
 *  This class is an instructor-provided driver for a Guarded Suspension pattern exercise.
 *  It hosts a thread that simulates a machine that fills boxes
 *  of breakfast cereals.
 *  <P>
 *  The simulator drops an amount of cereals into the box at
 *  periodic intervals.  Both the amounts of cereals and the intervals
 *  are subject to small random variations. When the box is filled
 *  to nominal capacity, the drops end.
 *  <P>
 *  An overflow safety mechanism shutoffs the drops if the box
 *  amount exceeds a certain threshold.
 */
public class Client {
    // Constants
    private static final int minAmount = 20;
    private static final int maxAmount = 25;
    private static final int minDuration = 15;
    private static final int maxDuration = 20;
    // Filling simulation thread.
    private Filler filler = new Filler ();
    private Watcher watcher = new Watcher ();
    private Box object = new Box ();

    // Device to compute intervals and amounts with random variations
    private Random random = new Random ();
    private int random (int start, int end) {
        int tmp = Math.abs (random.nextInt ()) % (end - start) + start;
        return tmp;
    }

    private class Filler extends Thread {
        int amount = 0;
        int duration = 0;
        public synchronized void run() {
            synchronized(object) {
                while (!object.isFilled()) {
                    amount = object.getContent() + random(minAmount, maxAmount);
                    object.setContent(amount);
                    duration = object.getDuration() + random(minDuration, maxDuration);
                    object.setDuration(duration);

                    // We've filled the object slightly. Let's notify the watcher to check
                    object.notify();
                    try {
                        object.wait();
                    }
                    catch (InterruptedException e) { throw new RuntimeException("Filler interrupted"); }
                    // When we wake up, the Watcher might have updated the filled status
                }
                object.notify();
            }
        }
    }
    private class Watcher extends Thread {
        public synchronized void run() {
            synchronized(object) {
                // Continue watching until threshold exceeded, or object is filled
                while (object.getContent() < object.getThreshold() && !object.isFilled()) {
                    System.out.println("Content: " + object.getContent() + " Duration: " + object.getDuration());
                    if (object.getContent() > object.getNominal()) {
                        object.setFilled(true);
                    }
                    object.notify();
                    try {
                         object.wait();
                    }
                    catch (InterruptedException e) { throw new RuntimeException("Watcher interrupted"); }
                }
                // Shutoff control for overflowing box
                if (!object.isFilled()) {
                    System.out.println("Box overflow: Content: " + object.getContent() +
                            " Duration: " + object.getDuration());
                    object.setFilled(true);
                }
                // Box is full
                else {
                    System.out.println("Box filled: Content: " + object.getContent() +
                            " Duration: " + object.getDuration());
                }
                object.notify();
            }

        }
    }



    private void main () {
        watcher.start ();
        filler.start ();
    }

    /**
     *  Usual entry point.
     *  @param ignore Ditto
     */
    public static void main (String [] ignore) {
        (new Client ()).main ();
    }
}



