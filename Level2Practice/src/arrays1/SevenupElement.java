package arrays1;

import java.util.ArrayList;
import java.util.List;

public class SevenupElement 
{

	public static void main(String[] args) 
	{
		int[] arr = {18, 21, 32, 49, 17, 1, 35, 5};
		
		System.out.println(sevenUp(arr));
	}
	
	public static List<Integer> sevenUp(int[] arr)
	{
		int length = arr.length;
		List<Integer> list = new ArrayList<>();
		list.add(arr[0]);
		
		for(int i=1; i<length; i++)
		{
			if(arr[i-1]%7 == 0)
			{
				list.add(arr[i]);
			}
		}
		return list;
	}

}
