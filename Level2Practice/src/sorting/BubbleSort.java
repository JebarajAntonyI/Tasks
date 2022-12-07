package sorting;

public class BubbleSort 
{

	public static void main(String[] args) 
	{
		int[] arr = {5, 6, 4, 2, 9, 3, 6 , 3};
		arr = bubble(arr);
		
		int length = arr.length;
		
		for(int i=0; i<length; i++)
		{
			System.out.print(arr[i] + ", ");
		}
	}
	
	public static int[] bubble(int[] arr)
	{
		int length = arr.length;
		
		for(int i=length-1; i>=0; i--)
		{
			for(int j=0; j<i; j++)
			{
				int temp = arr[j];
				if(arr[j] > arr[j+1])
				{
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}

}
