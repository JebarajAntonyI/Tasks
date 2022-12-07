package arrays1;

public class FindSingle 
{

	public static void main(String[] args) 
	{
		int[] arr = {1, 2, 2, 3, 3, 4, 4};
		
		System.out.println(finder(arr));
	}
	
	public static int finder(int[] arr)
	{
		int length = arr.length;
		
		for(int i=0; i<length; i++)
		{
			int temp = arr[i];
			for(int j=0; j<length; j++)
			{
				if(temp == arr[j] && i!=j)
				{
					break;
				}
				else if(j == length-1)
				{
					return arr[i];
				}
			}
		}
//		return arr[length - 1];
		return 0;
	}

}
