package com.banking.pojo;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Transaction 
{
	private int customerId;
	private int transactionId;
	private long transactionTime;
	private String modeOfTransaction;
	private long primaryAccount;
	private long secondaryAccount;
	private String transactionType;
	private double amount;
	private double closingBalance;
	private String transactionStatus;

	public String getTransactionType() 
	{
		return transactionType;
	}

	public void setTransactionType(String transactionType) 
	{
		this.transactionType = transactionType;
	}

	public double getAmount() 
	{
		return amount;
	}

	public void setAmount(double amount) 
	{
		this.amount = amount;
	}

	public int getCustomerId() 
	{
		return customerId;
	}

	public void setCustomerId(int customerId) 
	{
		this.customerId = customerId;
	}

	public int getTransactionId() 
	{
		return transactionId;
	}

	public void setTransactionId(int transactionId) 
	{
		this.transactionId = transactionId;
	}

	public long getTransactionTime() 
	{
		return transactionTime;
	}

	public void setTransactionTime(long transactionTime) 
	{
		this.transactionTime = transactionTime;
	}

	public String getModeOfTransaction() 
	{
		return modeOfTransaction;
	}

	public void setModeOfTransaction(String modeOfTransaction) 
	{
		this.modeOfTransaction = modeOfTransaction;
	}

	public long getPrimaryAccount() 
	{
		return primaryAccount;
	}

	public void setPrimaryAccount(long primaryAccount) 
	{
		this.primaryAccount = primaryAccount;
	}

	public long getSecondaryAccount() 
	{
		return secondaryAccount;
	}

	public void setSecondaryAccount(long secondaryAccount) 
	{
		this.secondaryAccount = secondaryAccount;
	}

	public double getClosingBalance() 
	{
		return closingBalance;
	}

	public void setClosingBalance(double closingBalance) 
	{
		this.closingBalance = closingBalance;
	}

	public String getTransactionStatus() 
	{
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) 
	{
		this.transactionStatus = transactionStatus;
	}
	
	LocalDateTime transactionDate = Instant.ofEpochMilli(getTransactionTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();


	public String toString() 
	{
		return ("Transaction ID: " + getTransactionId() + "		" + "Customer ID: " + getCustomerId() + "		"
				+ "Mode of Transaction: " + getModeOfTransaction() + "	" + "Primary Account: " + getPrimaryAccount() + "	"
				+ "Secondary Account: " + getSecondaryAccount() + "	" + "Transaction Type: " + getTransactionType() + "	" 
				+ "Amount: " + getAmount() + "	" + "Transaction Time: " + transactionDate + "	" 
				+ "Transaction Status: " + getTransactionStatus());
	}

}
