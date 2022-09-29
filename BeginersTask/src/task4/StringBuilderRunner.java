package task4;

import java.util.Scanner;

import myException.UserDefinedException;

public class StringBuilderRunner {

	Scanner scan = new Scanner(System.in);

	public String getStringInput()
	{
		String inputString="";
		System.out.println("Enter the String: ");
		inputString = scan.next();
		return inputString;
	}

	public int getIntegerInput(int number)
	{
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
				System.out.println("Enter input in Integer");
			}
		}
		return number;
	}

	public static void main (String[] args) throws UserDefinedException
	{
		StringBuilderTask run = new StringBuilderTask();
		StringBuilderRunner get = new StringBuilderRunner();
		int exerciseNo, length = 0, number = 0;
		int fromIndex = 0, toIndex = 0;
		System.out.println("Enter which number of exercise you want to perform");
		exerciseNo = get.getIntegerInput(0);
		while (exerciseNo != 0)
		{
			switch (exerciseNo) 
			{
			case 1:
			{
				try
				{
					StringBuilder stringBuilderObj = run.createFreshStringBuilder();
					length = run.getLength(stringBuilderObj);
					System.out.println("Length of StringBuilder before getting string: " + length);
					String inputString = get.getStringInput();
					stringBuilderObj = run.appendStringBuilder(" ",inputString);
					length = run.getLength(stringBuilderObj);
					System.out.println("Length of StringBuilder after getting string: " + length);
					System.out.println("Final string is: " + inputString);
				}
				catch (UserDefinedException ex)
				{
					System.out.println(ex);
				}
				break;
			}
			case 2:
			{
				try
				{
					StringBuilder stringBuilderObj = run.createFreshStringBuilder();
					String inputString = get.getStringInput();
					stringBuilderObj = run.appendStringBuilder(" ",inputString);
					length = run.getLength(stringBuilderObj);
					System.out.println("Length of StringBuilder after getting one string: " + length);
					System.out.println("Enter how many number of strings you want to add: ");
					number = get.getIntegerInput(number);
					String[] inputStringArray = new String[number+1];
					inputStringArray[0] = inputString;
					for (int i=1; i<number+1; i++)
					{
						inputStringArray[i] = get.scan.next();
					}
					System.out.println("Enter the symbol you want to add between: ");
					String symbol = get.scan.next();
					stringBuilderObj = run.appendStringBuilder(symbol,inputStringArray);
					length = run.getLength(stringBuilderObj);
					System.out.println("Length of StringBuilder after getting string: " + length);
					System.out.println("Final string is: " + stringBuilderObj);
				}
				catch (UserDefinedException ex)
				{
					System.out.println(ex);
				}
				break;
			}
			case 3:
			{
				try
				{
					StringBuilder stringBuilderObj = run.createFreshStringBuilder();
					String inputString = get.getStringInput();
					String inputString2 = get.getStringInput();
					System.out.println("Enter the symbol to add between words: ");
					String character = get.scan.next();
					stringBuilderObj = run.appendStringBuilder(character,inputString,inputString2);
					length = run.getLength(stringBuilderObj);
					System.out.println("Length of StringBuilder after getting string: " + length);
					System.out.println("Now the string is: " + stringBuilderObj);
					System.out.println("Enter how many number of strings you want to add in between: ");
					number = get.getIntegerInput(number);
					String[] inputStringArray = new String[number];
					for (int i=0; i<number; i++)
					{
						inputStringArray[i] = get.scan.next();
					}
					stringBuilderObj = run.getInsertedStrings(stringBuilderObj, inputStringArray, character);
					length = run.getLength(stringBuilderObj);
					System.out.println("Length of StringBuilder is: " + length);
					System.out.println("Now the string is: " + stringBuilderObj);
				}
				catch (UserDefinedException ex)
				{
					System.out.println(ex);
				}
				break;
			}
			case 4:
			{
				try
				{
					StringBuilder stringBuilderObj = run.createFreshStringBuilder();
					System.out.println("Enter how many number of strings you want to add: ");
					number = get.getIntegerInput(number);
					String[] inputStringArray = new String[number];
					for (int i=0; i<number; i++)
					{
						inputStringArray[i] = get.scan.next();
					}
					System.out.println("Enter the symbol to add between words: ");
					String character = get.scan.next();
					stringBuilderObj = run.appendStringBuilder(character,inputStringArray);
					length = run.getLength(stringBuilderObj);
					System.out.println("Length of StringBuilder after getting 2 strings: " + length);
					System.out.println("Now the string is: " + stringBuilderObj);
					stringBuilderObj = run.deleteFirstString(stringBuilderObj, character);
					length = run.getLength(stringBuilderObj);
					System.out.println("Length of StringBuilder after deleting first strings: " + length);
					System.out.println("Now the string is: " + stringBuilderObj);
				}
				catch (UserDefinedException ex)
				{
					System.out.println(ex);
				}
				break;
			}
			case 5:
			{
				try
				{
					StringBuilder stringBuilderObj = run.createFreshStringBuilder();
					System.out.println("Enter how many number of strings you want to add: ");
					number = get.getIntegerInput(number);
					String[] inputStringArray = new String[number];
					for (int i=0; i<number; i++)
					{
						inputStringArray[i] = get.scan.next();
					}
					System.out.println("Enter the symbol to add between words: ");
					String character = get.scan.next();
					stringBuilderObj = run.appendStringBuilder(character,inputStringArray);
					length = run.getLength(stringBuilderObj);
					System.out.println("Length of StringBuilder after adding symbol between strings: " + length);
					System.out.println("Now the string is: " + stringBuilderObj);
					System.out.println("Enter the symbol you want to replace the previous symbol: ");
					String stringCharacter = get.scan.next();
					stringBuilderObj = run.getStringBuilderSpaceReplace(stringBuilderObj, stringCharacter, character);
					length = run.getLength(stringBuilderObj);
					System.out.println("Length of StringBuilder after adding symbol replace space: " + length);
					System.out.println("Now the string is: " + stringBuilderObj);
				}
				catch (UserDefinedException ex)
				{
					System.out.println(ex);
				}
				break;
			}
			case 6:
			{
				try
				{
					StringBuilder stringBuilderObj = run.createFreshStringBuilder();
					System.out.println("Enter how many number of strings you want to add: ");
					number = get.getIntegerInput(number);
					String[] inputStringArray = new String[number];
					for (int i=0; i<number; i++)
					{
						inputStringArray[i] = get.scan.next();
					}
					System.out.println("Enter the symbol to add between words: ");
					String character = get.scan.next();
					stringBuilderObj = run.appendStringBuilder(character,inputStringArray);
					length = run.getLength(stringBuilderObj);
					System.out.println("Length of StringBuilder after adding symbol between strings: " + length);
					System.out.println("Now the string is: " + stringBuilderObj);
					StringBuilder reverseStringBuilder = run.getReverseStringBuilder(stringBuilderObj);
					length = run.getLength(reverseStringBuilder);
					System.out.println("Length of StringBuilder after reversing: " + length);
					System.out.println("Now the string is: " + reverseStringBuilder);
				}
				catch (UserDefinedException ex)
				{
					System.out.println(ex);
				}
				break;
			}
			case 7:
			{
				try
				{
					StringBuilder stringBuilderObj = run.createFreshStringBuilder();
					System.out.println("Enter a string with minimum 10 characters: ");
					String inputString = get.getStringInput();
					System.out.println("Enter from and to Index to remove: ");
					fromIndex = get.getIntegerInput(0);
					toIndex = get.getIntegerInput(0);
					System.out.println("Enter the symbol to add between words: ");
					String character = get.scan.next();
					stringBuilderObj = run.appendStringBuilder(character,inputString);
					StringBuilder outputStringBuilder = run.toRemoveStringsInbetween(stringBuilderObj, fromIndex, toIndex);
					System.out.println("Length of StringBuilder after removing: " + length);
					System.out.println("Now the string is: " + outputStringBuilder);
				}
				catch (UserDefinedException ex)
				{
					System.out.println(ex);
				}
				break;
			}
			case 8:
			{
				try
				{
					StringBuilder stringBuilderObj = run.createFreshStringBuilder();
					System.out.println("Enter a string with minimum 10 characters: ");
					String inputString = get.getStringInput();
					System.out.println("Enter from and to Index to replace: ");
					fromIndex = get.getIntegerInput(0);
					toIndex = get.getIntegerInput(0);
					System.out.println("Enter the symbol to add between words: ");
					String character = get.scan.next();
					stringBuilderObj = run.appendStringBuilder(character,inputString);
					System.out.println("Enter a string you want to replace: ");
					String replaceString = get.getStringInput();
					StringBuilder outputStringBuilder = run.toReplaceStringsInbetween(stringBuilderObj, replaceString, fromIndex, toIndex);
					System.out.println("Length of StringBuilder after replacing: " + length);
					System.out.println("Now the string is: " + outputStringBuilder);
				}
				catch (UserDefinedException ex)
				{
					System.out.println(ex);
				}
				break;
			}
			case 9:
			{
				try
				{
					StringBuilder stringBuilderObj = run.createFreshStringBuilder();
					System.out.println("Enter how many number of strings you want to add: ");
					number = get.getIntegerInput(number);
					String[] inputStringArray = new String[number];
					for (int i=0; i<number; i++)
					{
						inputStringArray[i] = get.scan.next();
					}
					System.out.println("Enter the symbol you want to add between: ");
					String symbol = get.scan.next();
					stringBuilderObj = run.appendStringBuilder(symbol,inputStringArray);
					length = run.getLength(stringBuilderObj);
					System.out.println("String after adding symbol inbetween: " + stringBuilderObj);
					System.out.println("Length of the String: " + length);
					int position = run.getFirstPositionOfSymbol(stringBuilderObj, symbol);
					System.out.println("First Index Position of the symbol: " + position);
				}
				catch (UserDefinedException ex)
				{
					System.out.println(ex);
				}
				break;
			}
			case 10:
			{
				try
				{
					StringBuilder stringBuilderObj = run.createFreshStringBuilder();
					System.out.println("Enter how many number of strings you want to add: ");
					number = get.getIntegerInput(number);
					String[] inputStringArray = new String[number];
					for (int i=0; i<number; i++)
					{
						inputStringArray[i] = get.scan.next();
					}
					System.out.println("Enter the symbol you want to add between: ");
					String symbol = get.scan.next();
					stringBuilderObj = run.appendStringBuilder(symbol,inputStringArray);
					length = run.getLength(stringBuilderObj);
					System.out.println("String after adding symbol inbetween: " + stringBuilderObj);
					System.out.println("Length of the String: " + length);
					int position = run.getLastPositionOfSymbol(stringBuilderObj, symbol);
					System.out.println("First Index Position of the symbol: " + position);
				}
				catch (UserDefinedException ex)
				{
					System.out.println(ex);
				}
				break;
			}
			default:
			{
				System.out.println(".......Enter value between 1 and 10.......");
			}

			}
			System.out.println(".......If you want to close the program enter 0.......");
			System.out.println("Enter which number of exercise you want to perform");
			exerciseNo = get.getIntegerInput(0);
		}

	}

}
