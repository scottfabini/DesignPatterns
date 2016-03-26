package com.company.Singleton;

import java.io.ObjectStreamException;

/**
 * Singleton Pattern
 */
public class Singleton  {
    /**
     * The singleton object
     */
    protected static Singleton theInstance = new Singleton();

    /**
     * The instantiator for the object
     * @return the Singleton object
     */
    public static Singleton getInstance() { return theInstance;}

    /**
     * protected/private constructor to prevent instantiation
     * use getInstance() to instantiate
     */
    protected Singleton() {}

    /**
     * Overriding readResolve needed to prevent Serializing the
     * class to bypass the Singleton pattern
     * @return the unserialized object
     * @throws ObjectStreamException
     */
    private Object readResolve() throws ObjectStreamException { return theInstance; }

}
