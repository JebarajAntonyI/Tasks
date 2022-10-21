package com.banking.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.banking.interfaces.TableAccessFace;
import com.banking.pojo.Account;
import com.banking.pojo.Customer;
import com.banking.pojo.CustomerRequest;
import com.banking.pojo.Transaction;
import com.banking.pojo.TransactionRequest;
import com.banking.pojo.User;
import com.user.exception.UserDefinedException;

public class TableAccess implements TableAccessFace 
{

	private static Connection getConnection() throws UserDefinedException 
	{
		try 
		{
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/bankingDB";
			String userName = "incubationTask";
			String password = "inc3363@JEBA";
			Class.forName(driver);
			Connection connect = DriverManager.getConnection(url, userName, password);
			return connect;
		} 
		catch (SQLException se) 
		{
			throw new UserDefinedException("Problem in DB Connection", se);
		} 
		catch (Exception e) 
		{
			throw new UserDefinedException(e);
		}
	}

	@Override
	public void addUserDetails(User userPojo) throws UserDefinedException 
	{
		String query = "INSERT INTO User_Information (NAME, MOBILE, EMAIL, PASSWORD, "
				+ "DOB, USER_TYPE) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection connect = getConnection()) 
		{
			try (PreparedStatement statement = connect.prepareStatement(query)) 
			{
				statement.setString(1, userPojo.getName());
				statement.setLong(2, userPojo.getMobile());
				statement.setString(3, userPojo.getEmail());
				statement.setString(4, userPojo.getPassword());
				statement.setString(5, userPojo.getDob());
				statement.setString(6, userPojo.getUserType());
				statement.executeUpdate();
			}
		} 
		catch (SQLException se) 
		{
			throw new UserDefinedException("Can't add User Detail", se);
		}
	}

	public StringBuilder getQuery(StringBuilder sBuilder, String... inputStrings) 
	{
		int size = inputStrings.length;
		for (int i = 0; i < size; i++) 
		{
			sBuilder.append(inputStrings[i] + ", ");
		}
		int index = sBuilder.lastIndexOf(",");
		sBuilder.replace(index, index + 1, "");
		return sBuilder;
	}

	@Override
	public void modifyUserDetails(User userPojo) throws SQLException, UserDefinedException 
	{
		String column;
		String name = userPojo.getName();
		long mobile = userPojo.getMobile();
		String email = userPojo.getEmail();
		String password = userPojo.getPassword();
		String dob = userPojo.getDob();
		String userType = userPojo.getUserType();
		String onlineStatus = userPojo.getOnlineStatus();
		int userId = userPojo.getUserId();
		StringBuilder buildQuery = new StringBuilder();
		buildQuery.append("UPDATE User_Information SET ");
		try (Connection connect = getConnection()) 
		{
			if (name != null) 
			{
				column = "NAME  = '" + name + "'";
				buildQuery = getQuery(buildQuery, column);
			}
			if (mobile != 0) 
			{
				column = "MOBILE = " + mobile;
				buildQuery = getQuery(buildQuery, column);
			}
			if (email != null) 
			{
				column = "EMAIL = '" + email + "'";
				buildQuery = getQuery(buildQuery, column);
			}
			if (password != null) 
			{
				column = "PASSWORD = '" + password + "'";
				buildQuery = getQuery(buildQuery, column);
			}
			if (dob != null) 
			{
				column = "DOB = '" + dob + "'";
				buildQuery = getQuery(buildQuery, column);
			}
			if (userType != null) 
			{
				column = "USER_TYPE = '" + userType + "'";
				buildQuery = getQuery(buildQuery, column);
			}
			if (onlineStatus != null) 
			{
				column = "ONLINE_STATUS = '" + onlineStatus + "'";
				buildQuery = getQuery(buildQuery, column);
			}
			String query = "" + buildQuery.append(" WHERE USER_ID = ?;");
			try (PreparedStatement statement = connect.prepareStatement(query)) 
			{
				statement.setInt(1, userId);
				statement.executeUpdate();
			}
		}
	}

//	@Override
//	public void addCustomerDetails(Customer customerPojo) throws UserDefinedException 
//	{
//		String query = "INSERT INTO Customer_Details (CUSTOMER_ID, AADHAR_NO, PAN_NO, ADDRESS) VALUES (?, ?, ?, ?)";
//		try (Connection connect = getConnection()) 
//		{
//			try (PreparedStatement statement = connect.prepareStatement(query)) 
//			{
//				statement.setInt(1, customerPojo.getCustomerId());
//				statement.setLong(2, customerPojo.getAadhar());
//				statement.setString(3, customerPojo.getPan());
//				statement.setString(4, customerPojo.getAddress());
//				statement.executeUpdate();
//			}
//		} 
//		catch (SQLException se) 
//		{
//			throw new UserDefinedException("Can't add Customer Detail", se);
//		}
//	}
	
