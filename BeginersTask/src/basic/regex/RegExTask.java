package basic.regex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import myException.InputValidityCheck;
import myException.UserDefinedException;

public class RegExTask 
{
//	EX1
	public boolean mobileNumberValidation(String mobile) throws UserDefinedException, PatternSyntaxException
	{
		InputValidityCheck.checkNull(mobile);
		String regxPattern = "[7-9]\\d{9}";
		return mobile.matches(regxPattern);
	}
	
//	EX2
	public boolean alphaNumericOnly(String inputString) throws UserDefinedException, PatternSyntaxException
	{
		InputValidityCheck.checkNull(inputString);
		String regxPattern = "^[a-zA-Z0-9]+$";
		return inputString.matches(regxPattern);
	}
	
//	EX3
	public boolean stringStartsWith(String inputString, String matchingString) throws UserDefinedException, PatternSyntaxException
	{
		InputValidityCheck.checkNull(inputString);
		InputValidityCheck.checkNull(matchingString);
		Pattern patrernObj = Pattern.compile("^" + matchingString);
		Matcher matcherObj = patrernObj.matcher(inputString);
		return matcherObj.find();
	}
	
//	EX3
	public boolean stringContainsMatching(String inputString, String matchingString) throws UserDefinedException, PatternSyntaxException
	{
		InputValidityCheck.checkNull(inputString);
		InputValidityCheck.checkNull(matchingString);
		Pattern patrernObj = Pattern.compile(matchingString);
		Matcher matcherObj = patrernObj.matcher(inputString);
		return matcherObj.find();
	}
	
//	EX3
	public boolean stringEndsWith(String inputString, String matchingString) throws UserDefinedException, PatternSyntaxException
	{
		InputValidityCheck.checkNull(inputString);
		InputValidityCheck.checkNull(matchingString);
		Pattern patrernObj = Pattern.compile(matchingString + "$");
		Matcher matcherObj = patrernObj.matcher(inputString);
		return matcherObj.find();
	}
	
//	EX3
	public boolean stringExactMatch(String inputString, String matchingString) throws UserDefinedException, PatternSyntaxException
	{
		InputValidityCheck.checkNull(inputString);
		InputValidityCheck.checkNull(matchingString);
		Pattern patrernObj = Pattern.compile("^" + matchingString + "$");
		Matcher matcherObj = patrernObj.matcher(inputString);
		return matcherObj.find();
	}
	
//	EX4
	public boolean stringMatchCaseInsensitive(String matchingString, String inputString) throws UserDefinedException, PatternSyntaxException
	{
		InputValidityCheck.checkNull(inputString);
		InputValidityCheck.checkNull(matchingString);
		Pattern patrernObj = Pattern.compile("^" + matchingString + "$", Pattern.CASE_INSENSITIVE);
		Matcher matcherObj = patrernObj.matcher(inputString);
		return matcherObj.find();
	}
	
//	EX5
	public boolean emailValidation(String inputString) throws UserDefinedException, PatternSyntaxException
	{
		InputValidityCheck.checkNull(inputString);
		String regxPattern = "^+[a-zA-Z0-9+_.-]+[@]+[a-zA-Z0-9.-]+[.]+[a-zA-Z]+$";
		return inputString.matches(regxPattern);
	}
	
//	EX6
	public List <String> stringsWithinLength(int length, List<String> stringList) throws UserDefinedException, PatternSyntaxException
	{
		InputValidityCheck.checkNull(stringList);
		List <String> outputList = new ArrayList<>();
		String regxPattern = "[^\\s]{1," + length + "}";
		int size = stringList.size();
		for (int i = 0; i < size; i++)
		{
			if (stringList.get(i).matches(regxPattern))
			{
				outputList.add(stringList.get(i));
			}
		}
		return outputList;
	}
	
//	EX7
	public Map<String, Integer> compareTwoList(List<String> stringList1, List<String> stringList2) throws UserDefinedException, PatternSyntaxException
	{
		InputValidityCheck.checkNull(stringList1);
		InputValidityCheck.checkNull(stringList2);
		int size1 = stringList1.size();
		int size2 = stringList2.size();
		Map<String, Integer> stringMap = new HashMap<String, Integer>();
		
		for (int i = 0; i<size2; i++)
		{
			Pattern patrernObj = Pattern.compile("^" + stringList2.get(i) + "$");
			for (int j = 0; j<size1; j++)
			{
				Matcher matcherObj = patrernObj.matcher(stringList1.get(j));
				if(matcherObj.find())
				{
					stringMap.put(stringList1.get(j), j);
				}
			}
		}
		return stringMap;
	}
	
//	EX8
	public List<String> stringHTML(String inputString) throws UserDefinedException, PatternSyntaxException
	{
		InputValidityCheck.checkNull(inputString);
		Pattern patrernObj = Pattern.compile("<([^>]+)>");
		Matcher matcherObj = patrernObj.matcher(inputString);
		List<String> list = new ArrayList<String>();
		while (matcherObj.find())
		{
			list.add(matcherObj.group());
		}
		return list;
	}
}



























