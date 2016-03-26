package com.company.Iterator;

/**
 * Created by sfabini on 2/3/16.
 */
public class Leaf implements BinaryTree {
    public Integer root() { throw new RuntimeException(); }
    public BinaryTree right() { throw new RuntimeException(); }
    public BinaryTree left() { throw new RuntimeException(); }
    public boolean isLeaf() { return true; }
    public BinaryTree insert(int x) { return new Branch(x, new Leaf(), new Leaf()); }
    public void iterate (int block) { }
    public void print(int level) { return; }
}
