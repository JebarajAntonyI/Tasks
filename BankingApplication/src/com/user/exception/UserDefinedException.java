package com.user.exception;

@SuppressWarnings("serial")
public class UserDefinedException extends Exception 
{
	public UserDefinedException(String message) 
	{
		super(message);
	}

	public UserDefinedException(String message, Exception e) 
	{
		super(message, e);
	}

	public UserDefinedException(Exception e) 
	{
		super(e);
	}
}
