package arrays2;

import java.util.Arrays;

public class LargestProduct 
{

	public static void main(String[] args) 
	{
		int[] arr = {-10, -10, 5, 2};
		System.out.println(product(arr));
	}
	
	public static int product(int[] arr)
	{
		int length = arr.length;
		Arrays.sort(arr);
		
		int first=0;
		int last=0;
		
		if(length >= 3)
		{
			first = arr[0] * arr[1] * arr[length-1];
			last = arr[length-1] * arr[length-2] * arr[length-3];
		}
		if(first>last)
		{
			return first;
		}
		return last;
	}

}
