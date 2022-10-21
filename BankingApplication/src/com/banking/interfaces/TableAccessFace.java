package com.banking.interfaces;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.banking.pojo.Account;
import com.banking.pojo.Customer;
import com.banking.pojo.CustomerRequest;
import com.banking.pojo.Transaction;
import com.banking.pojo.TransactionRequest;
import com.banking.pojo.User;
import com.user.exception.UserDefinedException;

public interface TableAccessFace 
{

	public void addUserDetails(User userPojo) throws UserDefinedException;

	public void modifyUserDetails(User userPojo) throws SQLException, UserDefinedException;

	public void addCustomerDetails(Customer customerPojo) throws UserDefinedException;//crt
	
	public void modifyCustomerDetails(Customer customerPojo) throws SQLException, UserDefinedException;//added
	
	//public void addUserCustomerDetails(Customer customerPojo) throws UserDefinedException;
	
	public void addAccountDetails(Account accountPojo) throws UserDefinedException;

	public void modifyAccountDetails(Account accountPojo) throws SQLException, UserDefinedException;

	public void addTransactionDetails(Transaction transactionPojo) throws UserDefinedException;

	public void addTransactionRequest(TransactionRequest transactionRequestPojo) throws UserDefinedException;

	public void modifyTransactionRequest(TransactionRequest transactionRequest) throws UserDefinedException;
	
	public void addCustomerRequest(CustomerRequest customerRequestPojo) throws UserDefinedException;

	public void modifyCustomerRequest(int reqNo, String status) throws UserDefinedException;

	public Map<Long, TransactionRequest> getAllTransactionRequestStatus(String status) throws UserDefinedException;

	public TransactionRequest getTransactionRequestStatus(String status, int reqNo) throws UserDefinedException;//crt

//	public int getUserId(int id) throws UserDefinedException;//crt

//	public int getUserIdViaAccount(long accountNo) throws UserDefinedException;//crt

	public User getUserInfo(int id) throws UserDefinedException;//crt

	public Customer getCustomerInfo(int id) throws UserDefinedException;//crt

	public Account getAccountInfo(long accountNo) throws UserDefinedException;//crt		

	public Map<Integer, User> getAllUserMap() throws SQLException, UserDefinedException;

	public Map<Integer, Map<Long, Account>> getAllAccountDetails(Integer... userId) throws SQLException, UserDefinedException;

	public Map<Long, Account> getAccountDetails(long accountNo) throws SQLException, UserDefinedException;//crt

	public Map<Long, Account> getSpecificUserAccount(int userId) throws UserDefinedException;//crt

	public Map<Long, Map<Integer, Transaction>> getAllTransactionDetailsMap(int customerId) throws SQLException, UserDefinedException;

	public List<Transaction> getTransactionDetails(long accountNo) throws SQLException, UserDefinedException;

	public Map<Integer, Customer> getCustomerDetails() throws UserDefinedException, SQLException;

	public Map<Integer, CustomerRequest> getRequestMessages(String reqStatus) throws SQLException, UserDefinedException;

}
