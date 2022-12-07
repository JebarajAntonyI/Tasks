package com.banking.pojo;

public class Account 
{
	private int customerId;
	private long accountNo;
	private String accountType;
	private String accountBranch;
	private String ifsc;
	private double balance;
	private String accountStatus;
	private String onlineStatus;

	public String getOnlineStatus() 
	{
		return onlineStatus;
	}

	public void setOnlineStatus(String onlineStatus) 
	{
		this.onlineStatus = onlineStatus;
	}

	public String getAccountStatus() 
	{
		return accountStatus;
	}

	public void setAccountStatus(String activeStatus) 
	{
		this.accountStatus = activeStatus;
	}

	public int getCustomerId() 
	{
		return customerId;
	}

	public void setCustomerId(int customerId) 
	{
		this.customerId = customerId;
	}

	public long getAccountNo() 
	{
		return accountNo;
	}

	public void setAccountNo(long accountNo) 
	{
		this.accountNo = accountNo;
	}

	public String getAccountType() 
	{
		return accountType;
	}

	public void setAccountType(String accountType) 
	{
		this.accountType = accountType;
	}

	public String getAccountBranch() 
	{
		return accountBranch;
	}

	public void setAccountBranch(String accountBranch) 
	{
		this.accountBranch = accountBranch;
	}

	public String getIfsc() 
	{
		return ifsc;
	}

	public void setIfsc(String ifsc) 
	{
		this.ifsc = ifsc;
	}

	public double getBalance() 
	{
		return balance;
	}

	public void setBalance(double balance) 
	{
		this.balance = balance;
	}

	public String toString() 
	{
		return ("Account Number: " + getAccountNo() + "\n" 
				+ "Account Type: " + getAccountType() + "\n"
				+ "Account Branch: " + getAccountBranch() + "\n" 
				+ "IFSC: " + getIfsc() + "\n" 
				+ "Account Balance: " +  getBalance());
	}
}
