package com.company.Bridge;

/**
 * The interface for the CollectionImplementation.
 * TODO: Can we convert this to an interface?  Appears so.
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 3/12/16
 */
public abstract class CollectionImplementation {
    public abstract void push(int data);
    public abstract int pop();
    public abstract int peek();
    public abstract boolean isEmpty();
}
