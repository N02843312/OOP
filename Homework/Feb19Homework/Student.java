//Brandon Walsh

import java.util.*;
public class Student
{
    private int id;
    private String dob;
    private String name;
    
    public Student(int id, String dob, String name)
    {
        this.id = id;
        this.dob = dob;
        this.name = name;
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getDob()
    {
        return dob;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String toString(){
        return "Name: "+ name + " ID: " + id + " DOB: "+dob +" \n";
    }
}