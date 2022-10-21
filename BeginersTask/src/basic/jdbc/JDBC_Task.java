package basic.jdbc;

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

import myException.InputValidityCheck;
import myException.UserDefinedException;

public class JDBC_Task 
{
	private Logger logger = Logger.getLogger("JDBC outputs");
	
	private static Connection getConnection() throws UserDefinedException
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
			throw new UserDefinedException (se);
		}
		catch (Exception e) 
		{
			throw new UserDefinedException (e.toString());
		}
	}
	
	private List<Map<String, ?>> getOutput(ResultSet result, ResultSetMetaData rsmd, int columnCount) throws UserDefinedException
	{
		InputValidityCheck.checkNull(result);
		InputValidityCheck.checkNull(rsmd);
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
			throw new UserDefinedException (se);							
		}
	}
	
	private String getQuery(int queryNo, String column)
	{
		String query = null;
		switch (queryNo)
		{
		case 2:
			query = "INSERT INTO EmployeeDetails (NAME, MOBILE, EMAIL, DEPARTMENT) VALUES (?, ?, ?, ?);";
			break;
			
		case 3:
			query = "SELECT * FROM EmployeeDetails WHERE NAME = ?";
			break;
			
		case 4:
			query = "UPDATE EmployeeDetails SET " + column + " = ? WHERE EMPLOYEE_ID = ?";
			break;
			
		case 42:
			query = "UPDATE EmployeeDetails SET DEPARTMENT = ?, MOBILE = ?, EMAIL = ? WHERE EMPLOYEE_ID = ?";
			break;
			
		case 5:
			query = "SELECT * FROM EmployeeDetails LIMIT ?;";
			break;
			
		case 6:
			query = "SELECT * FROM EmployeeDetails ORDER BY " + column + " LIMIT ?;";
			break;
			
		case 62:
			query = "SELECT * FROM EmployeeDetails ORDER BY " + column  + " DESC LIMIT ?";
			break;
			
		case 7:
			query = "DELETE FROM EmployeeDetails WHERE EMPLOYEE_ID = ?";
			break;
			
		case 10:
			query = "INSERT INTO EmployeeFamilyDetails (EMPLOYEE_ID, NAME, AGE, RELATIONSHIP) VALUES (?, ?, ?, ?);";
			break;
			
		case 11:
			query = "SELECT EmployeeDetails.EMPLOYEE_ID, EmployeeDetails.NAME, EmployeeFamilyDetails.RELATION_NAME, "
					+ "EmployeeFamilyDetails.AGE, EmployeeFamilyDetails.RELATIONSHIP "
					+ "FROM EmployeeDetails INNER JOIN EmployeeFamilyDetails "
					+ "ON EmployeeDetails.EMPLOYEE_ID = EmployeeFamilyDetails.EMPLOYEE_ID WHERE EmployeeDetails.NAME = ?";
			break;
			
		case 112:
			query = "SELECT EmployeeDetails.EMPLOYEE_ID, EmployeeDetails.NAME, EmployeeFamilyDetails.RELATION_NAME, "
					+ "EmployeeFamilyDetails.AGE, EmployeeFamilyDetails.RELATIONSHIP "
					+ "FROM EmployeeDetails INNER JOIN EmployeeFamilyDetails "
					+ "ON EmployeeDetails.EMPLOYEE_ID = EmployeeFamilyDetails.EMPLOYEE_ID WHERE EmployeeDetails.EMPLOYEE_ID = ?";
			break;
			
		case 12:
			query = "SELECT EmployeeDetails.EMPLOYEE_ID, EmployeeDetails.NAME, "
					+ "EmployeeFamilyDetails.RELATION_NAME, EmployeeFamilyDetails.AGE, "
					+ "EmployeeFamilyDetails.RELATIONSHIP FROM EmployeeDetails "
					+ "INNER JOIN EmployeeFamilyDetails ON EmployeeDetails.EMPLOYEE_ID = EmployeeFamilyDetails.EMPLOYEE_ID "
					+ "ORDER BY EmployeeDetails.NAME LIMIT ?";
			break;
			
		case 122:
			query = "SELECT EmployeeDetails.EMPLOYEE_ID, EmployeeDetails.NAME, "
					+ "EmployeeFamilyDetails.RELATION_NAME, EmployeeFamilyDetails.AGE, "
					+ "EmployeeFamilyDetails.RELATIONSHIP FROM EmployeeDetails "
					+ "INNER JOIN EmployeeFamilyDetails ON EmployeeDetails.EMPLOYEE_ID = EmployeeFamilyDetails.EMPLOYEE_ID "
					+ "ORDER BY EmployeeDetails.NAME DESC LIMIT ?";
			break;
			
		}
		return query;
	}
	
