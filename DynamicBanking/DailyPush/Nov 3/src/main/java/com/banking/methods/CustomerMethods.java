package com.banking.methods;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.banking.db.TableAccess;
import com.banking.interfaces.TableAccessFace;
import com.banking.login.UserLogin;
import com.banking.pojo.Account;
import com.banking.pojo.CustomerRequest;
import com.banking.pojo.Transaction;
import com.banking.pojo.TransactionRequest;
import com.user.exception.InputValidityCheck;
import com.user.exception.UserDefinedException;

public class CustomerMethods extends UserMethods {

	private TableAccessFace tableAccessObj = new TableAccess();
	UserLogin userLogin = new UserLogin();

	public void depositMoney(int userId, long accountNo, double amount) throws SQLException, UserDefinedException 
	{
		if(amount <= 0)
		{
			throw new UserDefinedException("Enter Amount Properly");
		}
		userLogin.getAccountStatus(accountNo);
		Account accountPojo = viewAccount(userId, accountNo);
		double balance = Double.sum(accountPojo.getBalance(), amount);
		long time = System.currentTimeMillis();
		try 
		{
			Transaction transactionPojo = new Transaction();
			transactionPojo.setCustomerId(userId);
			transactionPojo.setTransactionTime(time);
			transactionPojo.setModeOfTransaction("Deposit");
			transactionPojo.setPrimaryAccount(accountNo);
			transactionPojo.setTransactionType("Credit");
			transactionPojo.setAmount(amount);
			transactionPojo.setClosingBalance(balance);
			transactionPojo.setTransactionStatus("Success");
			tableAccessObj.addTransactionDetails(transactionPojo);
			Account modifyAccountPojo = new Account();
			modifyAccountPojo.setAccountNo(accountNo);
			modifyAccountPojo.setBalance(balance);
			tableAccessObj.modifyAccountDetails(modifyAccountPojo);
		} 
		catch (SQLException sqe) 
		{
			throw new UserDefinedException("The Account Number Does not Exist");
		}
	}

	public void withdrawMoney(int userId, long accountNo, double amount) throws SQLException, UserDefinedException 
	{
		if(amount <= 0)
		{
			throw new UserDefinedException("Enter Amount Properly");
		}
		userLogin.getAccountStatus(accountNo);
		Account accountPojo = viewAccount(userId, accountNo);
		double balance = accountPojo.getBalance();
		if (balance >= amount) 
		{

			long time = System.currentTimeMillis();
			TransactionRequest transactionRequest = new  TransactionRequest();
			transactionRequest.setCustomerId(userId);
			transactionRequest.setAccountNo(accountNo);
			transactionRequest.setRequestFor("Withdraw");
			transactionRequest.setStatus("Pending");
			transactionRequest.setRequestTime(time);
			transactionRequest.setAmount(amount);
			tableAccessObj.addTransactionRequest(transactionRequest);
		} 
		else 
		{
			throw new UserDefinedException("The Balance is insufficient");
		}
	}

	public void transferMoney(int userId, long accountNo, long toAccount, double amount) throws SQLException, UserDefinedException 
	{
		int toUserId = 0;
		if(amount <= 0)
		{
			throw new UserDefinedException("Enter Amount Properly");
		}
		userLogin.getAccountStatus(accountNo);
		Account accountPojo = new Account();
		try
		{
			accountPojo = tableAccessObj.getAccountInfo(toAccount);
			toUserId = accountPojo.getCustomerId();
		}
		finally
		{
			if (toUserId != 0) 
			{
				userLogin.getAccountStatus(toAccount);
			}
			double balance = checkBalance(accountNo);
			String regxPattern = "^[1-9][0-9]{9, 17}";
	
			if (String.valueOf(toAccount).matches(regxPattern)) 
			{
				if (balance >= amount) 
				{
					long time = System.currentTimeMillis();
					balance = balance - amount;
					Transaction transactionPojo = new Transaction();
					transactionPojo.setCustomerId(userId);
					transactionPojo.setTransactionTime(time);
					transactionPojo.setModeOfTransaction("Transfer");
					transactionPojo.setPrimaryAccount(accountNo);
					transactionPojo.setSecondaryAccount(toAccount);
					transactionPojo.setTransactionType("Debit");
					transactionPojo.setAmount(amount);
					transactionPojo.setClosingBalance(balance);
					transactionPojo.setTransactionStatus("Success");
					tableAccessObj.addTransactionDetails(transactionPojo);
					Account modifyAccountPojo = new Account();
					modifyAccountPojo.setAccountNo(accountNo);
					modifyAccountPojo.setBalance(balance);
					tableAccessObj.modifyAccountDetails(modifyAccountPojo);
	
					double toBalance = checkBalance(toAccount);
					if (toUserId != 0) 
					{
						toBalance = Double.sum(toBalance, amount);
						time = System.currentTimeMillis();
						transactionPojo = new Transaction();
						transactionPojo.setCustomerId(toUserId);
						transactionPojo.setTransactionTime(time);
						transactionPojo.setModeOfTransaction("Received");
						transactionPojo.setPrimaryAccount(toAccount);
						transactionPojo.setSecondaryAccount(accountNo);
						transactionPojo.setTransactionType("Credit");
						transactionPojo.setAmount(amount);
						transactionPojo.setClosingBalance(toBalance);
						transactionPojo.setTransactionStatus("Success");
						tableAccessObj.addTransactionDetails(transactionPojo);
						modifyAccountPojo = new Account();
						modifyAccountPojo.setAccountNo(toAccount);
						modifyAccountPojo.setBalance(toBalance);
						tableAccessObj.modifyAccountDetails(modifyAccountPojo);
					}
				} 
				else 
				{
					throw new UserDefinedException("The Balance is insufficient");
				}
			} 
			else 
			{
				throw new UserDefinedException("The Account Number is Invalid");
			}
		}

	}

	public List<Long> getAccountsDetails(int userId) throws UserDefinedException 
	{
		Map<Long, Account> accountMap = new HashMap<>();
		List<Long> accountList = new ArrayList<>();
		accountMap = tableAccessObj.getActiveAccount(userId);
		for (long key :  accountMap.keySet()) 
		{
			accountList.add(key);
		}
		InputValidityCheck.checkNull(accountList);
		return accountList;
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

	public void requestMessage(int customerId, long accountNo, String message) throws UserDefinedException 
	{
		CustomerRequest customerRequestPojo = new CustomerRequest();
		customerRequestPojo.setCustomerId(customerId);
		customerRequestPojo.setAccountNo(accountNo);
		customerRequestPojo.setRequestMessage(message);
		tableAccessObj.addCustomerRequest(customerRequestPojo);
	}
}