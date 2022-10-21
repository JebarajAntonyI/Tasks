package basic.files;

import myException.UserDefinedException;

public class SingletonClassTrail2 
{
	private static volatile SingletonClassTrail2 value;
	public String outputString = "Inside Singleton Class";
	
	private SingletonClassTrail2() throws UserDefinedException
	{
		if (value != null)
		{
			throw new UserDefinedException ("The class is already Initialised");
		}
	}
	
	public static SingletonClassTrail2 getInstance() throws UserDefinedException
	{
		if (value == null)
		{
			synchronized (SingletonClass.class)
			{
				if (value == null)
				{
					value = new SingletonClassTrail2();
				}
			}
		}
		return value;
	}
}
