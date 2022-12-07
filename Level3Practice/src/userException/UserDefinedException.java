package userException;

@SuppressWarnings("serial")
public class UserDefinedException extends Exception
{
	public UserDefinedException(Exception e)
	{
		super(e);
	}
	
	public UserDefinedException(String message)
	{
		super(message);
	}
	
	public UserDefinedException(String message, Exception e)
	{
		super(message, e);
	}
}
