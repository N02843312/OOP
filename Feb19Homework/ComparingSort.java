//Brandon Walsh
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class ComparingSort
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<Student> al = new ArrayList<Student>();
        
        try
		{
			Scanner inFile = new Scanner(new File("textfile.txt"));
			while(inFile.hasNextLine())
            {
                String lineText = inFile.nextLine();
                
                String dob = lineText.substring(0, lineText.indexOf(", "));    //get dob from string
                lineText = lineText.substring(lineText.indexOf(" ") + 1, lineText.length());  //chop off dob and first comma
                String name = lineText.substring(0, lineText.indexOf(", "));  //get name from string
                lineText = lineText.substring(lineText.indexOf(",") + 2, lineText.length());  //chop off name and final comma (leaving just the int)
                int id = Integer.parseInt(lineText);    //convert string to int

                Student s = new Student(id, dob, name); 
                al.add(s);
            }
		}
		catch(IOException e)
		{
			System.out.println("Error: " + e.getMessage());
		}
        
        System.out.println("Original: ");   
        System.out.println(al); //print original
        
        System.out.println("----------------------");
        
        System.out.println("By Id: ");
        Collections.sort(al, new SortById());   //sory by Id
        System.out.println(al); //print sorted by Id
        
        System.out.println("----------------------");
        
        System.out.println("By Name: ");
        Collections.sort(al, new SortByName());   //sory by name
        System.out.println(al); //print sorted by name
        
        System.out.println("----------------------");
        
        System.out.println("By Dob: ");
        Collections.sort(al, new SortByDob());   //sory by name
        System.out.println(al); //print sorted by name
    }
}

