package com.company.Visitor.Expr;

import com.company.Visitor.Visitor;

import java.io.PrintStream;

/**
 * Here we will construct Variables which
 * extend the Expr class.
 */
public class Variable extends Expr {
    /**
     * A variable has a String name, and a value
     */
    private String name;
    private int value;

    /**
     * Private default constructor
     */
    private Variable() {}

    /**
     * Initializing constructor for variables
     * @param name The name of the variable
     * @param value The int value of the variable
     */
    public Variable(String name, int value) {
        System.out.println("Constructing: " + name + "=" + value);
        this.name = name;
        this.value = value;
    }

    /**
     * Initializing constructor for literals
     * @param value The int value of the variable
     */
    public Variable(int value) {
        System.out.println("Constructing literal = " + value);
        this.name = String.valueOf(value);
        this.value = value;
    }
    public void print(PrintStream out) {
        out.print(name);
    }

    public int evaluate() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public Object accept(Visitor visitor, Integer integer) {
        return visitor.visit(this, integer);
    }
} // class Variable

