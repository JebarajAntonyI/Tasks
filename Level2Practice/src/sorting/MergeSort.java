package sorting;

public class MergeSort 
{
	
	public static void main(String[] args) 
	{
		int[] arr = {5, 2, 6, 1, 9, 4, 4};
		
		
		int length = arr.length;
		divide(arr, 0, length-1);
		for(int i=0; i<length; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void divide(int[] arr, int initial, int last)
	{
		if(initial<last)
		{
			int mid = (initial+last)/2;
			divide(arr, initial, mid);
			divide(arr, mid+1, last);
			merge(arr, initial, mid, last);
		}
	}
	
	public static void merge(int[] arr, int initial, int mid, int last)
	{
		int n1 = mid-initial+1;
		int n2 = last-mid;
		
		int[] left = new int[n1];
		int[] right = new int[n2];
		int m = 0;
		for(int i=initial; i<=mid; i++)
		{
			left[m] = arr[i];
			m++;
		}
		m = 0;
		for(int i=mid+1; i<=last; i++)
		{
			right[m] = arr[i];
			m++;
		}
		
		int i = 0;
		int j = 0;
		int k = initial;
		
		while(i<n1 && j<n2)
		{
			if(left[i] <= right[j])
			{
				arr[k] = left[i];
				i++;
			}
			else
			{
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		
		while(i<n1)
		{
			arr[k] = left[i];
			i++;
			k++;
		}
		
		while(j<n2)
		{
			arr[k] = right[j];
			j++;
			k++;
		}
	}
	
}



