//	EX1, 9
	public void createTable(String inputString) throws UserDefinedException
	{
//		inputString = null;
		try (Connection connect = getConnection())
		{
			try (Statement statement = connect.createStatement())										
			{
				statement.executeUpdate(inputString);
			}
		}
		catch (SQLException se) 
		{
			throw new UserDefinedException (se);
		}
	}
	
//	EX2
	public void addDetails(String name, String mobile, String email, String department) throws UserDefinedException
	{
		String query = getQuery(2, null);
		try (Connection connect = getConnection())
		{
			try (PreparedStatement statement = connect.prepareStatement(query))					
			{
				statement.setString(1, name);
				statement.setString(2, mobile);
				statement.setString(3, email);
				statement.setString(4, department);
				statement.executeUpdate();
			}
		}
		catch (SQLException se) 
		{
			throw new UserDefinedException (se);
		}
	}
	
//	EX8-2
	public void addDetails(PojoDB pojoObj) throws UserDefinedException
	{
		InputValidityCheck.checkNull(pojoObj);
		addDetails(pojoObj.getName(), pojoObj.getMobile(), pojoObj.getEmail(), pojoObj.getDepartment());
	}
	
//	EX3
	public List<Map<String, ?>> selectEmployeeByName (String name) throws UserDefinedException
	{
		String query = getQuery(3, null);
		try (Connection connect = getConnection())
		{
			try (PreparedStatement statement = connect.prepareStatement(query))
			{
				statement.setString(1, name);
				try (ResultSet result = statement.executeQuery())
				{
					List<Map<String, ?>> output = new ArrayList<Map<String, ?>>();
					ResultSetMetaData rsmd = result.getMetaData();
					int columnCount = rsmd.getColumnCount();
					output = getOutput(result, rsmd, columnCount);
					return output;
				}
			}
		}
		catch (SQLException se) 
		{
			throw new UserDefinedException (se);
		}
	}
	
//	EX8-3
	public List<Map<String, ?>> selectEmployeeByName (PojoDB pojoObj) throws UserDefinedException
	{
		InputValidityCheck.checkNull(pojoObj);
		List<Map<String, ?>> output = new ArrayList<Map<String, ?>>();
		output = selectEmployeeByName(pojoObj.getName());
		return output;
		
	}
	
//	EX4
	public void modifyAnyColumnDetails(int id, String column, String changes) throws UserDefinedException
	{
		String query = getQuery(4, column);
		try (Connection connect = getConnection())
		{
			try (PreparedStatement statement = connect.prepareStatement(query))
			{
				statement.setString(1, changes);
				statement.setInt(2, id);
				statement.executeUpdate();
			}
		}
		catch (SQLException se) 
		{
			throw new UserDefinedException (se);
		}
	}
	
//	EX4
	public void modifyAllDetails(int id, String dept, String mobile, String email) throws UserDefinedException
	{
		String query = getQuery(42, null);
		try (Connection connect = getConnection())
		{
			try (PreparedStatement statement = connect.prepareStatement(query))
			{
				statement.setString(1, dept);
				statement.setString(2, mobile);
				statement.setString(3, email);
				statement.setInt(4, id);
				statement.executeUpdate();
			}
		}
		catch (SQLException se) 
		{
			throw new UserDefinedException (se);
		}
	}
	
