package com.company.Flyweight;

import java.io.PrintStream;

/**
 * This is the Component of the Composite Pattern, where Compound [statement] is the Composite.
 * The Component declares the interface for objects in the Composition (print)
 * The Component implements any default behavior common to all classes (none)
 * @author Scott Fabini <sfabini@pdx.edu>
 */
public abstract class Statement {
    /**
     * Print interface for statements
     * @param printStream The output stream
     * @param indentLevel The indentation level for printing
     */
    public abstract void print(PrintStream printStream, int indentLevel);
}
