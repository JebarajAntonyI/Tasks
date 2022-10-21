package basic.files;

public class PojoStringAndInteger 
{
	private int number;
	private String inputString;
	
	public PojoStringAndInteger(String word, int num)
	{
		inputString = word;
		number = num;
		System.out.println("In Overloaded Constructor");
	}
	
	public PojoStringAndInteger()
	{
		System.out.println("In Default Constructor");
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	
	public String getInputString() {
		return inputString;
	}

	public void setInputString(String inputString) {
		this.inputString = inputString;
	}
	
	public String toString()
	{
		return "The String value is: " + inputString + "\nThe Integer value is: " + number;
	}
	
}
