package com.company.Adapter;

/**
 * Note: since these are static methods, we don't actually need the Adapter class.
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 3/15/16
 */
interface AdapterIF {
    static Matrix add (Matrix l, Matrix r) {
        return Matrix.plus(l, r);
    }
    static Matrix sub (Matrix l, Matrix r) {
        return Matrix.minus(l, r);
    }
    String toString();
}
