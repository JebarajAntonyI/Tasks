package com.tester;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.banking.login.UserLogin;
import com.banking.methods.BankUtil;
import com.banking.methods.CustomerMethods;
import com.banking.pojo.Account;
import com.banking.pojo.Transaction;
import com.banking.pojo.User;
import com.user.exception.InputValidityCheck;
import com.user.exception.UserDefinedException;

public class CustomerConnect 
{
	private int userId;
	private static Scanner scan = new Scanner(System.in);
	Logger logger = Logger.getLogger("Banking Application");

	private CustomerMethods customerMethods = new CustomerMethods();
	private BankUtil getInput = new BankUtil();
	private UserLogin userLogin = new UserLogin();
	
	public long selectAccount() throws UserDefinedException, SQLException
	{
		List<Long> accountList = new ArrayList<>();
		accountList = customerMethods.getAccountsDetails(userId);
		if (accountList.size() == 0)
		{
			throw new UserDefinedException("No Account is Available for Your User ID");
		}
		logger.info("\nSelect Account to Login");
		int i = 1;
		for (long accountNo: accountList)
		{
			System.out.println("\n"+ i + ")" + accountNo);
			i++;
		}
		int selectAccount = getInput.getIntegerInput();
		while(selectAccount>=i || selectAccount<=0)
		{
			logger.log(Level.WARNING, "Select Number From 1 - To " + (i-1));
			selectAccount = getInput.getIntegerInput();
		}
		long accountNo = accountList.get(selectAccount-1);
		customerMethods.setAccountLogin(accountNo, "ONLINE");
		return accountList.get(selectAccount-1);
	}
	
