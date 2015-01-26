//Brandon Walsh
import java.util.Scanner;

public class review2
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.println("Please input a number to square it: ");
		int input = kb.nextInt();

		try
		{
			if(input < 0)
			{
				throw new myException();
			}
			else
			{
				System.out.println(input*input);
			}
		}
		catch(myException e)
		{
			System.out.println(e.getMessage());
		}
	}
}

class myException extends Exception 
{
	public myException()
	{
		super("Negative number supplied");
	}
}