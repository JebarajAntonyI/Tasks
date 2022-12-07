package string3;

import java.util.Scanner;

public class BalanceWord 
{

	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) 
	{
		System.out.println("Enter Word");
		String input = scan.next();
		input = input.toUpperCase();
		
		System.out.println(balance(input));
	}
	
	public static String balance(String input)
	{
		int length = input.length();
		
		for(int i=1; i<length-1; i++)
		{
			char ch = input.charAt(i);
			int count = 1;
			int left = 0;
			int right = 0;
			for(int j=i-1; j>=0; j--)
			{
				left = left + ((input.charAt(j) - 'A'+1)*count);
				count++;
			}
			
			count = 1;
			for(int j=i+1; j<length; j++)
			{
				right = right + ((input.charAt(j) - 'A'+1)*count);
				count++;
			}
			
			if(left == right)
			{
				return "Balance at: " + ch;
			}
		}
		return "Not Balanced";
	}

}