	@Override
	public void addCustomerDetails(Customer customerPojo) throws UserDefinedException 
	{
		String query = "BEGIN;" + "\nINSERT INTO User_Information (NAME, MOBILE, "
				+ "EMAIL, PASSWORD, DOB, USER_TYPE) VALUES (?, ?, ?, ?, ?, ?);"
				+ "\nINSERT INTO Customer_Details (CUSTOMER_ID, AADHAR_NO, PAN_NO, "
				+ "ADDRESS) VALUES (LAST_INSERT_ID(), ?, ?, ?);" + "\nCOMMIT;";
		try (Connection connect = getConnection()) 
		{
			try (PreparedStatement statement = connect.prepareStatement(query)) 
			{
				statement.setString(1, customerPojo.getName());
				statement.setLong(2, customerPojo.getMobile());
				statement.setString(3, customerPojo.getEmail());
				statement.setString(4, customerPojo.getPassword());
				statement.setString(5, customerPojo.getDob());
				statement.setString(6, customerPojo.getUserType());
				statement.setLong(7, customerPojo.getAadhar());
				statement.setString(8, customerPojo.getPan());
				statement.setString(9, customerPojo.getAddress());
				statement.executeUpdate();
			}
		} 
		catch (SQLException se) 
		{
			throw new UserDefinedException("Syntax Error in adding User Customer Detail", se);
		}
	}
	
	@Override
	public void modifyCustomerDetails(Customer customerPojo) throws SQLException, UserDefinedException
	{
		String column;
		String name = customerPojo.getName();
		long mobile = customerPojo.getMobile();
		String email = customerPojo.getEmail();
		String password = customerPojo.getPassword();
		String dob = customerPojo.getDob();
		String userType = customerPojo.getUserType();
		String onlineStatus = customerPojo.getOnlineStatus();
		int customerId = customerPojo.getCustomerId();
		long aadhar = customerPojo.getAadhar();
		String pan = customerPojo.getPan();
		String address = customerPojo.getAddress();
		String customerState = customerPojo.getCustomerStatus();
		StringBuilder buildQuery = new StringBuilder();
		buildQuery.append("UPDATE User_Information SET ");
		try (Connection connect = getConnection()) 
		{
			if (name != null) 
			{
				column = "NAME  = '" + name + "'";
				buildQuery = getQuery(buildQuery, column);
			}
			if (mobile != 0) 
			{
				column = "MOBILE = " + mobile;
				buildQuery = getQuery(buildQuery, column);
			}
			if (email != null) 
			{
				column = "EMAIL = '" + email + "'";
				buildQuery = getQuery(buildQuery, column);
			}
			if (password != null) 
			{
				column = "PASSWORD = '" + password + "'";
				buildQuery = getQuery(buildQuery, column);
			}
			if (dob != null) 
			{
				column = "DOB = '" + dob + "'";
				buildQuery = getQuery(buildQuery, column);
			}
			if (userType != null) 
			{
				column = "USER_TYPE = '" + userType + "'";
				buildQuery = getQuery(buildQuery, column);
			}
			if (onlineStatus != null) 
			{
				column = "ONLINE_STATUS = '" + onlineStatus + "'";
				buildQuery = getQuery(buildQuery, column);
			}
			String query = "" + buildQuery.append(" WHERE USER_ID = ?;");
			try (PreparedStatement statement = connect.prepareStatement(query)) 
			{
				statement.setInt(1, customerId);
				statement.executeUpdate();
			}
//			Customer Details Update
			buildQuery = new StringBuilder();
			buildQuery.append("UPDATE User_Information SET ");
			if (aadhar != 0) 
			{
				column = "AADHAR_NO = '" + aadhar + "'";
				buildQuery = getQuery(buildQuery, column);
			}
			if (pan != null) 
			{
				column = "PAN_NO = '" + pan + "'";
				buildQuery = getQuery(buildQuery, column);
			}
			if (address != null) 
			{
				column = "ADDRESS = '" + address + "'";
				buildQuery = getQuery(buildQuery, column);
			}
			if (customerState != null) 
			{
				column = "CUSTOMER_STATE = '" + customerState + "'";
				buildQuery = getQuery(buildQuery, column);
			}
			String query2 = "" + buildQuery.append(" WHERE CUSTOMER_ID = ?;");
			try (PreparedStatement statement = connect.prepareStatement(query2)) 
			{
				statement.setInt(1, customerId);
				statement.executeUpdate();
			}
		}
	}


//	@Override
//	public void addUserCustomerDetails(Customer customerPojo) throws UserDefinedException 
//	{
//		String query = "BEGIN;" + "\nINSERT INTO User_Information (NAME, MOBILE, "
//				+ "EMAIL, PASSWORD, DOB, USER_TYPE) VALUES (?, ?, ?, ?, ?, ?);"
//				+ "\nINSERT INTO Customer_Details (CUSTOMER_ID, AADHAR_NO, PAN_NO, "
//				+ "ADDRESS) VALUES (LAST_INSERT_ID(), ?, ?, ?);" + "\nCOMMIT;";
//		try (Connection connect = getConnection()) 
//		{
//			try (PreparedStatement statement = connect.prepareStatement(query)) 
//			{
//				statement.setString(1, customerPojo.getName());
//				statement.setLong(2, customerPojo.getMobile());
//				statement.setString(3, customerPojo.getEmail());
//				statement.setString(4, customerPojo.getPassword());
//				statement.setString(5, customerPojo.getDob());
//				statement.setString(6, customerPojo.getUserType());
//				statement.setLong(7, customerPojo.getAadhar());
//				statement.setString(8, customerPojo.getPan());
//				statement.setString(9, customerPojo.getAddress());
//				statement.executeUpdate();
//			}
//		} 
//		catch (SQLException se) 
//		{
//			throw new UserDefinedException("Syntax Error in adding User Customer Detail", se);
//		}
//	}

