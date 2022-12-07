package patterns;

public class DiamondNumber 
{

	public static void main(String[] args) 
	{
		int n=4;
		
		number(n);
	}
	
	public static void number(int n)
	{
		for(int i=1; i<=n; i++)
		{
			for(int j=n; j>=1; j--)
			{
				if(j<=i)
				{
					System.out.print(j);
				}
				else
				{
					System.out.print(" ");
				}
				
				if(j==1)
				{
					for(int k=2; k<=i; k++)
					{
						System.out.print(k);
					}
				}
			}
			System.out.println();
		}
		
		for(int i=n-1; i>=1; i--)
		{
			for(int j=n; j>=1; j--)
			{
				if(j<=i)
				{
					System.out.print(j);
				}
				else
				{
					System.out.print(" ");
				}
				
				if(j==1)
				{
					for(int k=2; k<=i; k++)
					{
						System.out.print(k);
					}
				}
			}
			System.out.println();
		}
	}

}
