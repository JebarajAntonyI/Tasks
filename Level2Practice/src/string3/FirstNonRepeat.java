package string3;

import java.util.Scanner;

public class FirstNonRepeat 
{

	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) 
	{
		System.out.println("Enter Input String: ");
		String input = scan.next();
		
		char ch = nonRepeat(input);
		
		if(ch != '\0')
		{
			System.out.println(ch);
		}
		else
		{
			System.out.println("No matching Character");
		}
		
	}
	
	public static char nonRepeat(String input)
	{
		int length = input.length();
		
		for(int i=0; i<length; i++)
		{
			char ch = input.charAt(i);
			
			for(int j=i+1; j<length; j++)
			{
				if(ch == input.charAt(j))
				{
					input = input.replace(ch, '-');
					break;
				}
				else if(j == length-1 && ch != input.charAt(j))
				{
					return ch;
				}
			}
		
		}
		return '\0';
	}
}
