package com.banking.pojo;

public class User 
{
	private int userId;
	private String name;
	private long mobile;
	private String email;
	private String password;
	private String dob;
	private String userType;
	private String onlineStatus;

	public String getOnlineStatus() 
	{
		return onlineStatus;
	}

	public void setOnlineStatus(String onlineStatus) 
	{
		this.onlineStatus = onlineStatus;
	}

	public int getUserId() 
	{
		return userId;
	}

	public void setUserId(int userId) 
	{
		this.userId = userId;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public long getMobile() 
	{
		return mobile;
	}

	public void setMobile(long mobile) 
	{
		this.mobile = mobile;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getDob() 
	{
		return dob;
	}

	public void setDob(String dob) 
	{
		this.dob = dob;
	}

	public String getUserType() 
	{
		return userType;
	}

	public void setUserType(String userType) 
	{
		this.userType = userType;
	}

	public String toString() 
	{
		return ("Customer Id : " + getUserId() + "\n" 
				+ "Name: " + getName() + "\n" 
				+ "Mobile Number: " + getMobile() + "\n" 
				+ "E-Mail ID: " + getEmail() + "\n" 
				+ "Date of Birth: " + getDob() + "\n" 
				+ "UserType: " + getUserType());
	}
}
