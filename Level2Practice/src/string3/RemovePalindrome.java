package string3;

import java.util.Scanner;

public class RemovePalindrome 
{

	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) 
	{
		RemovePalindrome get = new RemovePalindrome();
		
//		String input;
//		StringBuilder rev;
//		String answer = "";
//		System.out.println("Enter Line: ");
//		input = scan.nextLine();
//		
//		String[] arr = input.split(" ");
//		int length = arr.length;
//		
//		for(int i=0; i<length; i++)
//		{
//			rev = new StringBuilder();
//			rev.append(arr[i]);
//			rev.reverse();
//			
//			if (!arr[i].equals(String.valueOf(rev)))
//			{
//				answer = answer + arr[i] + " ";
//			}
//		}
//		System.out.println(answer);
		
		String input;
		String word = "";
		System.out.println("Enter Line: ");
		input = scan.nextLine();
		
		char[] ch = input.toCharArray();
		int length = ch.length;
		
		for(int i=0; i<length; i++)
		{
			if(ch[i] != ' ')
			{
				word = word + ch[i];
			}
			else if(!word.equals(""))
			{
				boolean flag = get.rev(word);
				System.out.println(flag);
				if(flag == true)
				{
					i = i-word.length();
					ch = get.del(ch, i-word.length(), word.length());
					i--;
				}
				word = "";
			}
			if(i == length-1)
			{
				boolean flag = get.rev(word);
				System.out.println(flag);
				if(flag == true)
				{
					ch = get.del(ch, i-word.length(), word.length());
				}
			}
		}
		
		System.out.println(String.valueOf(ch));
		
	}
	
	public boolean rev(String word)
	{
		String rev = "";
		int len = word.length();
		
		for(int i=len-1; i>=0; i--)
		{
			rev = rev + word.charAt(i);
		}
		if(word.equals(rev)) 
		{
			return true;
		}
		return false;      
	}
	
	public char[] del(char[] ch, int start, int end)
	{
//		int count = 0;
		int len = ch.length;
		for(int i=start; i<len; i++)
		{
			if(i < len-end-1)
			{
				ch[i] = ch[i+end+1];
//				count++;
			}
			else
			{
				ch[i] = ' ';
			}
		}
		return ch;
	}
}
























