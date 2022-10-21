package tester;

import java.util.Scanner;

public class Doubts {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int a, b, c;
		System.out.println("Enter a value: ");
		a = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter b value: ");
		b = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter c value: ");
		c = scan.nextInt();
		System.out.println("a+b+c = " + (a+b+c));
		scan.close();
	}

}
