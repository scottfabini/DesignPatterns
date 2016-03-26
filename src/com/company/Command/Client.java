package com.company.Command;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.company.Command.cmdpack.*;
import com.company.Command.editor.*;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 3/2/16
 */


/**
 *  This applet schedules the execution of a predetermined sequence
 *  of commands for a trivial graphics editor. It hosts the editor,
 *  the command manager, and a thread to space commands in time.
 */
public class Client extends java.applet.Applet implements Runnable {
    private Command [] command = {
            new Translate(30, 30),
            new SetColor(Color.pink),
            new Rotate(30),
            new SetColor (Color.blue),
            new Undo(),
            new Redo (),
            new Translate (30, 0),
            new History()
    };
    private Editor editor = new Editor ();
    private CommandManager manager = new CommandManager (editor);
    private Thread thread;
    /** Initialize this applet. */
    public void init () {
        Frame mainFrame = new Frame("Java AWT Examples");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        mainFrame.add(editor);
        mainFrame.setVisible(true);
        // add (editor);
        thread = new Thread (this);
        thread.start ();
    }
    /** Execute the predetermined commands. */
    public void run () {
        for (int i = 0; i < command.length; i++) {
            manager.execute (command [i]);
            try { thread.sleep (2500); }
            catch (InterruptedException ok) {}
        }
    }
}
