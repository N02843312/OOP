//Brandon Walsh
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class SquareTester
{
    public static void main(String[] args)
    {
        int arg0 = Integer.parseInt(args[0]);
        int arg1 = Integer.parseInt(args[1]);

        MySquareIcon m1 = new MySquareIcon(arg0);
        MySquareIcon m2 = new MySquareIcon(arg1);

        ArrayList<MySquareIcon> al = new ArrayList<MySquareIcon>();

        al.add(m1);
        al.add(m2);

        Collections.sort(al, new SortBySize());

        for (MySquareIcon m : al)
        {
            if(arg0 < arg1)
            {
                JOptionPane.showMessageDialog(null, "This icon is small with size " + arg0, "Small Icon", JOptionPane.INFORMATION_MESSAGE, m);
                JOptionPane.showMessageDialog(null, "This icon is large with size " + arg1, "Large Icon", JOptionPane.INFORMATION_MESSAGE, m);
                break;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "This icon is small with size " + arg1, "Small Icon", JOptionPane.INFORMATION_MESSAGE, m);
                JOptionPane.showMessageDialog(null, "This icon is large with size " + arg0, "Large Icon", JOptionPane.INFORMATION_MESSAGE, m);
                break;
            }

        }
    }
}
