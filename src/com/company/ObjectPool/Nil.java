package com.company.ObjectPool;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 3/15/16
 */
public class Nil implements ListIF {
    public ListIF getNext() {
        return this;
    }

    public Nil() {
    }

    @Override
    public ListIF insert(int head) {
        return new Cons(head);
    }

    @Override
    public ListIF delete(int key) {
        return this;
    }

    @Override
    public boolean isNil() {
        return true;
    }

    @Override
    public String toString() {
        return "Λ";
    }
}
