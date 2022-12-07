package patterns;

public class pyramid 
{

	public static void main(String[] args) 
	{
		int n=5;
		
		pyramids(n);
	}
	
	public static void pyramids(int n)
	{
		for(int i=n; i>=1; i--)
		{
			for(int j=1; j<=n; j++)
			{
				if(j >= i)
				{
					System.out.print("* ");
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
