package com.company.Observer;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 2/29/16
 */
public class Observer implements java.beans.PropertyChangeListener{
    private Settable[] settable;

    public Observer(Settable [] settable) {
        this.settable = settable;
    }
    public void propertyChange(java.beans.PropertyChangeEvent evt) {
    }
}
