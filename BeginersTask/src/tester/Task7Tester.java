package tester;

import java.util.Scanner;

import basic.hashmap.HashMapTask;
import myException.UserDefinedException;

public class Task7Tester 
{

	public static void main(String[] args) throws UserDefinedException 
	{
		Scanner scan = new Scanner(System.in);
		HashMapTask run = new HashMapTask();
		int n = scan.nextInt();
		scan.close();
		try
		{
		switch(n)
		{
		case 1:
			run.getSize(null);
			break;
			
		case 8:
			run.isKeyPresent(null, null);
			break;
			
		case 9:
			run.isValuePresent(null, null);
			break;
			
		case 10:
			run.changeValue(null, null, null);
			break;
			
		case 11:
			run.getValue(null, null);
			break;
			
		case 12:
			run.getValue(null, null);
			break;
			
		case 13:
			run.getValueOrDefault(null, null);
			break;
			
		case 14:
			run.removeKey(null, null);
			break;
			
		case 15:
			run.removeKeyIfGivenValuePresent(null, null, null);
			break;
			
		case 16:
			run.replaceValueOfExistingKey(null, null, null);
			break;
			
		case 17:
			run.replaceValueOfExistingKeyValue(null, null, null, null);
			break;
			
		case 18:
			run.mergeTwoMaps(null, null);
			break;

		case 19:
			run.printUsingIterator(null);
			break;
			
		case 20:
			run.removeAllEntries(null);
			break;
			
		default:
			System.out.println("1, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20");
			break;

		}
		}
		catch (UserDefinedException ue)
		{
			System.out.println(ue);
		}
	}

}
