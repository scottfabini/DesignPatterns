package com.company.Composite;

import java.io.PrintStream;

/**
 * Created by sfabini on 1/26/16.
 * While statement prints while(expression) statement;
 */
public class While  extends Statement{
    Expr conditional;
    Statement statement;

    public While(Expr conditional, Statement statement) {
        this.conditional = conditional;
        this.statement = statement;
    }
    public void print(PrintStream printStream, int indentLevel) {
        for (int i = 0; i < indentLevel; ++i) {
            System.out.print("  ");
        }
        System.out.print("while (");
        conditional.print();
        System.out.println(") do");
        statement.print(printStream, indentLevel+1);
    }
}
