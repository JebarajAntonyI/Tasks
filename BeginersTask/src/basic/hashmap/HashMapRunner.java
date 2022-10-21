package basic.hashmap;

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
	
	public void getHashMapEntry(Map<String, String> hashMapObj) throws UserDefinedException
	{
		HashMapTask run = new HashMapTask();

		for (int i=0; i < 3; i++)
		{
			System.out.println("Enter key");
			String key = scan.next();
			System.out.println("Enter Value");
			String value = scan.next();
			run.getHashMap(hashMapObj, key, value);
		}
	}
	
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
						Map<String, Integer> hashMapObj = run.getNewHashMap();						//swami
						int size = run.getSize(hashMapObj);
						System.out.println("The size of the HashMap is: " + size);
						break;
					}
	
					case 2:
					{
						Map<String, String> hashMapObj = run.getNewHashMap();
						get.getHashMapEntry(hashMapObj);
						int size = run.getSize(hashMapObj);
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 3:
					{
						Map<Integer, Integer> hashMapObj = run.getNewHashMap();
						for (int i=0; i < 3; i++)
						{
							System.out.println("Enter key");
							int key = get.getIntegerInput();
							System.out.println("Enter Value");
							int value = get.getIntegerInput();
							run.getHashMap(hashMapObj, key, value);
						}
						int size = run.getSize(hashMapObj);
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 4:
					{
						Map<String, Integer> hashMapObj = run.getNewHashMap();
						for (int i=0; i < 3; i++)
						{
							System.out.println("Enter key");
							String key = get.scan.next();
							System.out.println("Enter Value");
							int value = get.getIntegerInput();
							run.getHashMap(hashMapObj, key, value);
						}
						int size = run.getSize(hashMapObj);
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 5:
					{
						Map<String, Object> hashMapObj = run.getNewHashMap();
						System.out.println("Enter key 1");
						String key = get.scan.next();
						run.getHashMap(hashMapObj, key, get);
						System.out.println("Enter key 2");
						key = get.scan.next();
						run.getHashMap(hashMapObj, key, run);
						System.out.println("Enter key 3");
						key = get.scan.next();
						run.getHashMap(hashMapObj, key, get.scan);
						int size = run.getSize(hashMapObj);
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 6:
					{
						Map<String, String> hashMapObj = run.getNewHashMap();
						get.getHashMapEntry(hashMapObj);
						System.out.println("Before Change");
						get.printHashMap(3, hashMapObj);
						System.out.println("Enter key you want to set null value");
						String key = get.scan.next();
						run.getHashMap(hashMapObj, key, null);
						System.out.println("After Change");
						int size = run.getSize(hashMapObj);
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 7:
					{
						Map<String, String> hashMapObj = run.getNewHashMap();
						run.getHashMap(hashMapObj, null, "One");
						int size = run.getSize(hashMapObj);
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 8:
					{
						Map<String, String> hashMapObj = run.getNewHashMap();
						get.getHashMapEntry(hashMapObj);
						System.out.println("Enter key to find if it is present");
						String key = get.scan.next();
						boolean value = run.isKeyPresent(hashMapObj, key);
						System.out.println("Is the given key is present: " + value);
						int size = run.getSize(hashMapObj);
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 9:
					{
						Map<String, String> hashMapObj = run.getNewHashMap();
						get.getHashMapEntry(hashMapObj);
						System.out.println("Enter value to find if it is present");
						String stringValue = get.scan.next();
						boolean value = run.isValuePresent(hashMapObj, stringValue);
						System.out.println("Is the given value is present: " + value);
						int size = run.getSize(hashMapObj);
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 10:
					{
						Map<String, String> hashMapObj = run.getNewHashMap();
						get.getHashMapEntry(hashMapObj);
						int size = run.getSize(hashMapObj);
						System.out.println("Before change");
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						System.out.println("Enter any old key you want to replace with new value");
						String oldKey = get.scan.next();
						System.out.println("Enter new value");
						String newValue = get.scan.next();
						run.changeValue(hashMapObj, oldKey, newValue);
						size = run.getSize(hashMapObj);
						System.out.println("After change");
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 11:
					{
						Map<String, String> hashMapObj = run.getNewHashMap();
						get.getHashMapEntry(hashMapObj);
						System.out.println("Enter the existing key you want to get the value of that key");
						String key = get.scan.next();
						String valueOfKey = run.getValue(hashMapObj, key);
						int size = run.getSize(hashMapObj);
						System.out.println("The value of the given key is: " + valueOfKey);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 12:
					{
						Map<String, String> hashMapObj = run.getNewHashMap();
						get.getHashMapEntry(hashMapObj);
						System.out.println("Enter the non existing key you want to get the value of that key");
						String key = get.scan.next();
						String valueOfKey = run.getValue(hashMapObj, key);
						int size = run.getSize(hashMapObj);
						System.out.println("The value of the given key is: " + valueOfKey);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 13:
					{
						Map<String, String> hashMapObj = run.getNewHashMap();
						get.getHashMapEntry(hashMapObj);
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
						Map<String, String> hashMapObj = run.getNewHashMap();
						get.getHashMapEntry(hashMapObj);
						int size = run.getSize(hashMapObj);
						System.out.println("Before Change: ");
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						System.out.println("Enter the key you want to remove");
						String removeKey = get.scan.next();
						run.removeKey(hashMapObj, removeKey);
						System.out.println("After Change: ");
						get.printHashMap(3, hashMapObj);
						size = run.getSize(hashMapObj);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 15:
					{
						Map<String, String> hashMapObj = run.getNewHashMap();
						get.getHashMapEntry(hashMapObj);
						int size = run.getSize(hashMapObj);
						System.out.println("Before Change: ");
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						System.out.println("Enter the key and value you want to remove");
						String removeKey = get.scan.next();
						String removeValue = get.scan.next();
						run.removeKeyIfGivenValuePresent(hashMapObj, removeKey, removeValue);
						System.out.println("After Change: ");
						get.printHashMap(3, hashMapObj);
						size = run.getSize(hashMapObj);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 16:
					{
						Map<String, String> hashMapObj = run.getNewHashMap();
						get.getHashMapEntry(hashMapObj);
						int size = run.getSize(hashMapObj);
						System.out.println("Before Change: ");
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						System.out.println("Enter the key and replace value");
						String key = get.scan.next();
						String replaceValue = get.scan.next();
						run.replaceValueOfExistingKey(hashMapObj, key, replaceValue);
						System.out.println("After Change: ");
						get.printHashMap(3, hashMapObj);
						size = run.getSize(hashMapObj);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 17:
					{
						Map<String, String> hashMapObj = run.getNewHashMap();
						get.getHashMapEntry(hashMapObj);
						int size = run.getSize(hashMapObj);
						System.out.println("Before Change: ");
						get.printHashMap(3, hashMapObj);
						System.out.println("The size is: " + size);
						System.out.println("Enter the key, existing value and replace value");
						String key = get.scan.next();
						String existingValue = get.scan.next();
						String replaceValue = get.scan.next();
						run.replaceValueOfExistingKeyValue(hashMapObj, key, existingValue, replaceValue);
						System.out.println("After Change: ");
						get.printHashMap(3, hashMapObj);
						size = run.getSize(hashMapObj);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 18:
					{
						Map<String, String> hashMapObj1 = run.getNewHashMap();
						System.out.println("Enter for Map 1");
						get.getHashMapEntry(hashMapObj1);
						Map<String, String> hashMapObj2 = run.getNewHashMap();
						System.out.println("Enter for Map 2");
						get.getHashMapEntry(hashMapObj2);
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
						Map<String, String> hashMapObj = run.getNewHashMap();
						get.getHashMapEntry(hashMapObj);
						int size = run.getSize(hashMapObj);
						System.out.println("Print using Iterator");
						run.printUsingIterator(hashMapObj);
						System.out.println("The size is: " + size);
						break;
					}
					
					case 20:
					{
						Map<String, String> hashMapObj = run.getNewHashMap();
						get.getHashMapEntry(hashMapObj);
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