/*

Searching by dob is a little wonky, but it's good enough and works for the most part.  

Original: 
[Name: Otto Guthrie ID: 64 DOB: 1956-12-5 
, Name: Kaden Mcmillan ID: 56 DOB: 1983-9-19 
, Name: Aristotle Garrison ID: 12 DOB: 1970-4-10 
, Name: Martin Travis ID: 51 DOB: 1971-10-11 
, Name: Maxwell Gamble ID: 49 DOB: 1971-4-22 
, Name: Stephanie Hogan ID: 9 DOB: 1969-10-24 
, Name: Glenna York ID: 13 DOB: 1963-6-4 
, Name: Jordan Nixon ID: 62 DOB: 1987-3-5 
, Name: Kieran Lang ID: 31 DOB: 1974-1-18 
, Name: Alexis Heath ID: 70 DOB: 1956-3-20 
, Name: Aladdin Cherry ID: 8 DOB: 1987-2-22 
, Name: Baxter Christian ID: 77 DOB: 1967-8-13 
, Name: Eden Pierce ID: 3 DOB: 1975-2-12 
, Name: Genevieve Hamilton ID: 18 DOB: 1950-8-17 
, Name: Aretha Bullock ID: 58 DOB: 1954-6-18 
, Name: Vivien Thornton ID: 74 DOB: 1987-4-13 
, Name: Clark Burnett ID: 87 DOB: 1950-12-4 
, Name: Britanni Cantrell ID: 14 DOB: 1951-3-5 
, Name: MacKenzie Oneal ID: 90 DOB: 1966-12-21 
, Name: Ulysses Bush ID: 11 DOB: 1980-5-9 
, Name: Uma Moon ID: 72 DOB: 1950-10-26 
, Name: Inez Gentry ID: 26 DOB: 1951-6-29 
, Name: Hayden Butler ID: 1 DOB: 1960-7-3 
, Name: Malachi Lynch ID: 17 DOB: 1967-7-4 
, Name: Laurel Burris ID: 43 DOB: 1955-2-5 
, Name: Lionel Sexton ID: 53 DOB: 1967-4-20 
, Name: Germaine Sears ID: 42 DOB: 1983-3-9 
, Name: Clark Franklin ID: 65 DOB: 1961-4-22 
, Name: Maile Pittman ID: 97 DOB: 1964-6-13 
, Name: Rhoda Pratt ID: 61 DOB: 1968-10-8 
, Name: Ciaran Rodriquez ID: 57 DOB: 1987-5-3 
, Name: Grady Cooke ID: 79 DOB: 1950-1-22 
, Name: Iris Mccarty ID: 63 DOB: 1954-11-28 
, Name: Jessamine Colon ID: 100 DOB: 1964-8-19 
, Name: Leroy Pickett ID: 45 DOB: 1970-1-25 
, Name: Shaeleigh Nelson ID: 6 DOB: 1968-5-19 
, Name: Lysandra Rodgers ID: 4 DOB: 1970-3-29 
, Name: Travis Barnes ID: 86 DOB: 1984-5-18 
, Name: Jeanette Mcmillan ID: 33 DOB: 1969-10-23 
, Name: India Larson ID: 15 DOB: 1977-6-13 
, Name: Tobias Wells ID: 40 DOB: 1988-5-4 
, Name: Kenyon Paul ID: 81 DOB: 1963-1-7 
, Name: Lucy Morin ID: 98 DOB: 1985-11-4 
, Name: Aaron Hogan ID: 27 DOB: 1968-6-23 
, Name: Ann Carrillo ID: 37 DOB: 1982-3-3 
, Name: Isaiah Blankenship ID: 2 DOB: 1975-10-24 
, Name: Dante Tucker ID: 41 DOB: 1978-2-30 
, Name: Matthew Gray ID: 92 DOB: 1952-2-24 
, Name: Imani Miller ID: 96 DOB: 1958-9-27 
, Name: Theodore Young ID: 29 DOB: 1973-10-7 
, Name: David Farmer ID: 91 DOB: 1961-4-9 
, Name: Cody Bauer ID: 67 DOB: 1990-6-27 
, Name: Fatima Pace ID: 5 DOB: 1972-8-10 
, Name: Fuller Savage ID: 99 DOB: 1972-3-7 
, Name: Lael Simpson ID: 93 DOB: 1968-5-7 
, Name: Jaquelyn Combs ID: 68 DOB: 1964-5-17 
, Name: Denise Conrad ID: 82 DOB: 1973-2-24 
, Name: Denise Johns ID: 22 DOB: 1976-10-3 
, Name: Mallory Fitzpatrick ID: 80 DOB: 1986-5-2 
, Name: Andrew Rocha ID: 95 DOB: 1986-9-1 
, Name: Harding Banks ID: 52 DOB: 1989-11-8 
, Name: Hedley Salas ID: 76 DOB: 1985-7-25 
, Name: Karen Dean ID: 24 DOB: 1979-8-14 
, Name: Oscar Morrison ID: 30 DOB: 1976-5-15 
, Name: Cadman Hodges ID: 44 DOB: 1950-12-18 
, Name: Reuben Walters ID: 84 DOB: 1980-10-12 
, Name: Brenden Rowland ID: 10 DOB: 1990-2-26 
, Name: Rajah Hunter ID: 60 DOB: 1979-1-25 
, Name: Althea Ellis ID: 19 DOB: 1974-12-6 
, Name: Avye Le ID: 75 DOB: 1956-1-9 
, Name: Judith Marquez ID: 85 DOB: 1956-11-28 
, Name: Preston Fields ID: 35 DOB: 1950-7-21 
, Name: Rogan Best ID: 71 DOB: 1989-6-3 
, Name: Jade Sutton ID: 36 DOB: 1972-1-17 
, Name: Tyler Alexander ID: 94 DOB: 1961-4-5 
, Name: Yoshi Blackburn ID: 25 DOB: 1979-3-6 
, Name: Pascale Cohen ID: 73 DOB: 1950-11-7 
, Name: Louis Stark ID: 59 DOB: 1988-8-14 
, Name: Erich Barrera ID: 34 DOB: 1963-6-6 
, Name: Emerson Parrish ID: 69 DOB: 1966-4-12 
, Name: Darius Kramer ID: 39 DOB: 1964-5-16 
, Name: Ashely Sosa ID: 55 DOB: 1977-11-28 
, Name: Jena Navarro ID: 83 DOB: 1971-4-3 
, Name: Lisandra Mcclain ID: 88 DOB: 1980-9-20 
, Name: Madeline Mann ID: 32 DOB: 1959-4-2 
, Name: Fatima Leblanc ID: 54 DOB: 1988-9-13 
, Name: Phoebe Gardner ID: 50 DOB: 1980-10-1 
, Name: Irene Cote ID: 78 DOB: 1970-10-19 
, Name: Aretha Cotton ID: 16 DOB: 1955-2-15 
, Name: Cameron Blair ID: 23 DOB: 1969-3-18 
, Name: Mariam Leonard ID: 7 DOB: 1963-11-28 
, Name: Xantha Conway ID: 89 DOB: 1951-7-30 
, Name: Carter Carver ID: 20 DOB: 1953-2-25 
, Name: Macaulay Nicholson ID: 48 DOB: 1965-4-23 
, Name: Lesley Collins ID: 46 DOB: 1969-1-7 
, Name: Uriah Dunlap ID: 28 DOB: 1974-6-4 
, Name: Cullen Tyler ID: 21 DOB: 1961-11-30 
, Name: Paul Cross ID: 47 DOB: 1966-1-21 
, Name: Cynthia Christian ID: 38 DOB: 1959-9-1 
, Name: Tobias Dorsey ID: 66 DOB: 1976-5-25 
]
----------------------
By Id: 
[Name: Hayden Butler ID: 1 DOB: 1960-7-3 
, Name: Isaiah Blankenship ID: 2 DOB: 1975-10-24 
, Name: Eden Pierce ID: 3 DOB: 1975-2-12 
, Name: Lysandra Rodgers ID: 4 DOB: 1970-3-29 
, Name: Fatima Pace ID: 5 DOB: 1972-8-10 
, Name: Shaeleigh Nelson ID: 6 DOB: 1968-5-19 
, Name: Mariam Leonard ID: 7 DOB: 1963-11-28 
, Name: Aladdin Cherry ID: 8 DOB: 1987-2-22 
, Name: Stephanie Hogan ID: 9 DOB: 1969-10-24 
, Name: Brenden Rowland ID: 10 DOB: 1990-2-26 
, Name: Ulysses Bush ID: 11 DOB: 1980-5-9 
, Name: Aristotle Garrison ID: 12 DOB: 1970-4-10 
, Name: Glenna York ID: 13 DOB: 1963-6-4 
, Name: Britanni Cantrell ID: 14 DOB: 1951-3-5 
, Name: India Larson ID: 15 DOB: 1977-6-13 
, Name: Aretha Cotton ID: 16 DOB: 1955-2-15 
, Name: Malachi Lynch ID: 17 DOB: 1967-7-4 
, Name: Genevieve Hamilton ID: 18 DOB: 1950-8-17 
, Name: Althea Ellis ID: 19 DOB: 1974-12-6 
, Name: Carter Carver ID: 20 DOB: 1953-2-25 
, Name: Cullen Tyler ID: 21 DOB: 1961-11-30 
, Name: Denise Johns ID: 22 DOB: 1976-10-3 
, Name: Cameron Blair ID: 23 DOB: 1969-3-18 
, Name: Karen Dean ID: 24 DOB: 1979-8-14 
, Name: Yoshi Blackburn ID: 25 DOB: 1979-3-6 
, Name: Inez Gentry ID: 26 DOB: 1951-6-29 
, Name: Aaron Hogan ID: 27 DOB: 1968-6-23 
, Name: Uriah Dunlap ID: 28 DOB: 1974-6-4 
, Name: Theodore Young ID: 29 DOB: 1973-10-7 
, Name: Oscar Morrison ID: 30 DOB: 1976-5-15 
, Name: Kieran Lang ID: 31 DOB: 1974-1-18 
, Name: Madeline Mann ID: 32 DOB: 1959-4-2 
, Name: Jeanette Mcmillan ID: 33 DOB: 1969-10-23 
, Name: Erich Barrera ID: 34 DOB: 1963-6-6 
, Name: Preston Fields ID: 35 DOB: 1950-7-21 
, Name: Jade Sutton ID: 36 DOB: 1972-1-17 
, Name: Ann Carrillo ID: 37 DOB: 1982-3-3 
, Name: Cynthia Christian ID: 38 DOB: 1959-9-1 
, Name: Darius Kramer ID: 39 DOB: 1964-5-16 
, Name: Tobias Wells ID: 40 DOB: 1988-5-4 
, Name: Dante Tucker ID: 41 DOB: 1978-2-30 
, Name: Germaine Sears ID: 42 DOB: 1983-3-9 
, Name: Laurel Burris ID: 43 DOB: 1955-2-5 
, Name: Cadman Hodges ID: 44 DOB: 1950-12-18 
, Name: Leroy Pickett ID: 45 DOB: 1970-1-25 
, Name: Lesley Collins ID: 46 DOB: 1969-1-7 
, Name: Paul Cross ID: 47 DOB: 1966-1-21 
, Name: Macaulay Nicholson ID: 48 DOB: 1965-4-23 
, Name: Maxwell Gamble ID: 49 DOB: 1971-4-22 
, Name: Phoebe Gardner ID: 50 DOB: 1980-10-1 
, Name: Martin Travis ID: 51 DOB: 1971-10-11 
, Name: Harding Banks ID: 52 DOB: 1989-11-8 
, Name: Lionel Sexton ID: 53 DOB: 1967-4-20 
, Name: Fatima Leblanc ID: 54 DOB: 1988-9-13 
, Name: Ashely Sosa ID: 55 DOB: 1977-11-28 
, Name: Kaden Mcmillan ID: 56 DOB: 1983-9-19 
, Name: Ciaran Rodriquez ID: 57 DOB: 1987-5-3 
, Name: Aretha Bullock ID: 58 DOB: 1954-6-18 
, Name: Louis Stark ID: 59 DOB: 1988-8-14 
, Name: Rajah Hunter ID: 60 DOB: 1979-1-25 
, Name: Rhoda Pratt ID: 61 DOB: 1968-10-8 
, Name: Jordan Nixon ID: 62 DOB: 1987-3-5 
, Name: Iris Mccarty ID: 63 DOB: 1954-11-28 
, Name: Otto Guthrie ID: 64 DOB: 1956-12-5 
, Name: Clark Franklin ID: 65 DOB: 1961-4-22 
, Name: Tobias Dorsey ID: 66 DOB: 1976-5-25 
, Name: Cody Bauer ID: 67 DOB: 1990-6-27 
, Name: Jaquelyn Combs ID: 68 DOB: 1964-5-17 
, Name: Emerson Parrish ID: 69 DOB: 1966-4-12 
, Name: Alexis Heath ID: 70 DOB: 1956-3-20 
, Name: Rogan Best ID: 71 DOB: 1989-6-3 
, Name: Uma Moon ID: 72 DOB: 1950-10-26 
, Name: Pascale Cohen ID: 73 DOB: 1950-11-7 
, Name: Vivien Thornton ID: 74 DOB: 1987-4-13 
, Name: Avye Le ID: 75 DOB: 1956-1-9 
, Name: Hedley Salas ID: 76 DOB: 1985-7-25 
, Name: Baxter Christian ID: 77 DOB: 1967-8-13 
, Name: Irene Cote ID: 78 DOB: 1970-10-19 
, Name: Grady Cooke ID: 79 DOB: 1950-1-22 
, Name: Mallory Fitzpatrick ID: 80 DOB: 1986-5-2 
, Name: Kenyon Paul ID: 81 DOB: 1963-1-7 
, Name: Denise Conrad ID: 82 DOB: 1973-2-24 
, Name: Jena Navarro ID: 83 DOB: 1971-4-3 
, Name: Reuben Walters ID: 84 DOB: 1980-10-12 
, Name: Judith Marquez ID: 85 DOB: 1956-11-28 
, Name: Travis Barnes ID: 86 DOB: 1984-5-18 
, Name: Clark Burnett ID: 87 DOB: 1950-12-4 
, Name: Lisandra Mcclain ID: 88 DOB: 1980-9-20 
, Name: Xantha Conway ID: 89 DOB: 1951-7-30 
, Name: MacKenzie Oneal ID: 90 DOB: 1966-12-21 
, Name: David Farmer ID: 91 DOB: 1961-4-9 
, Name: Matthew Gray ID: 92 DOB: 1952-2-24 
, Name: Lael Simpson ID: 93 DOB: 1968-5-7 
, Name: Tyler Alexander ID: 94 DOB: 1961-4-5 
, Name: Andrew Rocha ID: 95 DOB: 1986-9-1 
, Name: Imani Miller ID: 96 DOB: 1958-9-27 
, Name: Maile Pittman ID: 97 DOB: 1964-6-13 
, Name: Lucy Morin ID: 98 DOB: 1985-11-4 
, Name: Fuller Savage ID: 99 DOB: 1972-3-7 
, Name: Jessamine Colon ID: 100 DOB: 1964-8-19 
]
----------------------
By Name: 
[Name: Aaron Hogan ID: 27 DOB: 1968-6-23 
, Name: Aladdin Cherry ID: 8 DOB: 1987-2-22 
, Name: Alexis Heath ID: 70 DOB: 1956-3-20 
, Name: Althea Ellis ID: 19 DOB: 1974-12-6 
, Name: Andrew Rocha ID: 95 DOB: 1986-9-1 
, Name: Ann Carrillo ID: 37 DOB: 1982-3-3 
, Name: Aretha Bullock ID: 58 DOB: 1954-6-18 
, Name: Aretha Cotton ID: 16 DOB: 1955-2-15 
, Name: Aristotle Garrison ID: 12 DOB: 1970-4-10 
, Name: Ashely Sosa ID: 55 DOB: 1977-11-28 
, Name: Avye Le ID: 75 DOB: 1956-1-9 
, Name: Baxter Christian ID: 77 DOB: 1967-8-13 
, Name: Brenden Rowland ID: 10 DOB: 1990-2-26 
, Name: Britanni Cantrell ID: 14 DOB: 1951-3-5 
, Name: Cadman Hodges ID: 44 DOB: 1950-12-18 
, Name: Cameron Blair ID: 23 DOB: 1969-3-18 
, Name: Carter Carver ID: 20 DOB: 1953-2-25 
, Name: Ciaran Rodriquez ID: 57 DOB: 1987-5-3 
, Name: Clark Burnett ID: 87 DOB: 1950-12-4 
, Name: Clark Franklin ID: 65 DOB: 1961-4-22 
, Name: Cody Bauer ID: 67 DOB: 1990-6-27 
, Name: Cullen Tyler ID: 21 DOB: 1961-11-30 
, Name: Cynthia Christian ID: 38 DOB: 1959-9-1 
, Name: Dante Tucker ID: 41 DOB: 1978-2-30 
, Name: Darius Kramer ID: 39 DOB: 1964-5-16 
, Name: David Farmer ID: 91 DOB: 1961-4-9 
, Name: Denise Conrad ID: 82 DOB: 1973-2-24 
, Name: Denise Johns ID: 22 DOB: 1976-10-3 
, Name: Eden Pierce ID: 3 DOB: 1975-2-12 
, Name: Emerson Parrish ID: 69 DOB: 1966-4-12 
, Name: Erich Barrera ID: 34 DOB: 1963-6-6 
, Name: Fatima Leblanc ID: 54 DOB: 1988-9-13 
, Name: Fatima Pace ID: 5 DOB: 1972-8-10 
, Name: Fuller Savage ID: 99 DOB: 1972-3-7 
, Name: Genevieve Hamilton ID: 18 DOB: 1950-8-17 
, Name: Germaine Sears ID: 42 DOB: 1983-3-9 
, Name: Glenna York ID: 13 DOB: 1963-6-4 
, Name: Grady Cooke ID: 79 DOB: 1950-1-22 
, Name: Harding Banks ID: 52 DOB: 1989-11-8 
, Name: Hayden Butler ID: 1 DOB: 1960-7-3 
, Name: Hedley Salas ID: 76 DOB: 1985-7-25 
, Name: Imani Miller ID: 96 DOB: 1958-9-27 
, Name: India Larson ID: 15 DOB: 1977-6-13 
, Name: Inez Gentry ID: 26 DOB: 1951-6-29 
, Name: Irene Cote ID: 78 DOB: 1970-10-19 
, Name: Iris Mccarty ID: 63 DOB: 1954-11-28 
, Name: Isaiah Blankenship ID: 2 DOB: 1975-10-24 
, Name: Jade Sutton ID: 36 DOB: 1972-1-17 
, Name: Jaquelyn Combs ID: 68 DOB: 1964-5-17 
, Name: Jeanette Mcmillan ID: 33 DOB: 1969-10-23 
, Name: Jena Navarro ID: 83 DOB: 1971-4-3 
, Name: Jessamine Colon ID: 100 DOB: 1964-8-19 
, Name: Jordan Nixon ID: 62 DOB: 1987-3-5 
, Name: Judith Marquez ID: 85 DOB: 1956-11-28 
, Name: Kaden Mcmillan ID: 56 DOB: 1983-9-19 
, Name: Karen Dean ID: 24 DOB: 1979-8-14 
, Name: Kenyon Paul ID: 81 DOB: 1963-1-7 
, Name: Kieran Lang ID: 31 DOB: 1974-1-18 
, Name: Lael Simpson ID: 93 DOB: 1968-5-7 
, Name: Laurel Burris ID: 43 DOB: 1955-2-5 
, Name: Leroy Pickett ID: 45 DOB: 1970-1-25 
, Name: Lesley Collins ID: 46 DOB: 1969-1-7 
, Name: Lionel Sexton ID: 53 DOB: 1967-4-20 
, Name: Lisandra Mcclain ID: 88 DOB: 1980-9-20 
, Name: Louis Stark ID: 59 DOB: 1988-8-14 
, Name: Lucy Morin ID: 98 DOB: 1985-11-4 
, Name: Lysandra Rodgers ID: 4 DOB: 1970-3-29 
, Name: MacKenzie Oneal ID: 90 DOB: 1966-12-21 
, Name: Macaulay Nicholson ID: 48 DOB: 1965-4-23 
, Name: Madeline Mann ID: 32 DOB: 1959-4-2 
, Name: Maile Pittman ID: 97 DOB: 1964-6-13 
, Name: Malachi Lynch ID: 17 DOB: 1967-7-4 
, Name: Mallory Fitzpatrick ID: 80 DOB: 1986-5-2 
, Name: Mariam Leonard ID: 7 DOB: 1963-11-28 
, Name: Martin Travis ID: 51 DOB: 1971-10-11 
, Name: Matthew Gray ID: 92 DOB: 1952-2-24 
, Name: Maxwell Gamble ID: 49 DOB: 1971-4-22 
, Name: Oscar Morrison ID: 30 DOB: 1976-5-15 
, Name: Otto Guthrie ID: 64 DOB: 1956-12-5 
, Name: Pascale Cohen ID: 73 DOB: 1950-11-7 
, Name: Paul Cross ID: 47 DOB: 1966-1-21 
, Name: Phoebe Gardner ID: 50 DOB: 1980-10-1 
, Name: Preston Fields ID: 35 DOB: 1950-7-21 
, Name: Rajah Hunter ID: 60 DOB: 1979-1-25 
, Name: Reuben Walters ID: 84 DOB: 1980-10-12 
, Name: Rhoda Pratt ID: 61 DOB: 1968-10-8 
, Name: Rogan Best ID: 71 DOB: 1989-6-3 
, Name: Shaeleigh Nelson ID: 6 DOB: 1968-5-19 
, Name: Stephanie Hogan ID: 9 DOB: 1969-10-24 
, Name: Theodore Young ID: 29 DOB: 1973-10-7 
, Name: Tobias Dorsey ID: 66 DOB: 1976-5-25 
, Name: Tobias Wells ID: 40 DOB: 1988-5-4 
, Name: Travis Barnes ID: 86 DOB: 1984-5-18 
, Name: Tyler Alexander ID: 94 DOB: 1961-4-5 
, Name: Ulysses Bush ID: 11 DOB: 1980-5-9 
, Name: Uma Moon ID: 72 DOB: 1950-10-26 
, Name: Uriah Dunlap ID: 28 DOB: 1974-6-4 
, Name: Vivien Thornton ID: 74 DOB: 1987-4-13 
, Name: Xantha Conway ID: 89 DOB: 1951-7-30 
, Name: Yoshi Blackburn ID: 25 DOB: 1979-3-6 
]
----------------------
By Dob: 
[Name: Grady Cooke ID: 79 DOB: 1950-1-22 
, Name: Uma Moon ID: 72 DOB: 1950-10-26 
, Name: Pascale Cohen ID: 73 DOB: 1950-11-7 
, Name: Cadman Hodges ID: 44 DOB: 1950-12-18 
, Name: Clark Burnett ID: 87 DOB: 1950-12-4 
, Name: Preston Fields ID: 35 DOB: 1950-7-21 
, Name: Genevieve Hamilton ID: 18 DOB: 1950-8-17 
, Name: Britanni Cantrell ID: 14 DOB: 1951-3-5 
, Name: Inez Gentry ID: 26 DOB: 1951-6-29 
, Name: Xantha Conway ID: 89 DOB: 1951-7-30 
, Name: Matthew Gray ID: 92 DOB: 1952-2-24 
, Name: Carter Carver ID: 20 DOB: 1953-2-25 
, Name: Iris Mccarty ID: 63 DOB: 1954-11-28 
, Name: Aretha Bullock ID: 58 DOB: 1954-6-18 
, Name: Aretha Cotton ID: 16 DOB: 1955-2-15 
, Name: Laurel Burris ID: 43 DOB: 1955-2-5 
, Name: Avye Le ID: 75 DOB: 1956-1-9 
, Name: Judith Marquez ID: 85 DOB: 1956-11-28 
, Name: Otto Guthrie ID: 64 DOB: 1956-12-5 
, Name: Alexis Heath ID: 70 DOB: 1956-3-20 
, Name: Imani Miller ID: 96 DOB: 1958-9-27 
, Name: Madeline Mann ID: 32 DOB: 1959-4-2 
, Name: Cynthia Christian ID: 38 DOB: 1959-9-1 
, Name: Hayden Butler ID: 1 DOB: 1960-7-3 
, Name: Cullen Tyler ID: 21 DOB: 1961-11-30 
, Name: Clark Franklin ID: 65 DOB: 1961-4-22 
, Name: Tyler Alexander ID: 94 DOB: 1961-4-5 
, Name: David Farmer ID: 91 DOB: 1961-4-9 
, Name: Kenyon Paul ID: 81 DOB: 1963-1-7 
, Name: Mariam Leonard ID: 7 DOB: 1963-11-28 
, Name: Glenna York ID: 13 DOB: 1963-6-4 
, Name: Erich Barrera ID: 34 DOB: 1963-6-6 
, Name: Darius Kramer ID: 39 DOB: 1964-5-16 
, Name: Jaquelyn Combs ID: 68 DOB: 1964-5-17 
, Name: Maile Pittman ID: 97 DOB: 1964-6-13 
, Name: Jessamine Colon ID: 100 DOB: 1964-8-19 
, Name: Macaulay Nicholson ID: 48 DOB: 1965-4-23 
, Name: Paul Cross ID: 47 DOB: 1966-1-21 
, Name: MacKenzie Oneal ID: 90 DOB: 1966-12-21 
, Name: Emerson Parrish ID: 69 DOB: 1966-4-12 
, Name: Lionel Sexton ID: 53 DOB: 1967-4-20 
, Name: Malachi Lynch ID: 17 DOB: 1967-7-4 
, Name: Baxter Christian ID: 77 DOB: 1967-8-13 
, Name: Rhoda Pratt ID: 61 DOB: 1968-10-8 
, Name: Shaeleigh Nelson ID: 6 DOB: 1968-5-19 
, Name: Lael Simpson ID: 93 DOB: 1968-5-7 
, Name: Aaron Hogan ID: 27 DOB: 1968-6-23 
, Name: Lesley Collins ID: 46 DOB: 1969-1-7 
, Name: Jeanette Mcmillan ID: 33 DOB: 1969-10-23 
, Name: Stephanie Hogan ID: 9 DOB: 1969-10-24 
, Name: Cameron Blair ID: 23 DOB: 1969-3-18 
, Name: Leroy Pickett ID: 45 DOB: 1970-1-25 
, Name: Irene Cote ID: 78 DOB: 1970-10-19 
, Name: Lysandra Rodgers ID: 4 DOB: 1970-3-29 
, Name: Aristotle Garrison ID: 12 DOB: 1970-4-10 
, Name: Martin Travis ID: 51 DOB: 1971-10-11 
, Name: Maxwell Gamble ID: 49 DOB: 1971-4-22 
, Name: Jena Navarro ID: 83 DOB: 1971-4-3 
, Name: Jade Sutton ID: 36 DOB: 1972-1-17 
, Name: Fuller Savage ID: 99 DOB: 1972-3-7 
, Name: Fatima Pace ID: 5 DOB: 1972-8-10 
, Name: Theodore Young ID: 29 DOB: 1973-10-7 
, Name: Denise Conrad ID: 82 DOB: 1973-2-24 
, Name: Kieran Lang ID: 31 DOB: 1974-1-18 
, Name: Althea Ellis ID: 19 DOB: 1974-12-6 
, Name: Uriah Dunlap ID: 28 DOB: 1974-6-4 
, Name: Isaiah Blankenship ID: 2 DOB: 1975-10-24 
, Name: Eden Pierce ID: 3 DOB: 1975-2-12 
, Name: Denise Johns ID: 22 DOB: 1976-10-3 
, Name: Oscar Morrison ID: 30 DOB: 1976-5-15 
, Name: Tobias Dorsey ID: 66 DOB: 1976-5-25 
, Name: Ashely Sosa ID: 55 DOB: 1977-11-28 
, Name: India Larson ID: 15 DOB: 1977-6-13 
, Name: Dante Tucker ID: 41 DOB: 1978-2-30 
, Name: Rajah Hunter ID: 60 DOB: 1979-1-25 
, Name: Yoshi Blackburn ID: 25 DOB: 1979-3-6 
, Name: Karen Dean ID: 24 DOB: 1979-8-14 
, Name: Phoebe Gardner ID: 50 DOB: 1980-10-1 
, Name: Reuben Walters ID: 84 DOB: 1980-10-12 
, Name: Ulysses Bush ID: 11 DOB: 1980-5-9 
, Name: Lisandra Mcclain ID: 88 DOB: 1980-9-20 
, Name: Ann Carrillo ID: 37 DOB: 1982-3-3 
, Name: Germaine Sears ID: 42 DOB: 1983-3-9 
, Name: Kaden Mcmillan ID: 56 DOB: 1983-9-19 
, Name: Travis Barnes ID: 86 DOB: 1984-5-18 
, Name: Lucy Morin ID: 98 DOB: 1985-11-4 
, Name: Hedley Salas ID: 76 DOB: 1985-7-25 
, Name: Mallory Fitzpatrick ID: 80 DOB: 1986-5-2 
, Name: Andrew Rocha ID: 95 DOB: 1986-9-1 
, Name: Aladdin Cherry ID: 8 DOB: 1987-2-22 
, Name: Jordan Nixon ID: 62 DOB: 1987-3-5 
, Name: Vivien Thornton ID: 74 DOB: 1987-4-13 
, Name: Ciaran Rodriquez ID: 57 DOB: 1987-5-3 
, Name: Tobias Wells ID: 40 DOB: 1988-5-4 
, Name: Louis Stark ID: 59 DOB: 1988-8-14 
, Name: Fatima Leblanc ID: 54 DOB: 1988-9-13 
, Name: Harding Banks ID: 52 DOB: 1989-11-8 
, Name: Rogan Best ID: 71 DOB: 1989-6-3 
, Name: Brenden Rowland ID: 10 DOB: 1990-2-26 
, Name: Cody Bauer ID: 67 DOB: 1990-6-27 
]

*/