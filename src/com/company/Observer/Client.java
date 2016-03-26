package com.company.Observer;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 2/29/16
 */
public class Client extends java.applet.Applet {
    Client() {
        TextField textField = new TextField("0");
        JSlider jslider = new JSlider(0);
        PropertyChangeListener listener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

            }
        };
    }
    public void init() {

    }
    public static void main(String[] args) {

    }
}
