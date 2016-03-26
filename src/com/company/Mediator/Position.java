package com.company.Mediator;

import java.awt.*;

/**
 * @author Scott Fabini <sfabini@pdx.edu>
 * @since 3/10/16
 */
public class Position extends Canvas {
    private static Color [] colors = {Color.darkGray, Color.black, Color.white};
    private int state = 0;
    public static int first = 1;
    public static int second = 2;

    public void setState(int state) {
        this.state = state;
    }
    public void paint(Graphics g) {
        Color color = colors [state];
        g.setColor(color);
        g.fillOval(0,0,10,10);
        g.drawOval(0, 0, 10, 10);
    }
}
