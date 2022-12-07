package string3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AllPossibleStrings 
{

	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) 
	{
		AllPossibleStrings get = new AllPossibleStrings();
		
		List<String> list = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		System.out.println("Enter How many Alphabets you want to enter: ");
		int n = scan.nextInt();
		char[] charr = new char[n];
		String input = "";
		for(int i=0; i<n; i++)
		{
			charr[i] = scan.next().charAt(0);
			input = input + charr[i];
//			if(!list.contains(String.valueOf(charr[i])))
//			{
//				list.add(String.valueOf(charr[i]));
//			}
		}
		get.permutataion(input, 0, n, list);
//		for(int i=1; i<=n; i++)
//		{
//			for(int j=0; j<n; j++)
//			{
//				String send = "";
////				int t = 0;
//				for(int k=j; k<i; k++)
//				{
//					send = send + charr[k];
//				}
//				get.permutataion(send, 0, send.length(), list);
//			}
//		}
		Iterator<String> it = list.iterator();
		while(it.hasNext())
		{
			input = it.next();
//			if(input.length() == n)
//			{
				String temp = "";
				for(int i=0; i<n; i++)
				{
					temp = temp + input.charAt(i);
					if(!list2.contains(temp))				//.....
					{
						get.permutataion(temp, 0, i+1, list2);
					}
				}
//			}
		}
		Collections.sort(list2);
		System.out.println(list2);
	}
	
	public void permutataion(String input, int start, int end, List<String> list)
	{
		char[] ch = input.toCharArray();
		if(start == end)
		{
			String temp = String.valueOf(ch);
			if(!list.contains(temp))
			{
				list.add(temp);
			}
		}
		
		for(int i=start; i<end; i++)
		{
			ch = swap(ch, i, start);
			permutataion(String.valueOf(ch), start+1, end, list);
			ch = swap(ch, i, start);
		}
	}
	
	public char[] swap(char[] ch, int start, int end)
	{
		char c = ch[start];
		ch[start] = ch[end];
		ch[end] = c;
		return ch;
	}

}
