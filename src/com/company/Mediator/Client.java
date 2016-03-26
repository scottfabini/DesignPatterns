package com.company.Mediator;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 3/10/16
 */
public class Client extends Applet {
    public void init() {
        add (new Board());
        add (new Label("Black moves first"));
    }
    public static void main(String[] args) {
        Frame frame = new Frame("Othello");
        frame.setSize(400,400);
        frame.add(new Board());
        frame.add("South", new Label("Black moves first"));
        frame.show();
        frame.setResizable(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

    }
}
