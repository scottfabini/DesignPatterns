package com.company.Visitor.Expr;

import com.company.Visitor.Visitor;

import java.io.PrintStream;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 2/16/16
 *
 * < operator consists of the comparison
 * An evaluate method returns a 1 if true, 0 if false
 */
public class Gt extends Expr {
    Expr left;
    Expr right;

    public Gt(Expr left, Expr right) {
        this.left = left;
        this.right = right;
    }

    public void print(PrintStream out) {
        left.print(out);
        System.out.print(" > ");
        right.print(out);
    }

    public int evaluate() {
        return (left.evaluate() > right.evaluate()) ? 1 : 0;
    }
    public Object accept(Visitor visitor, Integer integer) {
        return visitor.visit(this, integer);
    }
}
