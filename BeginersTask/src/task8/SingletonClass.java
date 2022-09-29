package task8;

public final class SingletonClass 
{
	private static SingletonClass value;
	public String outputString = "Inside Singleton Class";
	
	private SingletonClass()
	{
		
	}
	
	public static SingletonClass getInstance()
	{
		if (value == null)
		{
			value = new SingletonClass();
		}
		return value;
	}
}
