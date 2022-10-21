package basic.files;


import java.io.IOException;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Properties;

import java.util.Scanner;
import java.util.logging.Logger;

import basic.reflection.RainbowColors;
import myException.UserDefinedException;

public class FileRunner 
{
	
	Scanner scan = new Scanner (System.in);
	
	public int getInt()
	{
		int number = 0;
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
				System.out.print("Enter value in integer");
				System.out.println();
			}
		}
		return number;
	}
	
	public String[] getStringArrInput(int number)
	{
		String[] inputStringArr = new String[number];
		for (int i=0; i<number; i++)
		{
			inputStringArr[i] = scan.next();
		}
		return inputStringArr;
	}

	public static void main(String[] args) throws UserDefinedException, IOException, ParseException
	{
		FileRunner get = new FileRunner();
		FileTask run = new FileTask();
		Logger logger = Logger.getLogger("Output Statement");
		logger.info("Enter which number of exercise you want to perform: ");
		int exerciseNo = get.getInt();
		while (exerciseNo != 0)
		{
			try
			{
				switch (exerciseNo)
				{
					case 1:
					{
						logger.info("Enter the file name you want to create(eg: sample.txt)");
						String file = get.scan.next();
						logger.info("Enter how many sentence you want to add: ");
						int number = get.getInt();
						String[] writeString = new String[number];
						for (int i = 0; i < number; i++)
						{
							get.scan.nextLine();
							writeString[i] = get.scan.nextLine();
						}
						run.writeFile(file, writeString);
						break;
					}
					
					case 2:
					{
						logger.info("Enter the file name you want to create(eg: myprops.txt)");
						String file = get.scan.next();
						Properties properties = new Properties();
						logger.info("Enter how many keys and values you want to add:");
						int number = get.getInt();
						String key;
						String value;
						for (int i = 0; i < number; i++)
						{
							logger.info("Enter the key - " + (i+1));
							key = get.scan.next();
							logger.info("Enter the value - " + (i+1));
							value = get.scan.next();
							properties.setProperty(key, value);
						}
						run.filePropertiesStore(file, properties);
						break;
					}
					
					case 3:
					{
						logger.info("Enter the file name you want to print(eg: myprops.txt)");
						String file = get.scan.next();
						Properties properties = new Properties();
						run.returnProperties(file, properties);
						System.out.println(properties);
						break;
					}
					
					case 4:
					{
						logger.info("Enter the directory you want to create folder (eg: /home/inc3/Jeba/FileTask/Trail)");
						String directory = get.scan.next();
						boolean flag = run.makeDirectorty(directory);
						System.out.println("Is the directory created: " + flag);
						logger.info("Enter the file name you want to create in the directory path(eg: sample.txt)");
						String file1 = get.scan.next();
						String samplePath = directory + "/" + file1;
						logger.info("Enter how many sentence you want to add: ");
						int number = get.getInt();
						String[] writeString = new String[number];
						for (int i = 0; i < number; i++)
						{
							get.scan.nextLine();
							writeString[i] = get.scan.nextLine();
						}
						run.writeFile(samplePath, writeString);
						logger.info("Enter file name you want to set properties (eg: myprops.txt)");
						String file2 = get.scan.next();
						String mypropPath = directory + "/" + file2;
						Properties properties = new Properties();
						logger.info("Enter how many keys and values you want to add:");
						number = get.getInt();
						String key, value;
						for (int i = 0; i < number; i++)
						{
							logger.info("Enter the key - " + (i+1));
							key = get.scan.next();
							logger.info("Enter the value - " + (i+1));
							value = get.scan.next();
							properties.setProperty(key, value);
						}
						run.filePropertiesStore(mypropPath, properties);
						break;
					}
						
					
					case 5:
					{
						logger.info("Enter String");
						String inputString = get.scan.next();
						PojoString pojoObj = new PojoString (inputString);
						System.out.println(pojoObj);
						break;
					}
					
					case 6:
					{
						logger.info("Enter String");
						String inputString = get.scan.next();
						logger.info("Enter Integer");
						int number = get.getInt();
						PojoStringAndInteger pojoObj = new PojoStringAndInteger (inputString, number);
						System.out.println(pojoObj);
						break;
					}
					
					case 7:
					{
						PojoStringAndInteger pojoObj = new PojoStringAndInteger ();
						logger.info("Enter String");
						String inputString = get.scan.next();
						logger.info("Enter Integer");
						int number = get.getInt();
						pojoObj.setInputString(inputString);
						pojoObj.setNumber(number);
						System.out.println("The String value is: " + pojoObj.getInputString());
						System.out.println("The Integer value is: " + pojoObj.getNumber());
						break;
					}
					
					case 9:
					{
						for (RainbowColors color : RainbowColors.values())
						{
							System.out.println(color.orders + " - " + color + " ------->(Ordinal value - " + color.ordinal() + ")");
						}
						break;
					}
					
					case 10:
					{
						SingletonClass one = SingletonClass.getInstance();
						System.out.println(one.outputString);
						break;
					}
					
					case 11:
					{
						TimeTask time = new TimeTask();
						System.out.println("1) Current Date and Time::  " + time.getDateTime());
						System.out.println("2) Time in milli seconds::  " + time.getTimeInMillis());
						ZoneId id1 = ZoneId.of("America/New_York");
						System.out.println("3 I) Newyork Date and Time::  " + time.getZonedTime(id1) + "\n");
						ZoneId id2 = ZoneId.of("Europe/London");
						System.out.println("3 II) London Date and Time::  " + time.getZonedTime(id2));
						LocalDate date = time.getLocalDate();
						System.out.println("4) Day of given Date is::  " + time.getDayOfDate(date));
						System.out.println("5) Month of given Date is::  " + time.getMonthOfDate(date));
						System.out.println("6) Year of given Date is::  " + time.getYearOfDate(date));
						break;
					}
					
					default:
					{
						System.out.println("Enter values 1, 8 to 20");
					}
				}
			}
			catch(IOException ioe)
			{
				System.out.println(ioe.getMessage() + "   " + ioe);
			}
			catch(UserDefinedException ue)
			{
				System.out.println(ue.getCause());
			}
			logger.info("Enter 0 to close the program");
			logger.info("Enter which number of exercise you want to perform: ");
			exerciseNo = get.getInt();
		}
	}

}


































