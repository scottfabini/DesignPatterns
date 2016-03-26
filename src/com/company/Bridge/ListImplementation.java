package com.company.Bridge;

import java.util.LinkedList;

/**
 * The List implementation of the CollectionImplementation abstract class
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 3/12/16
 */
public class ListImplementation extends CollectionImplementation {
    LinkedList<Integer> list;

    public ListImplementation() {
        list = new LinkedList<>();
    }
    public ListImplementation(int data) {
        list = new LinkedList<>();
        list.add(data);
    }
    public ListImplementation(CollectionImplementation array) {
        list = new LinkedList<>();
        while (!array.isEmpty()) {
            list.addLast(array.pop());
        }
        array = null;
    }

    @Override
    public void push(int data) {
        list.push(data);
    }


    @Override
    public int pop() {
        return list.pop();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int peek() {
        return list.peekFirst();
    }

}
