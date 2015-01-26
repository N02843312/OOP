//Brandon Walsh
import java.util.Scanner;
import java.io.*;

public class review3
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		PrintWriter outFile = null;

		System.out.println("Please give the name of an output file");
		String fileName = kb.next();

		try
		{
			outFile = new PrintWriter(fileName);

			outFile.println(1 * 1);
			outFile.println(2 * 2);
			outFile.println(3 * 3);
			outFile.println(4 * 4);

			outFile.close();
		}
		catch(IOException e)
		{
			System.out.println("Exception writing to file");
		}
	}
}