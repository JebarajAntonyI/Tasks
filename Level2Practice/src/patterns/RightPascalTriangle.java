package patterns;

public class RightPascalTriangle 
{

	public static void main(String[] args) 
	{
		int n=5;
		
		pascalTri(n);
	}
	
	public static void pascalTri(int n)
	{
		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=i; j++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
		
		for(int i=n-1; i>0; i--)
		{
			for(int j=1; j<=i; j++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
