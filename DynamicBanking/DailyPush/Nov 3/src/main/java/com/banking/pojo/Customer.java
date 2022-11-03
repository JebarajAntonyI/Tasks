package com.banking.pojo;

public class Customer extends User 
{
	private int customerId;
	private long aadhar;
	private String pan;
	private String address;
	private String customerStatus;

	public String getCustomerStatus() 
	{
		return customerStatus;
	}

	public void setCustomerStatus(String customerStatus) 
	{
		this.customerStatus = customerStatus;
	}

	public int getCustomerId() 
	{
		return customerId;
	}

	public void setCustomerId(int customerId) 
	{
		this.customerId = customerId;
	}

	public long getAadhar() 
	{
		return aadhar;
	}

	public void setAadhar(long aadhar) 
	{
		this.aadhar = aadhar;
	}

	public String getPan() 
	{
		return pan;
	}

	public void setPan(String pan) 
	{
		this.pan = pan;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String toString() 
	{
		return ("Customer ID: " + getCustomerId() + "\n" 
				+ "Aadhar Number: " + getAadhar() + "\n" 
				+ "PAN Number: " + getPan() + "\n" 
				+ "Address: " + getAddress() + "\n" 
				+ "Name: " + getName() + "\n" 
				+ "Mobile Number: " + getMobile() + "\n" 
				+ "E-Mail ID: " + getEmail() + "\n" 
				+ "Date of Birth: " + getDob() + "\n"
				+ "Customer Status: " + getCustomerStatus());
	}
}
