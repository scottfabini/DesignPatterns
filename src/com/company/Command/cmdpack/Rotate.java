package com.company.Command.cmdpack;

import com.company.Command.editor.Square;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 3/3/16
 */
public class Rotate extends Command {
    private int radians;
    public Rotate(int radians) { this.radians = radians; }
    public void doit(Square square) {
        square.rotate(radians);
    }
    public void undo(Square square) {
        square.rotate(-radians);
    }
    public String toString() { return "Rotate"; };
}
