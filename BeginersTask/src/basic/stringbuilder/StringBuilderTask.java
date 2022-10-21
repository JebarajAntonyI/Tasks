package basic.stringbuilder;

import myException.InputValidityCheck;

import myException.UserDefinedException;

public class StringBuilderTask 
{

	public StringBuilder createFreshStringBuilder()
	{
		StringBuilder fresh = new StringBuilder();
		return fresh;
	}
	
	//Ex1
		public int getLength(StringBuilder inputStringBuilder) throws UserDefinedException
		{
			InputValidityCheck.checkNull(inputStringBuilder);
			return inputStringBuilder.length();
		}

	//EX2
	public StringBuilder appendStringBuilder(String symbol, String... inputString) throws UserDefinedException
	{
		InputValidityCheck.checkNull(inputString);
		StringBuilder stringBuilderObj = createFreshStringBuilder();
		int length = inputString.length;
		for (int i=0; i<length; i++)
		{
			stringBuilderObj.append(inputString[i]);
			stringBuilderObj.append(symbol);
		}
		int sbLength = getLength(stringBuilderObj);
		stringBuilderObj.deleteCharAt(sbLength-1);
		return stringBuilderObj;
	}

	//EX3
	public StringBuilder getInsertedStrings(StringBuilder inputStringBuilder, String[] inputStringArray, String character) throws UserDefinedException
	{
		InputValidityCheck.checkNull(inputStringArray);
		InputValidityCheck.checkNull(inputStringBuilder);
		int length = inputStringArray.length;
		int index;
		for (int i=0; i<length; i++)
		{
			index = getLastPositionOfSymbol(inputStringBuilder, character);
			inputStringBuilder.insert(index+1, (inputStringArray[i] + character));
		}
		return inputStringBuilder;
	}

	//Ex4
	public StringBuilder deleteFirstString(StringBuilder inputStringBuilder, String character) throws UserDefinedException
	{
		int index = getFirstPositionOfSymbol(inputStringBuilder, character);
		inputStringBuilder = toRemoveStringsInbetween(inputStringBuilder, 0, index+1);
		return inputStringBuilder;
	}

	//Ex5	
	public StringBuilder getStringBuilderSpaceReplace(StringBuilder inputStringBuilder, String secondCharacter, String firstCharacter) throws UserDefinedException
	{
		int length = getLength(inputStringBuilder);
		for (int index=0; index<length; index++)
		{
			if (inputStringBuilder.charAt(index) == firstCharacter.charAt(0))
			{
				inputStringBuilder = toReplaceStringsInbetween(inputStringBuilder, secondCharacter, index, index+1);
			}
		}
		return inputStringBuilder;
	}

	//Ex6
	public StringBuilder getReverseStringBuilder(StringBuilder inputStringBuilder) throws UserDefinedException
	{
		InputValidityCheck.checkNull(inputStringBuilder);
		return inputStringBuilder.reverse();
	}

	//Ex7
	public StringBuilder toRemoveStringsInbetween(StringBuilder inputStringBuilder, int fromIndex, int toIndex) throws UserDefinedException
	{
		int size = getLength(inputStringBuilder);
		InputValidityCheck.indexCheck(size, fromIndex);
		InputValidityCheck.indexCheck(size, toIndex);
		if (fromIndex>toIndex)
		{
			throw new UserDefinedException("The fromIndex is greater than toIndex");
		}
		return inputStringBuilder.delete(fromIndex, toIndex);
	}

	//Ex8
	public StringBuilder toReplaceStringsInbetween(StringBuilder inputStringBuilder, String replaceString, int fromIndex, int toIndex)throws UserDefinedException
	{
		int size = getLength(inputStringBuilder);
		InputValidityCheck.indexCheck(size, fromIndex);
		InputValidityCheck.indexCheck(size, toIndex);
		if (fromIndex>toIndex)
		{
			throw new UserDefinedException("The fromIndex is greater than toIndex");
		}
		return inputStringBuilder.replace(fromIndex, toIndex, replaceString);
	}

	//Ex9
	public int getFirstPositionOfSymbol(StringBuilder inputStringBuilder, String symbol)throws UserDefinedException
	{
		InputValidityCheck.checkNull(inputStringBuilder);
		return inputStringBuilder.indexOf(symbol);
	}

	//Ex10
	public int getLastPositionOfSymbol(StringBuilder inputStringBuilder, String symbol)throws UserDefinedException
	{
		InputValidityCheck.checkNull(inputStringBuilder);
		return inputStringBuilder.lastIndexOf(symbol);
	}
}



















