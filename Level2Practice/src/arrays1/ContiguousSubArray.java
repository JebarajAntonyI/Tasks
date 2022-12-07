package arrays1;

public class ContiguousSubArray {

	public static void main(String[] args) 
	{
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int sum = 15;
		sub(arr, sum);
	}
	
	public static void sub(int[] arr, int sum)
	{
		int length = arr.length;
		int start = 0;
		int end = 0;
		
		A:
		for(int i=0; i<length; i++)
		{
			int add = 0;
			for(int j=i; j<length; j++)
			{
				add = add + arr[j];
				
				if(add>sum)
				{
					break;
				}
				else if(add == sum)
				{
					start = i+1;
					end = j+1;
					break A;
				}
			}
		}
		System.out.println(start + " " + end);
	}

}
