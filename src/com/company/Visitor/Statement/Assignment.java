package com.company.Visitor.Statement;

import com.company.Visitor.Expr.Expr;
import com.company.Visitor.Expr.Variable;
import com.company.Visitor.Visitor;

import java.io.PrintStream;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 *
 * Assignment statement consists of an lvalue and rvalue.  Printed as "lvalue := rvalue;"
 */
public class Assignment extends Statement {
    /**
     * Assignment statement has a String lvalue corresponding to a Variable and an Expr rvalue
     */
    private Variable lvalue;
    private Expr rvalue;

    /**
     * Initializing constructor
     * @param lvalue String corresponding to the variable name
     * @param rvalue Expression on the RHS of the :=
     */
    public Assignment(Variable lvalue, Expr rvalue) {
        this.lvalue = lvalue;
        this.rvalue = rvalue;
    }

    /**
     * Print the assignment statement as "lvalue := rvalue;"
     * @param out The output stream
     * @param indentLevel The indentation level for printing
     */
    public void print(PrintStream out, int indentLevel) {
        for (int i = 0; i < indentLevel; ++i) {
            out.print("  ");
        }
        lvalue.print(out);
        out.print(" := ");
        rvalue.print(out);
        out.println(";");
    }

    public int interpret() {
        int evaluation = rvalue.evaluate();
        lvalue.setValue(evaluation);
        return evaluation;
    }

    public Object accept(Visitor visitor, Integer integer) {
        return visitor.visit(this, integer);
    }

}
