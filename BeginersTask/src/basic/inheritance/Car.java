package basic.inheritance;

public class Car 
{
	public Car()
	{
	}
	public Car(String inputString)
	{
		System.out.println(inputString);
	}
	private int yearOfMake;
	private String engineNumber, type;
	
	public int getYearOfMake()
	{
		return yearOfMake;
	}
	
	public void setYearOfMake(int yearOfMake)
	{
		this.yearOfMake = yearOfMake;
	}
	
	public String getEngineNumber()
	{
		return engineNumber;
	}
	
	public void setEngineNumber(String engineNumber)
	{
		this.engineNumber = engineNumber;
	}
	
	public String getType()
	{
		return type;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public void maintenance()
	{
		System.out.println("Car under maintenance");
	}
}

