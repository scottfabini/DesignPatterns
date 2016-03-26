package com.company.Immutable;


/**
 * @author Scott Fabini
 * Concrete Immutable representing an (x,y) position pair
 * From [Grand] Patterns in Java Volume 1 (2nd Edition)
 */
public class Position implements ImmutablePositionIF{
    /**
     * x coordinate
     */
    private int x;

    /**
     * y coordinate
     */
    private int y;

    /**
     * Initializing constructor
     * @param x x coordinate
     * @param y y coordinate
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    } // constructor(int, int)

    /**
     * x getter
     * @return x coordinate
     */
    public int getX() { return x; }

    /**
     * y getter
     * @return y coordinate
     */
    public int getY() { return y; }

    /**
     * x setter
     * @param x
     */
    public void setX(int x) { this.x = x; }

    /**
     * y setter
     * @param y
     */
    public void setY(int y) { this.y = y; }

    /**
     * Change current position by adding the pair (xOffset, yOffset)
     * @param xOffset
     * @param yOffset
     * @return The updated position
     */
    public Position offset(int xOffset, int yOffset) {
        return new Position(x + xOffset, y + yOffset);
    } // offset(int, int)
} // class Position
