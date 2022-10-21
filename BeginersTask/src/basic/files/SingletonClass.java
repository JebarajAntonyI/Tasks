package basic.files;

public class SingletonClass 
{
	
	private static final SingletonClass SINGLE_INSTANCE = new SingletonClass();
	public String outputString = "Inside Singleton Class";

	private SingletonClass()
	{
		
	}
	
	public static SingletonClass getInstance()
	{
		return SINGLE_INSTANCE;
	}

}

























