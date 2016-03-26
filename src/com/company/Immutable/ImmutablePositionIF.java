package com.company.Immutable;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 *
 * Interface for an immutable position object.
 * A position is an (x,y) coordinate pair
 *
 * We only use these to prove we get a compiler
 * error when we try to access them
 */
public interface ImmutablePositionIF {
    // Once this interface object has been instantiated, it has no methods to change the x,y position.
    // Thus, it is immutable

    /**
     * x coordinate
     * @return the x coordinate
     */
    public int getX();

    /**
     * y coordinate
     * @return the y coordinate
     */
    public int getY();
}
