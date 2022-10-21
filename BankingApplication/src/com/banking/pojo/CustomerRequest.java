package com.banking.pojo;

public class CustomerRequest 
{
	private int requestNo;
	private int customerId;
	private long accountNo;
	private String requestMessage;
	private String requestStatus;

	public int getRequestNo() 
	{
		return requestNo;
	}

	public void setRequestNo(int requestNo) 
	{
		this.requestNo = requestNo;
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

	public String getRequestMessage() 
	{
		return requestMessage;
	}

	public void setRequestMessage(String requestMessage) 
	{
		this.requestMessage = requestMessage;
	}

	public String getRequestStatus() 
	{
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) 
	{
		this.requestStatus = requestStatus;
	}

	public String toString() 
	{
		return ("Request Number: " + getRequestNo() + "\n" 
				+ "Customer ID: " + getCustomerId() + "\n"
				+ "Account Number: " + getAccountNo() + "\n" 
				+ "Request Message: " + getRequestMessage() + "\n"
				+ "Request Status: " + getRequestStatus());
	}
}
