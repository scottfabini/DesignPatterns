package com.company.Flyweight;

import java.util.Hashtable;

/**
 * VarFactory for Variables.  The Flyweight pattern avoids duplication of new variables every time a
 * variable is encountered.  Instead, it checks if the variable is already present in a Hashtable
 * storage.  If so, it returns that already-constructed variable.
 * @author Scott Fabini <sfabini@pdx.edu>
 *
 */
public class FlyweightFactory {

    /**
     * Hashtable table stores the Variables that have already been constructed
     */
    static Hashtable table = new Hashtable();
    /**
     * A temporary variable used when we insert/extract from the table
     */
    private static Variable variable;


    /**
     * The ConcreteFlyweight of the pattern.  Here we will construct Variables which
     * extend the Expr class.  These are defined in an internal class so users must use the factory
     * for construction of variables.
     */
    private static class Variable extends Expr {
        /**
         * A variable has a String name
         */
        String name;

        /**
         * Private default constructor
         */
        private Variable() {}

        /**
         * Private initializing constructor
         * TODO: Should a variable be a name and a value?
         * @param name The name of the variable
         */
        private Variable(String name) {
            System.out.println("Constructing: " + name);
            this.name = name;
        }

        /**
         * Implementation of Expr print()
         */
        public void print() {
            System.out.print(name);
        }

    } // class Variable

    /**
     * Singleton pattern for the factory
     */
    private FlyweightFactory() {}
    private static FlyweightFactory ourInstance;
    public static FlyweightFactory getInstance() {
        return ourInstance;

    }

    /**
     * Get the Variable from the Hashtable.  If it is not in the table, construct it and add it
     * @param s The Name of the variable
     * @return The variable (from the hash table, or newly constructed
     */
    public static Variable get(String s) {
        variable = (Variable) table.get(s);
        if (variable == null) {
            variable = new Variable(s);
            table.put(s, variable);
        }
        return variable;
    }
}
