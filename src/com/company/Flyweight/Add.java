package com.company.Flyweight;

/**
 * Addition operator consists of the addition of two values
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 2/16/16
 */
public class Add extends Expr {
    Expr left;
    Expr right;

    Add(Expr l, Expr r) {
        this.left = l;
        this.right = r;
    }
    public void print() {
        left.print();
        System.out.println(" + ");
        right.print();

    }
}
