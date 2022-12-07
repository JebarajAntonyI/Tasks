package sorting;

public class InsertionSort 
{

	public static void main(String[] args) 
	{
		int[] arr = {5, 1, 9, 7, 6, 8, 3};
		arr = insertion(arr);
		
		int length = arr.length;
		for(int i=0; i<length; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}
	
	public static int[] insertion(int[] arr)
	{
		int length = arr.length;
		
		for(int i=1; i<length; i++)
		{
			int min = arr[i];
			int j = i-1;
			
			while(j>=0 && arr[j]<min)
			{
				arr[j+1] = arr[j];
				arr[j] = min;
				j--;
			}
		}
		return arr;
	}

}
