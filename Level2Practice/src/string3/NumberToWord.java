package string3;

import java.util.Scanner;

public class NumberToWord 
{
	static Scanner scan = new Scanner(System.in);
	int num = 0;
	static int number;
	String[] once = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	String[] tens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};;
	String[] ty = {"Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	String[] others = {"Hundred", "Thousand"};

	public static void main(String[] args) 
	{
		System.out.println("Enter Number: ");
		NumberToWord get = new NumberToWord();
		number = scan.nextInt();
		
		if(number == 0)
		{
			System.out.println("Zero");
		}
		
		int length = String.valueOf(number).length();
		
		if(length == 4)
		{
			System.out.println();
			get.thousand();
		}
		else if(length == 3)
		{
			System.out.println();
			get.hundred();
		}
		else if(length == 2)
		{
			System.out.println();
			get.ten();
		}
		else if(length == 1)
		{
			System.out.println();
			get.one();
		}
	}
	
	public void thousand()
	{
		num = (number/1000)%10;
		System.out.print(once[num] + " " + others[1] + " ");
		hundred();
	}
	
	public void hundred()
	{
		num = (number/100)%10;
		if(num!=0)
		{
			System.out.print(once[num] + " " + others[0] + " and" + " ");
		}
		else
		{
			System.out.print("and ");
		}
		ten();
	}
	
	public void ten()
	{
		num = (number/10)%10;
		if(num!=0 && num!=1)
		{
			System.out.print(ty[num-2] + " ");
			one();
		}
		else
		{
			num = number%10;
			System.out.print(tens[num]);
		}
	}
	
	public void one()
	{
		num = (number/1)%10;;
		if(num!=0)
		{
			System.out.print(once[num]);
		}
	}

}
