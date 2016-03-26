package com.company.Composite;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

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
    private List<Statement> statementList;

    /**
     * Compound statement constructor
     * @param args array of Statements of unspecified extent
     */
    public Compound(Statement... args) {
        statementList = new LinkedList<Statement>();
        for (Statement arg : args) {
            statementList.add(arg);
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
        for (int i = 0; i < statementList.size(); ++i) {
            // simple for loop through the list, since we haven't learned iterators yet.
            statementList.get(i).print(printStream, indentLevel + 1);
        }
        for (int i = 0; i < indentLevel; ++i) {
            System.out.print("  ");
        }
        System.out.println("end");
    }
}
