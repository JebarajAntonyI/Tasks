package task10;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.ResultSetMetaData;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.List;

import java.util.Map;

import java.util.logging.Logger;

import myException.UserDefinedException;

public class JDBC_Task 
{
	Logger logger = Logger.getLogger("JDBC_Task.class");
	
	public static Connection getConnection() throws UserDefinedException
	{
		try
		{
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/incubationDB";
			String userName = "incubationTask";
			String password = "inc3363@JEBA";
			Class.forName(driver);
			Connection connect = DriverManager.getConnection(url, userName, password);
			System.out.println("Connected");
			return connect;
		}
		catch (SQLException se) 
		{
//			throw new UserDefinedException ("SQL-Exception" + se);
			throw new UserDefinedException ("SQL Syntax Error");
		}
		catch (Exception e) 
		{
			throw new UserDefinedException ("" + e);
		}
	}
	
	public List<Map<String, ?>> getOutput(ResultSet result, ResultSetMetaData rsmd, int columnCount) throws UserDefinedException
	{
		List<Map<String, ?>> output = new ArrayList<Map<String, ?>>();
		try
		{
			while (result.next())
			{
				Map<String, Object> row = new HashMap<String, Object>();
				
				for (int i=1; i<=columnCount; i++)
				{
					row.put(rsmd.getColumnLabel(i).toUpperCase(), result.getObject(i));
				}
				output.add(row);
			}
			return output;
		}
		catch (SQLException se) 
		{
//			throw new UserDefinedException ("SQL-Exception" + se);
			throw new UserDefinedException ("SQL Syntax Error");
		}
	}
	
//	EX1
	public void createTable(String inputString) throws UserDefinedException
	{
		Connection connect;
		Statement statement;
		try 
		{
			connect = getConnection();
			statement = connect.createStatement();
			statement.executeUpdate(inputString);
		}
		catch (SQLException se) 
		{
//			throw new UserDefinedException ("SQL-Exception" + se);
			throw new UserDefinedException ("SQL Syntax Error");
		}
	}
	
	public void addDetails(String name, String mobile, String email, String department) throws UserDefinedException
	{
		try
		{
			Connection connect = getConnection();
			PreparedStatement statement = connect.prepareStatement("INSERT INTO EmployeeDetails (NAME, MOBILE, EMAIL, DEPARTMENT) VALUES (?, ?, ?, ?);");
			statement.setString(1, name);
			statement.setString(2, mobile);
			statement.setString(3, email);
			statement.setString(4, department);
			statement.executeUpdate();
		}
		catch (SQLException se) 
		{
//			throw new UserDefinedException ("SQL-Exception" + se);
			throw new UserDefinedException ("SQL Syntax Error");
		}
	}
	
	public void addDetails(PojoDB pojoObj) throws UserDefinedException
	{
		addDetails(pojoObj.getName(), pojoObj.getMobile(), pojoObj.getEmail(), pojoObj.getDepartment());
	}
	
	public List<Map<String, ?>> selectEmployeeByName (String inputString) throws UserDefinedException
	{
		try
		{
			Connection connect = getConnection();
			PreparedStatement statement = connect.prepareStatement("SELECT * FROM EmployeeDetails WHERE NAME = ?");
			statement.setString(1, inputString);
			ResultSet result = statement.executeQuery();
			List<Map<String, ?>> output = new ArrayList<Map<String, ?>>();
			ResultSetMetaData rsmd = result.getMetaData();
			int columnCount = rsmd.getColumnCount();
			output = getOutput(result, rsmd, columnCount);
			return output;
		}
		catch (SQLException se) 
		{
//			throw new UserDefinedException ("SQL-Exception" + se);
			throw new UserDefinedException ("SQL Syntax Error");
		}
	}
	
	public List<Map<String, ?>> selectEmployeeByName (PojoDB pojoObj) throws UserDefinedException
	{
		List<Map<String, ?>> output = new ArrayList<Map<String, ?>>();
		output = selectEmployeeByName(pojoObj.getName());
		return output;
		
	}
	
	public void modifyDepartmentDetails(int id, String inputString) throws UserDefinedException
	{
		try
		{
			Connection connect = getConnection();
			PreparedStatement statement = connect.prepareStatement("UPDATE EmployeeDetails SET DEPARTMENT = ? WHERE EMPLOYEE_ID = ?");
			statement.setString(1, inputString);
			statement.setInt(2, id);
			statement.executeUpdate();
		}
		catch (SQLException se) 
		{
//			throw new UserDefinedException ("SQL-Exception" + se);
			throw new UserDefinedException ("SQL Syntax Error");
		}
	}
	
