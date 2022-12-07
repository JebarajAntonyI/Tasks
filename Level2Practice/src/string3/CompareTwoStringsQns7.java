package string3;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompareTwoStringsQns7 
{

	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) 
	{
		StringBuilder one = new StringBuilder();
		StringBuilder two = new StringBuilder();
		String str1, str2;
		List<String> list = new ArrayList<>();
//		Map<String, String> map = new HashMap<>();
		System.out.println("Enter Two Strings");
		str1 = scan.next();
		str2 = scan.next();
		
		int length1 = str1.length();
		int length2 = str2.length();
		if(length1 != length2)
		{
			System.out.println("Invalid Input");
		}
		else
		{
			for(int i=0; i<length1; i++)
			{
				char c1 = str1.charAt(i);
				char c2 = str2.charAt(i);
				if(c1 != c2)
				{
					one.append(c1);
					two.append(c2);
				}
				else if(one.length() != 0)
				{
//					map.put(one.toString(), two.toString());
					list.add(one.toString() + "," + two.toString());
//					list.add(two.toString());
					one = new StringBuilder();
					two = new StringBuilder();
				}
				if(i == length1-1 && one.length() != 0)
				{
					list.add(one.toString() + "," + two.toString());
//					map.put(one.toString(), two.toString());
				}
			}
			int size = list.size();
			for(int i=0; i<size; i++)
			{
				System.out.println(list.get(i));
			}
//			System.out.println(map);

		}
	}

}
