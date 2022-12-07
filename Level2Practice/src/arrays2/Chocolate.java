package arrays2;

public class Chocolate 
{

	public static void main(String[] args) 
	{
		int[] arr = {1, 3, 4, 7, 9, 9, 12, 56};
		int students = 5;
		
		System.out.println(choco(arr, students));
	}
	
	public static int choco(int[] arr, int num)
	{
		int length = arr.length;
		int ans = Integer.MAX_VALUE;
		
		for(int i=0; i<length; i++)
		{
			int min = arr[i];
			for(int j=i; j<length; j++)
			{
				if(min > arr[j])
				{
					min = arr[j];
					arr[j] = arr[i];
				}
			}
			arr[i] = min;
		}
		for(int i=0; i<length-num+1; i++)
		{
			int val = arr[i+num-1] - arr[i];
			if(ans>val)
			{
				ans = val;
			}
		}
		return ans;
	}

}
