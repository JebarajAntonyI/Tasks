package arrays2;

public class SortBasedOnSum 
{

	public static void main(String[] args) 
	{
		int[] arr = {332, 165, 2345, 2643, 934};
		arr = sorted(arr);
		
		int length = arr.length;
		for(int i=0; i<length; i++)
		{
			System.out.println(arr[i]);
		}
	}
	
	public static int[] sorted(int[] arr)
	{
		int length = arr.length;
		
		for(int i=0; i<length; i++)
		{
			int temp = arr[i];
			for(int j=i; j<length; j++)
			{
				int one=0, l=1;
				for(int k=temp/l; k>0; k=temp/l)
				{
					one = one + ((temp/l)%10);
					l = l*10;
				}
				l=1;
				int two = 0;
				for(int k=arr[j]/l; k>0; k=arr[j]/l)
				{
					two = two + ((arr[j]/l)%10);
					l = l*10;
				}
				if(one>two)
				{
					arr[i] = arr[j];
					arr[j] = temp;
					temp = arr[i];
				}
			}
		}
		return arr;
	}

}
