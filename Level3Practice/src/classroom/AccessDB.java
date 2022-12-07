package classroom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import userException.UserDefinedException;

public class AccessDB 
{
	public Connection getConnection() throws UserDefinedException
	{
		String url = "jdbc:mysql://localhost:3306/level3Practice";
		String username = "incubationTask";
		String password = "inc3363@JEBA";
		
		try
		{
			Connection connect = DriverManager.getConnection(url, username, password);
			return connect;
		}
		catch (SQLException e)
		{
			throw new UserDefinedException("Problem in DB Connection", e);
		}
	}
	
	public void addUser(UserDetails user) throws UserDefinedException
	{
		String query = "INSERT INTO User_Details (NAME, EMAIL, PASSWORD, MOBILE, ROLL) VALUES(?, ?, ?, ?, ?)";
		
		try(Connection connect = getConnection())
		{
			try(PreparedStatement statement = connect.prepareStatement(query))
			{
				statement.setString(1, user.getName());
				statement.setString(2, user.getMail());
				statement.setString(3, user.getPassword());
				statement.setLong(4, user.getMobile());
				statement.setString(5, user.getRoll());
				statement.executeUpdate();
			}
		}
		catch (SQLException e)
		{
			throw new UserDefinedException("Problem in User Details Input", e);
		}
	}
	
	public void postMaterials(StudyMaterials materials) throws UserDefinedException
	{
		String query = "INSERT INTO Study_Materials (FACULTY, EMAIL, MATERIALS) VALUES(?, ?, ?)";
		
		try(Connection connect = getConnection())
		{
			try(PreparedStatement statement = connect.prepareStatement(query))
			{
				statement.setString(1, materials.getFaculty());
				statement.setString(2, materials.getEmail());
				statement.setString(3, materials.getMaterials());
				statement.executeUpdate();
			}
		}
		catch (SQLException e)
		{
			throw new UserDefinedException("Problem in Study Materials Input", e);
		}
	}
	
	public void postDoubts(Doubts doubt) throws UserDefinedException
	{
		String query = "INSERT INTO Doubts (QUESTIONS) VALUES(?)";
		
		try(Connection connect = getConnection())
		{
			try(PreparedStatement statement = connect.prepareStatement(query))
			{
				statement.setString(1, doubt.getQuestion());
				statement.executeUpdate();
			}
		}
		catch (SQLException e)
		{
			throw new UserDefinedException("Problem in Doubts Input", e);
		}
	}
	
	public Map<String, UserDetails> getUserDetails(String... mail) throws UserDefinedException
	{
		String query = "SELECT * FROM User_Details";
		Map<String, UserDetails> userMap = new HashMap<>();
		
		try(Connection connect = getConnection())
		{
			try(PreparedStatement statement = connect.prepareStatement(query))
			{
				try(ResultSet result = statement.executeQuery())
				{
					while(result.next())
					{
						UserDetails user = new UserDetails();
						
						user.setName(result.getString("NAME"));
						user.setMail(result.getString("EMAIL"));
						user.setPassword(result.getString("PASSWORD"));
						user.setMobile(result.getLong("MOBILE"));
						user.setRoll(result.getString("ROLL"));
						user.setStatus(result.getString("STATUS"));
						
						userMap.put(user.getMail(), user);
					}
					
					int size = mail.length;
					
					if(size == 0)
					{
						return userMap;
					}
					Map<String, UserDetails> specificUser = new HashMap<>();
					for(int i=0; i<size; i++)
					{
						UserDetails user = userMap.get(mail[i]);
						if(user != null)
						{
							specificUser.put(user.getMail(), user);
						}
					}
					return specificUser;
				}
			}
		}
		catch (SQLException e)
		{
			throw new UserDefinedException("Problem getting User Details", e);
		}
	}
	
