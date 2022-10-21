package basic.regex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.PatternSyntaxException;

import myException.UserDefinedException;

public class RegExRunner 
{
	
	private Scanner scan = new Scanner(System.in);
	
	private int getInt()
	{
		int number = 0;
		boolean value = true;
		while (value)
		{
			if (scan.hasNextInt())
			{
				number = scan.nextInt();
				value = false;
			}
			else
			{
				scan.next();
				System.out.print("Enter value in integer");
				System.out.println();
			}
		}
		return number;
	}

	public static void main(String[] args) throws UserDefinedException 
	{
		RegExRunner get = new RegExRunner();
		RegExTask run = new RegExTask();
		
		Logger logger = Logger.getLogger("RegExRunner.class");
		
		logger.info("Enter which exercise you want to perform: ");
		
		int exerciseNo = get.getInt();
		
		while (exerciseNo != 0)
		{
			try 
			{
				switch (exerciseNo)
				{
				case 1:
				{
					logger.info("Enter Mobile Number: ");
					String mobile = get.scan.next();
					System.out.println("Is the mobile number valid - " + run.mobileNumberValidation(mobile));
					break;
				}
				case 2:
				{
					logger.info("Enter String: ");
					String inputString = get.scan.next();
					System.out.println("Is the String contails Alpha Numeric value only - " + run.alphaNumericOnly(inputString));
					break;
				}
				case 3:
				{
					logger.info("Enter String: ");
					String inputString = get.scan.next();
					logger.info("Enter Matching String: ");
					String matchingString = get.scan.next();
					System.out.println("Is the String starts with Matching String - " + run.stringStartsWith(inputString, matchingString));
					System.out.println("Is the String contains Matching String - " + run.stringContainsMatching(inputString, matchingString));
					System.out.println("Is the String ends with Matching String - " + run.stringEndsWith(inputString, matchingString));
					System.out.println("Is the String exact match with Matching String - " + run.stringExactMatch(inputString, matchingString));
					break;
				}
				case 4:
				{
					logger.info("Enter how many strings you want to enter: ");
					int number = get.getInt();
					List <String> stringList = new ArrayList<String>();
					for (int i = 0; i < number; i++)
					{
						logger.info("Enter String : " + (i+1));
						stringList.add(get.scan.next());
					}
					logger.info("Enter Matching String: ");
					String matchingString = get.scan.next();
					for (int i = 0; i < number; i++)
					{
						System.out.println("Is '" + stringList.get(i) + "' match with Matching String - "+ run.stringMatchCaseInsensitive(matchingString, stringList.get(i)));
					}
					break;
				}
				case 5:
				{
					logger.info("Enter Email: ");
					String inputString = get.scan.next();
					System.out.println("Is Email is valid - " + run.emailValidation(inputString));
					break;
				}
				case 6:
				{
					logger.info("Enter how many strings you want to enter: ");
					int number = get.getInt();
					List <String> stringList = new ArrayList<String>();
					for (int i = 0; i < number; i++)
					{
						logger.info("Enter String : " + (i+1));
						stringList.add(get.scan.next());
					}
					logger.info("Enter length of strings within limit you want to count: ");
					int length = get.getInt();
					logger.info("The List of Strings within limit: " + run.stringsWithinLength(length, stringList));
					break;
				}
				case 7:
				{
					logger.info("Enter how many strings you want to enter in List 1: ");
					int number1 = get.getInt();
					List <String> stringList1 = new ArrayList<String>();
					for (int i = 0; i < number1; i++)
					{
						logger.info("Enter String : " + (i+1));
						stringList1.add(get.scan.next());
					}
					logger.info("Enter how many strings you want to enter in List 2: ");
					int number2 = get.getInt();
					List <String> stringList2 = new ArrayList<String>();
					for (int i = 0; i < number2; i++)
					{
						logger.info("Enter String : " + (i+1));
						stringList2.add(get.scan.next());
					}
					Map<String, Integer> stringMap = new HashMap<String, Integer>();
					stringMap = run.compareTwoList(stringList1, stringList2);
					System.out.println(stringMap);
					break;
				}
				case 8:
					String inputString = "<p>The <code>President</code> of India is the first\n"
							+ "citizen of our country.</p>";
					List<String> list = new ArrayList<String>();
					list = run.stringHTML(inputString);
					System.out.println(list);
					break;
				}
			}
			catch(UserDefinedException ue)
			{
				System.out.println(ue.getMessage());
				ue.printStackTrace();
			}
			catch(PatternSyntaxException pse)
			{
				pse.printStackTrace();
			}
			System.out.println("Enter 0 to close the program");
			System.out.println("Enter which number of exercise you want to perform: ");
			exerciseNo = get.getInt();
		}
	}

}
