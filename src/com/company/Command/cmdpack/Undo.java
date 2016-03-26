package com.company.Command.cmdpack;

import com.company.Command.editor.Square;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 3/3/16
 */
public class Undo extends Command {
    public void doit(Square square) {
        throw new IllegalStateException (getClass().getName()+" doit called!");
    }
    public void undo(Square square) {
        throw new IllegalStateException (getClass().getName()+" undo called!");
    }
    public String toString() { return "Undo (stub)"; };

}
