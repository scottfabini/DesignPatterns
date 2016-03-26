package com.company.Iterator;

/**
 * Created by sfabini on 2/3/16.
 */
public interface BinaryTree {
    Integer root();
    BinaryTree right();
    BinaryTree left();
    boolean isLeaf();
    // BinaryTree insert(Integer x);
    void iterate(int block);
    void print(int level);
    // Iterator createIterator();
}
