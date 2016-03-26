package com.company.Mediator;

import java.awt.*;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 3/10/16
 */
public class Board extends Panel {
    /** The number of position along the side of the board. */
    private static final int size = 8;
    private static final int gap = 1;
    private Position[] [] cell = new Position [size] [size];
    private static final Color dotColor = new Color(200, 200, 100);
    private static final int step = 10 + gap;

    public Board() {
        setBackground(Color.lightGray);
        setLayout (new GridLayout (size, size, gap, gap));
        for (int row = 0; row < size; row++)
            for (int col = 0; col < size; col ++) {
                Position p = new Position ();
                p.addMouseListener (new Mediator (cell, row, col));
                cell [row] [col] = p;
                add (p);
            }
        int center = size / 2;
        cell [center] [center-1] . setState (Position.first);
        cell [center-1] [center] . setState (Position.first);
        cell [center] [center] . setState (Position.second);
        cell [center-1] [center-1] . setState (Position.second);


    }

    public void paint(Graphics g) {
        g.setColor(dotColor);
        int hw = step * size;
        for (int row = 0; row <= size; row++) {
            int b = step * row;
            g.drawLine (b, 0, b, hw);
            g.drawLine (0, b, hw, b);
        }
        int p = gap - 1;
        int q = 2 * gap - 1;
        for (int row = 2; row <= 6; row += 4)
            for (int col = 2; col <= 6; col += 4) {
                g.fillRect (step * row - p, step * col - p, q, q);
            }
    }
}
