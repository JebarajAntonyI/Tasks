package task7;

import java.util.HashMap;

import java.util.Map;

import java.util.Map.Entry;

import myException.UserDefinedException;

import java.util.Scanner;

public class HashMapRunner 
{
	Scanner scan = new Scanner(System.in);
	public int getIntegerInput()
	{
		int integer = 0;
		boolean value = true;
		while (value)
		{
			if (scan.hasNextInt())
			{
				integer = scan.nextInt();
				value = false;
			}
			else
			{
				scan.next();
				System.out.print("Enter the value in Integer type: ");
				System.out.println();
			}
		}
		return integer;
	}

//	public String[] getStringArrayInput(int number)
//	{
//		String[] inputStringArray = new String[number];
//		for (int i = 0; i < number; i++)
//		{
//			inputStringArray[i] = scan.next();
//		}
//		return inputStringArray;
//	}

	public <T,U> void printHashMap(int number, Map<T, U> inputHM)
	{
		System.out.println("The HashMap is: ");
		for (Entry<T, U> i : inputHM.entrySet())
		{
			System.out.println(i.getKey() + " = " + i.getValue());
		}
	}

	public static void main(String[] args) throws UserDefinedException
	{
		HashMapRunner get = new HashMapRunner();

		HashMapTask run = new HashMapTask();

		System.out.println("Enter which number of exercise you want to perform: ");
		int exerciseNo = get.getIntegerInput();

		while(exerciseNo != 0)
		{
			try
			{
				switch(exerciseNo)
				{
					case 1:
					{
						Map<String, Integer> hashMapObj = new HashMap<>();
						int size = run.getSize(hashMapObj);
						System.out.println("The size of the HashMap is: " + size);
						break;
					}
	
					case 2:
					{
						Map<String, String> hashMapObj = new HashMap<>();
						run.getHashMap(hashMapObj, "First", "One");
						run.getHashMap(hashMapObj, "Second", "Two");
						run.getHashMap(hashMapObj, "Third", "Three");
						int size = run.getSize(hashMapObj);
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 3:
					{
						Map<Integer, Integer> hashMapObj = new HashMap<>();
						run.getHashMap(hashMapObj, 1, 11);
						run.getHashMap(hashMapObj, 2, 22);
						run.getHashMap(hashMapObj, 3, 33);
						int size = run.getSize(hashMapObj);
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 4:
					{
						Map<String, Integer> hashMapObj = new HashMap<>();
						run.getHashMap(hashMapObj, "First", 41);
						run.getHashMap(hashMapObj, "Second", 42);
						run.getHashMap(hashMapObj, "Third", 43);
						int size = run.getSize(hashMapObj);
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 5:
					{
						Map<String, Object> hashMapObj = new HashMap<>();
						run.getHashMap(hashMapObj, "First", get);
						run.getHashMap(hashMapObj, "Second", run);
						run.getHashMap(hashMapObj, "Third", get.scan);
						int size = run.getSize(hashMapObj);
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 6:
					{
						Map<String, String> hashMapObj = new HashMap<>();
						run.getHashMap(hashMapObj, "First", "One");
						run.getHashMap(hashMapObj, "Second", "Two");
						run.getHashMap(hashMapObj, "Third", null);
						int size = run.getSize(hashMapObj);
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 7:
					{
						Map<String, String> hashMapObj = new HashMap<>();
						run.getHashMap(hashMapObj, null, "One");
						int size = run.getSize(hashMapObj);
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 8:
					{
						Map<String, String> hashMapObj = new HashMap<>();
						run.getHashMap(hashMapObj, "First", "One");
						run.getHashMap(hashMapObj, "Second", "Two");
						run.getHashMap(hashMapObj, "Third", "Three");
						boolean value = run.isKeyPresent(hashMapObj, "ok");
						System.out.println("Is the given key is present: " + value);
						int size = run.getSize(hashMapObj);
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 9:
					{
						Map<String, String> hashMapObj = new HashMap<>();
						run.getHashMap(hashMapObj, "First", "One");
						run.getHashMap(hashMapObj, "Second", "Two");
						run.getHashMap(hashMapObj, "Third", "Three");
						boolean value = run.isValuePresent(hashMapObj, "One");
						System.out.println("Is the given value is present: " + value);
						int size = run.getSize(hashMapObj);
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 10:
					{
						Map<String, String> hashMapObj = new HashMap<>();
						run.getHashMap(hashMapObj, "First", "One");
						run.getHashMap(hashMapObj, "Second", "Two");
						run.getHashMap(hashMapObj, "Third", "Three");
						int size = run.getSize(hashMapObj);
						System.out.println("Before change");
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						String[] oldKeys = {"First", "Second", "Third"};
						String[] newValues = {"1", "2", "3"};
						run.changeValue(hashMapObj, oldKeys, newValues);
						size = run.getSize(hashMapObj);
						System.out.println("After change");
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 11:
					{
						Map<String, String> hashMapObj = new HashMap<>();
						run.getHashMap(hashMapObj, "First", "One");
						run.getHashMap(hashMapObj, "Second", "Two");
						run.getHashMap(hashMapObj, "Third", "Three");
						String valueOfKey = run.getValue(hashMapObj, "Second");
						int size = run.getSize(hashMapObj);
						System.out.println("The value of the given key is: " + valueOfKey);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 12:
					{
						Map<String, String> hashMapObj = new HashMap<>();
						run.getHashMap(hashMapObj, "First", "One");
						run.getHashMap(hashMapObj, "Second", "Two");
						run.getHashMap(hashMapObj, "Third", "Three");
						String valueOfKey = run.getValue(hashMapObj, "no");
						int size = run.getSize(hashMapObj);
						System.out.println("The value of the given key is: " + valueOfKey);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 13:
					{
						Map<String, String> hashMapObj = new HashMap<>();
						run.getHashMap(hashMapObj, "First", "One");
						run.getHashMap(hashMapObj, "Second", "Two");
						run.getHashMap(hashMapObj, "Third", "Three");
						int size = run.getSize(hashMapObj);
						System.out.println("Before Change: ");
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						String valueOfKey = run.getValueOrDefault(hashMapObj, "no");
						System.out.println("After Change: ");
						get.printHashMap(3, hashMapObj);
						System.out.println("The value of the given key is: " + valueOfKey);
						size = run.getSize(hashMapObj);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 14:
					{
						Map<String, String> hashMapObj = new HashMap<>();
						run.getHashMap(hashMapObj, "First", "One");
						run.getHashMap(hashMapObj, "Second", "Two");
						run.getHashMap(hashMapObj, "Third", "Three");
						int size = run.getSize(hashMapObj);
						System.out.println("Before Change: ");
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						run.removeKey(hashMapObj, "Second");
						System.out.println("After Change: ");
						get.printHashMap(3, hashMapObj);
						size = run.getSize(hashMapObj);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 15:
					{
						Map<String, String> hashMapObj = new HashMap<>();
						run.getHashMap(hashMapObj, "First", "One");
						run.getHashMap(hashMapObj, "Second", "Two");
						run.getHashMap(hashMapObj, "Third", "Three");
						int size = run.getSize(hashMapObj);
						System.out.println("Before Change: ");
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						run.removeKeyIfGivenValuePresent(hashMapObj, "Second", "Two");
						System.out.println("After Change: ");
						get.printHashMap(3, hashMapObj);
						size = run.getSize(hashMapObj);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 16:
					{
						Map<String, String> hashMapObj = new HashMap<>();
						run.getHashMap(hashMapObj, "First", "One");
						run.getHashMap(hashMapObj, "Second", "Two");
						run.getHashMap(hashMapObj, "Third", "Three");
						int size = run.getSize(hashMapObj);
						System.out.println("Before Change: ");
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						run.replaceValueOfExistingKey(hashMapObj, "Second", "Changed");
						System.out.println("After Change: ");
						get.printHashMap(3, hashMapObj);
						size = run.getSize(hashMapObj);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 17:
					{
						Map<String, String> hashMapObj = new HashMap<>();
						run.getHashMap(hashMapObj, "First", "One");
						run.getHashMap(hashMapObj, "Second", "Two");
						run.getHashMap(hashMapObj, "Third", "Three");
						int size = run.getSize(hashMapObj);
						System.out.println("Before Change: ");
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						run.replaceValueOfExistingKeyValue(hashMapObj, "Second", "Two", "Changed");
						System.out.println("After Change: ");
						get.printHashMap(3, hashMapObj);
						size = run.getSize(hashMapObj);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 18:
					{
						Map<String, String> hashMapObj1 = new HashMap<>();
						run.getHashMap(hashMapObj1, "First", "One");
						run.getHashMap(hashMapObj1, "Second", "Two");
						run.getHashMap(hashMapObj1, "Third", "Three");
						Map<String, String> hashMapObj2 = new HashMap<>();
						run.getHashMap(hashMapObj2, "Fourth", "Four");
						run.getHashMap(hashMapObj2, "Fifth", "Five");
						run.getHashMap(hashMapObj2, "Sixth", "Six");
						System.out.println("HashMap 1 is: ");
						get.printHashMap(3, hashMapObj1);
						int size = run.getSize(hashMapObj1);
						System.out.println("The size of HashMap 1 is: " + size);
						System.out.println("Before Change of HashMap 2: ");
						get.printHashMap(3, hashMapObj2);
						size = run.getSize(hashMapObj2);
						System.out.println("The size is: " + size);
						run.mergeTwoMaps(hashMapObj1, hashMapObj2);
						System.out.println("After Change: ");
						get.printHashMap(6, hashMapObj2);
						size = run.getSize(hashMapObj2);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 19:
					{
						Map<String, String> hashMapObj = new HashMap<>();
						run.getHashMap(hashMapObj, "First", "One");
						run.getHashMap(hashMapObj, "Second", "Two");
						run.getHashMap(hashMapObj, "Third", "Three");
						int size = run.getSize(hashMapObj);
						System.out.println("Print using Iterator");
						run.printUsingIterator(hashMapObj);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 20:
					{
						Map<String, String> hashMapObj = new HashMap<>();
						run.getHashMap(hashMapObj, "First", "One");
						run.getHashMap(hashMapObj, "Second", "Two");
						run.getHashMap(hashMapObj, "Third", "Three");
						int size = run.getSize(hashMapObj);
						System.out.println("Before Change: ");
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						System.out.println("After Change: ");
						run.removeAllEntries(hashMapObj);
						size = run.getSize(hashMapObj);
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						break;
					}
					
					default:
					{
						System.out.println("......Enter the value between 1 and 20");
					}

				}
			}
			catch (UserDefinedException ex)
			{
				System.out.println(ex);
			}
				System.out.println("If you want to close the program Enter 0");
				System.out.println("Enter which number of exercise you want to perform: ");
				exerciseNo = get.getIntegerInput();
			}
		}

	}
