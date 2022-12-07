package patterns;

public class RightAngledTriangle 
{

	public static void main(String[] args) 
	{
		int n = 5;
		
		rightAngle(n);
	}
	
	public static void rightAngle(int n)
	{
		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=i; j++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
