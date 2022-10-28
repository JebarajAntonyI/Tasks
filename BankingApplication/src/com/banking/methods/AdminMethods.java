package com.banking.methods;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.banking.db.TableAccess;
import com.banking.interfaces.TableAccessFace;
import com.banking.pojo.Account;
import com.banking.pojo.Customer;
import com.banking.pojo.CustomerRequest;
import com.banking.pojo.Transaction;
import com.banking.pojo.TransactionRequest;
import com.banking.pojo.User;
import com.user.exception.InputValidityCheck;
import com.user.exception.UserDefinedException;

public class AdminMethods extends UserMethods
{

	private TableAccessFace tableAccessObj = new TableAccess();

	public List<User> viewAllUsers() throws SQLException, UserDefinedException 
	{
		Map<Integer, User> userMap = new HashMap<>();
		userMap = tableAccessObj.getAllUserMap();
		List<User> userList = new ArrayList<>();
		Collection<User> userCollection = userMap.values();
		userList.addAll(userCollection);
		return userList;
	}

	public List<Account> viewAllAccount() throws SQLException, UserDefinedException 
	{
		Map<Integer, Map<Long, Account>> accountMap = new HashMap<Integer, Map<Long, Account>>();
		accountMap = tableAccessObj.getAllAccountDetails();
		Collection<Map<Long, Account>> outerCollections = accountMap.values();
		InputValidityCheck.checkNull(outerCollections);
		List<Account> accountList = new ArrayList<>();
		for (Map<Long, Account> i : outerCollections) 
		{
			Collection<Account> accountCollections = i.values();
			accountList.addAll(accountCollections);
		}
		return accountList;
	}

	public Map<Long, TransactionRequest> checkTransactionStatus(String status) throws UserDefinedException 
	{
		Map<Long, TransactionRequest> statusMap = new HashMap<Long, TransactionRequest>();
		statusMap = tableAccessObj.getAllTransactionRequestStatus(status);
		if (statusMap == null) 
		{
			throw new UserDefinedException("No Such Status Available");
		}
		return statusMap;
	}

	public void withdrawApproval(int reqNo, String status) throws SQLException, UserDefinedException
	{
		TransactionRequest statusPojo = tableAccessObj.getTransactionRequestStatus("Pending", reqNo);
		InputValidityCheck.checkNull(statusPojo);
		
		int customerId = statusPojo.getCustomerId();
		long accountNo = statusPojo.getAccountNo();
		
		Account accountPojo = viewAccount(customerId, accountNo);
		InputValidityCheck.checkNull(accountPojo);
		double balance = accountPojo.getBalance();
		double amount = statusPojo.getAmount();
		
		Transaction approvePojo = new Transaction();
		
		if (status.equals("Approved")) {
			long time = System.currentTimeMillis();
			balance = balance - amount;
			TransactionRequest modTransactionReqPojo = new TransactionRequest();
			modTransactionReqPojo.setRequestNumber(reqNo);
			modTransactionReqPojo.setVerifiedTime(time);
			modTransactionReqPojo.setStatus("Approved");
			tableAccessObj.modifyTransactionRequest(modTransactionReqPojo);
			
			approvePojo.setCustomerId(customerId);
			approvePojo.setTransactionTime(time);
			approvePojo.setModeOfTransaction("Withdraw");
			approvePojo.setPrimaryAccount(accountNo);
			approvePojo.setTransactionType("Debit");
			approvePojo.setAmount(amount);
			approvePojo.setClosingBalance(balance);
			approvePojo.setTransactionStatus("Success");
			tableAccessObj.addTransactionDetails(approvePojo);
			
			Account accountChangePojo = new Account();
			accountChangePojo.setAccountNo(accountNo);
			accountChangePojo.setBalance(balance);
			tableAccessObj.modifyAccountDetails(accountChangePojo);
		} 
		else if (status.equals("Rejected")) 
		{
			long time = System.currentTimeMillis();
			TransactionRequest modTransactionReqPojo = new TransactionRequest();
			modTransactionReqPojo.setRequestNumber(reqNo);
			modTransactionReqPojo.setVerifiedTime(time);
			modTransactionReqPojo.setStatus("Rejected");
			tableAccessObj.modifyTransactionRequest(modTransactionReqPojo);
			
			approvePojo.setCustomerId(customerId);
			approvePojo.setTransactionTime(time);
			approvePojo.setModeOfTransaction("Withdraw");
			approvePojo.setPrimaryAccount(accountNo);
			approvePojo.setTransactionType("-");
			approvePojo.setAmount(amount);
			approvePojo.setClosingBalance(balance);
			approvePojo.setTransactionStatus("Failed");
			tableAccessObj.addTransactionDetails(approvePojo);
		} 
		else 
		{
			throw new UserDefinedException("The Balance is insufficient");
		}
	}

//	public User getSpecifiesUserDetail(int userId) throws SQLException, UserDefinedException
//	{
//		Map<Integer, User> userMap = new HashMap<>();
//		userMap = tableAccessObj.getAllUserMap();
//		User userInfo = new User();
//		userInfo = userMap.get(userId);
//		return userInfo;
//	}

