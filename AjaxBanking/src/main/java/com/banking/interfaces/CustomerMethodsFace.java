package com.banking.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.banking.pojo.Transaction;
import com.user.exception.UserDefinedException;

public interface CustomerMethodsFace {
	public void depositMoney(int userId, long accountNo, double amount) throws SQLException, UserDefinedException;

	public void withdrawMoney(int userId, long accountNo, double amount) throws SQLException, UserDefinedException;

	public void transferMoney(int userId, long accountNo, long toAccount, double amount)
			throws SQLException, UserDefinedException;

	public List<Long> getAccountsDetails(int userId) throws UserDefinedException;

	public List<Transaction> getTransactionDetails(long accountNo) throws SQLException, UserDefinedException;

	public void requestMessage(int customerId, long accountNo, String message) throws UserDefinedException;

}
