package com.company.Bridge;

/**
 * Interface for the collection abstraction
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 3/12/16
 */
public interface AbstractCollectionIF {
    void insert(int data);
    int remove();
    int first();
    boolean isEmpty();
}
