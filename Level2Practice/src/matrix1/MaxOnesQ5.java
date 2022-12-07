package matrix1;

import java.util.Arrays;

public class MaxOnesQ5 
{

	public static void main(String[] args) 
	{
		int[][] arr = {{0, 1, 1, 1}, {0, 0, 1, 1}, {1, 1, 1, 1}, {0, 0, 0, 0}};
		replaceOnes(arr);
		
		int row = arr.length;
		
		for(int i=0; i<row; i++)
		{
			System.out.println(Arrays.toString(arr[i]));
		}
	}
	
	public static void replaceOnes(int[][] arr)
	{
		int min = Integer.MIN_VALUE;
		int index = 0;
		int row = arr.length;
		int col = arr[0].length;
		
		for(int i=0; i<row; i++)
		{
			int count = 0;
			for(int j=0; j<col; j++)
			{
				if(arr[i][j] == 1)
				{
					count++;
				}
			}
			if(count>min)
			{
				index = i;
				min = count;
			}
		}
		for(int i=0; i<col; i++)
		{
			arr[index][i] = 0;
		}
	}

}