	public void modifyMobileDetails(int id, String inputString) throws UserDefinedException
	{
		try
		{
			Connection connect = getConnection();
			PreparedStatement statement = connect.prepareStatement("UPDATE EmployeeDetails SET MOBILE = ? WHERE EMPLOYEE_ID = ?");
			statement.setString(1, inputString);
			statement.setInt(2, id);
			statement.executeUpdate();
		}
		catch (SQLException se) 
		{
//			throw new UserDefinedException ("SQL-Exception" + se);
			throw new UserDefinedException ("SQL Syntax Error");
		}
	}
	
	public void modifyEmailDetails(int id, String inputString) throws UserDefinedException
	{
		try
		{
			Connection connect = getConnection();
			PreparedStatement statement = connect.prepareStatement("UPDATE EmployeeDetails SET EMAIL = ? WHERE EMPLOYEE_ID = ?");
			statement.setString(1, inputString);
			statement.setInt(2, id);
			statement.executeUpdate();
		}
		catch (SQLException se) 
		{
//			throw new UserDefinedException ("SQL-Exception" + se);
			throw new UserDefinedException ("SQL Syntax Error");
		}
	}
	
	public void modifyAllDetails(int id, String... inputString) throws UserDefinedException
	{
		try
		{
			Connection connect = getConnection();
			PreparedStatement statement = connect.prepareStatement("UPDATE EmployeeDetails SET DEPARTMENT = ?, MOBILE = ?, EMAIL = ? WHERE EMPLOYEE_ID = ?");
			statement.setString(1, inputString[0]);
			statement.setString(2, inputString[1]);
			statement.setString(3, inputString[2]);
			statement.setInt(4, id);
			statement.executeUpdate();
		}
		catch (SQLException se) 
		{
//			throw new UserDefinedException ("SQL-Exception" + se);
			throw new UserDefinedException ("SQL Syntax Error");
		}
	}
	
	public List<Map<String, ?>> getEmployeesDetailsOfFirstN(int n) throws UserDefinedException
	{
		try
		{
			Connection connect = getConnection();
			PreparedStatement statement = connect.prepareStatement("SELECT * FROM EmployeeDetails WHERE EMPLOYEE_ID <= ?;");
			statement.setInt(1, n);
			ResultSet result = statement.executeQuery();
			List<Map<String, ?>> output = new ArrayList<Map<String, ?>>();
			ResultSetMetaData rsmd = result.getMetaData();
			int columnCount = rsmd.getColumnCount();
			output = getOutput(result, rsmd, columnCount);
			return output;
		}
		catch (SQLException se) 
		{
//			throw new UserDefinedException ("SQL-Exception" + se);
			throw new UserDefinedException ("SQL Syntax Error");
		}
	}
	
	public List<PojoDB> getEmployeesDetailsOfFirstNpojo(int n) throws UserDefinedException
	{
		try
		{
			Connection connect = getConnection();
			PreparedStatement statement = connect.prepareStatement("SELECT * FROM EmployeeDetails WHERE EMPLOYEE_ID <= ?;");
			statement.setInt(1, n);
			ResultSet result = statement.executeQuery();
			List<PojoDB> output = new ArrayList<PojoDB>();
			PojoDB pojoObj;
			while (result.next())
			{
				pojoObj = new PojoDB();
				pojoObj.setId(result.getInt("EMPLOYEE_ID"));
				pojoObj.setName(result.getString("NAME"));
				pojoObj.setMobile(result.getString("MOBILE"));
				pojoObj.setDepartment(result.getString("DEPARTMENT"));
				pojoObj.setEmail(result.getString("EMAIL"));
				output.add(pojoObj);
			}
			return output;
		}
		catch (SQLException se) 
		{
//			throw new UserDefinedException ("SQL-Exception" + se);
			throw new UserDefinedException ("SQL Syntax Error");
		}
	}
	
	public List<Map<String, ?>> getEmployeesDetailsInAscendingOrder(int n, String column) throws UserDefinedException
	{
		try
		{
			Connection connect = getConnection();
			PreparedStatement statement = connect.prepareStatement("SELECT * FROM EmployeeDetails WHERE EMPLOYEE_ID <= ? ORDER BY " + column);
			statement.setInt(1, n);
			ResultSet result = statement.executeQuery();
			List<Map<String, ?>> output = new ArrayList<Map<String, ?>>();
			ResultSetMetaData rsmd = result.getMetaData();
			int columnCount = rsmd.getColumnCount();
			output = getOutput(result, rsmd, columnCount);
			return output;
		}
		catch (SQLException se) 
		{
//			throw new UserDefinedException ("SQL-Exception" + se);
			throw new UserDefinedException ("SQL Syntax Error");
		}
	}
	
