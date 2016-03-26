package com.company.Visitor;

import com.company.Visitor.Expr.Expr;
import com.company.Visitor.Statement.Statement;

import java.io.PrintStream;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 2/25/16
 */
public class PrintVisitor implements Visitor{
    private PrintStream printStream;

    public PrintVisitor(PrintStream printStream) {
        this.printStream = printStream;
    }

    public Object visit(Statement statement, Integer integer) {
        statement.print(printStream, integer);
        return statement;

    }

    public Object visit(Expr expr, Integer integer) {
        expr.print(printStream);
        return expr;

    }

}
