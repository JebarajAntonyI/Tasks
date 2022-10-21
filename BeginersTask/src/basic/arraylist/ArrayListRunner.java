package basic.arraylist;

import java.util.ArrayList;

import java.util.List;

import java.util.Scanner;

import myException.UserDefinedException;

public class ArrayListRunner 
{

	Scanner scan = new Scanner(System.in);
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
				System.out.println("Enter the value in Integer: ");
			}
		}
		return number;
	}

	public float getFloatInput(float number)
	{
		boolean value = true;
		while (value)
		{
			if (scan.hasNextFloat())
			{
				number = scan.nextFloat();
				value = false;
			}
			else 
			{
				scan.next();
				System.out.println("Enter the value in Integer: ");
			}
		}
		return number;
	}

	public long getLongInput(long number)
	{
		boolean value = true;
		while (value)
		{
			if (scan.hasNextLong())
			{
				number = scan.nextLong();
				value = false;
			} else 
			{
				scan.next();
				System.out.println("Enter the value in Integer: ");
			}
		}
		return number;
	}

	public String getStringInput()
	{
		String inputString;
		System.out.println("Enter the String: ");
		inputString = scan.next();
		return inputString;
	}

	public String[] getStringArrInput(int number)
	{
		String[] inputStringArr = new String[number];
		for (int i=0; i<number; i++)
		{
			inputStringArr[i] = scan.next();
		}
		return inputStringArr;
	}

	public int[] getIntArrInput(int number)
	{
		int[] intArr = new int[number];
		for (int i=0; i<number; i++)
		{
			boolean value = true;
			while (value)
			{
				if (scan.hasNextInt())
				{
					intArr[i] = scan.nextInt();
					value = false;
				} else 
				{
					scan.next();
					System.out.println("Enter the value in Integer: ");
				}
			}
		}
		return intArr;
	}

	public <T> void printArrayList(List<T> outputAL) throws UserDefinedException
	{
		ArrayListTask run = new ArrayListTask();
		int size = run.getSizeOfArrayList(outputAL);
		System.out.print("The ArrayList is: ");
		for (int i=0; i < size; i++)
		{
			System.out.print(outputAL.get(i) + "  ");
		}
	}

	public static void main(String[] args) throws UserDefinedException
	{
		ArrayListRunner get = new ArrayListRunner();
		ArrayListTask run = new ArrayListTask();

		int size = 0, number = 0, number2 = 0;
		String[] inputStringArr;

		System.out.println("Enter which number of exercise you want perform: ");
		int exerciseNo = get.getIntegerInput(0);


		while (exerciseNo != 0)
		{
			try
			{
				switch (exerciseNo)
				{
				case 1:
				{
					List<String> inputAL = new ArrayList<>();
					size = run.getSizeOfArrayList(inputAL);
					System.out.println("The size of Array List: " + size);
					break;
				}
				case 2:
				{
					System.out.println("Enter the number of strings you want to add: ");
					number = get.getIntegerInput(0);
					inputStringArr = get.getStringArrInput(number);
					List<String> inputAL = new ArrayList<>();
					inputAL = run.getArrayListOfStrings(number, inputStringArr);
					size = run.getSizeOfArrayList(inputAL);
					get.printArrayList(inputAL);
					System.out.println();
					System.out.println("The size of Array List: " + size);
					break;
				}
				case 3:
				{
					System.out.println("Enter the number of int you want to add: ");
					number = get.getIntegerInput(0);
					int[] intArr = get.getIntArrInput(number);
					List<Integer> inputAL = new ArrayList<>();
					inputAL = run.getArrayListOfInt(number, intArr);
					size = run.getSizeOfArrayList(inputAL);
					get.printArrayList(inputAL);
					System.out.println();
					System.out.println("The size of Array List: " + size);
					break;
				}
				case 4:
				{
					List<Object> inputAL = new ArrayList<>();
					inputAL.add(get);
					inputAL.add(run);
					get.printArrayList(inputAL);
					size = run.getSizeOfArrayList(inputAL);
					System.out.println();
					System.out.println("The size of Array List: " + size);
					break;
				}
				case 5:
				{
					List<Object> inputAL = new ArrayList<>();
					System.out.println("Enter the number of int you want to add: ");
					number = get.getIntegerInput(0);
					int[] intArr = new int[number];
					for (int i=0; i<number; i++)
					{
						intArr[i] = get.getIntegerInput(0);
					}
					System.out.println("Enter the number of strings you want to add: ");
					number2 = get.getIntegerInput(0);
					String[] stringArr2 = new String[number2];
					for (int i=0; i<number2; i++)
					{
						stringArr2[i] = get.getStringInput();
					}
					inputAL = run.getArrayListOfIntAndString(intArr, stringArr2);
					inputAL.add(get);
					inputAL.add(run);
					get.printArrayList(inputAL);
					System.out.println();
					size = run.getSizeOfArrayList(inputAL);
					System.out.println("The size of Array List: " + size);
					break;
				}
				case 6:
				{
					System.out.println("Enter the number of strings you want to add: ");
					number = get.getIntegerInput(0);
					inputStringArr = get.getStringArrInput(number);
					List<String> inputAL = new ArrayList<>();
					inputAL = run.getArrayListOfStrings(number, inputStringArr);
					size = run.getSizeOfArrayList(inputAL);
					System.out.println("Enter the word to find position: ");
					String find = get.getStringInput();
					int position = run.getFirstPosition(inputAL,find);
					if (position < 0)
					{
						System.out.println("The given input is not available");
					}
					else
					{
						System.out.println("The Index position of the given word is: " + position);
					}
					System.out.println();
					System.out.println("The size of Array List: " + size);
					break;
				}
				case 7:
				{
					System.out.println("Enter the number of strings you want to add: ");
					number = get.getIntegerInput(0);
					inputStringArr = get.getStringArrInput(number);
					List<String> inputAL = new ArrayList<>();
					inputAL = run.getArrayListOfStrings(number, inputStringArr);
					size = run.getSizeOfArrayList(inputAL);
					run.printUsingIterator(inputAL);
					run.printUsingForLoop(inputAL);
					break;
				}
				case 8:
				{
					System.out.println("Enter the number of strings you want to add: ");
					number = get.getIntegerInput(0);
					inputStringArr = get.getStringArrInput(number);
					List<String> inputAL = new ArrayList<>();
					inputAL = run.getArrayListOfStrings(number, inputStringArr);
					size = run.getSizeOfArrayList(inputAL);
					System.out.println("Enter the index you want to print: ");
					int index = get.getIntegerInput(0);
					String position = run.getIndexString(inputAL, index);
					System.out.println("The size of Array List: " + size);
					System.out.println("The Index" +index+ "value is: " + position);
					break;
				}
				case 9:
				{
					System.out.println("Enter the number of strings you want to add: ");
					number = get.getIntegerInput(0);
					inputStringArr = get.getStringArrInput(number);
					List<String> inputAL = new ArrayList<>();
					inputAL = run.getArrayListOfStrings(number, inputStringArr);
					size = run.getSizeOfArrayList(inputAL);
					System.out.println("Enter the word to find: ");
					String word = get.getStringInput();
					int firstIndex = run.getFirstPosition(inputAL, word);
					int lastIndex = run.getLastPosition(inputAL, word);
					System.out.println("The size of Array List: " + size);
					System.out.println("First position: " + firstIndex + "   ............   " + "Last Position: " + lastIndex);
					break;
				}
				case 10:
				{
					System.out.println("Enter the number of strings you want to add: ");
					number = get.getIntegerInput(0);
					inputStringArr = get.getStringArrInput(number);
					List<String> inputAL = new ArrayList<>();
					inputAL = run.getArrayListOfStrings(number, inputStringArr);
					System.out.println("Enter the String you want to add: ");
					String word = get.getStringInput();
					System.out.println("Enter the index you want to add that word: ");
					int index = get.getIntegerInput(0);
					inputAL = run.insertWord(inputAL, word, index);
					size = run.getSizeOfArrayList(inputAL);
					System.out.println("The size of Array List: " + size);
					get.printArrayList(inputAL);
					break;
				}
				case 11:
				{
					System.out.println("Enter the number of strings you want to add: ");
					number = get.getIntegerInput(0);
					inputStringArr = get.getStringArrInput(number);
					List<String> inputAL1 = new ArrayList<>();
					inputAL1 = run.getArrayListOfStrings(number, inputStringArr);
					System.out.println("Enter from and to index to create a new Array list: ");
					int firstIndex = get.getIntegerInput(0);
					int lastIndex = get.getIntegerInput(0);
					List<String> inputAL2 = new ArrayList<>();
					inputAL2 = run.createSubArrayList(inputAL1, firstIndex, lastIndex);
					size = run.getSizeOfArrayList(inputAL2);
					System.out.println("The size of Array List: " + size);
					get.printArrayList(inputAL2);
					break;
				}
				case 12:
				{
					System.out.println("Enter the number of strings you want to add in ArrayList 1: ");
					number = get.getIntegerInput(0);
					String[] inputStringArr1 = get.getStringArrInput(number);
					List<String> inputAL1 = new ArrayList<>();
					inputAL1 = run.getArrayListOfStrings(number, inputStringArr1);
					System.out.println("Enter the number of strings you want to add in ArrayLIst 2: ");
					number = get.getIntegerInput(0);
					String[] inputStringArr2 = get.getStringArrInput(number);
					List<String> inputAL2 = new ArrayList<>();
					inputAL2 = run.getArrayListOfStrings(number, inputStringArr2);
					List<String> inputAL3 = new ArrayList<>();
					inputAL3 = run.mergeTwoArrayList(inputAL1, inputAL2);
					size = run.getSizeOfArrayList(inputAL3);
					System.out.println("The size of Array List: " + size);
					get.printArrayList(inputAL3);
					break;
				}
				case 13:
				{
					System.out.println("Enter the number of strings you want to add in ArrayList 1: ");
					number = get.getIntegerInput(0);
					String[] inputStringArr1 = get.getStringArrInput(number);
					List<String> inputAL1 = new ArrayList<>();
					inputAL1 = run.getArrayListOfStrings(number, inputStringArr1);
					System.out.println("Enter the number of strings you want to add in ArrayLIst 2: ");
					number = get.getIntegerInput(0);
					String[] inputStringArr2 = get.getStringArrInput(number);
					List<String> inputAL2 = new ArrayList<>();
					inputAL2 = run.getArrayListOfStrings(number, inputStringArr2);
					List<String> inputAL3 = new ArrayList<>();
					inputAL3 = run.mergeTwoArrayList(inputAL2, inputAL1);
					size = run.getSizeOfArrayList(inputAL3);
					System.out.println("The size of Array List: " + size);
					get.printArrayList(inputAL3);
					break;
				}
				case 14:
				{
					System.out.println("Enter the number of values you want to add: ");
					number = get.getIntegerInput(0);
					List<Float> inputAL1 = new ArrayList<>();
					float[] floatArr = new float[number];
					for (int i=0; i < number; i++)
					{
						floatArr [i] = get.getFloatInput(0);
					}
					inputAL1 = run.getArrayListOfFloat(number, floatArr);
					System.out.println("Enter the value to remove: ");
					float floatNumber = get.scan.nextFloat();
					List<Float> outputAL = new ArrayList<>();
					outputAL = run.removeParticularValues(inputAL1, floatNumber);
					size = run.getSizeOfArrayList(outputAL);
					System.out.println("The size of Array List: " + size);
					get.printArrayList(outputAL);
					break;
				}
				case 15:
				{
					System.out.println("Enter the number of values you want to add: ");
					number = get.getIntegerInput(0);
					List<Float> inputAL1 = new ArrayList<>();
					float[] floatArr = new float[number];
					for (int i=0; i < number; i++)
					{
						floatArr [i] = get.getFloatInput(0);
					}
					inputAL1 = run.getArrayListOfFloat(number, floatArr);
					System.out.println("Enter the index to remove: ");
					int index = get.getIntegerInput(0);
					List<Float> outputAL = new ArrayList<>();
					outputAL = run.removeIndexValues(inputAL1, index);
					size = run.getSizeOfArrayList(outputAL);
					System.out.println("The size of Array List: " + size);
					get.printArrayList(outputAL);
					break;
				}
				case 16:
				{
					System.out.println("Enter the number of values you want to add: ");
					number = get.getIntegerInput(0);
					List<Long> inputAL1 = new ArrayList<>();
					long [] longArr = new long [number];
					for (int i=0; i < number; i++)
					{
						longArr[i] = get.getLongInput(0);
					}
					inputAL1 = run.getArrayListOfLong(number, longArr);
					System.out.println("Enter the from and to index to remove: ");
					int fromIndex = get.getIntegerInput(0);
					int toIndex = get.getIntegerInput(0);
					List<Long> outputAL = new ArrayList<>();
					outputAL = run.removeFromToIndex(inputAL1, fromIndex, toIndex);
					size = run.getSizeOfArrayList(outputAL);
					System.out.println("The size of Array List: " + size);
					get.printArrayList(outputAL);
					break;
				}
				case 17:
				{
					System.out.println("Enter the number of strings you want to add in ArrayList 1: ");
					number = get.getIntegerInput(0);
					String[] inputStringArr1 = get.getStringArrInput(number);
					List<String> inputAL1 = new ArrayList<>();
					inputAL1 = run.getArrayListOfStrings(number, inputStringArr1);
					System.out.println("Enter the number of strings you want to add in ArrayLIst 2: ");
					number = get.getIntegerInput(0);
					String[] inputStringArr2 = get.getStringArrInput(number);
					List<String> inputAL2 = new ArrayList<>();
					inputAL2 = run.getArrayListOfStrings(number, inputStringArr2);
					List<String> outputAL = new ArrayList<>();
					outputAL = run.removeSameString(inputAL1, inputAL2);
					size = run.getSizeOfArrayList(outputAL);
					System.out.println("The size of Array List: " + size);
					get.printArrayList(outputAL);
					break;
				}
				case 18:
				{
					System.out.println("Enter the number of strings you want to add in ArrayList 1: ");
					number = get.getIntegerInput(0);
					String[] inputStringArr1 = get.getStringArrInput(number);
					List<String> inputAL1 = new ArrayList<>();
					inputAL1 = run.getArrayListOfStrings(number, inputStringArr1);
					System.out.println("Enter the number of strings you want to add in ArrayLIst 2: ");
					number = get.getIntegerInput(0);
					String[] inputStringArr2 = get.getStringArrInput(number);
					List<String> inputAL2 = new ArrayList<>();
					inputAL2 = run.getArrayListOfStrings(number, inputStringArr2);
					List<String> outputAL = new ArrayList<>();
					outputAL = run.retainSameString(inputAL1, inputAL2);
					size = run.getSizeOfArrayList(outputAL);
					System.out.println("The size of Array List: " + size);
					get.printArrayList(outputAL);
					break;
				}
				case 19:
				{
					System.out.println("Enter the number of values you want to add: ");
					number = get.getIntegerInput(0);
					List<Long> inputAL1 = new ArrayList<>();
					long [] longArr = new long [number];
					for (int i=0; i < number; i++)
					{
						longArr[i] = get.getLongInput(0);
					}
					inputAL1 = run.getArrayListOfLong(number, longArr);
					List<Long> outputAL = new ArrayList<>();
					outputAL = run.removeAll(inputAL1);
					size = run.getSizeOfArrayList(outputAL);
					System.out.println("The size of Array List: " + size);
					get.printArrayList(outputAL);
					break;
				}
				case 20:
				{
					System.out.println("Enter the number of strings you want to add in ArrayList 1: ");
					number = get.getIntegerInput(0);
					String[] inputStringArr1 = get.getStringArrInput(number);
					List<String> inputAL1 = new ArrayList<>();
					inputAL1 = run.getArrayListOfStrings(number, inputStringArr1);
					System.out.println("Enter the word you want to check: ");
					String checkWord = get.getStringInput();
					boolean value = run.isGivenStringIsPresent(inputAL1, checkWord);
					System.out.println(value);
					size = run.getSizeOfArrayList(inputAL1);
					System.out.println("The size of Array List: " + size);
					get.printArrayList(inputAL1);
					break;
				}
				}
			}
			catch (UserDefinedException e)
			{
				System.out.println(e);
			}
			System.out.println();
			System.out.println(".......If you want to close the program enter 0.......");
			System.out.println("Enter which number of exercise you want to perform: ");
			exerciseNo = get.getIntegerInput(0);
		}



	}

}
