package arrays2;

public class PerfectDigitQ16 
{

	public static void main(String[] args) 
	{
		int num = 2;
		System.out.println(isPerfect(num));
	}
	
	public static int isPerfect(int num)
	{
		if(num/10 == 0)
		{
			int diff = 10 - num;
			
			num = (num*10) + diff;
			return num;
		}
		else
		{
			int l = 1;
			int sum = 0;
			for(int i = num/l; i>0; i=num/l)
			{
				sum = sum + ((num/l)%10);
				l = l*10;
			}
			if(sum == 10)
			{
				return num;
			}
		}
		return 0;
	}

}
