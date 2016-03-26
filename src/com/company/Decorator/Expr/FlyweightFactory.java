package com.company.Decorator.Expr;

import java.util.Hashtable;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 *
 * VarFactory for Variables.  The Flyweight pattern avoids duplication of new variables every time a
 * variable is encountered.  Instead, it checks if the variable is already present in a Hashtable
 * storage.  If so, it returns that already-constructed variable.
 */
public class FlyweightFactory {

    /**
     * Hashtable table stores the Variables that have already been constructed
     */
    static Hashtable varTable = new Hashtable();
    /**
     * A temporary variable used when we insert/extract from the table
     */
    private static Variable variable;

    /**
     * Singleton pattern for the factory
     */
    private FlyweightFactory() {}
    private static FlyweightFactory ourInstance;
    public static FlyweightFactory getInstance() {
        return ourInstance;
    }

    /**
     * Make pre-initialized Variable
     * @param name The Name of the variable
     * @return The variable (from the hash table, or newly constructed
     */
    public Variable makeVar(String name, int value) {
        variable = (Variable) varTable.get(name);
        if (variable == null) {
            variable = new Variable(name, value);
            varTable.put(name, variable);
        }
        return variable;
    }

    /**
     * Make uninitialized Variable
     * @param name The Name of the variable
     * @return The variable (from the hash table, or newly constructed
     */
    public static Variable makeVar(String name) {
        variable = (Variable) varTable.get(name);
        if (variable == null) {
            variable = new Variable(name, 0);
            varTable.put(name, variable);
        }
        return variable;
    }

    /**
     * Make a new literal value.
     * @param value
     * @return A literal Variable
     */
    public static Variable makeLit(int value) {
        String name = String.valueOf(value);
        variable = (Variable) varTable.get(name);
        if (variable == null) {
            variable = new Variable(name, value);
            varTable.put(name, variable);

        }
        return variable;
    }
}
