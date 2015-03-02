//Brandon Walsh
import java.util.Comparator;

public class SortBySize implements Comparator<MySquareIcon>
{
    public int compare(MySquareIcon s1, MySquareIcon s2)
    {
        return s1.getIconWidth() - s2.getIconWidth();
    }
}
