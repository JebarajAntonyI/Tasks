package myException;

@SuppressWarnings("serial")
public class UserDefinedException extends Exception
{
	public UserDefinedException (String message)
	{
		super(message);
	}
}
