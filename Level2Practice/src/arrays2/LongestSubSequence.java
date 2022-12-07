package arrays2;

import java.util.ArrayList;
import java.util.List;

public class LongestSubSequence 
{

	public static void main(String[] args) 
	{
		int[] arr = {1, 5, 2, 3, 4};
		System.out.println(subSequence(arr));
	}
	
	public static int subSequence(int[] arr)
	{
		int length = arr.length;
		List<Integer> list = new ArrayList<>();
		if(length < 1)
		{
			return 0;
		}
		int temp = arr[length-1];
		list.add(temp);
		
		for(int i=length-2; i>=0; i--)
		{
			if(arr[i] < temp)
			{
				list.add(arr[i]);
				temp = arr[i];
			}
			else
			{
				int size = list.size();
				list.remove(size-1);
				list.add(arr[i]);
				temp = arr[i];
			}
		}
//		System.out.println(list);
		return list.size();
	}

}
