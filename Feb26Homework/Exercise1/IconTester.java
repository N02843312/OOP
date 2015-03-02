//Brandon Walsh
//Exercise 1
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class IconTester
{
    public static void main(String[] args)
    {
        MySquareIcon icn = new MySquareIcon(20);
        JOptionPane.showMessageDialog(null, "Hello World!", "Message", JOptionPane.INFORMATION_MESSAGE, icn);
    }
}
