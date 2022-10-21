package com.banking.interfaces;

import java.sql.SQLException;

import com.banking.pojo.Account;
import com.banking.pojo.User;
import com.user.exception.UserDefinedException;

public interface UserMethodsFace {
	
	public void setUserLogin(int userId, String status) throws SQLException, UserDefinedException;
	
	public void setAccountLogin(long accountNo, String status)throws SQLException, UserDefinedException;

	public Account viewAccount(int userId, long accountNo) throws SQLException, UserDefinedException;

	public double checkBalance(int userId, long accountNo) throws SQLException, UserDefinedException;

	public double checkBalance(long accountNo) throws SQLException, UserDefinedException;

	public User userInfo(int userId) throws SQLException, UserDefinedException;

	public void changePassword(int userId, String oldPassword, String newPassword)
			throws SQLException, UserDefinedException;

	public Account viewAccount(long accountNo) throws SQLException, UserDefinedException;

}
