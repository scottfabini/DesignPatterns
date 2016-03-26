package com.company.ObjectPool;

/**
 * A List is a recursive data structure.  A List is either a Nil, or
 * a Cons containing a data element and a List.
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 3/15/16
 */
interface ListIF {
    public ListIF insert(int object);
    public ListIF delete(int key);
    public boolean isNil();
    public String toString();
}
