package basic.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import myException.UserDefinedException;

public class PojoDB_Runer 
{
	
	private static PojoDB getPojoObj()
	{
		return new PojoDB();
	}

	public static void main(String[] args) throws UserDefinedException 
	{
		JDBC_Runner get = new JDBC_Runner();
		JDBC_Task run = new JDBC_Task();
		System.out.println(".....Using POJO class.....");
		System.out.println("If you want to add Employee Details press 1");
		System.out.println("If you want to get Employee Details press 2");
		System.out.println("If you want to get first N Employee Details press 3");
		System.out.println("If you want to get first N Employee Details in order press 4");

		int n = get.getInt();
		switch (n)
		{
		case 1:
		{
			System.out.println("Enter how many Employees Informations you want to add: ");
			int pojoNumber = get.getInt();
			for (int i=0; i<pojoNumber; i++)
			{
				PojoDB pojoObj = getPojoObj();
				get.scan.nextLine();
				System.out.println("Enter Employee Name: ");
				String pojoName = get.scan.nextLine();
				pojoObj.setName(pojoName);
				System.out.println("Enter Mobile Number: ");
				String pojoMobile = get.scan.next();
				pojoObj.setMobile(pojoMobile);
				System.out.println("Enter E-mail: ");
				String pojoEmail = get.scan.next();
				pojoObj.setEmail(pojoEmail);
				get.scan.nextLine();
				System.out.println("Enter Department: ");
				String pojoDepartment = get.scan.nextLine();
				pojoObj.setDepartment(pojoDepartment);
				run.addDetails(pojoObj);
			}
			break;
		}
			
		case 2:
		{
			PojoDB pojoObj = getPojoObj();
			System.out.println("Enter the Name of Employee you want to get Details: ");
			get.scan.nextLine();
			String pojoName = get.scan.nextLine();
			pojoObj.setName(pojoName);
			List<Map<String, ?>> pojoListByName = new ArrayList<Map<String, ?>>();
			pojoListByName = run.selectEmployeeByName(pojoObj);
			for (Map<String, ?> row : pojoListByName)
			{
				System.out.println(row);
			}					
			break;
		}
		
		case 3:
		{
			System.out.println("Enter the number for first N employee details: ");
			int number = get.getInt();
			List<PojoDB> arrayListForFirstN = new ArrayList<PojoDB>();
			arrayListForFirstN = run.getEmployeesDetailsOfFirstNpojo(number);
			for (int i = 0; i < number; i++)
			{
				PojoDB pojo = arrayListForFirstN.get(i);
				System.out.println("EMPLOYEE_ID = " + pojo.getId());
				System.out.println("NAME = " + pojo.getName());
				System.out.println("MOBILE = " + pojo.getMobile());
				System.out.println("DEPARTMENT = " + pojo.getDepartment());
				System.out.println("EMAIL = " + pojo.getEmail());
				System.out.println();
			}
			break;
		}
			
		case 4:
		{
			System.out.println("Enter the number for first N employee details: ");
			int number = get.getInt();
			System.out.println("In which column will print in order: ");
			System.out.println("1) NAME \n2) MOBILE \n3) EMAIL \n4) DEPARTMENT \n5) ID");
			int c = get.getInt();
			String column;
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
			List<PojoDB> arrayListOrder = new ArrayList<PojoDB>();
			switch (order)
			{
			case 2:
				arrayListOrder = run.getEmployeesDetailsInDescendingOrderPojo(number, column);
				break;
			
			default:
				arrayListOrder = run.getEmployeesDetailsInAscendingOrderPojo(number, column);
				break;
			}
			for (int i = 0; i < number; i++)
			{
				PojoDB pojo = arrayListOrder.get(i);
				System.out.println("EMPLOYEE_ID = " + pojo.getId());
				System.out.println("NAME = " + pojo.getName());
				System.out.println("MOBILE = " + pojo.getMobile());
				System.out.println("DEPARTMENT = " + pojo.getDepartment());
				System.out.println("EMAIL = " + pojo.getEmail());
				System.out.println();
			}
			break;
		}
		}
	}

}
