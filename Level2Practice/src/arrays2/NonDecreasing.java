package arrays2;

public class NonDecreasing 
{

	public static void main(String[] args) 
	{
		int arr[] = {10, 5, 1};
		System.out.println(notDec(arr));
	}
	
	public static boolean notDec(int[] arr)
	{
		int length = arr.length;
		int count = 0;
		for(int i=1; i<length; i++)
		{
			if(arr[i-1] > arr[i])
			{
				count++;
			}
		}
		if(count>1)
		{
			return false;
		}
		return true;
	}

}
