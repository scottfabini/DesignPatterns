package com.company.Adapter;

/**
 * Adapter class adapts Matrix class methods (plus and minus) into what the client expects (add and sub)
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 3/15/16
 */
public class Adapter implements AdapterIF {

    public static Matrix add(Matrix l, Matrix r) {
        return Matrix.plus(l, r);

    }
    public static Matrix sub(Matrix l, Matrix r) {
        return Matrix.minus(l, r);
    }
}
