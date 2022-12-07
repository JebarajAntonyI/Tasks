package sorting;

public class SelectionSort 
{

	public static void main(String[] args) 
	{
		int[] arr = {5, 3, 1, 9, 6, 2, 3};
		arr = selection(arr);
		
		int length = arr.length;
		for(int i=0; i<length; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}
	
	public static int[] selection(int[] arr)
	{
		int length = arr.length;
		
		for(int i=0; i<length; i++)
		{
			int index = i;
			int min = arr[i];
			
			for(int j=i+1; j<length; j++)
			{
				if(min>arr[j])
				{
					index = j;
					min = arr[j];
				}
			}
			arr[index] = arr[i];
			arr[i] = min;
		}
		return arr;
	}

}
