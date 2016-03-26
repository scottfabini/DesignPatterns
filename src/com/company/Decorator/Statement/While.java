package com.company.Decorator.Statement;

import com.company.Decorator.Expr.Expr;
import com.company.Decorator.Statement.Statement;

import java.io.PrintStream;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 *
 * While is a subclass of Statement.  It implements the print method of the Statement interface
 * A While statement consists of a conditional and a statement (which may be a compound statement (block))
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
     * @param out The output stream
     * @param indentLevel The indentation level for printing
     */
    public void print(PrintStream out, int indentLevel) {
        for (int i = 0; i < indentLevel; ++i) {
            out.print("  ");
        }
        out.print("while (");
        conditional.print(out);
        out.println(") do");
        statement.print(out, indentLevel+1);
    }

    /**
     * Evaluation of the expression
     * @return while returns 0
     */
    public int interpret() {
        int result = 0;
        while (this.conditional.evaluate() != 0) {
            result = this.statement.interpret();
        }
        return result;
    }
}
