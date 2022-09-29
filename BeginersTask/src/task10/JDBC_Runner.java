package task10;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC_Runner 
{

	public static void main(String[] args) throws Exception 
	{
		getConnection();
	}
	
	public static Connection getConnection() throws Exception
	{
		try
		{
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/incubationDB";
			String userName = "hi";
			String password = "free";
			Class.forName(driver);
			
			Connection connect = DriverManager.getConnection(url, userName, password);
			System.out.println("Connected");
			return connect;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return null;
	}

}
