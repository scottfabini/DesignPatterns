package com.company.Flyweight;

import java.io.PrintStream;

/**
 * While is a subclass of Statement.  It implements the print method of the Statement interface
 * A While statement consists of a conditional and a statement (which may be a compound statement (block))
 * @author Scott Fabini <sfabini@pdx.edu>
 */
public class While  extends Statement {
    /**
     * conditional: The conditional expression of the while loop
     * statement: The statement (or compound statement) of the while loop
     */
    Expr conditional;
    Statement statement;

    /**
     * Initializing constructor
     * @param conditional The conditional expression
     * @param statement The statement (or compound statement)
     */
    public While(Expr conditional, Statement statement) {
        this.conditional = conditional;
        this.statement = statement;
    }

    /**
     * Print routine for a while statement
     * @param printStream The output stream
     * @param indentLevel The indentation level for printing
     */
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
