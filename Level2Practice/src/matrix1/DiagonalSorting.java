package matrix1;

import java.util.Arrays;

public class DiagonalSorting 
{

	public static void main(String[] args) 
	{
		int[][] arr = {{5, 2, 0, 7, 1}, {3, 4, 2, 9, 14}, {5, 1, 3, 5, 2}, {4, 2, 6, 2, 1}, {0, 6, 3, 5, 1}};
		sort(arr);
		
		int row = arr.length;
		
		for(int i=0; i<row; i++)
		{
			System.out.println(Arrays.toString(arr[i]));
		}
	}
	
	public static void sort(int[][] arr)
	{
		int row = arr.length;
		int col = arr[0].length;
		
		if(row == col)
		{
			for(int i=0; i<row; i++)
			{
				int index = i;
				int temp = arr[i][i];
				for(int j=i+1; j<row; j++)
				{
					if(temp > arr[j][j])
					{
//						System.out.println(temp);
						index = j;
						temp = arr[j][j];
					}
				}
				arr[index][index] = arr[i][i];
				arr[i][i] = temp;
//				System.out.println(arr[i][i]);
			}
		}
	}

}
