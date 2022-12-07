package arrays2;

public class ClosestNumber 
{

	public static void main(String[] args) 
	{
		int[] arr = {901, 40, 35, 0, 60, 900, 903, 1000};
		closest(arr);
	}
	
	public static void closest(int[] arr)
	{
		int length = arr.length;
		int min = Integer.MAX_VALUE;
		int diff = 0, start = 0, end = 0;
		
		for(int i=0; i<length; i++)
		{
			for(int j=i+1; j<length; j++)
			{
				diff = Math.abs(arr[i] - arr[j]);
				
				if(diff<min)
				{
					start = i;
					end = j;
					min = diff;
				}
			}
		}
		System.out.println(arr[start] +  ", " + arr[end]);
	}

}
