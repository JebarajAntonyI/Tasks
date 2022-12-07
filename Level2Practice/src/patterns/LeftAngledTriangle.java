package patterns;

public class LeftAngledTriangle 
{

	public static void main(String[] args) 
	{
		int n=5;
		
		leftAngle(n);
	}
	
	public static void leftAngle(int n)
	{
		for(int i=n; i>0; i--)
		{
			for(int j=1; j<=n; j++)
			{
				if(j>=i)
				{
					System.out.print("* ");
				}
				else
				{
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

}
