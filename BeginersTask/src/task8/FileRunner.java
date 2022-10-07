package task8;

import java.io.File;

import java.io.FileOutputStream;

import java.io.IOException;

import java.io.OutputStream;

import java.text.ParseException;

import java.util.Properties;

import java.util.Scanner;

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
		System.out.println("Enter which number of exercise you want to perform: ");
		int exerciseNo = get.getInt();
		String writeString1 = "Programmatically created file.";
		String writeString2 = "These words were written programmatically.";
		String writeString3 = "All is Well. Be happy & enjoy the moment.";
		while (exerciseNo != 0)
		{
			try
			{
				switch (exerciseNo)
				{
					case 1:
					{
						String path = "sample.txt";
						OutputStream os = new FileOutputStream(path);
						run.writeFile(os, writeString1);
						run.writeFile(os, writeString2);
						run.writeFile(os, writeString3);
						break;
					}
					
					case 2:
					{
						String path = "myprops.txt";
						Properties p = new Properties();
						OutputStream os = new FileOutputStream(path);
						run.filePropertiesAdd(p, os, "1", "A");
						run.filePropertiesAdd(p, os, "2", "B");
						run.filePropertiesAdd(p, os, "3", "C");
						run.filePropertiesAdd(p, os, "4", "D");
						run.filePropertiesAdd(p, os, "5", "E");
						run.storeProperty(os, p);
						break;
					}
					
					case 3:
					{
						String path = "myprops.txt";
						Properties p = new Properties();
						run.returnProperties(path, p);
						System.out.println(p);
						break;
					}
					
					case 4:
					{
						String path = "/home/inc3/Jeba/FileTask/Trail";
						File newFile = new File (path);
						newFile.mkdir();
						OutputStream os = new FileOutputStream("/home/inc3/Jeba/FileTask/Trail/sample.txt");
						run.writeFile(os, writeString1);
						run.writeFile(os, writeString2);
						run.writeFile(os, writeString3);
						path = "/home/inc3/Jeba/FileTask/Trail/myprops.txt";
						Properties p = new Properties();
						OutputStream os1 = new FileOutputStream(path);
						run.filePropertiesAdd(p, os1, "1", "A");
						run.filePropertiesAdd(p, os1, "2", "B");
						run.filePropertiesAdd(p, os1, "3", "C");
						run.filePropertiesAdd(p, os1, "4", "D");
						run.filePropertiesAdd(p, os1, "5", "E");
						run.storeProperty(os1, p);
						break;
					}
						
					
					case 5:
					{
						PojoQ5 pojoObj = new PojoQ5 ("Hi bro");
						System.out.println(pojoObj);
						break;
					}
					
					case 6:
					{
						PojoQ6_7_8 pojoObj = new PojoQ6_7_8 ("Hi bro", 8);
						System.out.println(pojoObj);
						break;
					}
					
					case 7:
					{
						PojoQ6_7_8 pojoObj = new PojoQ6_7_8 ();
						pojoObj.setInputString("Hello");
						pojoObj.setNumber(exerciseNo);
						System.out.println("The String value is: " + pojoObj.getInputString());
						System.out.println("The Integer value is: " + pojoObj.getNumber());
						break;
					}
					
					case 9:
					{
						for (RainbowColors color : RainbowColors.values())
						{
							System.out.println(color.orders + " - " + color);
						}
						System.out.println("Print using Ordinal: ");
						for (RainbowColors color : RainbowColors.values())
						{
							System.out.println(color.ordinal() + " - " + color);
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
						String time1 =  time.getDateTime1();
						System.out.println("1) Current Date and Time::  " + time1);
						String time2 = time.getDateTime2();
						System.out.println("2) Time with milli seconds::  " + time2);
						String time3 = time.getDateTime3("America/New_York");
						System.out.println("3 I) Newyork Date and Time::  " + time3 + "\n");
						time3 = time.getDateTime3("Europe/London");
						System.out.println("3 II) London Date and Time::  " + time3);
						String dayOfWeek = time.getDateTime4("29/09/2022");
						System.out.println("4) Day of given Date is::  " + dayOfWeek);
						String month = time.getDateTime5(2022, 8, 29);
						System.out.println("5) Month of given Date is::  " + month);
						int year = time.getDateTime6(29, 05, 2022);
						System.out.println("6) Year of given Date is::  " + year);
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
				System.out.println(ioe);
			}
			catch(UserDefinedException ue)
			{
				System.out.println(ue);
			}
			System.out.println("Enter 0 to close the program");
			System.out.println("Enter which number of exercise you want to perform: ");
			exerciseNo = get.getInt();
		}
	}

}


































