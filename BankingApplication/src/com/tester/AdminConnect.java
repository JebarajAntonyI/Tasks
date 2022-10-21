package com.tester;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.banking.methods.AdminMethods;
import com.banking.pojo.Account;
import com.banking.pojo.Customer;
import com.banking.pojo.CustomerRequest;
import com.banking.pojo.Transaction;
import com.banking.pojo.TransactionRequest;
import com.banking.pojo.User;
import com.user.exception.InputValidityCheck;
import com.user.exception.UserDefinedException;

public class AdminConnect 
{
	private int userId;
	private static Scanner scan = new Scanner(System.in);
	Logger logger = Logger.getLogger("Banking Application");

	
	private AdminMethods adminMethods = new AdminMethods();
	private CustomerConnect customerConnect = new CustomerConnect();
	private GetInput getInput = new GetInput();

	public void admin(int userId) throws SQLException, UserDefinedException
	{
		this.userId = userId;
		System.out.println(".......................WELCOME ADMIN.......................");
		logger.info("\nSelect Which Operation you want to Perform "
				+ "\n	 1) View Specific User Information"
				+ "\n	 2) View Specific Account Details"
				+ "\n	 3) Check Specific Account Balance"
				+ "\n	 4) Check Withdraw Status"
				+ "\n	 5) Approve Withdraw"
				+ "\n	 6) View all Users"
				+ "\n	 7) View all Accounts"
				+ "\n	 8) View User Transactions"
				+ "\n	 9) View Customer Details"
				+ "\n	10) Change Password"
				+ "\n	11) Access Own Bank Account"
				+ "\n	12) View Request Messages"
				+ "\n	13) Activate Customer ID"
				+ "\n	14) Activate Account Number"
				+ "\n	15) Exit Account");
		int choice = getInput.getIntegerInput();
		logger.info("");
		System.out.println("...........................................................");
		A:
		while(choice != 0)
		{
			try
			{
			switch(choice)
				{
				case 1:
				{
					User userPojo = new User();
					logger.info("Enter the User ID you want to get Details");
					int customerId = getInput.getIntegerInput();
					userPojo = adminMethods.userInfo(customerId);
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
					Account accountPojo = new Account();
					logger.info("Enter the Account Number you want to get Details");
					long userAccountNo = getInput.getLongInput();
					accountPojo = adminMethods.viewAccount(userAccountNo);
					logger.info("Account Number: " + accountPojo.getAccountNo() + "\n"
							+ "Account Type: " + accountPojo.getAccountType() + "\n"
							+ "Account Branch: " + accountPojo.getAccountBranch() + "\n"
							+ "IFSC: " + accountPojo.getIfsc());
					break;
				}
				
				case 3:
				{
					Account accountPojo = new Account();
					logger.info("Enter the Account Number you want to check Balance");
					long userAccountNo = getInput.getLongInput();
					accountPojo = adminMethods.viewAccount(userAccountNo);
					logger.info("Account Number: " + accountPojo.getAccountNo() + "\n"
							+ "Balance: " + accountPojo.getBalance());
					break;
				}
				
				case 4:
				{
					logger.info("Enter Which Status you want to view "
							+ "\n	1) Pending"
							+ "\n	2) Approved"
							+ "\n	3) Rejected");
					int option = getInput.getIntegerInput();
					Map<Long, TransactionRequest> statusMap = new HashMap<Long, TransactionRequest>();
					switch(option)
					{
					case 1:
						statusMap = adminMethods.checkTransactionStatus("Pending");
						break;
					case 2:
						statusMap = adminMethods.checkTransactionStatus("Approved");
						break;
					case 3:
						statusMap = adminMethods.checkTransactionStatus("Rejected");
						break;
					}
					for (Map.Entry<Long, TransactionRequest> it: statusMap.entrySet())
					{
						TransactionRequest statusPojo = it.getValue();
						System.out.println(statusPojo + "\n\n");
					}
					break;
				}
					
				case 5:
				{
					logger.info("Enter Request Number to Approve/Reject");
					int reqNo = getInput.getIntegerInput();
					logger.info("Press	1) Approve"
							  + "		2) Reject");
					int option = getInput.getIntegerInput();
					switch(option)
					{
					case 1:
						adminMethods.withdrawApproval(reqNo, "Approved");
						break;
					case 2:
						adminMethods.withdrawApproval(reqNo, "Rejected");
						break;
					}
					break;
				}
				
				case 6:
				{
					List<User> userList = new ArrayList<>();
					userList = adminMethods.viewAllUsers();
					InputValidityCheck.checkNull(userList);
					int size = userList.size();
					for(int i=0; i<size; i++)
					{
						System.out.println(userList.get(i) + "\n\n");
					}
					break;
				}
				
				case 7:
				{
					List<Account> accountList = new ArrayList<>();
					accountList = adminMethods.viewAllAccount();
					InputValidityCheck.checkNull(accountList);
					int size = accountList.size();
					for(int i=0; i<size; i++)
					{
						System.out.println(accountList.get(i) + "\n\n");
					}
					break;
				}
				
				case 8:
				{
					logger.info("Enter Customer ID to Check Transactions");
					int customerId = getInput.getIntegerInput();
					List<Transaction> transactionList = new ArrayList<>();
					transactionList = adminMethods.viewCustomerTransactions(customerId);
					InputValidityCheck.checkNull(transactionList);
					int size = transactionList.size();
					for(int i=0; i<size; i++)
					{
						System.out.println(transactionList.get(i) + "\n");
					}
					break;
				}
				
				case 9:
				{
					List<Customer> customerList = new ArrayList<>();
					customerList = adminMethods.viewCustomerDetails();
					InputValidityCheck.checkNull(customerList);
					int size = customerList.size();
					for(int i=0; i<size; i++)
					{
						System.out.println(customerList.get(i) + "\n\n");
					}
					break;
				}
				
				case 10:
				{
					logger.info("Enter Last Password");
					String oldPassword = scan.next();
					logger.info("Enter New Password");
					String newPassword = scan.next();
					try
					{
						adminMethods.changePassword(userId, oldPassword, newPassword);
						System.out.println("The Password Changed Sucessfully");
					}
					catch (UserDefinedException ue)
					{
						logger.log(Level.SEVERE, ue.getMessage());
					}
					break;
				}
				
				case 11:
				{
					customerConnect.customers(this.userId);
					break;
				}
				
				case 12:
				{
					logger.info("Enter Which Status you want to view "
							+ "\n	1) Pending"
							+ "\n	2) Approved"
							+ "\n	3) Rejected");
					int option = getInput.getIntegerInput();
					Map<Integer, CustomerRequest> reqMessageMap = new HashMap<>();
					switch(option)
					{
					case 1:
						reqMessageMap = adminMethods.viewMessage("Pending");
						break;
					case 2:
						reqMessageMap = adminMethods.viewMessage("Approved");
						break;
					case 3:
						reqMessageMap = adminMethods.viewMessage("Rejected");
						break;
					}
					for (Entry<Integer, CustomerRequest> it: reqMessageMap.entrySet())
					{
						CustomerRequest reqMessagePojo = it.getValue();
						System.out.println(reqMessagePojo + "\n\n");
					}
					break;
				}
				
				case 13:
				{
					logger.info("Enter Request Number to Approve/Reject");
					int requestNumber = getInput.getIntegerInput();
					logger.info("Press	1) Approve"
							  + "		2) Reject");
					int option = getInput.getIntegerInput();
					switch(option)
					{
					case 1:
						logger.info("Enter Customer Id to Activate the Account");
						int customerId = getInput.getIntegerInput();
						Customer customerPojo = new Customer();
						customerPojo.setUserId(customerId);
						customerPojo.setCustomerStatus("ACTIVE");
						adminMethods.modifyCustomerDetails(customerPojo);
						adminMethods.replayMessage(requestNumber, "Approved");
						break;
					case 2:
						logger.info("Enter Customer Id to Reject the Account");
						customerId = getInput.getIntegerInput();
						adminMethods.replayMessage(requestNumber, "Rejected");
						break;
					}
					break;
				}
				
				case 14:
				{
					logger.info("Enter Request Number to Approve/Reject");
					int requestNumber = getInput.getIntegerInput();
					logger.info("Press	1) Approve"
							  + "		2) Reject");
					int option = getInput.getIntegerInput();
					switch(option)
					{
					case 1:
						logger.info("Enter Account Number to Activate the Account");
						long accountNumber = getInput.getLongInput();
						Account accountPojo = new Account();
						accountPojo.setAccountNo(accountNumber);
						accountPojo.setAccountStatus("ACTIVE");
						adminMethods.modifyAccountDetails(accountPojo);
						adminMethods.replayMessage(requestNumber, "Approved");
						break;
					case 2:
						logger.info("Enter Account Number to Reject the Request");
						accountNumber = getInput.getLongInput();
						adminMethods.replayMessage(requestNumber, "Rejected");
						break;
					}
					break;
				}
				
				case 15:
					break A;
					
				default:
					System.out.println("Select Value Between 1 and 12");
					break;
						
				}
			}
			catch(UserDefinedException ue)
			{
				logger.log(Level.SEVERE, ue.getMessage());
			}
			System.out.println("...........................................................");
			logger.info("\nSelect Which Operation you want to Perform "
					+ "\n	 1) View Specific User Information"
					+ "\n	 2) View Specific Account Details"
					+ "\n	 3) Check Specific Account Balance"
					+ "\n	 4) Check Withdraw Status"
					+ "\n	 5) Approve Withdraw"
					+ "\n	 6) View all Users"
					+ "\n	 7) View all Accounts"
					+ "\n	 8) View User Transactions"
					+ "\n	 9) View Customer Details"
					+ "\n	10) Change Password"
					+ "\n	11) Access Own Bank Account"
					+ "\n	12) View Request Messages"
					+ "\n	13) Activate Customer ID"
					+ "\n	14) Activate Account Number"
					+ "\n	15) Exit Account");
			choice = getInput.getIntegerInput();
			System.out.println("...........................................................");
			
			
			}
		
	}
}
