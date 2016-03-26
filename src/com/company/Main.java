package com.company;
// Note: After studying Flyweight, I moved to making separate "Client" classes in each of the pattern.  The
// Client classes contain the main() definitions and are used for testing for all classes besides
// those imported below.

import com.company.Flyweight.flyweightDriver;
import com.company.Immutable.ImmutablePositionIF;
import com.company.Immutable.LoggerHandler;
import com.company.Immutable.Position;
import com.company.Singleton.SingletonLogger;
import com.company.AbstractFactory.abstractFactoryDriver;

import java.util.Scanner;
import java.util.logging.Level;


// Uncomment to select which Design Pattern to test
// TODO: refactor all of these test methods into their own Client classes


/**
 * Singleton, Immutable, AbstractFactory, and Flyweight test code
 */
public class Main {

    public static void main(String[] args) {
        // singletonLoggerMainTest();
        // mutableAndImmutablePositionTest();
        //abstractFactoryIFTest();
        //compositeDriver.main(args);
        flyweightDriver.main(args);
        //IteratorClient.main(args);

    }



    // Test Abstract Factory design pattern (AbstractFactoryIF)
    // Instantiate a User on an Economy plan (ids 1000-4999)
    // Instantiate a User on an Standard plan (ids 5000-9999)
    public static void abstractFactoryIFTest() {
        String [] absFactTest = new String [1];
        absFactTest[0] = new String("1001");
        abstractFactoryDriver.abstractFactoryIFTest(absFactTest);
        absFactTest[0] = new String("5001");
        abstractFactoryDriver.abstractFactoryIFTest(absFactTest);

    }

    public static void mutableAndImmutablePositionTest() {
        // Instantiate a mutable Position object and init to 0,0
        int x = 0;
        int y = 0;
        Position mutablePosition = new Position(x, y);
        // Naturally, we can use the setX and setY methods that we defined for the Position class
        mutablePosition.setX(1);
        mutablePosition.setY(2);

        // See that the key to using the interface is that our variable
        // is an ImmutablePositionIF, but it instantiates a full mutable Position object
        // but the methods that make the Position mutable are not accessible via the IF.
        ImmutablePositionIF immutablePosition = new Position(x, y);
        // Uncomment the two lines below to see the compiler errors
        // immutablePosition.setX(1);
        // immutablePosition.setY(2);

        // We see that using the setX and setY methods which are not part
        // of the ImmutablePositionIF leads to a compiler error

    }

    public static void singletonLoggerMainTest() {
        SingletonLogger myLogger = SingletonLogger.getInstance();
        myLogger.addHandler(new LoggerHandler());
        myLogger.setLevel(Level.ALL);
        int count = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("SingletonLoggerTest");
        System.out.println("Enter your data");
        System.out.println("<CTRL>-D to end input");
        System.out.println("This program will detect the number of lines containing a 3");
        do {
            if (sc.findInLine("3") != null) {
                System.out.println("3 detected");
                count++;
            }
            sc.nextLine();
        } while (sc.hasNext());
        myLogger.log(Level.ALL, "Number of 3s detected in file/input: " + count);
        sc.close();

    }
}


