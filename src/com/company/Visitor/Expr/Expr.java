package com.company.Visitor.Expr;


import com.company.Visitor.Visitor;

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
    public Object accept(Visitor visitor, Integer integer) {
        return visitor.visit(this, integer);
    }


}
