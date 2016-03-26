package com.company.Iterator;

import java.util.Enumeration;

/**
 * Created by sfabini on 2/3/16.
 */
class Iterator implements Enumeration<Integer> {
    BinaryTree e;
    public Iterator(BinaryTree e) { this.e = e; }
    public boolean hasMoreElements() {
        if (e.left().isLeaf() && e.right().isLeaf()) {
            return false;}
        return true;
    }
    // dummy iterator.  still need to implement
    // need to track if we have already gone left
    public Integer nextElement() { return 0; }


}
