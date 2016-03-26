package com.company.Visitor.Statement;

import com.company.Visitor.Visitor;

import java.io.PrintStream;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 *
 * This is the Component of the Composite Pattern, where Compound [statement] is the Composite.
 * The Component declares the interface for objects in the Composition (print)
 * The Component implements any default behavior common to all classes (none)
 */
public abstract class Statement {
    /**
     * Print interface for statements
     * @param printStream The output stream
     * @param indentLevel The indentation level for printing
     */
    public abstract void print(PrintStream printStream, int indentLevel);
    public abstract int interpret();
    public Object accept(Visitor visitor, Integer integer) {
        return visitor.visit(this, integer);
    }
}
