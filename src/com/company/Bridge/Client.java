package com.company.Bridge;

/**
 * A use of the Bridge pattern is to dynamically change the implementation of an object.
 * Design, code and test a stack with the following characteristics.
 * Initially, a stack is implemented by an array and, consequently, has a fixed size.
 * If there is a need to push an element on a full fixed-size stack,
 * the implementation of stack is replaced by a linked list and, consequently,
 * the stack becomes unbounded.
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 3/12/16
 */
public class Client {
    private static AbstractCollectionIF collection;

    public static void main(String[] args) {
        collection = new AbstractCollection();
        System.out.println();
        System.out.println("Bounds check: Stack fits in array");
        for (int i = 0; i < 5; i++) {
            collection.insert(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.print(collection.remove() + ", ");
        }
        System.out.println();
        System.out.println("Bounds check: Stack one greater than array size");
        for (int i = 0; i < 6; i++) {
            collection.insert(i);
        }
        for (int i = 0; i < 6; i++) {
            System.out.print(collection.remove() + ", ");
        }
        // reset the collection
        collection = new AbstractCollection();
        System.out.println();
        System.out.println("Big stack");
        for (int i = 0; i < 20; i++) {
            collection.insert(i);
        }
        for (int i = 0; i < 20; i++) {
            System.out.print(collection.remove() + ", ");
        }




    }

}
