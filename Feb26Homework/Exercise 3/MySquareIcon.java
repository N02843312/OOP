//Brandon Walsh
//Exercise 1
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class MySquareIcon implements Icon
{
    private int side;

    public MySquareIcon(int n)
    {
        side = n;
    }

    public int getIconHeight()
    {
        return side;
    }

    public int getIconWidth()
    {
        return side;
    }

    public void paintIcon(Component c, Graphics g, int x, int y)
    {
        g.setColor(Color.BLUE);
        g.drawRect(x, y, side, side);
        g.fillRect(x, y, side, side);
    }
}