	public List<PojoDB> getEmployeesDetailsInAscendingOrderPojo(int n, String column) throws UserDefinedException
	{
		try
		{
			Connection connect = getConnection();
			PreparedStatement statement = connect.prepareStatement("SELECT * FROM EmployeeDetails WHERE EMPLOYEE_ID <= ? ORDER BY " + column);
			statement.setInt(1, n);
			ResultSet result = statement.executeQuery();
			List<PojoDB> output = new ArrayList<PojoDB>();
			PojoDB pojoObj;
			while (result.next())
			{
				pojoObj = new PojoDB();
				pojoObj.setId(result.getInt("EMPLOYEE_ID"));
				pojoObj.setName(result.getString("NAME"));
				pojoObj.setMobile(result.getString("MOBILE"));
				pojoObj.setDepartment(result.getString("DEPARTMENT"));
				pojoObj.setEmail(result.getString("EMAIL"));
				output.add(pojoObj);
			}
			return output;
		}
		catch (SQLException se) 
		{
//			throw new UserDefinedException ("SQL-Exception" + se);
			throw new UserDefinedException ("SQL Syntax Error");
		}
	}
	
	public List<Map<String, ?>> getEmployeesDetailsInDescendingOrder(int n, String column) throws UserDefinedException
	{
		try
		{
			Connection connect = getConnection();
			PreparedStatement statement = connect.prepareStatement("SELECT * FROM EmployeeDetails WHERE EMPLOYEE_ID <= ? ORDER BY " + column  + " DESC");
			statement.setInt(1, n);
			ResultSet result = statement.executeQuery();
			List<Map<String, ?>> output = new ArrayList<Map<String, ?>>();
			ResultSetMetaData rsmd = result.getMetaData();
			int columnCount = rsmd.getColumnCount();
			output = getOutput(result, rsmd, columnCount);
			return output;
		}
		catch (SQLException se) 
		{
//			throw new UserDefinedException ("SQL-Exception" + se);
			throw new UserDefinedException ("SQL Syntax Error");
		}
	}
	
	public List<PojoDB> getEmployeesDetailsInDescendingOrderPojo(int n, String column) throws UserDefinedException
	{
		try
		{
			Connection connect = getConnection();
			PreparedStatement statement = connect.prepareStatement("SELECT * FROM EmployeeDetails WHERE EMPLOYEE_ID <= ? ORDER BY " + column + " DESC");
			statement.setInt(1, n);
			ResultSet result = statement.executeQuery();
			List<PojoDB> output = new ArrayList<PojoDB>();
			PojoDB pojoObj;
			while (result.next())
			{
				pojoObj = new PojoDB();
				pojoObj.setId(result.getInt("EMPLOYEE_ID"));
				pojoObj.setName(result.getString("NAME"));
				pojoObj.setMobile(result.getString("MOBILE"));
				pojoObj.setDepartment(result.getString("DEPARTMENT"));
				pojoObj.setEmail(result.getString("EMAIL"));
				output.add(pojoObj);
			}
			return output;
		}
		catch (SQLException se) 
		{
//			throw new UserDefinedException ("SQL-Exception" + se);
			throw new UserDefinedException ("SQL Syntax Error");
		}
	}
	
	public void deleteEmployee(int id) throws UserDefinedException
	{
		try
		{
			Connection connect = getConnection();
			PreparedStatement statement = connect.prepareStatement("DELETE FROM EmployeeDetails WHERE EMPLOYEE_ID = ?");
			statement.setInt(1, id);
			statement.executeUpdate();
		}
		catch (SQLException se) 
		{
//			throw new UserDefinedException ("SQL-Exception" + se);
			throw new UserDefinedException ("SQL Syntax Error");
		}
	}
	
	public void addFamilyDetails(int id, String name, int age, String relation) throws UserDefinedException
	{
		try
		{
			Connection connect = getConnection();
			PreparedStatement statement = connect.prepareStatement("INSERT INTO EmployeeFamilyDetails (EMPLOYEE_ID, NAME, AGE, RELATIONSHIP) VALUES (?, ?, ?, ?);");
			statement.setInt(1, id);
			statement.setString(2, name);
			statement.setInt(3, age);
			statement.setString(4, relation);
			statement.executeUpdate();
		}
		catch (SQLException se) 
		{
//			throw new UserDefinedException ("SQL-Exception" + se);
			throw new UserDefinedException ("SQL Syntax Error");
		}
	}
	
