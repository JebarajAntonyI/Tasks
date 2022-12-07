package arrays1;

public class DigitsQn16 
{

	public static void main(String[] args) 
	{
		int[] arr = {1, 2, 3};
		arr = finding(arr);
		
		int size = arr.length;
		
		for(int i=0; i<size; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}
	
	public static int[] finding(int[] arr)
	{
		int number = 0;
		int length = arr.length;
		
		for(int i=0; i<length; i++)
		{
			number = (number*10) + arr[i];
		}
		number = number + 1;
		
		int k = length-1;
		if(number%10 == 0)
		{
			arr = new int[length+1];
			k = length;
		}
		int n = 1;
		
		
		for(int i=number/n; i>0; i=number/n)
		{
			arr[k] = i%10;
			k--;
			n = n*10;
		}
		return arr;
	}

}
