package com.company.Iterator;

/**
 * Created by sfabini on 2/3/16.
 */
public class Branch implements BinaryTree {
   private Integer decoration;
   private BinaryTree left;
   private BinaryTree right;

   public Branch(Integer x, BinaryTree left, BinaryTree right) { decoration = x; this.left = left; this.right = right; }
   public Integer root() { return decoration; }
   public BinaryTree right() { return right; }
   public BinaryTree left() { return left; }
   public boolean isLeaf() { return false; }
   public BinaryTree insert(Integer x) {
      if (x < decoration) { left = new Branch(x, new Leaf(), new Leaf()); }
      else if (x > decoration) { right = new Branch(x, new Leaf(), new Leaf()); }
      return this;
   }
   public void iterate (int block) { }
   public void print (int level) {
      for (int i = 0; i < level; ++i) {
         System.out.print("   ");
      }
      System.out.println(decoration);
   }
}