	public List<Map<String, ?>> selectFamilyByName (String inputString) throws UserDefinedException
	{
		try
		{
			Connection connect = getConnection();
			PreparedStatement statement = connect.prepareStatement("SELECT EmployeeDetails.EMPLOYEE_ID, EmployeeDetails.NAME, EmployeeFamilyDetails.RELATION_NAME, EmployeeFamilyDetails.AGE, EmployeeFamilyDetails.RELATIONSHIP FROM EmployeeDetails INNER JOIN EmployeeFamilyDetails ON EmployeeDetails.EMPLOYEE_ID = EmployeeFamilyDetails.EMPLOYEE_ID WHERE EmployeeDetails.NAME = ?");
			statement.setString(1, inputString);
			ResultSet result = statement.executeQuery();                                                                          
			List<Map<String, ?>> output = new ArrayList<Map<String, ?>>();
			ResultSetMetaData rsmd = result.getMetaData();
			int columnCount = rsmd.getColumnCount();
			output = getOutput(result, rsmd, columnCount);
			return output;
		}
		catch (SQLException se) 
		{
//			throw new UserDefinedException ("SQL-Exception" + se);
			throw new UserDefinedException ("SQL Syntax Error");
		}
	}
	
	public List<Map<String, ?>> selectFamilyById (int id) throws UserDefinedException
	{
		try
		{
			Connection connect = getConnection();
			PreparedStatement statement = connect.prepareStatement("SELECT EmployeeDetails.EMPLOYEE_ID, EmployeeDetails.NAME, EmployeeFamilyDetails.RELATION_NAME, EmployeeFamilyDetails.AGE, EmployeeFamilyDetails.RELATIONSHIP FROM EmployeeDetails INNER JOIN EmployeeFamilyDetails ON EmployeeDetails.EMPLOYEE_ID = EmployeeFamilyDetails.EMPLOYEE_ID WHERE EmployeeDetails.EMPLOYEE_ID = ?");
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();                                                                          
			List<Map<String, ?>> output = new ArrayList<Map<String, ?>>();
			ResultSetMetaData rsmd = result.getMetaData();
			int columnCount = rsmd.getColumnCount();
			output = getOutput(result, rsmd, columnCount);
			return output;
		}
		catch (SQLException se) 
		{
//			throw new UserDefinedException ("SQL-Exception" + se);
			throw new UserDefinedException ("SQL Syntax Error");
		}
	}
	
	public List<Map<String, ?>> getEmployeesFamilyDetailsInAscendingOrder(int n) throws UserDefinedException
	{
		try
		{
			Connection connect = getConnection();
			PreparedStatement statement = connect.prepareStatement("SELECT EmployeeDetails.EMPLOYEE_ID, EmployeeDetails.NAME, EmployeeFamilyDetails.RELATION_NAME, EmployeeFamilyDetails.AGE, EmployeeFamilyDetails.RELATIONSHIP FROM EmployeeDetails INNER JOIN EmployeeFamilyDetails ON EmployeeDetails.EMPLOYEE_ID = EmployeeFamilyDetails.EMPLOYEE_ID WHERE EmployeeDetails.EMPLOYEE_ID <= ? ORDER BY EmployeeDetails.EMPLOYEE_ID");
			statement.setInt(1, n);
			ResultSet result = statement.executeQuery();                                                                          
			List<Map<String, ?>> output = new ArrayList<Map<String, ?>>();
			ResultSetMetaData rsmd = result.getMetaData();
			int columnCount = rsmd.getColumnCount();
			output = getOutput(result, rsmd, columnCount);
			logger.info("Bye");
			return output;
		}
		catch (SQLException se) 
		{
//			throw new UserDefinedException ("SQL-Exception" + se);
			throw new UserDefinedException ("SQL Syntax Error");
		}
	}
	
	public List<Map<String, ?>> getEmployeesFamilyDetailsInDescendingOrder(int n) throws UserDefinedException
	{
		try
		{
			Connection connect = getConnection();
			PreparedStatement statement = connect.prepareStatement("SELECT EmployeeDetails.EMPLOYEE_ID, EmployeeDetails.NAME, EmployeeFamilyDetails.RELATION_NAME, EmployeeFamilyDetails.AGE, EmployeeFamilyDetails.RELATIONSHIP FROM EmployeeDetails INNER JOIN EmployeeFamilyDetails ON EmployeeDetails.EMPLOYEE_ID = EmployeeFamilyDetails.EMPLOYEE_ID WHERE EmployeeDetails.EMPLOYEE_ID <= ? ORDER BY EmployeeDetails.EMPLOYEE_ID DESC");
			statement.setInt(1, n);
			ResultSet result = statement.executeQuery();                                                                 
			List<Map<String, ?>> output = new ArrayList<Map<String, ?>>();
			ResultSetMetaData rsmd = result.getMetaData();
			int columnCount = rsmd.getColumnCount();
			output = getOutput(result, rsmd, columnCount);
			logger.info("Bye");
			return output;
		}
		catch (SQLException se) 
		{
//			throw new UserDefinedException ("SQL-Exception" + se);
			throw new UserDefinedException ("SQL Syntax Error");
		}
	}
	
}











