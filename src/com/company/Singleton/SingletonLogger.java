package com.company.Singleton;

import java.io.ObjectStreamException;
import java.util.logging.Logger;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 *
 * Singleton Logger
 */
public class SingletonLogger extends Logger {
    /**
     * The Singleton logger object.  Declared static to keep it single
     */
    private static SingletonLogger theInstance = new SingletonLogger("SingletonLogger", null);

    /**
     * Use getInstance to instantiate the singleton
     * @return The Singleton instance
     */
    public static SingletonLogger getInstance() { return theInstance;}

    /**
     * Private constructor prevents multiple object construction.
     * Use the getInstance to get the singleton.
     * Note: Logger has no defined default constructor to override
     * @param s
     * @param s1
     */
    private SingletonLogger(String s, String s1) { super(s, s1); }

    /**
     * Overriding readResolve prevents using Serializable to
     * bypass the Singleton pattern
     * @return the unserialized object
     * @throws ObjectStreamException
     */
    private Object readResolve() throws ObjectStreamException { return theInstance; }



}