	public Map<Integer, StudyMaterials> getStudyMaterials(Integer... id) throws UserDefinedException
	{
		String query = "SELECT * FROM Study_Materials";
		Map<Integer, StudyMaterials> studyMap = new HashMap<>();
		
		try(Connection connect = getConnection())
		{
			try(PreparedStatement statement = connect.prepareStatement(query))
			{
				try(ResultSet result = statement.executeQuery())
				{
					while(result.next())
					{
						StudyMaterials material = new StudyMaterials();
						
						material.setId(result.getInt("ID"));
						material.setFaculty(result.getString("FACULTY"));
						material.setEmail(result.getString("EMAIL"));
						material.setMaterials(result.getString("MATERIALS"));
						
						studyMap.put(material.getId(), material);
					}
					
					int size = id.length;
					
					if(size == 0)
					{
						return studyMap;
					}
					Map<Integer, StudyMaterials> specificMaterial = new HashMap<>();
					for(int i=0; i<size; i++)
					{
						StudyMaterials material = studyMap.get(id[i]);
						if(material != null)
						{
							specificMaterial.put(material.getId(), material);
						}
					}
					return specificMaterial;
				}
			}
		}
		catch (SQLException e)
		{
			throw new UserDefinedException("Problem getting Study Materials", e);
		}
	}
	
	public Map<Integer, Doubts> getDoubts(Integer... number) throws UserDefinedException
	{
		String query = "SELECT * FROM Doubts";
		Map<Integer, Doubts> doubtMap = new HashMap<>();
		
		try(Connection connect = getConnection())
		{
			try(PreparedStatement statement = connect.prepareStatement(query))
			{
				try(ResultSet result = statement.executeQuery())
				{
					while(result.next())
					{
						Doubts doubt = new Doubts();
						
						doubt.setNumber(result.getInt("NUMBER"));
						doubt.setQuestion(result.getString("QUESTIONS"));
						doubt.setAnswer(result.getString("ANSWERS"));
						
						doubtMap.put(doubt.getNumber(), doubt);
					}
					
					int size = number.length;
					
					if(size == 0)
					{
						return doubtMap;
					}
					Map<Integer, Doubts> specificDoubt = new HashMap<>();
					for(int i=0; i<size; i++)
					{
						Doubts doubt = doubtMap.get(number[i]);
						if(doubt != null)
						{
							specificDoubt.put(doubt.getNumber(), doubt);
						}
					}
					return specificDoubt;
				}
			}
		}
		catch (SQLException e)
		{
			throw new UserDefinedException("Problem getting Doubts", e);
		}
	}
	
	public void modifyUserDetails(UserDetails user) throws UserDefinedException
	{
		String query = "UPDATE User_Details SET NAME = ?, EMAIL = ?, PASSWORD = ?, MOBILE = ?, STATUS = ? WHERE EMAIL = ?";
		
		try(Connection connect = getConnection())
		{
			try(PreparedStatement statement = connect.prepareStatement(query))
			{
				statement.setString(1, user.getName());
				statement.setString(2, user.getMail());
				statement.setString(3, user.getPassword());
				statement.setLong(4, user.getMobile());
				statement.setString(5, user.getStatus());
				statement.setString(6, user.getMail());
				
				statement.executeUpdate();
			}
		}
		catch (SQLException e)
		{
			throw new UserDefinedException("Problem in Modifying User Details", e);
		}
	}
	
	public void modifyDoubts(Doubts doubt) throws UserDefinedException
	{
		String query = "UPDATE Doubts SET ANSWERS = ? WHERE NUMBER = ?";
		
		try(Connection connect = getConnection())
		{
			try(PreparedStatement statement = connect.prepareStatement(query))
			{
				statement.setString(1, doubt.getAnswer());
				statement.setInt(2, doubt.getNumber());
				
				statement.executeUpdate();
			}
		}
		catch (SQLException e)
		{
			throw new UserDefinedException("Problem in Modifying Doubts", e);
		}
	}
	
	public void deleteStudyMaterials(int id) throws UserDefinedException
	{
		String query = "DELETE FROM Study_Materials WHERE ID = ?";
		
		try(Connection connect = getConnection())
		{
			try(PreparedStatement statement = connect.prepareStatement(query))
			{
				statement.setInt(1, id);
				statement.executeUpdate();
			}
		}
		catch (SQLException e)
		{
			throw new UserDefinedException("Problem in Deleting Study Material", e);
		}
	}
	
	public void deleteDoubts(int number) throws UserDefinedException
	{
		String query = "DELETE FROM Doubts WHERE NUMBER = ?";
		
		try(Connection connect = getConnection())
		{
			try(PreparedStatement statement = connect.prepareStatement(query))
			{
				statement.setInt(1, number);
				statement.executeUpdate();
			}
		}
		catch (SQLException e)
		{
			throw new UserDefinedException("Problem in Deleting Doubts", e);
		}
	}
}


















