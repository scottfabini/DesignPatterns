package com.company.Mediator;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A very basic mediator that changes cells to white (setState(2)) when clicked
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 3/10/16
 */
public class Mediator extends MouseAdapter{
    private Position [] [] cell;
    private int row;
    private int column;
    public Mediator(Position [][] cell, int row, int column) {
        this.cell = cell;
        this.row = row;
        this.column = column;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        super.mouseClicked(mouseEvent);
        cell[row][column].setState(2);
        cell[row][column].repaint();
    }
}
