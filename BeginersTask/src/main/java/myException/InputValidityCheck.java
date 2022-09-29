package myException;

import java.util.Objects;

public class InputValidityCheck 
{

	public static void checkNull(Object inputString) throws UserDefinedException 
	{
		if (Objects.isNull(inputString)) 
		{
			throw new UserDefinedException("Input Value is null");
		}
	}

	public static void checkEmpty(String inputString) throws UserDefinedException 
	{
		checkNull(inputString);
		if (inputString.isEmpty()) 
		{
			throw new UserDefinedException("Input value is empty");
		}
	}

}