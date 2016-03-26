package com.company.Decorator.Expr;


import java.io.PrintStream;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 * Abstract class for Expr (Expressions)
 */
public abstract class Expr  {
    /**
     * Subclasses of Expr must implement the print() method
     */
    abstract public void print(PrintStream out);
    abstract public int evaluate();


}
