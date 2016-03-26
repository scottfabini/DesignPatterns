package com.company.Command.editor;

import java.awt.*;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 3/2/16
 */
public class Editor extends Panel {
    private Square square = new Square(25);
    private static final Dimension dim = new Dimension(300,300);

    public void paint(Graphics g) {
        square.paint(g);
    }

    public Square getSquare() {
        return square;
    }

    public Dimension getPreferredSize() { return dim; }
}
