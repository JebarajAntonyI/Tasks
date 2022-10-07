package task11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

import java.util.regex.Pattern;

public class RegExTask 
{
	
	public boolean mobileNumberValidation(String mobile)
	{
		String regx = "[7-9]\\d{9}";
		return mobile.matches(regx);
	}
	
	public boolean alphaNumericOnly(String inputString)
	{
		String regx = "[a-zA-Z0-9]{0,}";
		return inputString.matches(regx);
	}
	
	public boolean stringStartsWith(String inputString, String matchingString)
	{
		Pattern pat = Pattern.compile("^" + matchingString);
		Matcher mat = pat.matcher(inputString);
		return mat.find();
	}
	
	public boolean stringContainsMatching(String inputString, String matchingString)
	{
		Pattern pat = Pattern.compile(matchingString);
		Matcher mat = pat.matcher(inputString);
		return mat.find();
	}
	
	public boolean stringEndsWith(String inputString, String matchingString)
	{
		Pattern pat = Pattern.compile(matchingString + "$");
		Matcher mat = pat.matcher(inputString);
		return mat.find();
	}
	
	public boolean stringExactMatch(String inputString, String matchingString)
	{
		Pattern pat = Pattern.compile("^" + matchingString + "$");
		Matcher mat = pat.matcher(inputString);
		return mat.find();
	}
	
	public boolean stringMatchCaseInsensitive(String matchingString, String inputString)
	{
		Pattern pat = Pattern.compile("^" + matchingString + "$", Pattern.CASE_INSENSITIVE);
		Matcher mat = pat.matcher(inputString);
		return mat.find();
	}
	
	public boolean emailValidation(String inputString)
	{
		String regx = "^+[a-zA-Z0-9+_.-]+[@]+[a-zA-Z0-9.-]+[.]+[a-zA-Z]+$";
		return inputString.matches(regx);
	}
	
	public int lengthOfString(int length, List<String> stringList)
	{
		String regx = "[^\\s]{1," + length + "}";
		int n = 0;
		Iterator<String> it = stringList.iterator();
		while (it.hasNext())
		{
			if (it.next().matches(regx))
			{
				n++;
			}
		}
		return n;
	}
	
	public Map<String, Integer> compareTwoList(List<String> stringList1, List<String> stringList2)
	{
		int size1 = stringList1.size();
		int size2 = stringList2.size();
		Map<String, Integer> stringMap = new HashMap<String, Integer>();
		
		for (int i = 0; i<size2; i++)
		{
			Pattern pat = Pattern.compile("^" + stringList2.get(i) + "$");
			for (int j = 0; j<size1; j++)
			{
				Matcher mat = pat.matcher(stringList1.get(j));
				if(mat.find())
				{
					stringMap.put(stringList1.get(j), j);
				}
			}
		}
		return stringMap;
	}
	
	public List<String> stringHTML(String inputString)
	{
		Pattern pat = Pattern.compile("<([^>]+)>");
		Matcher mat = pat.matcher(inputString);
		List<String> list = new ArrayList<String>();
		while (mat.find())
		{
			list.add(mat.group());
		}
		return list;
	}
}



