	@Override
	public void modifyAccountDetails(Account accountPojo) throws SQLException, UserDefinedException 
	{
		StringBuilder buildQuery = new StringBuilder();
		String column;
		buildQuery = buildQuery.append("UPDATE Account_Details SET ");
		int customerId = accountPojo.getCustomerId();
		long accountNo = accountPojo.getAccountNo();
		String branch = accountPojo.getAccountBranch();
		String accountType = accountPojo.getAccountType();
		String ifsc = accountPojo.getIfsc();
		double balance = accountPojo.getBalance();
		String status = accountPojo.getAccountStatus();
		if (customerId != 0) 
		{
			column = "CUSTOMER_ID = " + customerId;
			getQuery(buildQuery, column);
		}
		if (accountNo != 0) 
		{
			column = "ACCOUNT_NO = " + accountNo;
			getQuery(buildQuery, column);
		}
		if (branch != null) 
		{
			column = "ACCOUNT_BRANCH = '" + branch + "'";
			getQuery(buildQuery, column);
		}
		if (accountType != null) 
		{
			column = "ACCOUNT_TYPE = '" + accountType + "'";
			getQuery(buildQuery, column);
		}
		if (ifsc != null) 
		{
			column = "IFSC = '" + ifsc + "'";
			getQuery(buildQuery, column);
		}
		if (balance != 0) 
		{
			column = "BALANCE = " + balance;
			getQuery(buildQuery, column);
		}
		if (status != null) 
		{
			column = "ACCOUNT_STATUS = '" + status + "'";
			getQuery(buildQuery, column);
		}
		String query = "" + buildQuery.append(" WHERE ACCOUNT_NO = ?;");
		try (Connection connect = getConnection()) 
		{
			try (PreparedStatement statement = connect.prepareStatement(query)) 
			{
				statement.setLong(1, accountNo);
				statement.executeUpdate();
			}
		}
	}

	@Override
	public void addAccountDetails(Account accountPojo) throws UserDefinedException 
	{
		String query = "INSERT INTO Account_Details (CUSTOMER_ID, ACCOUNT_NO, ACCOUNT_TYPE, "
				+ "ACCOUNT_BRANCH, IFSC, BALANCE) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection connect = getConnection()) 
		{
			try (PreparedStatement statement = connect.prepareStatement(query)) {
				statement.setInt(1, accountPojo.getCustomerId());
				statement.setLong(2, accountPojo.getAccountNo());
				statement.setString(3, accountPojo.getAccountType());
				statement.setString(4, accountPojo.getAccountBranch());
				statement.setString(5, accountPojo.getIfsc());
				statement.setDouble(6, accountPojo.getBalance());
				statement.executeUpdate();
			}
		} 
		catch (SQLException se) 
		{
			throw new UserDefinedException("Account Details was not Inserted Properly", se);
		}
	}

