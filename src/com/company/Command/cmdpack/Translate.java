package com.company.Command.cmdpack;

import com.company.Command.editor.Square;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 3/3/16
 */
public class Translate extends Command {
    private int x;
    private int y;
    public Translate (int x, int y) { this.x = x; this.y = y; }
    public void doit(Square square) {
        square.translate(x, y);
    }
    public void undo(Square square) {
        square.translate(-x, -y);
    }
    public String toString() { return "Translate"; };
}
