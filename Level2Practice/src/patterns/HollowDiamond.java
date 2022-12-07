package patterns;

public class HollowDiamond 
{

	public static void main(String[] args) 
	{
		int n=6;
		
		hollow(n);
	}
	
	public static void hollow(int n)
	{
		for(int i=n; i>1; i--)
		{
			for(int j=1; j<=n; j++)
			{
				if(j==i || j==n)
				{
					System.out.print("* ");
				}
				else if(j>i)
				{
					System.out.print("  ");
				}
				else
				{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=n; j++)
			{
				if(j==i || j==n)
				{
					System.out.print("* ");
				}
				else if(j>i)
				{
					System.out.print("  ");
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
