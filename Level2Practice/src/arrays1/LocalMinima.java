package arrays1;

import java.util.ArrayList;
import java.util.List;

public class LocalMinima {

	public static void main(String[] args) 
	{
		int[] arr = {9, 6, 2, 14, 5, 7, 4};
		
		System.out.println(minima(arr));
	}
	
	public static List<Integer> minima(int[] arr)
	{
		int length = arr.length;
		List<Integer> list = new ArrayList<>();
		
		for(int i=0; i<length; i++)
		{
			int var = arr[i];
			if(i==0)
			{
				if(var<= arr[i+1])
				{
					list.add(var);
				}
			}
			else if(i==length-1)
			{
				if(var<= arr[i-1])
				{
					list.add(var);
				}
			}
			else if(var <= arr[i-1] && var <= arr[i+1])
			{
				list.add(var);
			}
		}
		return list;
	}

}