//	EX5
	public List<Map<String, ?>> getEmployeesDetailsOfFirstN(int firstN) throws UserDefinedException
	{
		String query = getQuery(5, null);
		try (Connection connect = getConnection())
		{
			try (PreparedStatement statement = connect.prepareStatement(query))
			{
				statement.setInt(1, firstN);
				try (ResultSet result = statement.executeQuery())
				{
					List<Map<String, ?>> output = new ArrayList<Map<String, ?>>();
					ResultSetMetaData rsmd = result.getMetaData();
					int columnCount = rsmd.getColumnCount();
					output = getOutput(result, rsmd, columnCount);
					return output;
				}
			}
		}
		catch (SQLException se) 
		{
			throw new UserDefinedException (se);
		}
	}
	
//	EX8-5
	public List<PojoDB> getEmployeesDetailsOfFirstNpojo(int firstN) throws UserDefinedException
	{
		String query = getQuery(5, null);
		try (Connection connect = getConnection())
		{
			try (PreparedStatement statement = connect.prepareStatement(query))
			{
				statement.setInt(1, firstN);
				try (ResultSet result = statement.executeQuery())
				{
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
			}
		}
		catch (SQLException se) 
		{
			throw new UserDefinedException (se);
		}
	}
	
//	EX6
	public List<Map<String, ?>> getEmployeesDetailsInAscendingOrder(int firstN, String column) throws UserDefinedException
	{
		String query = getQuery(6, column);
		try (Connection connect = getConnection())
		{
			try (PreparedStatement statement = connect.prepareStatement(query))
			{
				statement.setInt(1, firstN);
				try (ResultSet result = statement.executeQuery())
				{
					List<Map<String, ?>> output = new ArrayList<Map<String, ?>>();
					ResultSetMetaData rsmd = result.getMetaData();
					int columnCount = rsmd.getColumnCount();
					output = getOutput(result, rsmd, columnCount);
					return output;
				}
			}
		}
		catch (SQLException se) 
		{
			throw new UserDefinedException (se);
		}
	}
	
//	EX8-6
	public List<PojoDB> getEmployeesDetailsInAscendingOrderPojo(int firstN, String column) throws UserDefinedException
	{
		String query = getQuery(6, column);
		try (Connection connect = getConnection())
		{
			try (PreparedStatement statement = connect.prepareStatement(query))
			{
				statement.setInt(1, firstN);
				try (ResultSet result = statement.executeQuery())
				{
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
			}
		}
		catch (SQLException se) 
		{
			throw new UserDefinedException (se);
		}
	}
	
//	EX6
	public List<Map<String, ?>> getEmployeesDetailsInDescendingOrder(int firstN, String column) throws UserDefinedException
	{
		String query = getQuery(62, column);
		try (Connection connect = getConnection())
		{
			try (PreparedStatement statement = connect.prepareStatement(query))
			{
				statement.setInt(1, firstN);
				try (ResultSet result = statement.executeQuery())
				{
					List<Map<String, ?>> output = new ArrayList<Map<String, ?>>();
					ResultSetMetaData rsmd = result.getMetaData();
					int columnCount = rsmd.getColumnCount();
					output = getOutput(result, rsmd, columnCount);
					return output;
				}
			}
		}
		catch (SQLException se) 
		{
			throw new UserDefinedException (se);
		}
	}
	
//	EX8-6
	public List<PojoDB> getEmployeesDetailsInDescendingOrderPojo(int firstN, String column) throws UserDefinedException
	{
		String query = getQuery(62, column);
		try (Connection connect = getConnection())
		{
			try (PreparedStatement statement = connect.prepareStatement(query))
			{
				statement.setInt(1, firstN);
				try (ResultSet result = statement.executeQuery())
				{
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
			}
		}
		catch (SQLException se) 
		{
			throw new UserDefinedException (se);
		}
	}
	
//	EX7
	public void deleteEmployee(int id) throws UserDefinedException
	{
		String query = getQuery(7, null);
		try (Connection connect = getConnection())
		{
			try (PreparedStatement statement = connect.prepareStatement(query))
			{
				statement.setInt(1, id);
				statement.executeUpdate();
			}
		}
		catch (SQLException se) 
		{
			throw new UserDefinedException (se);
		}
	}
	
//	EX10
	public void addFamilyDetails(int id, String name, int age, String relation) throws UserDefinedException
	{
		String query = getQuery(10, null);
		try (Connection connect = getConnection())
		{
			try (PreparedStatement statement = connect.prepareStatement(query))
			{
				statement.setInt(1, id);
				statement.setString(2, name);
				statement.setInt(3, age);
				statement.setString(4, relation);
				statement.executeUpdate();
			}
		}
		catch (SQLException se) 
		{
			throw new UserDefinedException (se);
		}
	}
	
//	EX11
	public List<Map<String, ?>> selectFamilyByName (String name) throws UserDefinedException
	{
		String query = getQuery(11, null);
		try (Connection connect = getConnection())
		{
			try (PreparedStatement statement = connect.prepareStatement(query))
			{
				statement.setString(1, name);
				try (ResultSet result = statement.executeQuery())
				{
					List<Map<String, ?>> output = new ArrayList<Map<String, ?>>();
					ResultSetMetaData rsmd = result.getMetaData();
					int columnCount = rsmd.getColumnCount();
					output = getOutput(result, rsmd, columnCount);
					return output;
				}
			}
		}
		catch (SQLException se) 
		{
			throw new UserDefinedException (se);
		}
	}
	
//	EX11
	public List<Map<String, ?>> selectFamilyById (int id) throws UserDefinedException
	{
		String query = getQuery(112, null);
		try (Connection connect = getConnection())
		{
			try (PreparedStatement statement = connect.prepareStatement(query))
			{
				statement.setInt(1, id);
				try (ResultSet result = statement.executeQuery())
				{
					List<Map<String, ?>> output = new ArrayList<Map<String, ?>>();
					ResultSetMetaData rsmd = result.getMetaData();
					int columnCount = rsmd.getColumnCount();
					output = getOutput(result, rsmd, columnCount);
					return output;
				}
			}
		}
		catch (SQLException se) 
		{
			throw new UserDefinedException (se);
		}
	}
	
//	EX12
	public List<Map<String, ?>> getEmployeesFamilyDetailsInAscendingOrder(int firstN) throws UserDefinedException
	{
		String query = getQuery(12, null);
		try (Connection connect = getConnection())
		{
			try (PreparedStatement statement = connect.prepareStatement(query))
			{
				statement.setInt(1, firstN);
				try (ResultSet result = statement.executeQuery())
				{
					List<Map<String, ?>> output = new ArrayList<Map<String, ?>>();
					ResultSetMetaData rsmd = result.getMetaData();
					int columnCount = rsmd.getColumnCount();
					output = getOutput(result, rsmd, columnCount);
					logger.info("Bye");
					return output;
				}
			}
		}
		catch (SQLException se) 
		{
			throw new UserDefinedException (se);
		}
	}
	
//	EX12
	public List<Map<String, ?>> getEmployeesFamilyDetailsInDescendingOrder(int firstN) throws UserDefinedException
	{
		String query = getQuery(122, null);
		try (Connection connect = getConnection())
		{
			try (PreparedStatement statement = connect.prepareStatement(query))
			{
				statement.setInt(1, firstN);
				try (ResultSet result = statement.executeQuery())
				{
					List<Map<String, ?>> output = new ArrayList<Map<String, ?>>();
					ResultSetMetaData rsmd = result.getMetaData();
					int columnCount = rsmd.getColumnCount();
					output = getOutput(result, rsmd, columnCount);
					logger.info("Bye");
					return output;
				}
			}
		}
		catch (SQLException se) 
		{
			throw new UserDefinedException (se);
		}
	}
	
}











