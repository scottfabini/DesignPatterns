package com.company.ObjectPool;

/**
 * Client for Object Pool Pattern
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 3/15/16
 */
public class Client {
    public static void main(String[] args) {
        ListIF list = new Nil();
        System.out.println(list);
        list = list.insert(1);
        System.out.println(list);
        list = list.insert(2);
        System.out.println(list);
        list = list.insert(3);
        System.out.println(list);
        list = list.insert(4);
        System.out.println(list);
        list = list.delete(3);
        System.out.println(list);
        list = list.delete(4);
        System.out.println(list);
        list = list.delete(2);
        System.out.println(list);
        list = list.delete(1);
        System.out.println(list);


    }
}
