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

public interface AdminMethodsFace {
	public void withdrawApproval(int reqNo, String status) throws SQLException, UserDefinedException;

	public Map<Long, TransactionRequest> checkTransactionStatus(String status) throws UserDefinedException;

	public List<Account> viewAllAccount() throws SQLException, UserDefinedException;

	public List<User> viewAllUsers() throws SQLException, UserDefinedException;

	public List<Transaction> viewCustomerTransactions(int customerId) throws SQLException, UserDefinedException;

	public List<Customer> viewCustomerDetails() throws SQLException, UserDefinedException;

	public Map<Integer, CustomerRequest> viewMessage(String reqStatus) throws SQLException, UserDefinedException;

	public void replayMessage(int reqNo, String status) throws UserDefinedException;

	public void modifyUserDetails(User userPojo) throws SQLException, UserDefinedException;

	public void modifyAccountDetails(Account accountPojo)
			throws SQLException, UserDefinedException;

}
