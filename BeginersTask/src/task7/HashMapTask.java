package task7;

import java.util.Iterator;

import java.util.Map;

import myException.InputValidityCheck;

import myException.UserDefinedException;

public class HashMapTask 
{
	
	public <T, U> void getHashMap(Map<T, U> inputHashMap, T key, U value) throws UserDefinedException
	{
		InputValidityCheck.checkNull(inputHashMap);
		inputHashMap.put(key, value);
	}

//EX1 to 7
	public <T,U> int getSize(Map<T,U> inputHashMap) throws UserDefinedException
	{
		InputValidityCheck.checkNull(inputHashMap);
		return inputHashMap.size();
	}

//EX8
	public <T,U> boolean isKeyPresent (Map<T,U> inputHashMap, T key) throws UserDefinedException
	{
		InputValidityCheck.checkNull(inputHashMap);
		return inputHashMap.containsKey(key);
	}

//EX9
	public <T,U> boolean isValuePresent (Map<T,U> inputHashMap, U value) throws UserDefinedException
	{
		InputValidityCheck.checkNull(inputHashMap);
		return inputHashMap.containsValue(value);
	}

//EX10
	public void changeValue (Map<String, String> inputHashMap, String[] oldKeys, String... newValues) throws UserDefinedException
	{
		int size = getSize(inputHashMap);
		for (int i=0; i<size; i++)
		{
		inputHashMap.replace(oldKeys[i], newValues[i]);
		}
	}
	
//EX11, 12
	public <T, U> String getValue (Map<T,U> inputHashMap, T key) throws UserDefinedException
	{
		InputValidityCheck.checkNull(inputHashMap);
		return (String) inputHashMap.get(key);
	}
	
//EX13
	public <T> String getValueOrDefault (Map<T,String> inputHashMap, T key) throws UserDefinedException
	{
		InputValidityCheck.checkNull(inputHashMap);
		return  inputHashMap.getOrDefault(key, "Zoho");
	}
	
//EX14
	public <T, U> void removeKey(Map<T,U> inputHashMap, T key) throws UserDefinedException
	{
		InputValidityCheck.checkNull(inputHashMap);
		inputHashMap.remove(key);
	}
	
//EX15
	public <T, U> void removeKeyIfGivenValuePresent(Map<T,U> inputHashMap, T key, U value) throws UserDefinedException
	{
		InputValidityCheck.checkNull(inputHashMap);
		inputHashMap.remove(key, value);
	}
	
//EX16
	public <T, U> void replaceValueOfExistingKey (Map<T,U> inputHashMap, T key, U value) throws UserDefinedException
	{
		InputValidityCheck.checkNull(inputHashMap);
		inputHashMap.replace(key, value);
	}
	
//EX17
	public <T, U> void replaceValueOfExistingKeyValue (Map<T,U> inputHashMap, T key, U oldValue, U newValue) throws UserDefinedException
	{
		InputValidityCheck.checkNull(inputHashMap);
		inputHashMap.replace(key, oldValue, newValue);
	}
	
//EX18
	public <T, U> void mergeTwoMaps (Map<T,U> inputHashMap1, Map<T,U> inputHashMap2) throws UserDefinedException
	{
		InputValidityCheck.checkNull(inputHashMap2);
		inputHashMap2.putAll(inputHashMap1);
	}
	
//EX19
	public <T, U> void printUsingIterator (Map<T,U> inputHashMap) throws UserDefinedException
	{
		InputValidityCheck.checkNull(inputHashMap);
		Iterator <Map.Entry<T, U>> it = inputHashMap.entrySet().iterator();
		while (it.hasNext())
		{
			Map.Entry<T, U> output = it.next();
			System.out.println("key is " + output.getKey() + "     " + "Value is " + output.getValue());
		}
	}
	
//EX20
	public <T, U> void removeAllEntries (Map<T,U> inputHashMap) throws UserDefinedException
	{
		InputValidityCheck.checkNull(inputHashMap);
		inputHashMap.clear();
	}
	
}






























