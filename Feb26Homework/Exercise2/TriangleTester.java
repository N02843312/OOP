//Brandon Walsh
//Exercise 1
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class TriangleTester
{
    public static void main(String[] args)
    {
        String[] buttons = {"Ok", "Cancel", "Retry"};
        MyTriangleIcon icn = new MyTriangleIcon(100);
        JOptionPane.showOptionDialog(null, "Click OK to Continue", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, icn, buttons, buttons[0]);
    }
}
