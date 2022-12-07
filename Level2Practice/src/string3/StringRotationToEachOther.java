package string3;

import java.util.Scanner;

public class StringRotationToEachOther 
{
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) 
	{
		String one, two;
		
		System.out.println("Enter Two Words: ");
		one = scan.nextLine();
		two = scan.nextLine();
		
		
		if (one.length() == two.length()) 
		{
			one = one + one;
			if (one.contains(two)) 
			{
				System.out.println("Yes");
			} else {
				System.out.println("No");
			} 
		}
		else
		{
			System.out.println("No");
		}
	}

}
