package com.tester;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.banking.login.UserLogin;
import com.banking.methods.CustomerMethods;
import com.banking.methods.UserMethods;
import com.user.exception.UserDefinedException;

public class BankRunner {
	
	static CustomerMethods customFace = new CustomerMethods();
	static UserMethods userFace = new UserMethods();
	static int userId;
	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) throws UserDefinedException, SQLException 
	{
		CustomerConnect customerConnect = new CustomerConnect();
		AdminConnect adminConnect = new AdminConnect();
		GetInput getInput = new GetInput();
		boolean value = false;
		String password;
		Logger logger = Logger.getLogger("Banking Application");
		UserLogin userLogin = new UserLogin();
		do
		{
			try
			{
				logger.info("Enter your User ID to login: ");
				userId = getInput.getIntegerInput();

				value = userLogin.userIdValidation(userId);

				if (value)
				{
					do
					{
						logger.info("Enter Password: ");
						password = scan.next();
						if (userLogin.passwordValidation(userId, password) != true)
						{
							logger.warning("The Entered Password is wrong....\nEnter Correct password to login");
						}
					}while(userLogin.passwordValidation(userId, password) != true);
				}
				else
				{
					logger.warning("User ID is not Available");
				}
			}
			catch (UserDefinedException ue) 
			{
				logger.warning(ue.getMessage());
			}
		}while(value != true);

		String userType = userLogin.getUserType(userId);
//		if (userLogin.getCustomerStatus(userId))
//		{
			userFace.setUserLogin(userId, "ONLINE");
			try
			{
				if(userType.equals("Customer"))
				{
					customerConnect.customers(userId);
				}
				else if(userType.equals("ADMIN"))
				{
					adminConnect.admin(userId);
				}
			}
			catch(UserDefinedException ue)
			{
				logger.log(Level.SEVERE, ue.getMessage());
				
			}			
			userFace.setUserLogin(userId, "OFFLINE");
			System.out.println("..................THANKYOU HAVE A NICE DAY.................");
//		}
//		else
//		{
//			logger.severe("Your User Id is Not Active");
//		}
	}
}







