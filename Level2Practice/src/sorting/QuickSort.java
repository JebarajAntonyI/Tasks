package sorting;

import java.util.Arrays;

public class QuickSort 
{

	public static void main(String[] args) 
	{
		int[] arr = {1,9,5,4,6,8,1,4,6};
		int length = arr.length;
		divide(arr, 0, length-1);
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static void divide(int[] arr, int start, int end)
	{
		if(start<end)
		{
			int partition = partition(arr, start, end);
			
			divide(arr, start, partition-1);
			divide(arr, partition+1, end);
		}
	}
	
	public static int partition(int[] arr, int start, int end)
	{
		int pivot = arr[end];
		
		int i = start;
		
		for(int j=start; j<end; j++)
		{
			if(arr[j] < pivot)
			{
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
			}
		}
		int temp = arr[i];
		arr[i] = arr[end];
		arr[end] = temp;
		return i;
	}

}
