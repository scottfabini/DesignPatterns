package com.company.Visitor.Statement;

import com.company.Visitor.Expr.Expr;
import com.company.Visitor.Visitor;

import java.io.PrintStream;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 2/25/16
 */
public class Output extends Statement {
    private final Expr expr;

    // output only prints when interpret()'ed
    public void print(PrintStream printStream, int indentLevel) {
    }

    public Output(Expr expr) {
        this.expr = expr;
    }

    public int interpret() {
        expr.print(System.out);
        System.out.println(" := " + expr.evaluate());
        return 0;
    }


    public Object accept(Visitor visitor, Integer integer) {
        return visitor.visit(this, integer);
    }
}
