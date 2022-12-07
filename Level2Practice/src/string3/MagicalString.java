package string3;

import java.util.Scanner;

public class MagicalString 
{

	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) 
	{
		System.out.println("Enter String 1: ");
		String one = scan.next();
		
		System.out.println("Enter String 2: ");
		String two = scan.next();
		
		System.out.println(magic(one, two));
		
		
	}
	
	public static String magic(String one, String two)
	{
		String ans="";
		int length1 = one.length();
		int length2 = two.length();
		
		if(length1 != length2)
		{
			return "No Such String";
		}
		
		A:
		for(int i=0; i<length1; i++)
		{
			if(one.charAt(i) > two.charAt(i))
			{
				return "No Such String";
			}
			else if(one.charAt(i) < two.charAt(i))
			{
				break A;
			}
		}
		
		int count = 1;
		for(int i=length1-1; i>=0; i--)
		{
			int ch = one.charAt(i);
			if(count == 1 && (ch <= 65 || ch >= 122) && one.charAt(i-1) != 122)
			{
				count = 0;
			}
			else if((count == 0 || count == 1) && one.charAt(i) != 122)
			{
				ch++;
				count = -1;
			}
			ans = (char)ch + ans;
		}
		
		if(ans.equals(two))
		{
			return "No Such String";
		}
		return ans;
		
	}

}
