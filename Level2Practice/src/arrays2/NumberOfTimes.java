package arrays2;

public class NumberOfTimes 
{

	public static void main(String[] args) 
	{
		int arr[] = {2, 3, 6, 2, 2, 1, 6};
		repeat(arr);
	}
	
	public static void repeat(int[] arr)
	{
		int length = arr.length;
		int count = 1;
		
		for(int i=0; i<length; i++)
		{
			int max = arr[i];
			for(int j=i; j<length; j++)
			{
				if(max<arr[j])
				{
					max = arr[j];
					arr[j] = arr[i];
					arr[i] = max;
				}
			}
			arr[i] = max;
//			System.out.println(max);
		}
		
		for(int i=0; i<length-1; i++)
		{
//			System.out.println(arr[i]);
			if(arr[i] != arr[i+1])
			{
				System.out.println(arr[i] + "-" + count);
				count = 0;
			}
			count++;
		}
		System.out.println(arr[length-1] + "-" + count);
	}

}
