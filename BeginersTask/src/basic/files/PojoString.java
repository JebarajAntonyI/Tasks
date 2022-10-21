package basic.files;

public class PojoString 
{
private String inputString;
	
	public PojoString(String word)
	{
		inputString = word;
	}
	
	public String toString()
	{
		return "The String value is: " + inputString;
	}
}
