package task6;

import java.util.ArrayList;

import java.util.Iterator;

import java.util.List;

import myException.UserDefinedException;

import myException.InputValidityCheck;

public class ArrayListTask
{

	public <T> int getSizeOfArrayList(List<T> inputAL) throws UserDefinedException
	{
		InputValidityCheck.checkNull(inputAL);
		return inputAL.size();
	}

	public List<String> getArrayListOfStrings(int number, String[] inputStringArr) throws UserDefinedException
	{
		List<String> inputAL = new ArrayList<>();
		for (int i=0; i<number; i++)
		{
			inputAL.add(inputStringArr[i]);
		}
		return inputAL;
	}

	public List<Integer> getArrayListOfInt(int number, int[] intArr) throws UserDefinedException
	{
		List<Integer> inputAL = new ArrayList<>();
		for (int i=0; i<number; i++)
		{
			inputAL.add(intArr[i]);
		}
		return inputAL;
	}

	public List<Float> getArrayListOfFloat(int number, float[] floatArr) throws UserDefinedException
	{
		List<Float> inputAL = new ArrayList<>();
		for (int i=0; i<number; i++)
		{
			inputAL.add(floatArr[i]);
		}
		return inputAL;
	}

	public List<Long> getArrayListOfLong(int number, long[] longArr) throws UserDefinedException
	{
		List<Long> inputAL = new ArrayList<>();
		for (int i=0; i<number; i++)
		{
			inputAL.add(longArr[i]);
		}
		return inputAL;
	}
	public List<Object> getArrayListOfIntAndString(int number, int[] intArr, int number2, String[] stringArr) throws UserDefinedException
	{
		List<Object> inputAL = new ArrayList<>();
		for (int i=0; i<number; i++)
		{
			inputAL.add(intArr[i]);
		}
		for (int i=0; i<number2; i++)
		{
			inputAL.add(stringArr[i]);			
		}
		return inputAL;
	}

	public int findPosition (List<String> inputAL, String find) throws UserDefinedException
	{
		InputValidityCheck.checkNull(inputAL);
		int position = inputAL.indexOf(find);
		if (position < 0)
		{
			throw new UserDefinedException ("The given input is not available");
		}
		return position;
	}

	public void printUsingIterator(List<String> inputAL) throws UserDefinedException
	{
		InputValidityCheck.checkNull(inputAL);
		Iterator <String> it = inputAL.iterator();
		System.out.println("Print using Iterator");
		while (it.hasNext())
		{
			System.out.println(it.next());
		}
	}

	public void printUsingForLoop(List<String> inputAL) throws UserDefinedException
	{
		System.out.println("Print using For loop");
		for (String i : inputAL)
		{
			System.out.println(i);
		}
	}

	public String getIndexString(List<String> inputAL, int index) throws UserDefinedException
	{
		if (index >= getSizeOfArrayList(inputAL) || index < 0)
		{
			throw new UserDefinedException ("The Index value is outside the boundary");
		}
		return inputAL.get(index);
	}

	public int getFirstPosition(List<String> inputAL, String word) throws UserDefinedException
	{
		InputValidityCheck.checkNull(inputAL);
		return inputAL.indexOf(word);
	}

	public int getLastPosition(List<String> inputAL, String word) throws UserDefinedException
	{
		InputValidityCheck.checkNull(inputAL);
		return inputAL.lastIndexOf(word);
	}

	public List<String> insertWord(List<String> inputAL, String word, int index) throws UserDefinedException
	{
		if (index < 0 || index >= getSizeOfArrayList(inputAL))
		{
			throw new UserDefinedException ("The Index value is outside the boundary");

		}
		inputAL.add(index, word);
		return inputAL;
	}

	public List<String> createSubArrayList(List<String> inputAL, int from, int to) throws UserDefinedException
	{
		int Size = getSizeOfArrayList(inputAL);
		if (from < 0 || from >= Size || to < 0 || to >= Size || from>to)
		{
			throw new UserDefinedException ("The Index value is outside the boundary");

		}
		return inputAL.subList(from, to);
	}

	public List<String> mergeTwoArrayList(List<String> inputAL, List<String> inputAL2) throws UserDefinedException
	{
		List<String> outputAL = new ArrayList<String> ();
		outputAL.addAll(inputAL);
		outputAL.addAll(inputAL2);
		return outputAL;
	}

	public List<Float> removeParticularValues(List<Float> inputAL, float bin) throws UserDefinedException
	{
		InputValidityCheck.checkNull(inputAL);
		inputAL.remove(bin);
		return inputAL;
	}

	public List<Float> removeIndexValues(List<Float> inputAL, int index) throws UserDefinedException
	{
		if (index < 0 || index >= getSizeOfArrayList(inputAL))
		{
			throw new UserDefinedException ("The Index value is outside the boundary");

		}
		inputAL.remove(index);
		return inputAL;
	}

	public List<Long> removeFromToIndex (List<Long> inputAL, int from, int to) throws UserDefinedException
	{
		int Size = getSizeOfArrayList(inputAL);
		if (from < 0 || from >= Size || to < 0 || to >= Size || from>to)
		{
			throw new UserDefinedException ("The Index value is outside the boundary");

		}
		inputAL.subList(from, to).clear();
		return inputAL;
	}

	public List<String> removeSameString(List<String> inputAL, List<String> inputAL2) throws UserDefinedException
	{
		InputValidityCheck.checkNull(inputAL);
		inputAL.removeAll(inputAL2);
		return inputAL;
	}

	public List<String> retainSameString(List<String> inputAL, List<String> inputAL2) throws UserDefinedException
	{
		InputValidityCheck.checkNull(inputAL);
		inputAL.retainAll(inputAL2);
		return inputAL;
	}

	public List<Long> removeAll (List<Long> inputAL) throws UserDefinedException
	{
		InputValidityCheck.checkNull(inputAL);
		inputAL.removeAll(inputAL);
		return inputAL;
	}

	public boolean isGivenStringIsPresent (List<String> inputAL, String given) throws UserDefinedException
	{
		InputValidityCheck.checkNull(inputAL);
		return inputAL.contains(given);
	}
}
























