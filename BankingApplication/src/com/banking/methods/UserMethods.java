package com.banking.methods;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.banking.db.TableAccess;
import com.banking.pojo.Account;
import com.banking.pojo.User;
import com.user.exception.InputValidityCheck;
import com.user.exception.UserDefinedException;

public class UserMethods {

	private TableAccess tableAccessObj = new TableAccess();

	public Account viewAccount(int userId, long accountNo) throws SQLException, UserDefinedException 
	{
		Map<Integer, Map<Long, Account>> accountMap = new HashMap<Integer, Map<Long, Account>>();
		accountMap = tableAccessObj.getAllAccountDetails();
		Map<Long, Account> innerMap = accountMap.get(userId);
		if (innerMap == null) 
		{
			throw new UserDefinedException("The UserId is Not Available");
		}
		Account accountPojo = innerMap.get(accountNo);
		if (accountPojo == null) 
		{
			throw new UserDefinedException("The Account Number is Not Available");
		}
		return accountPojo;
	}

	public double checkBalance(int userId, long accountNo) throws SQLException, UserDefinedException 
	{
		Account balancePojo = viewAccount(userId, accountNo);
		if (balancePojo == null) 
		{
			throw new UserDefinedException("The UserId and Account Number is Matched");
		}
		return balancePojo.getBalance();
	}

	public double checkBalance(long accountNo) throws SQLException, UserDefinedException 
	{
		Account accountPojo = viewAccount(accountNo);
		if (accountPojo == null) 
		{
			throw new UserDefinedException("The Account Number is Not Available");
		}
		return accountPojo.getBalance();
	}

	public User userInfo(int userId) throws SQLException, UserDefinedException 
	{
		Map<Integer, User> userMap = new HashMap<>();
		userMap = tableAccessObj.getAllUserMap();
		User userPojo = new User();
		userPojo = userMap.get(userId);
		if (userPojo == null) 
		{
			throw new UserDefinedException("The UserId is Not Available");
		}
		return userPojo;
	}

	public void changePassword(int userId, String oldPassword, String newPassword) throws SQLException, UserDefinedException 
	{
		User userPojo = userInfo(userId);
		InputValidityCheck.checkNull(userPojo);
		String checkPassword = userPojo.getPassword();
		System.out.println(checkPassword);
		if (oldPassword.equals(checkPassword)) {
			User changePojo = new User();
			changePojo.setUserId(userId);
			changePojo.setPassword(newPassword);
			tableAccessObj.modifyUserDetails(changePojo);
		} 
		else 
		{
			throw new UserDefinedException("The Old password is incorrect");
		}

	}

	public Account viewAccount(long accountNo) throws SQLException, UserDefinedException 
	{
		Map<Long, Account> accountMap = new HashMap<Long, Account>();
		accountMap = tableAccessObj.getAccountDetails(accountNo);
		Account accountPojo = accountMap.get(accountNo);
		if (accountPojo == null) 
		{
			throw new UserDefinedException("The Account Number is Not Available");
		}
		return accountPojo;
	}
	
	public void setUserLogin(int userId, String status) throws SQLException, UserDefinedException
	{
		User userPojo = new User();
		userPojo.setUserId(userId);
		userPojo.setOnlineStatus(status);
		tableAccessObj.modifyUserDetails(userPojo);
	}
	
	public void setAccountLogin(long accountNo, String status) throws SQLException, UserDefinedException
	{
		Account modifyAccountPojo = new Account();
		modifyAccountPojo.setAccountNo(accountNo);
		modifyAccountPojo.setOnlineStatus(status);
		tableAccessObj.modifyAccountDetails(modifyAccountPojo);
		
	}

}
