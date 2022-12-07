package arrays2;

import java.util.HashSet;
import java.util.Set;

public class MultiSet 
{

	public static void main(String[] args) 
	{
		int[] arr = {15, 5, 20, 10, 35, 15, 10};
		System.out.println(multiSets(arr));
	}
	
	public static boolean multiSets(int[] arr)
	{
		Set<Integer> set = new HashSet<>();
		int length = arr.length;
		int sum = 0;
		for(int i=0; i<length; i++)
		{
			sum = 0;
			for(int j=i; j<length; j++)
			{
				sum = sum + arr[j];
				if(j!=i)
				{
					if(set.contains(sum))
					{
						return true;
					}
					set.add(sum);
				}
			}
		}
		return false;
	}
}
