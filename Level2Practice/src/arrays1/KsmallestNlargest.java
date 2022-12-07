package arrays1;

public class KsmallestNlargest 
{

	public static void main(String[] args) 
	{
		int arr[] = {7, 10, 4, 3, 20, 15};
		System.out.println(finding(arr, 3, 2));
	}
	
	public static int finding(int[] arr, int k, int n)
	{
		int len = arr.length;
		for(int i=0; i<len; i++)
		{
			int max = arr[i];
			for(int j=i; j<len; j++)
			{
				if(max<arr[j])
				{
					max = arr[j];
					arr[j] = arr[i];
					arr[i] = max;
				}
			}
		}
		return arr[n-1] + arr[len-k];
	}

}
