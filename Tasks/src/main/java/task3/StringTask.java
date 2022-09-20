package task3;

import java.util.Objects;

import myException.UserDefinedException;


public class StringTask 
{
	
    private void checkNull(Object inputString) throws UserDefinedException 
    {
        if (Objects.isNull(inputString)) 
        {
            throw new UserDefinedException("Input Value is null");
        }
    }

    private void checkEmpty(String inputString) throws UserDefinedException 
    {
        checkNull(inputString);
        if (inputString.isEmpty()) 
        {
            throw new UserDefinedException("Input value is empty");
        }
    }

    //EX1
    public int getLength(String inputString) throws UserDefinedException 
    {
        checkNull(inputString);
        return inputString.length();
    }
    //EX2
    public char[] getCharArr(String inputString) throws UserDefinedException 
    {
        checkNull(inputString);
        char[] chArray = inputString.toCharArray();
        return chArray;
    }
    //EX3
    public char getPenultimate(String inputString) throws UserDefinedException 
    {
        int length = getLength(inputString);
        return inputString.charAt(length - 2);
    }
    //EX4
    public int getOccurance(String inputString, char character) throws UserDefinedException 
    {
        char[] chArray = getCharArr(inputString);
        int number = 0;
        int length = chArray.length;
        for (int i = 0; i < length; i++) 
        {
            if (chArray[i] == character) 
            {
                number++;
            }
        }
        return number;
    }
    //EX5
    public int getGreatestPosition(String inputString, char character) throws UserDefinedException 
    {
        checkNull(inputString);
        int position = inputString.lastIndexOf(character);
        if (position == -1)
        {
        	return 0;
        }
        else
        {
        	return position;
        }
    }
    //EX6
    public String getLastNCharacters(String inputString, int index) throws UserDefinedException 
    {
    	int length = getLength(inputString);
        if (length >= index) 
        {
            if (index < 0) 
            {
                throw new UserDefinedException("The index value must be positive");
            }
            return inputString.substring(length - index);
        } 
        else 
        {
            throw new UserDefinedException("The index value must not greater than string length");
        }
    }
    //EX7
    public String getFirstNCharacters(String inputString, int index) throws UserDefinedException 
    {
    	int length = getLength(inputString);
        if (length >= index) 
        {
            if (index < 0) 
            {
                throw new UserDefinedException("The index value must be positive");
            }
            return inputString.substring(0, index);
        } else
            throw new UserDefinedException("The index value must not greater than string length");
    }
    //EX8
    public String replaceFirstNCharacters(String inputString, String inputString2) throws UserDefinedException 
    {
    	int length = getLength(inputString);
    	int length2 = getLength(inputString2);
        if (length2 <= length) 
        {
            String outputString = "";
            outputString = inputString2 + inputString.substring(length2);
            return outputString;
        } 
        else 
        {
            throw new UserDefinedException("Replaceable string must be smaller than original string");
        }
    }
    //EX9
    public boolean compareFirstNCharacters(String inputString, String comparingString) throws UserDefinedException 
    {
    	int cmpLength = getLength(comparingString);
    	int length = getLength(inputString);
        if (cmpLength <= length) 
        {
        return inputString.startsWith(comparingString);
        } 
        else 
        {
            throw new UserDefinedException("Comparing string must be smaller than original string");
        }
    }
    //EX10
    public boolean compareLastNCharacters(String inputString, String comparingString) throws UserDefinedException 
    {
    	int length = getLength(inputString);
    	int cmpLength = getLength(comparingString);
        if (cmpLength <= length) 
        {
            return inputString.endsWith(comparingString);
        } 
        else 
        {
            throw new UserDefinedException("Comparing string must be smaller than original string");
        }
    }
    //EX11
    public String convertToUppercase(String inputString) throws UserDefinedException 
    {
        checkNull(inputString);
        return inputString.toLowerCase();
    }
    //EX12
    public String convertToLowercase(String inputString) throws UserDefinedException 
    {
        checkNull(inputString);
        return inputString.toUpperCase();
    }
    //EX13
    public String getReverse(String inputString) throws UserDefinedException 
    {
    	String reverseString = "";
        int length = getLength(inputString);
        for (int i = 0; i < length; i++) 
        {
            char character = inputString.charAt(i);
            reverseString = character + reverseString;
        }
        return reverseString;
    }
    //EX16
    public String[] stringToStringArray(String inputString) throws UserDefinedException 
    {
        checkEmpty(inputString);
        String[] stringArray = inputString.split(" ");
        return stringArray;
    }
    //EX15
    public String getStringWithoutSpace(String inputString) throws UserDefinedException 
    {
        checkEmpty(inputString);
        String outputString;
        outputString = inputString.replace(" ", "");
        return outputString;
    }
    //EX17
    public String mergeStringsWithSymbols(String[] stringArray, int number, String symbol) throws UserDefinedException 
    {
        checkNull(stringArray);
        return String.join(symbol, stringArray);
    }
    //EX18
    public boolean compareCaseSensitive(String inputString, String inputString2) throws UserDefinedException 
    {
        checkNull(inputString);
        checkNull(inputString2);
        return inputString.equals(inputString2);
    }
    //EX19
    public boolean compareCaseInSensitive(String inputString, String inputString2) throws UserDefinedException 
    {
        checkNull(inputString);
        checkNull(inputString2);
        return inputString.equalsIgnoreCase(inputString2);
    }
    //EX20
    public String properString(String inputString) throws UserDefinedException 
    {
        checkEmpty(inputString);
        return inputString.trim();
    }
}