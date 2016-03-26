package com.company.Visitor;

import com.company.Visitor.Expr.Expr;
import com.company.Visitor.Statement.Statement;

import java.io.PrintStream;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 2/29/16
 */
public class InterpretVisitor implements Visitor {

    public InterpretVisitor() {
    }

    public Object visit(Statement statement, Integer integer) {
        return statement.interpret();

    }

    public Object visit(Expr expr, Integer integer) {
        return expr.evaluate();
    }
}
