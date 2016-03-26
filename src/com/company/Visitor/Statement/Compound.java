package com.company.Visitor.Statement;

import com.company.Visitor.Visitor;

import java.io.PrintStream;
import java.util.Vector;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 *
 * It stores child components (Statements).  It implements child-related operations (print).
 * Compound statements print:
 * "begin
 *      <statements print>
 * end"
 * A Compound [statement] is the Composite of the Composite pattern.
 */
public class Compound extends Statement {
    /**
     * Compound statements represented as a list of statements
     */
    private Vector<Statement> statements;

    /**
     * Compound statement constructor
     * @param args array of Statements of unspecified extent
     */
    public Compound(Statement... args) {
        statements = new Vector<Statement>();
        for (Statement arg : args) {
            statements.add(arg);
        }
    }

    /**
     * Print to specified stream at specified indentation level
     * @param printStream the stream to output to
     * @param indentLevel the indentation level to print
     */
    public void print(PrintStream printStream, int indentLevel) {
        for (int i = 0; i < indentLevel; ++i) {
            System.out.print("  ");
        }
        System.out.println("begin:");
        for (int i = 0; i < statements.size(); ++i) {
            // simple for loop through the list, since we haven't learned iterators yet.
            statements.get(i).print(printStream, indentLevel + 1);
        }
        for (int i = 0; i < indentLevel; ++i) {
            System.out.print("  ");
        }
        System.out.println("end");
    }

    /**
     * Evaluate the compound statements in order
     * @return The evaluation result of the final expression
     */
    public int interpret() {
        int size = statements.size();
        for (int i = 0; i < (size-1); ++i) {
            statements.get(i).interpret();
        }
        return statements.get(size - 1).interpret();
    }

    public Object accept(Visitor visitor, Integer integer) {
        return visitor.visit(this, integer);
    }
}
