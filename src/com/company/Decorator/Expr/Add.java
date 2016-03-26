package com.company.Decorator.Expr;

import com.company.Decorator.Expr.Expr;

import java.io.PrintStream;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 2/16/16
 *
 * Addition operator consists of the addition of two values
 * An evaluate method returns the value a+b.
 */
public class Add extends Expr {
    Expr left;
    Expr right;

    public Add(Expr left, Expr right) {
        this.left = left;
        this.right = right;
    }
    public void print(PrintStream out) {
        left.print(out);
        out.print(" + ");
        right.print(out);
    }
    public int evaluate() {
        return left.evaluate() + right.evaluate();
    }
}
