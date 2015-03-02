//Brandon Walsh

import java.util.*;
public class SortByDob implements Comparator<Student>
{
    public int compare(Student s1, Student s2)
    {
        return s1.getDob().compareTo(s2.getDob());
    }
}