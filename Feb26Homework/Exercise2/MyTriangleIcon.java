//Brandon Walsh
//Exercise 2
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class MyTriangleIcon implements Icon
{
    private int base;
    private int height;

    public MyTriangleIcon(int x)
    {
        base = x;
        height = x/2;
    }

    public int getIconHeight()
    {
        return height;
    }

    public int getIconWidth()
    {
        return base;
    }

    public void paintIcon(Component c, Graphics g, int x, int y)
    {
        Graphics2D g2 = (Graphics2D) g;
        int[] xCoor = {0, height, base};
        int[] yCoor = {base, 0, base};
        Polygon p = new Polygon(xCoor, yCoor, 3);
        g.setColor(Color.YELLOW);
        g2.fill(p);
    }
}
