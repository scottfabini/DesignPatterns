package com.company.Decorator.Expr;

import com.company.Decorator.Expr.Expr;

import java.io.PrintStream;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 2/16/16
 *
 * An example of a Decorator pattern.  This profile class
 * decorates the Expr class and measures the time it takes
 * to evaluate a given expression
 */
public class TimedDecorator extends Expr {
    Expr expr;

    public TimedDecorator(Expr expr) {
        this.expr = expr;
    }

    public void print(PrintStream out) {
        long begin = System.currentTimeMillis();
        expr.print(out);
        long end = System.currentTimeMillis();
        out.println("Expression evaluation time in ms: " +
                (end - begin));
    }
    public int evaluate() {
        long begin = System.currentTimeMillis();
        expr.print(System.out);
        long end = System.currentTimeMillis();
        System.out.println("Expression evaluation time in ms: " +
                (end - begin));
        return 0;
    }

}