	@Override
	public void addTransactionDetails(Transaction transactionPojo) throws UserDefinedException 
	{
		String query = "INSERT INTO Transaction_Details (CUSTOMER_ID, "
				+ "TRANSACTION_TIME, MODE_OF_TRANSACTION, PRIMARY_ACCOUNT, "
				+ "SECONDARY_ACCOUNT, TRANSACTION_TYPE, AMOUNT, CLOSING_BALANCE, "
				+ "TRANSACTION_STATUS) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection connect = getConnection()) {
			try (PreparedStatement statement = connect.prepareStatement(query)) 
			{
				statement.setInt(1, transactionPojo.getCustomerId());
				statement.setLong(2, transactionPojo.getTransactionTime());
				statement.setString(3, transactionPojo.getModeOfTransaction());
				statement.setLong(4, transactionPojo.getPrimaryAccount());
				statement.setLong(5, transactionPojo.getSecondaryAccount());
				statement.setString(6, transactionPojo.getTransactionType());
				statement.setDouble(7, transactionPojo.getAmount());
				statement.setDouble(8, transactionPojo.getClosingBalance());
				statement.setString(9, transactionPojo.getTransactionStatus());
				statement.executeUpdate();
			}
		} 
		catch (SQLException se) 
		{
			throw new UserDefinedException("Transaction Details was not Inserted Properly", se);
		}
	}

	@Override
	public void addTransactionRequest(TransactionRequest transactionRequestPojo) throws UserDefinedException 
	{
		String query = "INSERT INTO Transaction_Request (CUSTOMER_ID, "
				+ "ACCOUNT_NO, REQUEST_FOR, REQUEST_TIME, VERIFIED_TIME, "
				+ "STATUS, AMOUNT) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (Connection connect = getConnection()) 
		{
			try (PreparedStatement statement = connect.prepareStatement(query)) 
			{
				statement.setInt(1, transactionRequestPojo.getCustomerId());
				statement.setLong(2, transactionRequestPojo.getAccountNo());
				statement.setString(3, transactionRequestPojo.getRequestFor());
				statement.setLong(4, transactionRequestPojo.getRequestTime());
				statement.setLong(5, transactionRequestPojo.getVerifiedTime());
				statement.setString(6, transactionRequestPojo.getStatus());
				statement.setDouble(7, transactionRequestPojo.getAmount());
				statement.executeUpdate();
			}
		} 
		catch (SQLException se) 
		{
			throw new UserDefinedException("Transaction Request was not Inserted Properly", se);
		}
	}

	@Override
	public void modifyTransactionRequest(TransactionRequest transactionRequest) throws UserDefinedException 
	{
		StringBuilder buildQuery = new StringBuilder();
		String column;
		int customerId = transactionRequest.getCustomerId();
		long accountNo = transactionRequest.getAccountNo();
		String reqFor = transactionRequest.getRequestFor();
		long reqTime = transactionRequest.getRequestTime();
		long verTime = transactionRequest.getVerifiedTime();
		String status = transactionRequest.getStatus();
		double amount = transactionRequest.getAmount();
		int reqNo = transactionRequest.getRequestNumber();
		buildQuery = buildQuery.append("UPDATE Transaction_Request SET ");
		if (customerId != 0) 
		{
			column = "CUSTOMER_ID = " + customerId;
			getQuery(buildQuery, column);
		}
		if (accountNo != 0) 
		{
			column = "ACCOUNT_NO = " + accountNo;
			getQuery(buildQuery, column);
		}
		if (reqFor != null) 
		{
			column = "REQUEST_FOR = '" + reqFor + "'";
			getQuery(buildQuery, column);
		}
		if (reqTime != 0) 
		{
			column = "REQUEST_TIME = " + reqTime;
			;
			getQuery(buildQuery, column);
		}
		if (verTime != 0) 
		{
			column = "VERIFIED_TIME = " + verTime;
			getQuery(buildQuery, column);
		}
		if (status != null) 
		{
			column = "STATUS = '" + status + "'";
			getQuery(buildQuery, column);
		}
		if (amount != 0) 
		{
			column = "AMOUNT = " + amount;
			getQuery(buildQuery, column);
		}
		String query = "" + buildQuery.append(" WHERE REQUEST_NO = ?;");
		try (Connection connect = getConnection()) 
		{
			try (PreparedStatement statement = connect.prepareStatement(query)) 
			{
				statement.setInt(1, reqNo);
				statement.executeUpdate();
			}
		} 
		catch (SQLException se) 
		{
			throw new UserDefinedException(se);
		}
	}

	@Override
	public Map<Long, TransactionRequest> getAllTransactionRequestStatus(String status) throws UserDefinedException 
	{
		String query = "SELECT * FROM Transaction_Request WHERE STATUS = ?";
		Map<Long, TransactionRequest> statusMap = new HashMap<Long, TransactionRequest>();
		try (Connection connect = getConnection()) 
		{
			try (PreparedStatement statement = connect.prepareStatement(query)) 
			{
				statement.setString(1, status);
				try (ResultSet result = statement.executeQuery()) 
				{
					while (result.next()) 
					{
						TransactionRequest statusPojo = new TransactionRequest();
						statusPojo.setRequestNumber(result.getInt("REQUEST_NO"));
						statusPojo.setCustomerId(result.getInt("CUSTOMER_ID"));
						statusPojo.setAccountNo(result.getLong("ACCOUNT_NO"));
						statusPojo.setRequestFor(result.getString("REQUEST_FOR"));
						statusPojo.setRequestTime(result.getLong("REQUEST_TIME"));
						statusPojo.setVerifiedTime(result.getLong("VERIFIED_TIME"));
						statusPojo.setStatus(result.getString("STATUS"));
						statusPojo.setAmount(result.getDouble("AMOUNT"));
						statusMap.put(statusPojo.getAccountNo(), statusPojo);
					}
				}
			}
		} 
		catch (SQLException se) 
		{
			throw new UserDefinedException("No Such Status Available", se);
		}
		return statusMap;
	}

	@Override
	public TransactionRequest getTransactionRequestStatus(String status, int reqNo) throws UserDefinedException 
	{
		String query = "SELECT * FROM Transaction_Request WHERE STATUS = ? AND REQUEST_NO = ?";
		TransactionRequest statusPojo = new TransactionRequest();
		try (Connection connect = getConnection()) 
		{
			try (PreparedStatement statement = connect.prepareStatement(query)) 
			{
				statement.setString(1, status);
				statement.setInt(2, reqNo);
				try (ResultSet result = statement.executeQuery()) 
				{
				result.next();
				statusPojo.setCustomerId(result.getInt("CUSTOMER_ID"));
				statusPojo.setAccountNo(result.getLong("ACCOUNT_NO"));
				statusPojo.setRequestFor(result.getString("REQUEST_FOR"));
				statusPojo.setRequestTime(result.getLong("REQUEST_TIME"));
				statusPojo.setVerifiedTime(result.getLong("VERIFIED_TIME"));
				statusPojo.setStatus(result.getString("STATUS"));
				statusPojo.setAmount(result.getDouble("AMOUNT"));
				}
			}
		} 
		catch (SQLException se) 
		{
			throw new UserDefinedException("No Such Status Available", se);
		}
		return statusPojo;
	}

