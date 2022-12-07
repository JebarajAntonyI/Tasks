package patterns;

public class Diamond 
{

	public static void main(String[] args) 
	{
		int n=5;
		
		diam(n);
	}
	
	public static void diam(int n)
	{
		for(int i=n; i>=1; i--)
		{
			for(int j=1; j<=n+1; j++)
			{
				if(j==n+1)
				{
					System.out.print("*");
				}
				else if(j>i)
				{
					System.out.print("**");
				}
				else
				{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		for(int i=1; i<n; i++)
		{
			System.out.print(" ");
			for(int j=1; j<=n; j++)
			{
				if(j==n)
				{
					System.out.print("*");
				}
				else if(j>i)
				{
					System.out.print("**");
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
