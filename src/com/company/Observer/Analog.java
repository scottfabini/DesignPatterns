package com.company.Observer;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 2/29/16
 */
public class Analog implements Settable {
    int value = 0;
    public void setInt(int newValue) {
        this.value = newValue;
    }
}