	public void customers(int userId) throws UserDefinedException, SQLException
	{
		this.userId = userId;
		if(userLogin.getCustomerStatus(userId) == true)
		{
			System.out.println("......................WELCOME CUSTOMER......................");
			long accountNo = selectAccount();
			try
			{
				userLogin.getAccountStatus(accountNo);
				System.out.println("You Selected The Account Number: " + accountNo);
				logger.info("\nSelect Which Operation you want to Perform "
						+ "\n	 1) View User Information"
						+ "\n	 2) View Account Details"
						+ "\n	 3) View Transaction Details"
						+ "\n	 4) Check Balance"
						+ "\n	 5) Deposit"
						+ "\n	 6) Request Withdraw"
						+ "\n	 7) Transfer"
						+ "\n	 8) Change Password"
						+ "\n	 9) Change Account"
						+ "\n	10) Logout");
				int choice = getInput.getIntegerInput();
				logger.info("");
				System.out.println("...........................................................");
				A:
				while (choice != 0)
				{
//				try
//				{
					switch(choice)
					{
					case 1:
					{
						User userPojo = new User();
						userPojo = customerMethods.userInfo(userId);
						logger.info("Customer Id : " + userPojo.getUserId() + "\n"
								+ "Name: " + userPojo.getName() + "\n"
								+ "Mobile Number: " + userPojo.getMobile() + "\n"
								+ "E-Mail ID: " + userPojo.getEmail() + "\n"
								+ "Date of Birth: " + userPojo.getDob() + "\n"
								+ "UserType: " + userPojo.getUserType());
						break;
					}
					
					case 2:
					{
						try {
							Account accountPojo = new Account();
							accountPojo = customerMethods.viewAccount(userId, accountNo);
							logger.info("Account Number: " + accountPojo.getAccountNo() + "\n"
									+ "Account Type: " + accountPojo.getAccountType() + "\n"
									+ "Account Branch: " + accountPojo.getAccountBranch() + "\n"
									+ "IFSC: " + accountPojo.getIfsc());
							break;
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					case 3:
					{
						List<Transaction> transactionList = new ArrayList<>();
						transactionList = customerMethods.getTransactionDetails(accountNo);
						InputValidityCheck.checkNull(transactionList);
						int size = transactionList.size();
						for(int i=0; i<size; i++)
						{
							System.out.println(transactionList.get(i) + "\n\n");
						}
						break;
					}
					
					case 4:
					{
						double balance = customerMethods.checkBalance(accountNo);
						logger.info("Account Number: " + accountNo + "\n"
								+ "Account Balance: " + balance);
						break;
					}
					
					case 5:
					{
						logger.info("Enter the Amount you want to Deposit");
						double depositAmount = getInput.getDoubleInput();
						try
						{
							customerMethods.depositMoney(userId, accountNo, depositAmount);
							System.out.println("Successfully Deposited");
						}
						catch (UserDefinedException ue)
						{
							logger.log(Level.SEVERE, ue.getMessage());
						}
						break;
					}
					
					case 6:
					{
						logger.info("Enter the Amount you want to Withdraw");
						double withdrawAmount = getInput.getDoubleInput();
						try
						{
							customerMethods.withdrawMoney(userId, accountNo, withdrawAmount);
							logger.info("Your Withdraw Request is Submitted "
									+ "\nWait for the Approval");
						}
						catch (UserDefinedException ue)
						{
							logger.log(Level.SEVERE, ue.getMessage());
						}
						break;
					}
					
					case 7:
					{
						logger.info("Enter the Account Number you want to Transfer Money");
						long toAccount = getInput.getLongInput();
						logger.info("Enter the Amount you want to Transfer");
						double amount = getInput.getDoubleInput();
						try
						{
							customerMethods.transferMoney(userId, accountNo, toAccount, amount);
							System.out.println("The Amount: " + amount + " is Successfully Transfered to " + toAccount);
						}
						catch (UserDefinedException ue)
						{
							logger.log(Level.SEVERE, ue.getMessage());
							ue.printStackTrace();
						}
						break;
					}
					
					case 8:
					{
						logger.info("Enter Last Password");
						String oldPassword = scan.next();
						logger.info("Enter New Password");
						String newPassword = scan.next();
						try
						{
							customerMethods.changePassword(userId, oldPassword, newPassword);
							System.out.println("The Password Changed Sucessfully");
						}
						catch (UserDefinedException ue)
						{
							logger.log(Level.SEVERE, ue.getMessage());
						}
						break;
					}
					
					case 9:
					{
						accountNo = selectAccount();
						System.out.println("You Selected The Account Number: " + accountNo);
						break;
					}
					case 10:
						customerMethods.setAccountLogin(accountNo, "OFFLINE");
						break A;
						
					default:
						System.out.println("Select Value Between 1 and 10");
						break;
					}
//				}
//				catch(UserDefinedException ue)
//				{
//					logger.log(Level.SEVERE, ue.getMessage());
//				}
					System.out.println("...........................................................");
					logger.info("\nSelect Which Operation you want to Perform "
							+ "\n	 1) View User Information"
							+ "\n	 2) View Account Details"
							+ "\n	 3) View Transaction Details"
							+ "\n	 4) Check Balance"
							+ "\n	 5) Deposit"
							+ "\n	 6) Request Withdraw"
							+ "\n	 7) Transfer"
							+ "\n	 8) Change Password"
							+ "\n	 9) Change Account"
							+ "\n	10) Logout");
					choice = getInput.getIntegerInput();
					System.out.println("...........................................................");
				}
			}
			catch (UserDefinedException ue)
			{
				logger.severe(ue.getMessage());
				logger.info("Your Account is Not Active"
						+ "\n	1) Request for Active"
						+ "\n	Press any Other number to Exit");
				int choice = getInput.getIntegerInput();
				
				switch(choice)
				{
				case 1:
					logger.info("Enter your Request Message: ");
					String message = scan.nextLine();
					scan.nextLine();
					customerMethods.requestMessage(userId, accountNo, message);
					break;
					
				default:
					break;
				}
				customerMethods.setAccountLogin(accountNo, "OFFLINE");
			}
		}
		else
		{
			logger.severe("The Customer Id is Not Available/Active");
		}
	}
}
