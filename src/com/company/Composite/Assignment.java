package com.company.Composite;

import java.io.PrintStream;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 *
 * Assignment statement consists of an lvalue and rvalue.  Printed as "lvalue := rvalue;"
 */
public class Assignment extends Statement{
    /**
     * Assignment statement has a String lvalue corresponding to a Variable and an Expr rvalue
     */
    private String lvalue;
    private Expr rvalue;

    /**
     * Initializing constructor
     * @param lvalue String corresponding to the variable name
     * @param rvalue Expression on the RHS of the :=
     */
    public Assignment(String lvalue, Expr rvalue) {
        this.lvalue = lvalue;
        this.rvalue = rvalue;
    }

    /**
     * Print the assignment statement as "lvalue := rvalue;"
     * @param printStream The output stream
     * @param indentLevel The indentation level for printing
     */
    public void print(PrintStream printStream, int indentLevel) {
        for (int i = 0; i < indentLevel; ++i) {
            System.out.print("  ");
        }
        System.out.print(lvalue + " := ");
        rvalue.print();
        System.out.println(";");
    }

}
