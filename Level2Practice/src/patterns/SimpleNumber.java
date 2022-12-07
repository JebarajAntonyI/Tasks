package patterns;

public class SimpleNumber 
{

	public static void main(String[] args) 
	{
		int n=5;
		
		simple(n);
	}
	
	public static void simple(int n)
	{
		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=n; j++)
			{
				if(j<=i)
				{
					System.out.print(j + " ");
				}
			}
			System.out.println();
		}
	}

}
