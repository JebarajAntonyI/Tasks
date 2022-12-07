package com.banking.login;

import java.util.HashMap;
import java.util.Map;

import com.banking.db.TableAccess;
import com.banking.interfaces.TableAccessFace;
import com.banking.pojo.Account;
import com.banking.pojo.Customer;
import com.banking.pojo.User;
import com.user.exception.InputValidityCheck;
import com.user.exception.UserDefinedException;

public class UserLogin {
	private TableAccessFace accessTable = new TableAccess();

	public boolean userIdValidation(int userId) throws UserDefinedException 
	{
		User userPojo = new User();
		userPojo = accessTable.getUserInfo(userId);
		int userCheck = userPojo.getUserId();
		if (userCheck == userId) 
		{
			return true;
		}
		return false;
	}

	public boolean passwordValidation(int userId, String password) throws UserDefinedException 
	{
		User userPojo = new User();
		userPojo = accessTable.getUserInfo(userId);
		String passwordCheck = userPojo.getPassword();
		InputValidityCheck.checkNull(passwordCheck);
		if (passwordCheck.equals(password)) 
		{
			return true;
		}
		return false;
	}

	public String getUserType(int userId) throws UserDefinedException 
	{
		User userPojo = new User();
		userPojo = accessTable.getUserInfo(userId);
		String userType = userPojo.getUserType();
		return userType;
	}

	public boolean getCustomerStatus(int userId) throws UserDefinedException 
	{
		Customer customerPojo = new Customer();
		customerPojo = accessTable.getCustomerInfo(userId);
		String customerState = customerPojo.getCustomerStatus();
		InputValidityCheck.checkNull(customerState);
		if (customerState.equals("ACTIVE")) 
		{
			return true;
		}
		return false;
	}

	public boolean getAccountStatus(long account) throws UserDefinedException 
	{
		Map<Long, Account> accountMap = new HashMap<Long, Account>();
		accountMap = accessTable.getAccountInfo(account);
		Account accountPojo = new Account();
		accountPojo = accountMap.get(account);
		String accountStatus = accountPojo.getAccountStatus();
		InputValidityCheck.checkNull(accountStatus);
		if (accountStatus.equals("ACTIVE")) 
		{
			return true;
		}
		throw new UserDefinedException("The Account Number is Inactive");
	}
}
