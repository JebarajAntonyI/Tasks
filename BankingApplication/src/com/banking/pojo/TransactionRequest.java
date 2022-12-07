package com.banking.pojo;

import com.banking.methods.BankUtil;

public class TransactionRequest 
{
	private int customerId;
	private long accountNo;
	private String requestFor;
	private long requestTime;
	private long verifiedTime;
	private String status;
	private double amount;
	private int requestNumber;

	public int getRequestNumber() 
	{
		return requestNumber;
	}

	public void setRequestNumber(int requestNumber) 
	{
		this.requestNumber = requestNumber;
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

	public String getRequestFor() 
	{
		return requestFor;
	}

	public void setRequestFor(String requestFor) 
	{
		this.requestFor = requestFor;
	}

	public long getRequestTime() 
	{
		return requestTime;
	}

	public void setRequestTime(long requestTime) 
	{
		this.requestTime = requestTime;
	}

	public long getVerifiedTime() 
	{
		return verifiedTime;
	}

	public void setVerifiedTime(long verifiedTime) 
	{
		this.verifiedTime = verifiedTime;
	}

	public String getStatus() 
	{
		return status;
	}

	public void setStatus(String status) 
	{
		this.status = status;
	}

	public double getAmount() 
	{
		return amount;
	}

	public void setAmount(double amount) 
	{
		this.amount = amount;
	}
	
	public String toString() 
	{
		return ("Request Number: " + getRequestNumber() + "\n" 
				+ "Customer ID: " + getCustomerId() + "\n" 
				+ "Account Number: " + getAccountNo() + "\n"
				+ "Request For: " + getRequestFor() + "\n" 
				+ "Request Time: " + BankUtil.getTime(getRequestTime()) + "\n" 
				+ "Request Status: " + getStatus() + "\n" 
				+ "Request Amount: " + getAmount());
	}
}
