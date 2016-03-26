package com.company.Bridge;


/**
 * The bridge consists of an Abstraction and an Implementation.  This is the Abstraction of the collection.
 * The CollectionImplementation can be either an array or link list.
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 3/12/16
 */
public class AbstractCollection implements AbstractCollectionIF{
    private CollectionImplementation implementation;

   public AbstractCollection() {
       implementation = new ArrayImplementation();
   }

    /**
     * In hindsight, this insert method is highly implementation dependent.  The switching of
     * the underlying implementation should be done in the implementation.
     * TODO: switch the underlying implementation within the implementation class
     * @param data Data to insert
     */
    public void insert(int data) {
        // Switch the underlying implementation if array throws out of bounds exception
        try {
            implementation.push(data);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Switching Implementation from Array to LinkedList");
            implementation = new ListImplementation(implementation);
            implementation.push(data);
            return;
        }
    }
    public int remove() {
        return implementation.pop();

    }
    public int first() {
        return implementation.peek();
    }
    public boolean isEmpty() {
        return implementation.isEmpty();
    }

}
