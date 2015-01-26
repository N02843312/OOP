//Brandon Walsh

import java.util.Scanner;
import java.io.*;
public class review1
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);

		System.out.println("Please input a file name to calculate the number of lines it has:");
		String fileName = kb.next();

		try
		{
			Scanner inFile = new Scanner(new File(fileName));
			int numOfLines = 0;
			while(inFile.hasNextLine())
			{
				numOfLines++;
				inFile.nextLine();
			}

			inFile.close();
			System.out.println("Number of lines: " + numOfLines);
		}
		catch(IOException e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}
}