//	@Override
//	public int getUserId(int id) throws UserDefinedException 
//	{
//		String query = "SELECT USER_ID FROM User_Information WHERE USER_ID = ?";
//		try (Connection connect = getConnection()) 
//		{
//			try (PreparedStatement statement = connect.prepareStatement(query)) 
//			{
//				statement.setLong(1, id);
//				try (ResultSet result = statement.executeQuery()) 
//				{
//					result.next();
//					return result.getInt("USER_ID");
//				}
//			}
//		} 
//		catch (SQLException se) 
//		{
//			throw new UserDefinedException("The User ID does not exist", se);
//		}
//	}

//	@Override
//	public int getUserIdViaAccount(long accountNo) throws UserDefinedException 
//	{
//		String query = "SELECT CUSTOMER_ID FROM Account_Details WHERE ACCOUNT_NO = ?";
//		try (Connection connect = getConnection()) 
//		{
//			try (PreparedStatement statement = connect.prepareStatement(query)) 
//			{
//				statement.setLong(1, accountNo);
//				try (ResultSet result = statement.executeQuery()) 
//				{
//					result.next();
//					return result.getInt("CUSTOMER_ID");
//				}
//			}
//		} 
//		catch (SQLException se) 
//		{
//			throw new UserDefinedException("The User ID does not exist", se);
//		}
//	}

	@Override
	public User getUserInfo(int id) throws UserDefinedException 
	{
		String query = "SELECT * FROM User_Information WHERE USER_ID = ?";
		try (Connection connect = getConnection()) 
		{
			try (PreparedStatement statement = connect.prepareStatement(query)) 
			{
				statement.setInt(1, id);
				try (ResultSet result = statement.executeQuery()) 
				{
					result.next();
					User userPojo = new User();
					userPojo.setUserId(result.getInt("USER_ID"));
					userPojo.setName(result.getString("NAME"));
					userPojo.setMobile(result.getLong("MOBILE"));
					userPojo.setEmail(result.getString("EMAIL"));
					userPojo.setPassword(result.getString("PASSWORD"));
					userPojo.setDob(result.getString("DOB"));
					userPojo.setUserType(result.getString("USER_TYPE"));
					userPojo.setOnlineStatus(result.getString("ONLINE_STATUS"));
					return userPojo;
				}
			}
		}
		catch (SQLException se) 
		{
			throw new UserDefinedException("No Such Column Available in User Information Table", se);
		}
	}

	@Override
	public Customer getCustomerInfo(int id) throws UserDefinedException 
	{
		String query = "SELECT * FROM Customer_Details WHERE CUSTOMER_ID = ?";
		try (Connection connect = getConnection()) 
		{
			try (PreparedStatement statement = connect.prepareStatement(query)) 
			{
				try (ResultSet result = statement.executeQuery()) 
				{
					result.next();
					Customer customerPojo = new Customer();
					customerPojo.setCustomerId(result.getInt("CUSTOMER_ID"));
					customerPojo.setAadhar(result.getLong("AADHAR_NO"));
					customerPojo.setPan(result.getString("PAN_NO"));
					customerPojo.setAddress(result.getString("ADDRESS"));
					customerPojo.setUserId(result.getInt("USER_ID"));
					customerPojo.setName(result.getString("NAME"));
					customerPojo.setMobile(result.getLong("MOBILE"));
					customerPojo.setEmail(result.getString("EMAIL"));
					customerPojo.setDob(result.getString("DOB"));
					customerPojo.setUserType(result.getString("USER_TYPE"));
					customerPojo.setCustomerStatus(result.getString("CUSTOMER_STATE"));
					customerPojo.setOnlineStatus(result.getString("ONLINE_STATUS"));
					return customerPojo;
					}
			}
		} 
		catch (SQLException se) 
		{
			throw new UserDefinedException("No Such Column Available in Customer Details", se);
		}
	}

	@Override
	public Account getAccountInfo(long accountNo) throws UserDefinedException 
	{
		String query = "SELECT * FROM Account_Details WHERE ACCOUNT_NO = ?";
		try (Connection connect = getConnection()) 
		{
			try (PreparedStatement statement = connect.prepareStatement(query)) 
			{
				statement.setLong(1, accountNo);
				try (ResultSet result = statement.executeQuery()) 
				{
					result.next();
					Account accountPojo = new Account();
					accountPojo.setCustomerId(result.getInt("CUSTOMER_ID"));
					accountPojo.setAccountNo(result.getLong("ACCOUNT_NO"));
					accountPojo.setAccountType(result.getString("ACCOUNT_TYPE"));
					accountPojo.setAccountBranch(result.getString("ACCOUNT_BRANCH"));
					accountPojo.setIfsc(result.getString("IFSC"));
					accountPojo.setBalance(result.getDouble("BALANCE"));
					accountPojo.setAccountStatus(result.getString("ACCOUNT_STATUS"));
					accountPojo.setOnlineStatus(result.getString("ONLINE_STATUS"));
					return accountPojo;
					}
			}
		} 
		catch (SQLException se) 
		{
			throw new UserDefinedException("No Such Column Available in Customer Details", se);
		}
	}

	@Override
	public Map<Integer, User> getAllUserMap() throws SQLException, UserDefinedException 
	{
		String query = "SELECT * FROM User_Information ORDER BY USER_ID";
		Map<Integer, User> userMap = new HashMap<>();
		try (Connection connect = getConnection()) 
		{
			try (PreparedStatement statement = connect.prepareStatement(query)) 
			{
				try (ResultSet result = statement.executeQuery()) 
				{
					while (result.next()) 
					{
						User userPojo = new User();
						userPojo.setUserId(result.getInt("USER_ID"));
						userPojo.setName(result.getString("NAME"));
						userPojo.setMobile(result.getLong("MOBILE"));
						userPojo.setEmail(result.getString("EMAIL"));
						userPojo.setPassword(result.getString("PASSWORD"));
						userPojo.setDob(result.getString("DOB"));
						userPojo.setUserType(result.getString("USER_TYPE"));
						userPojo.setOnlineStatus(result.getString("ONLINE_STATUS"));
						userMap.put(userPojo.getUserId(), userPojo);
					}
				}
			} 
			catch (SQLException se) 
			{
				throw new UserDefinedException("No Such Column Available in User Information", se);
			}
			return userMap;
		}

	}

	@Override
	public Map<Integer, Map<Long, Account>> getAllAccountDetails(Integer... userId) throws SQLException, UserDefinedException 
	{
		String query = "SELECT * FROM Account_Details ORDER BY CUSTOMER_ID";
		Map<Long, Account> innerMap;
		Map<Integer, Map<Long, Account>> accountMap = new HashMap<Integer, Map<Long, Account>>();
		try (Connection connect = getConnection()) 
		{
			try (PreparedStatement statement = connect.prepareStatement(query)) 
			{
				try (ResultSet result = statement.executeQuery()) 
				{
					while (result.next()) 
					{
						Account accountPojo = new Account();

						accountPojo.setCustomerId(result.getInt("CUSTOMER_ID"));
						accountPojo.setAccountNo(result.getLong("ACCOUNT_NO"));
						accountPojo.setAccountType(result.getString("ACCOUNT_TYPE"));
						accountPojo.setAccountBranch(result.getString("ACCOUNT_BRANCH"));
						accountPojo.setIfsc(result.getString("IFSC"));
						accountPojo.setBalance(result.getDouble("BALANCE"));
						accountPojo.setAccountStatus(result.getString("ACCOUNT_STATUS"));
						accountPojo.setOnlineStatus(result.getString("ONLINE_STATUS"));
						int customerId = accountPojo.getCustomerId();
						long accountNo = accountPojo.getAccountNo();
						if (accountMap.get(customerId) == null) {
							innerMap = new HashMap<>();
						} 
						else 
						{
							innerMap = accountMap.get(accountPojo.getCustomerId());
						}
						innerMap.put(accountNo, accountPojo);
						accountMap.put(customerId, innerMap);
					}
				}
			} 
			catch (SQLException se) 
			{
				throw new UserDefinedException("No Such Column Available in Account Details", se);
			}
		}
		if (userId == null)
		{
			return accountMap;
		}
		Map<Integer, Map<Long, Account>> userAccountMap = new HashMap<Integer, Map<Long, Account>>();
		int size = userId.length;
		for (int i=0; i<size; i++)
		{
			userAccountMap.put(userId[i], accountMap.get(userId[i]));
		}
		return userAccountMap;
	}

	@Override
	public Map<Long, Account> getAccountDetails(long accountNo) throws SQLException, UserDefinedException 
	{
		String query = "SELECT * FROM Account_Details WHERE ACCOUNT_NO = ?";
		Map<Long, Account> accountMap = new HashMap<Long, Account>();
		try (Connection connect = getConnection()) 
		{
			try (PreparedStatement statement = connect.prepareStatement(query)) 
			{
				statement.setLong(1, accountNo);
				try (ResultSet result = statement.executeQuery()) 
				{
					while (result.next()) 
					{
						Account accountPojo = new Account();
						accountPojo.setCustomerId(result.getInt("CUSTOMER_ID"));
						accountPojo.setAccountNo(result.getLong("ACCOUNT_NO"));
						accountPojo.setAccountType(result.getString("ACCOUNT_TYPE"));
						accountPojo.setAccountBranch(result.getString("ACCOUNT_BRANCH"));
						accountPojo.setIfsc(result.getString("IFSC"));
						accountPojo.setBalance(result.getDouble("BALANCE"));
						accountPojo.setAccountStatus(result.getString("ACCOUNT_STATUS"));
						accountPojo.setOnlineStatus(result.getString("ONLINE_STATUS"));
						accountMap.put(accountPojo.getAccountNo(), accountPojo);
					}
				}
			} 
			catch (SQLException se) 
			{
				throw new UserDefinedException("No Such Column Available in Account Details", se);
			}
			return accountMap;
		}

	}

	@Override
	public Map<Long, Account> getSpecificUserAccount(int userId) throws UserDefinedException 
	{
		String query = "SELECT * FROM Account_Details WHERE CUSTOMER_ID = ?";
		Map<Long, Account> accountMap = new HashMap<>();
		try (Connection connect = getConnection()) {
			try (PreparedStatement statement = connect.prepareStatement(query)) 
			{
				statement.setInt(1, userId);
				try (ResultSet result = statement.executeQuery()) 
				{
					while (result.next()) 
					{
						Account accountPojo = new Account();
						accountPojo.setCustomerId(result.getInt("CUSTOMER_ID"));
						accountPojo.setAccountNo(result.getLong("ACCOUNT_NO"));
						accountPojo.setAccountType(result.getString("ACCOUNT_TYPE"));
						accountPojo.setAccountBranch(result.getString("ACCOUNT_BRANCH"));
						accountPojo.setIfsc(result.getString("IFSC"));
						accountPojo.setBalance(result.getDouble("BALANCE"));
						accountPojo.setAccountStatus(result.getString("ACCOUNT_STATUS"));
						accountPojo.setOnlineStatus(result.getString("ONLINE_STATUS"));
						accountMap.put(accountPojo.getAccountNo(), accountPojo);
					}
				}
			}
		} 
		catch (SQLException se) 
		{
			throw new UserDefinedException("No Such Column Available in Account Details", se);
		}
		return accountMap;
	}

	@Override
	public Map<Long, Map<Integer, Transaction>> getAllTransactionDetailsMap(int customerId) throws SQLException, UserDefinedException 
	{
		String query = "SELECT * FROM Transaction_Details WHERE CUSTOMER_ID = ?";
		Map<Long, Map<Integer, Transaction>> transactionMap = new HashMap<Long, Map<Integer, Transaction>>();
		try (Connection connect = getConnection()) 
		{
			try (PreparedStatement statement = connect.prepareStatement(query)) 
			{
				statement.setInt(1, customerId);
				try (ResultSet result = statement.executeQuery()) 
				{
					Map<Integer, Transaction> innerMap = new HashMap<>();
					while (result.next()) 
					{
						Transaction transactionPojo = new Transaction();
						transactionPojo.setCustomerId(result.getInt("CUSTOMER_ID"));
						transactionPojo.setTransactionId(result.getInt("TRANSACTION_ID"));
						transactionPojo.setTransactionTime(result.getLong("TRANSACTION_TIME"));
						transactionPojo.setModeOfTransaction(result.getString("MODE_OF_TRANSACTION"));
						transactionPojo.setPrimaryAccount(result.getLong("PRIMARY_ACCOUNT"));
						transactionPojo.setSecondaryAccount(result.getLong("SECONDARY_ACCOUNT"));
						transactionPojo.setTransactionType(result.getString("TRANSACTION_TYPE"));
						transactionPojo.setAmount(result.getDouble("AMOUNT"));
						transactionPojo.setClosingBalance(result.getDouble("CLOSING_BALANCE"));
						transactionPojo.setTransactionStatus(result.getString("TRANSACTION_STATUS"));
						int transactionId = transactionPojo.getTransactionId();
						long accountNo = transactionPojo.getPrimaryAccount();
						if (transactionMap.get(accountNo) == null) 
						{
							innerMap = new HashMap<>();
						}
						else 
						{
							innerMap = transactionMap.get(accountNo);
						}
						innerMap.put(transactionId, transactionPojo);
						transactionMap.put(accountNo, innerMap);
					}
				}
			} 
			catch (SQLException se) 
			{
				throw new UserDefinedException("No Such Column Available in Transaction Details", se);
			}
			return transactionMap;
		}
	}

	@Override
	public List<Transaction> getTransactionDetails(long accountNo) throws SQLException, UserDefinedException 
	{
		String query = "SELECT * FROM Transaction_Details WHERE PRIMARY_ACCOUNT = ? ORDER BY TRANSACTION_ID DESC LIMIT 18";
		List<Transaction> transactionList = new ArrayList<>();
		try (Connection connect = getConnection()) 
		{
			try (PreparedStatement statement = connect.prepareStatement(query)) 
			{
				statement.setLong(1, accountNo);
				try (ResultSet result = statement.executeQuery()) 
				{
					while (result.next()) 
					{
						Transaction transactionPojo = new Transaction();
						transactionPojo.setCustomerId(result.getInt("CUSTOMER_ID"));
						transactionPojo.setTransactionId(result.getInt("TRANSACTION_ID"));
						transactionPojo.setTransactionTime(result.getLong("TRANSACTION_TIME"));
						transactionPojo.setModeOfTransaction(result.getString("MODE_OF_TRANSACTION"));
						transactionPojo.setPrimaryAccount(result.getLong("PRIMARY_ACCOUNT"));
						transactionPojo.setSecondaryAccount(result.getLong("SECONDARY_ACCOUNT"));
						transactionPojo.setTransactionType(result.getString("TRANSACTION_TYPE"));
						transactionPojo.setAmount(result.getDouble("AMOUNT"));
						transactionPojo.setClosingBalance(result.getDouble("CLOSING_BALANCE"));
						transactionPojo.setTransactionStatus(result.getString("TRANSACTION_STATUS"));
						transactionList.add(transactionPojo);
					}
				}
			} 
			catch (SQLException se) 
			{
				throw new UserDefinedException("No Such Column Available in Transaction Details", se);
			}
			return transactionList;
		}
	}

	@Override
	public Map<Integer, Customer> getCustomerDetails() throws UserDefinedException, SQLException 
	{
		String query = "SELECT * FROM User_Information, Customer_Details WHERE User_Information.USER_ID = Customer_Details.CUSTOMER_ID";
		Map<Integer, Customer> customerMap = new HashMap<>();
		try (Connection connect = getConnection()) 
		{
			try (PreparedStatement statement = connect.prepareStatement(query)) 
			{
				try (ResultSet result = statement.executeQuery()) 
				{
					while (result.next()) 
					{
						Customer customerPojo = new Customer();
						customerPojo.setCustomerId(result.getInt("CUSTOMER_ID"));
						customerPojo.setAadhar(result.getLong("AADHAR_NO"));
						customerPojo.setPan(result.getString("PAN_NO"));
						customerPojo.setAddress(result.getString("ADDRESS"));
						customerPojo.setUserId(result.getInt("USER_ID"));
						customerPojo.setName(result.getString("NAME"));
						customerPojo.setMobile(result.getLong("MOBILE"));
						customerPojo.setEmail(result.getString("EMAIL"));
						customerPojo.setDob(result.getString("DOB"));
						customerPojo.setUserType(result.getString("USER_TYPE"));
						customerPojo.setCustomerStatus(result.getString("CUSTOMER_STATE"));
						customerPojo.setOnlineStatus(result.getString("ONLINE_STATUS"));
						customerMap.put(customerPojo.getCustomerId(), customerPojo);
					}
				}
			} 
			catch (SQLException se) 
			{
				throw new UserDefinedException("No Such Column Available in User Information & Customer Details", se);
			}
			return customerMap;
		}
	}

	@Override
	public void addCustomerRequest(CustomerRequest customerRequestPojo) throws UserDefinedException 
	{
		String query = "INSERT INTO Customer_Request (CUSTOMER_ID, ACCOUNT_NO, REQUEST_MESSAGE) VALUES (?, ?, ?)";
		try (Connection connect = getConnection()) 
		{
			try (PreparedStatement statement = connect.prepareStatement(query)) {
				statement.setInt(1, customerRequestPojo.getCustomerId());
				statement.setLong(2, customerRequestPojo.getAccountNo());
				statement.setString(3, customerRequestPojo.getRequestMessage());
				statement.executeUpdate();
			}
		} 
		catch (SQLException se) 
		{
			throw new UserDefinedException("Can't able to add values in Customer Request Table", se);
		}
	}

	@Override
	public void modifyCustomerRequest(int reqNo, String status) throws UserDefinedException 
	{
		String query = "UPDATE Customer_Request SET REQUEST_STATUS = ? WHERE REQUEST_NO = ?;";
		try (Connection connect = getConnection()) 
		{
			try (PreparedStatement statement = connect.prepareStatement(query)) 
			{
				statement.setString(1, status);
				statement.setLong(2, reqNo);
				statement.executeUpdate();
			}
		}
		catch (SQLException se) 
		{
			throw new UserDefinedException("No such Request Number Available", se);
		}
	}

	@Override
	public Map<Integer, CustomerRequest> getRequestMessages(String reqStatus) throws SQLException, UserDefinedException 
	{
		String query = "SELECT * FROM Customer_Request WHERE REQUEST_STATUS = ?";
		Map<Integer, CustomerRequest> reqMessageMap = new HashMap<>();
		try (Connection connect = getConnection()) 
		{
			try (PreparedStatement statement = connect.prepareStatement(query)) 
			{
				statement.setString(1, reqStatus);
				try (ResultSet result = statement.executeQuery()) 
				{
					while (result.next()) 
					{
						CustomerRequest reqMessagePojo = new CustomerRequest();
						reqMessagePojo.setRequestNo(result.getInt("REQUEST_NO"));
						reqMessagePojo.setCustomerId(result.getInt("CUSTOMER_ID"));
						reqMessagePojo.setAccountNo(result.getLong("ACCOUNT_NO"));
						reqMessagePojo.setRequestMessage(result.getString("REQUEST_MESSAGE"));
						reqMessagePojo.setRequestStatus(result.getString("REQUEST_STATUS"));
						reqMessageMap.put(reqMessagePojo.getRequestNo(), reqMessagePojo);
					}
				}
			} 
			catch (SQLException se) 
			{
				throw new UserDefinedException("No Such Status Available", se);
			}
			return reqMessageMap;
		}
	}
}
