package com.company.ObjectPool;

/**
 * Cons class.  A cons is an element in a list that contains data
 * (as opposed to a Nil which is a Null Object pattern which contains no data)
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 3/15/16
 */
public class Cons implements ListIF {
    private int head; // the head data element
    private ListIF tail; // the rest of the list

    /**
     * Make default constructor private
     */
    private Cons() {}

    /**
     * Parameterized Constructor
     * @param head The element for this Cons
     */
    public Cons(int head) {
        this.head = head;
        tail = new Nil();
    }

    /**
     * Parameterized Constructor
     * @param head The element for this Cons
     * @param tail The next Cons/Nil in the list
     */
    public Cons(int head, ListIF tail) {
        this.head = head;
        this.tail = tail;
    }

    /**
     * Recursive insert into Cons
     * push current head to a new cons, and return this cons with
     * toInsert as the head element
     * @param toInsert the item to insert
     * @return this Cons
     */
    @Override
    public ListIF insert(int toInsert) {
        tail = new Cons(this.head, tail);
        this.head = toInsert;
        return this;
    }

    /**
     * Recursive delete
     * @param key if the key matches the head value, this Cons will be deleted
     * @return if key matches, return tail; else, return this cons
     */
    @Override
    public ListIF delete(int key) {
        if (this.head == key) {
            return tail;
        }
        else {
            tail = tail.delete(key);
        }
        return this;
    }

    /**
     * isNil predicate
     * @return false
     */
    @Override
    public boolean isNil() {
        return false;
    }

    /**
     * Convert Cons to string
     * @return String representation of this Cons and recursive tail Cons
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(head);
        sb.append(", ");
        sb.append(tail.toString());
        return sb.toString();
    }

}
