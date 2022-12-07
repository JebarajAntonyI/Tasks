package arrays2;

public class Closest 
{

	public static void main(String[] args) 
	{
		int[] arr = {1, 2, 3, 4, 5};
		int x = 10;
		near(arr, x);
	}
	
	public static void near(int[] arr, int x)
	{
		int length = arr.length;
		int min = Integer.MAX_VALUE;
		int one = 0, two = 0;
		
		for(int i=0; i<length-1; i++)
		{
			
			for(int j=i+1; j<length; j++)
			{
				int diff = Math.abs(arr[i] + arr[j] - x);
				
				if(min > diff)
				{
					min = diff;
					one = arr[i];
					two = arr[j];
				}
				
			}
			
		}
		System.out.println(one + " " + two);
	}
}
