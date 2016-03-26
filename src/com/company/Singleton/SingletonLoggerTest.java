package com.company.Singleton;

import com.company.Immutable.LoggerHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 *
 * Test framework for Singleton pattern
 */
public class SingletonLoggerTest {
    SingletonLogger myLogger = SingletonLogger.getInstance();

    @Before
    public void init() {
        myLogger.addHandler(new LoggerHandler());
        myLogger.setLevel(Level.ALL);
        Assert.assertTrue(myLogger.isLoggable(Level.ALL));
    }

    @Test
    public void testLoggerInit() {
        Assert.assertTrue(myLogger.getName().compareTo("SingletonLogger") == 0);
        Assert.assertTrue(myLogger.getResourceBundleName() == null);
    }
    @Test
    public void testReinstantiateSingleton() {
        myLogger = SingletonLogger.getInstance();
        Assert.assertTrue(myLogger.getName().compareTo("SingletonLogger") == 0);
        Assert.assertTrue(myLogger.getResourceBundleName() == null);
    }
    @Test
    public void basicTestLog() {
        myLogger.log(Level.ALL, "Level.ALL Log Message");
        myLogger.log(Level.FINE, "Level.FINE Log Message");
        // Confirm results in console output
    }
    @Test
    public void intermediateTestLog() {
        //String data = "Hello, World 3!\r\n";
        //InputStream stdin = System.in; // store original stdin
        //System.setIn(new ByteArrayInputStream(data.getBytes()));
        //Scanner sc = new Scanner(System.in);
        int count = 0;
        File file = new File("/home/sfabini/IdeaProjects/DesignPatterns/src/com/company/testDriverFile.txt");

        try {
            Scanner sc = new Scanner(file);
            //System.out.println(sc.nextLine());
            System.out.println("Begin Test");
            while (sc.hasNext()) {
                sc.next();
                if (sc.findInLine("3") != null) {
                    count++;
                }
            }
            myLogger.log(Level.ALL, "Number of 3s detected in file/input: " + count);
            sc.close();
        } catch (FileNotFoundException e) {
            System.err.println("File " + file.toString() + " not found.");
        }
        //System.setIn(null);
    }



        //Scanner sc = new Scanner(System.in);
}
