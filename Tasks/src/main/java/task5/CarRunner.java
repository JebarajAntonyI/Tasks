package task5;

import java.util.Scanner;

public class CarRunner 
{
	static Scanner scan = new Scanner(System.in);
	Swift sObj = new Swift();
	SCross sCrossObj = new SCross();
	XUV XuvObj = new XUV();
	
	public int getIntegerInput(int number)
	{
		boolean value = true;
		while (value)
		{
			if (scan.hasNextInt())
			{
				number = scan.nextInt();
				value = false;
			}
			else
			{
				scan.next();
				System.out.println("Enter input in Integer");
			}
		}
		return number;
	}
	public static void main (String[] args)
	{
		CarRunner get = new CarRunner();
		
		System.out.println("Enter the exercise no you want to perform: ");
		int exerciseNo = get.getIntegerInput(0);
		while (exerciseNo != 0)
		{
			switch (exerciseNo)
			{
				case 2:
				{
					Swift sCar = new Swift();
					System.out.println("Enter how many seats: ");
					sCar.setSeats(get.getIntegerInput(0));
					System.out.println("Enter how many airbags: ");
					sCar.setAirbags(get.getIntegerInput(0));
					System.out.println("Enter model name: ");
					sCar.setModel(scan.next());
					System.out.println("Enter model color: ");
					sCar.setColor(scan.next());
					
					System.out.println("The number of seats is: " + sCar.getSeats());
					System.out.println("The number of airbags is: " + sCar.getAirbags());
					System.out.println("The model name is: " + sCar.getModel());
					System.out.println("The color is: " + sCar.getColor());
					break;
				}
				case 3:
				{
					SCross sCrossCar = new SCross();
					System.out.println("Enter how many seats: ");
					sCrossCar.setSeats(get.getIntegerInput(0));
					System.out.println("Enter how many airbags: ");
					sCrossCar.setAirbags(get.getIntegerInput(0));
					System.out.println("Enter model name: ");
					sCrossCar.setModel(scan.next());
					System.out.println("Enter model color: ");
					sCrossCar.setColor(scan.next());
					System.out.println("Enter year of make: ");
					sCrossCar.setYearOfMake(get.getIntegerInput(0));
					System.out.println("Enter engine number: ");
					sCrossCar.setEngineNumber(scan.next());
					System.out.println("Enter the type: ");
					sCrossCar.setType(scan.next());
					
					System.out.println("The number of seats is: " + sCrossCar.getSeats());
					System.out.println("The number of airbags is: " + sCrossCar.getAirbags());
					System.out.println("The model name is: " + sCrossCar.getModel());
					System.out.println("The color is: " + sCrossCar.getColor());
					System.out.println("The year of make is: " + sCrossCar.getYearOfMake());
					System.out.println("The engine number is: " + sCrossCar.getEngineNumber());
					System.out.println("The type of car is: " + sCrossCar.getType());
					break;
				}
				case 4:
				{
					get.carMethod(get.sObj);
					get.carMethod(get.sCrossObj);
					get.carMethod(get.XuvObj);
					break;
				}
				case 6:
				{
					Swift swiftObj = new Swift();
					get.swiftMethod(swiftObj);
					Car sCarObj = new Swift();
//					get.swiftMethod(sCarObj);
//					get.swiftMethod(get.sCrossObj);
//					get.swiftMethod(get.XuvObj);
					break;
				}
				case 7:
				{
					SCross sCrossObj = new SCross();
					sCrossObj.maintenance();
					Car sCrossCarObj = new SCross();
					sCrossCarObj.maintenance();
					Car carObj = new Car();
					carObj.maintenance();
					Swift swiftObj = new Swift();
					swiftObj.maintenance();
					break;
				}
				case 8:
				{
					Car carConstructor = new Car("Constructor");
					XUV XuvOb = new XUV();
//					XUV XuvOb2 = new XUV("new");
				}
				case 9:
				{
//					BirdAbstract absObj = new BirdAbstract();
					ParrotMod birds = new ParrotMod();
					birds.fly();
					birds.speak();
					break;
				}
				case 10:
				{
					Duck duckObj = new Duck();
					duckObj.fly();
					duckObj.speak();
					break;
				}
				default:
				{
					System.out.println("Enter any one of the value 2, 3, 4, 6, 7, 8");
					System.out.println();
				}
			}
			System.out.println("Enter 0 to stop the programe");
			System.out.println("Enter the exercise no you want to perform: ");
			exerciseNo = get.getIntegerInput(0);
		}
	}
	
	public void carMethod (Car carObj)
	{
		CarRunner get = new CarRunner();
		if (carObj.equals(sObj))
		{
			System.out.println("Hatch");
		}
		if (carObj.equals(sCrossObj))
		{
			System.out.println("SUV");
		}
		if (carObj.equals(XuvObj))
		{
			System.out.println("Sedan");
		}
		System.out.println("Enter year of make: ");
		carObj.setYearOfMake(get.getIntegerInput(0));
		System.out.println("Enter engine number: ");
		carObj.setEngineNumber(scan.next());
		System.out.println("Enter the type: ");
		carObj.setType(scan.next());
		
		System.out.println("The year of make is: " + carObj.getYearOfMake());
		System.out.println("The engine number is: " + carObj.getEngineNumber());
		System.out.println("The type of car is: " + carObj.getType());
		System.out.println("..........Thankyou..........");
	}
	
	public void swiftMethod (Swift swiftObj)
	{
		CarRunner get = new CarRunner();
		System.out.println("Enter how many seats: ");
		swiftObj.setSeats(get.getIntegerInput(0));
		System.out.println("Enter how many airbags: ");
		swiftObj.setAirbags(get.getIntegerInput(0));
		System.out.println("Enter model name: ");
		swiftObj.setModel(scan.next());
		System.out.println("Enter model color: ");
		swiftObj.setColor(scan.next());
		
		System.out.println("The number of seats is: " + swiftObj.getSeats());
		System.out.println("The number of airbags is: " + swiftObj.getAirbags());
		System.out.println("The model name is: " + swiftObj.getModel());
		System.out.println("The color is: " + swiftObj.getColor());
	}
}




























