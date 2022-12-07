package arrays2;

import java.util.Arrays;

public class ClockwiseRotationQ4and7 
{

	public static void main(String[] args) 
	{
		int[] arr = {1, 2, 3, 4, 5};
		int n = 1;
		arr = swap(arr, n);
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static int[] swap(int[] arr, int n)
	{
		int length = arr.length;
		
		for(int i=1; i<=n; i++)
		{
			int temp = arr[length-1];
			for(int j=length-1; j>=0; j--)
			{
				if(j==0)
				{
					arr[j] = temp;
				}
				else
				{
					arr[j] = arr[j-1];
				}
			}
		}
		return arr;
	}

}
