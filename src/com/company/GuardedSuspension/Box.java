package com.company.GuardedSuspension;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 3/7/16
 */
public class Box {
    // The box is full with 400 grams.
    private final int nominal = 400;
    // The threshold is 3% above nominal capacity
    private final int threshold = (int) (nominal * 1.03 + 0.5);
    // The current box content
    private int content;
    // True when box has been filled
    private boolean filled = false;
    // The duration of the filling
    private int duration = 0;

    public int getNominal() { return nominal; }
    public int getThreshold() {
        return threshold;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;

    }
    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