	// Corrected
//	public Map<Long, Map<Integer, Transaction>> getAllTransactionsMap() throws SQLException, UserDefinedException{
//		Map<Long, Map<Integer, Transaction>> transactionMap = new HashMap<Long, Map<Integer, Transaction>>();
//		transactionMap = tableAccessObj.getAllTransactionDetailsMap();
//		return transactionMap;
//	}

	@SuppressWarnings("unused")
	public List<Transaction> viewCustomerTransactions(int customerId) throws SQLException, UserDefinedException 
	{
		Map<Long, Map<Integer, Transaction>> transactionMap = new HashMap<Long, Map<Integer, Transaction>>();
		transactionMap = tableAccessObj.getAllTransactionDetailsMap(customerId);
		Collection<Map<Integer, Transaction>> outerCollection = transactionMap.values();
		List<Transaction> transactionList = new ArrayList<>();
		for (Map<Integer, Transaction> i : outerCollection) 
		{
			Collection<Transaction> innerCollection = i.values();
			transactionList.addAll(innerCollection);
		}
		if (transactionList == null) 
		{
			throw new UserDefinedException("The Customer ID is not Exist");
		}
		return transactionList;
	}

	public List<Customer> viewCustomerDetails() throws SQLException, UserDefinedException 
	{
		List<Customer> customerList = new ArrayList<>();
		Map<Integer, Customer> customerMap = new HashMap<>();
		customerMap = tableAccessObj.getAllCustomerDetails();
		Collection<Customer> customerCollections = customerMap.values();
		customerList.addAll(customerCollections);
		return customerList;
	}

	public Map<Integer, CustomerRequest> viewMessage(String reqStatus) throws SQLException, UserDefinedException 
	{
		Map<Integer, CustomerRequest> reqMessageMap = new HashMap<>();
		reqMessageMap = tableAccessObj.getRequestMessages(reqStatus);
		if (reqMessageMap == null) 
		{
			throw new UserDefinedException("No Such Status Available");
		}
		return reqMessageMap;
	}
	
	public void createNewCustomerUser(Customer customerPojo) throws UserDefinedException
	{
		InputValidityCheck.checkNull(customerPojo);
		tableAccessObj.addCustomerDetails(customerPojo);
	}
	
	public void createNewUser(User userPojo) throws UserDefinedException
	{
		InputValidityCheck.checkNull(userPojo);
		tableAccessObj.addUserDetails(userPojo);
	}
	
	public void addCustomerDetailsOnly(Customer customerPojo) throws UserDefinedException
	{
		InputValidityCheck.checkNull(customerPojo);
		tableAccessObj.addCustomerDetails(customerPojo);
	}
	
	public void addAccountDetails(Account accountPojo) throws UserDefinedException
	{
		InputValidityCheck.checkNull(accountPojo);
		tableAccessObj.addAccountDetails(accountPojo);
	}

	public void replayMessage(int reqNo, String status) throws UserDefinedException 
	{
		tableAccessObj.modifyCustomerRequest(reqNo, status);
	}

	public void modifyUserDetails(User userPojo) throws SQLException, UserDefinedException 
	{
		InputValidityCheck.checkNull(userPojo);
		tableAccessObj.modifyUserDetails(userPojo);
	}
	
	public void modifyCustomerDetails(Customer customerPojo) throws SQLException, UserDefinedException 
	{
		InputValidityCheck.checkNull(customerPojo);
		tableAccessObj.modifyCustomerDetails(customerPojo);
	}

	public void modifyAccountDetails(Account accountPojo) throws SQLException, UserDefinedException 
	{
		InputValidityCheck.checkNull(accountPojo);
		tableAccessObj.modifyAccountDetails(accountPojo);
	}
}