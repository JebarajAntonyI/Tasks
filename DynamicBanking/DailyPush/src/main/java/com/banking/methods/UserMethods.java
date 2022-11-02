package com.banking.methods;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.banking.db.TableAccess;
import com.banking.pojo.Account;
import com.banking.pojo.Customer;
import com.banking.pojo.Transaction;
import com.banking.pojo.User;
import com.user.exception.InputValidityCheck;
import com.user.exception.UserDefinedException;

public class UserMethods {

	private TableAccess tableAccessObj = new TableAccess();

	public Account viewAccount(int userId, long accountNo) throws SQLException, UserDefinedException 
	{
		Map<Integer, Map<Long, Account>> accountMap = new HashMap<Integer, Map<Long, Account>>();
		accountMap = tableAccessObj.getAllAccountDetails();
		Map<Long, Account> innerMap = new HashMap<>();
		innerMap = accountMap.get(userId);
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
	
	public Map<Long, Account> viewAccount(int userId) throws SQLException, UserDefinedException 
	{
		Map<Integer, Map<Long, Account>> accountMap = new HashMap<Integer, Map<Long, Account>>();
		accountMap = tableAccessObj.getAllAccountDetails(userId);
		Map<Long, Account> innerMap = new HashMap<>();
		innerMap = accountMap.get(userId);
		if (innerMap != null)
		{
			return innerMap;
		}
		throw new UserDefinedException("The UserId is Not Available");
	}

	public double checkBalance(int userId, long accountNo) throws SQLException, UserDefinedException 
	{
		Account balancePojo = viewAccount(userId, accountNo);
		if (balancePojo == null) 
		{
			throw new UserDefinedException("The UserId and Account Number is Not Matched");
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
		Account accountPojo = tableAccessObj.getAccountInfo(accountNo);
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
	
	public List<Customer> viewCustomerDetails(Integer... customerId) throws SQLException, UserDefinedException 
	{
		List<Customer> customerList = new ArrayList<>();
		Map<Integer, Customer> customerMap = new HashMap<>();
		customerMap = tableAccessObj.getAllCustomerDetails(customerId);
		Collection<Customer> customerCollections = customerMap.values();
		customerList.addAll(customerCollections);
		return customerList;
	}
	
	public void setAccountLogin(long accountNo, String status) throws SQLException, UserDefinedException
	{
		Account modifyAccountPojo = new Account();
		modifyAccountPojo.setAccountNo(accountNo);
		modifyAccountPojo.setOnlineStatus(status);
		tableAccessObj.modifyAccountDetails(modifyAccountPojo);
	}
	
	public List<Transaction> getTransactionDetails(long accountNo) throws SQLException, UserDefinedException 
	{
		List<Transaction> transactionList = new ArrayList<>();
		transactionList = tableAccessObj.getTransactionDetails(accountNo);
		if (transactionList == null) 
		{
			throw new UserDefinedException("The Account Number is not Available");
		}
		return transactionList;
	}
	
	public void modifyUserDetails(User userPojo) throws SQLException, UserDefinedException 
	{
		InputValidityCheck.checkNull(userPojo);
		tableAccessObj.modifyUserDetails(userPojo);
	}

}
