package com.company.Bridge;

/**
 * The array implementation of the CollectionImplementation abstract class
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 3/12/16
 */
public class ArrayImplementation extends CollectionImplementation {
    private Integer [] array;
    private static final int size = 5;
    private int top;

    public ArrayImplementation() {
        array = new Integer [size];
        for (int i = 0; i < size; ++i) {
            array[i] = null;
        }
        top = 0;
    }

    @Override
    public void push(int data) {
       if (top == size) { throw new ArrayIndexOutOfBoundsException();}
       else {
            array[top++] = data;
           //System.out.println("Push " + top + " ");
       }
    }

    @Override
    public int pop() {
        int temp;
        if (top == 0) { throw new IndexOutOfBoundsException(); }
        else {
            --top;
            //System.out.println("Pop " + top + " ");
            temp = array[top];
            array[top] = null;
        }
        return temp;

    }

    @Override
    public boolean isEmpty() {
        if (top == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int peek() {
        return array[top];
    }

    public int getSize() {
        return size;
    }
}
