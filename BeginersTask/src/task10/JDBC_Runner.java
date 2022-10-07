package task10;

import java.util.ArrayList;

import java.util.List;

import java.util.Map;

import java.util.Scanner;

import myException.UserDefinedException;

public class JDBC_Runner 
{
	Scanner scan = new Scanner(System.in);
	
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

	public static void main(String[] args) throws UserDefinedException 
	{
		
		JDBC_Runner get = new JDBC_Runner();
		
		JDBC_Task run = new JDBC_Task();
		
		System.out.println("Enter which exercise you want to perform: ");
		int exerciseNo = get.getInt();
		
		while (exerciseNo != 0)
		{
			try 
			{
				switch (exerciseNo)
				{
				
				case 1:
					String CREATE_TABLE_SQL = "CREATE TABLE EmployeeDetails (EMPLOYEE_ID INT AUTO_INCREMENT, NAME VARCHAR(45) NOT NULL, MOBILE BIGINT NOT NULL UNIQUE, EMAIL VARCHAR(45) NOT NULL UNIQUE, DEPARTMENT VARCHAR(45) NOT NULL, PRIMARY KEY (EMPLOYEE_ID))";
					run.createTable(CREATE_TABLE_SQL);
					break;
					
				case 2:
					System.out.println("Enter how many Employees Informations you want to add: ");
					int number = get.getInt();					
					for (int i=0; i<number; i++)
					{
						get.scan.nextLine();
						System.out.println("Enter Employee Name: ");
						String name = get.scan.nextLine();
						System.out.println("Enter Mobile Number: ");
						String mobile = get.scan.next();
						System.out.println("Enter E-mail: ");
						String email = get.scan.next();
						get.scan.nextLine();
						System.out.println("Enter Department: ");
						String department = get.scan.nextLine();
						run.addDetails(name, mobile, email, department);
					}
					break;
					
				case 3:
					System.out.println("Enter the Name of Employee you want to get Details: ");
					get.scan.nextLine();
					String name = get.scan.nextLine();
					List<Map<String, ?>> arrayListByName = new ArrayList<Map<String, ?>>();
					arrayListByName = run.selectEmployeeByName(name);
					for (Map<String, ?> row : arrayListByName)
					{
						System.out.println(row);
					}					
					break;
					
				case 4:
					System.out.println("Enter the Employee ID you want to modify details: ");
					int id = get.getInt();
					System.out.println("Which details you want to modify: ");
					System.out.println("1) Department \n2)Mobile \n3)Email \n4)All the above");
					number = get.getInt();
					switch(number)
					{
					case 1:
						System.out.println("Enter New Department: ");
						get.scan.nextLine();
						String department = get.scan.nextLine();
						run.modifyDepartmentDetails(id, department);
						break;
						
					case 2:
						System.out.println("Enter New Mobile: ");
						String mobile = get.scan.next();
						run.modifyMobileDetails(id, mobile);
						break;
						
					case 3:
						System.out.println("Enter New Email: ");
						String email = get.scan.next();
						run.modifyEmailDetails(id, email);
						break;
						
					case 4:
						System.out.println("Enter New Department: ");
						get.scan.nextLine();
						department = get.scan.nextLine();
						System.out.println("Enter New Mobile: ");
						mobile = get.scan.next();
						System.out.println("Enter New Email: ");
						email = get.scan.next();
						run.modifyAllDetails(id, department, mobile, email);
						break;
						
					default:
						System.out.println("Enter value between 1 and 4: ");
						break;
					}
					break;
					
				case 5:
					System.out.println("Enter the number for first N employee details: ");
					number = get.getInt();
					List<Map<String, ?>> arrayListForFirstN = new ArrayList<Map<String, ?>>();
					arrayListForFirstN = run.getEmployeesDetailsOfFirstN(number);
					for (Map<String, ?> row : arrayListForFirstN)
					{
						System.out.println(row);
					}
					break;
					
				case 6:
					System.out.println("Enter the number for first N employee details: ");
					number = get.getInt();
					String column;
//					System.out.println("In which order the name will print: ");
					System.out.println("In which column will print in order: ");
					System.out.println("1) NAME \n2) MOBILE \n3) EMAIL \n4) DEPARTMENT \n5) ID");
					int c = get.getInt();
					switch (c)
					{
					case 1:
						column = "NAME";
						break;
						
					case 2:
						column = "MOBILE";
						break;
						
					case 3:
						column = "EMAIL";
						break;
						
					case 4:
						column = "DEPARTMENT";
						break;
						
					default:
						column = "EMPLOYEE_ID";
						break;
					}
					System.out.println("press (2) for Descending Order \nor press other numbers for Ascending Order");
					int order = get.getInt();
					List<Map<String, ?>> arrayListInOrder = new ArrayList<Map<String, ?>>();
					switch (order)
					{
					case 2:
						arrayListInOrder = run.getEmployeesDetailsInDescendingOrder(number, column);
						break;
					
					default:
						arrayListInOrder = run.getEmployeesDetailsInAscendingOrder(number, column);
						break;
					}
					for (Map<String, ?> row : arrayListInOrder)
					{
						System.out.println(row);
					}
					break;
					
				case 7:
					System.out.println("Enter the EMPLOYEE ID you want to delete: ");
					id = get.getInt();
					run.deleteEmployee(id);
					break;
					
				case 8:
					break;
					
				case 9:
					CREATE_TABLE_SQL = "CREATE TABLE EmployeeFamilyDetails (EMPLOYEE_ID INT, NAME VARCHAR(45) NOT NULL, AGE INT NOT NULL, RELATIONSHIP VARCHAR(45) NOT NULL, FOREIGN KEY (EMPLOYEE_ID) REFERENCES EmployeeDetails (EMPLOYEE_ID))";
					run.createTable(CREATE_TABLE_SQL);
					break;
					
				case 10:
					System.out.println("Enter Employees ID you want to add Informations: ");
					id = get.getInt();
					String famName;
					int famAge;
					String famRelation;
					while (id != 0)
					{
						get.scan.nextLine();
						System.out.println("Enter Name: ");
						famName = get.scan.nextLine();
						System.out.println("Enter Age: ");
						famAge = get.getInt();
						System.out.println("Enter Relationship: ");
						famRelation = get.scan.next();
						run.addFamilyDetails(id, famName, famAge, famRelation);
						System.out.println("Enter Employees ID you want to add Informations: ");
						System.out.println("........or Enter 0 to close........");
						id = get.getInt();
					}
					break;
					
				case 11:
					System.out.println("\t If you want to Enter name press (1) \n\t If you want to Enter ID press (2)");
					int choice = get.getInt();
					List<Map<String, ?>> listByName = new ArrayList<Map<String, ?>>();

					switch (choice)
					{
					case 1:
						System.out.println("Enter Name: ");
						get.scan.nextLine();
						name = get.scan.nextLine();
						listByName = run.selectFamilyByName(name);
						break;
						
					case 2:
						System.out.println("Enter ID: ");
						id = get.getInt();
						listByName = run.selectFamilyById(id);
						break;
						
					default:
						System.out.println("Enter value 1 or 2: ");
						break;
					}
					for (Map<String, ?> row : listByName)
					{
						System.out.println(row);
					}
					break;
					
				case 12:
					System.out.println("Enter the number for first N employee details: ");
					number = get.getInt();
					System.out.println("In which order the name will print: ");
					System.out.println("press (2) for Descending Order \nor press other numbers for Ascending Order");
					order = get.getInt();
					List<Map<String, ?>> arrayListOutput = new ArrayList<Map<String, ?>>();
					switch (order)
					{
					case 2:
						arrayListOutput = run.getEmployeesFamilyDetailsInDescendingOrder(number);
						break;
					
					default:
						arrayListOutput = run.getEmployeesFamilyDetailsInAscendingOrder(number);
						break;
					}
					for (Map<String, ?> row : arrayListOutput)
					{
						System.out.println(row);
					}
					break;
				}
			}
			catch (UserDefinedException ue)
			{
				System.out.println(ue);
			}
			System.out.println("Enter 0 to close the program");
			System.out.println("Enter which number of exercise you want to perform: ");
			exerciseNo = get.getInt();
		}
	}
	
	

}
