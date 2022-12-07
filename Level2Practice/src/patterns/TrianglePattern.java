package patterns;

public class TrianglePattern 
{

	public static void main(String[] args) 
	{
		int n=5;
		
		triangle(n);
	}
	
	public static void triangle(int n)
	{
		for(int i=n; i>0; i--)
		{
			for(int j=1; j<=n; j++)
			{
				if(i==1)
				{
					System.out.print("*");
				}
				else if(j==i)
				{
					System.out.print("*");
				}
				else
				{
					System.out.print(" ");
				}
			}
			
			for(int k=n-2; k>=0; k--)
			{
				if(i==1)
				{
					System.out.print("*");
				}
				else if(k==i-1)
				{
					System.out.print("*");
				}
				else
				{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}
