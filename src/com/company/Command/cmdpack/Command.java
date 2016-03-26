package com.company.Command.cmdpack;

import com.company.Command.editor.Square;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 3/3/16
 */
public abstract class Command implements Cloneable {
    public abstract void doit(Square square);
    public abstract void undo(Square square);
    public Command() { }
    // shallow copy clone
    // if we had an array here, we would need to do a deep copy
    public Object clone() {
        Object o = null;
        try {
            // by calling the super clone, we make a chain that clones all of the base class objects as well
            o = super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new IllegalStateException ("Can't clone " + getClass().getName());
        }
        return o;
    }

}
