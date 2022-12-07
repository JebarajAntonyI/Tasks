package arrays2;

import java.util.ArrayList;
import java.util.List;

public class EqualToSum 
{

	public static void main(String[] args) 
	{
		int[] arr = {10, 9, 5, 9, 0, 10, 2, 10, 1, 9};
		int sum = 12;
		List<String> list = comp(arr, sum);
		
		System.out.println(list);
	}
	
	public static List<String> comp(int[] arr, int sum)
	{
		List<String> list = new ArrayList<>();
		int length = arr.length;
		
		for(int i=0; i<length-1; i++)
		{
			for(int j=i+1; j<length; j++)
			{
				int add = arr[i] + arr[j];
				
				if(add == sum)
				{
					list.add("(" + arr[j] + ", " + arr[i] + ")");
				}
			}
		}
		return list;
	}

}
