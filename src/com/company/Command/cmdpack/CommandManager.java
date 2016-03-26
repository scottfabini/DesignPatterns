package com.company.Command.cmdpack;

import com.company.Command.editor.Editor;
import com.company.Command.editor.Square;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 3/3/16
 */
public class CommandManager {
    Editor editor;
    private static final int maxHistory = 10;
    private static int historyCount = 0;
    private Command [] history = new Command [maxHistory];

    public CommandManager(Editor editor) { this.editor = editor; }
    public void execute (Command command) {
        System.out.println("Command: " + command);
        Square square = editor.getSquare();
        if (command instanceof History) {
            for (int i = 0; i < historyCount; ++i) {
                System.out.print(i + ": " + history[i] + ", ");
            }
        }
        else if (command instanceof Undo) {

        }
        else if (command instanceof Redo) {

        }
        else {
            // limited to 10 history.
            // TODO: convert to circular buffer
            if (historyCount < maxHistory)
                history[historyCount++] = command;
            command.doit(square);
            editor.repaint();

        }
    }

}
