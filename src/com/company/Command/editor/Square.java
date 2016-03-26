package com.company.Command.editor;

import java.awt.*;

/**
 * Derived largely from Prof. Antoy's solution (since I'm new to java.awt)
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 3/2/16
 */
public class Square {
    private int x = 0;
    private int y = 0;
    private Color color = Color.black;
    private double radians = 0.0;
    private int side;

    /**
     * Construct a square with sides of length side
     * @param side The side of the square
     */
    public Square (int side) { this.side = side; }

    /**
     * Return this square
     * @return This square
     */
    public Square getSquare () { return this; }
    /**
     * Set the color of this square
     * @param color The color of this square
     */
    public void setColor (Color color) { this.color = color; }

    /**
     * Get the color of this square
     * @return The color of this square
     */
    public Color getColor () { return this.color; }

    /**
     * Move the origin by (dx, dy)
     * @param dx The change in x position
     * @param dy The change in y position
     */
    public void translate(int dx, int dy) { this.x += dx; this.y += dy; }

    /**
     * Rotate this square by radians
     * @param radians The rotation in radians
     */
    public void rotate (double radians) { this.radians += radians; }

    private int [] xarray = new int[4];
    private int [] yarray = new int[4];

    /**
     * Paint this square
     * @param g The graphics context
     */
    public void paint (Graphics g) {
        double cos = side * Math.cos (radians);
        double sin = side * Math.sin (radians);
        xarray [0] = x;
        yarray [0] = y;
        xarray [1] = (int) (x + cos);
        yarray [1] = (int) (y + sin);
        xarray [2] = (int) (xarray [1] - sin);
        yarray [2] = (int) (yarray [1] + cos);
        xarray [3] = (int) (x - sin);
        yarray [3] = (int) (y + cos);
        g.setColor (color);
        g.fillPolygon (xarray, yarray, 4);
        g.setColor (Color.black);
        g.drawPolygon (xarray, yarray, 4);
    }
}

