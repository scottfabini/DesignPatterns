package com.company.Command.cmdpack;

import com.company.Command.editor.Square;

import java.awt.*;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 3/3/16
 */
public class SetColor extends Command {
    private Color currentColor;
    private Color previousColor;
    public SetColor (Color color) { this.currentColor = color; }
    public void doit(Square square) {
        previousColor = square.getColor();
        square.setColor(currentColor);
    }
    public void undo(Square square) {
        square.setColor(previousColor);
    }
    public String toString() { return "SetColor"; };
}
