package com.java.servletpack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.banking.login.UserLogin;
import com.banking.methods.AdminMethods;
import com.banking.methods.CustomerMethods;
import com.banking.methods.UserMethods;
import com.banking.pojo.Account;
import com.banking.pojo.Customer;
import com.banking.pojo.CustomerRequest;
import com.banking.pojo.Transaction;
import com.banking.pojo.TransactionRequest;
import com.banking.pojo.User;
import com.user.exception.UserDefinedException;

/**
 * Servlet implementation class TrailServlet
 */
@WebServlet("/servlet")
public class BankServlet extends HttpServlet 
{
//	int userId;
//	String userType;
	private UserLogin userLogin = new UserLogin();
	private UserMethods userObj = new UserMethods();
	private CustomerMethods customerMethods = new CustomerMethods();
	private AdminMethods adminMethods = new AdminMethods();


	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BankServlet() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			runner(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserDefinedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			runner(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserDefinedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void runner(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, UserDefinedException, SQLException 
	{
		PrintWriter out = response.getWriter();

		String action = request.getParameter("action");
		String url = request.getServletPath();
		System.out.println(url);
		//		switch(url)
		//		{
		//		case"/":
		//			String path = "jsp/LoginPage.jsp";
		//			response.sendRedirect(path);
		//			break;
		//		}
		System.out.println(action);
		if(action != null)
		{
			switch (action)
			{
			case "Login":
			{
				HttpSession session = request.getSession(true);
				int userId = Integer.parseInt(request.getParameter("uid"));
//				this.userId = userId;
				session.setAttribute("userId", userId);
				String password = request.getParameter("pass");
				try 
				{
					if (userLogin.userIdValidation(userId) == true) 
					{
						if (userLogin.passwordValidation(userId, password) != true) 
						{
							request.setAttribute("message", "Password is Wrong");
							RequestDispatcher dispatch = request.getRequestDispatcher("jsp/LoginPage.jsp");
							dispatch.forward(request, response);
							break;
						}
						String userType = userLogin.getUserType(userId);
//						this.userType = userType;
						session.setAttribute("userType", userType);
						int id = (int) session.getAttribute("userId");
						if (userType.equals("Customer")) 
						{
							if(userLogin.getCustomerStatus(userId) == true)
							{
								userObj.setUserLogin(id, "ONLINE");
								List<Customer> customerList = new ArrayList<>();
								customerList = userObj.viewCustomerDetails(userId);
								Customer customerPojo = customerList.get(0);
								List<Long> accountList = new ArrayList<>();
								accountList = customerMethods.getAccountsDetails(userId, "ACTIVE");
//								session.setAttribute("customer", customerPojo);
								session.setAttribute("name", customerPojo.getName());
								session.setAttribute("accountList", accountList);
								RequestDispatcher dispatch = request.getRequestDispatcher("jsp/CustomerFrame.jsp");
								dispatch.forward(request, response);
							}
							else
							{
								request.setAttribute("message", "Your ID is InActive");
								RequestDispatcher dispatch = request.getRequestDispatcher("jsp/LoginPage.jsp");
								dispatch.forward(request, response);
								break;
							}
						}
						else if (userType.equals("ADMIN")) 
						{
							userObj.setUserLogin(id, "ONLINE");
							User userPojo = userObj.userInfo(userId);
//							session.setAttribute("userPojo", userPojo);
							session.setAttribute("name", userPojo.getName());
							RequestDispatcher dispatch = request.getRequestDispatcher("jsp/AdminFrame.jsp");
							dispatch.forward(request, response);
						}
					}
				} 
				catch (UserDefinedException e) 
				{
					request.setAttribute("message", "User ID is Invalid");
					RequestDispatcher dispatch = request.getRequestDispatcher("jsp/LoginPage.jsp");
					dispatch.forward(request, response);			}
				break;	
			}

			case "Admin Home":
			{
				String path = "jsp/AdminHome.jsp";
				HttpSession session = request.getSession(true);
				int userId = (int) session.getAttribute("userId");
				User userPojo = userObj.userInfo(userId);
				request.setAttribute("userPojo", userPojo);
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}

			case "View All User":
			{
				List<User> userList = new ArrayList<>();
				userList = adminMethods.viewAllUsers();
				request.setAttribute("userList", userList);
				String path = "jsp/AllUser.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}

			case "View All Account":
			{
				List<Account> accountList = new ArrayList<>();
				accountList = adminMethods.viewAllAccount();
				request.setAttribute("accountList", accountList);
				String path = "jsp/AllAccount.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}
			
			case "adminStatement":
			{
				request.setAttribute("show", "hide");
				String path = "jsp/AdminTransactionDetails.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}
			
			case "getAccountList":
			{
				int customerId = Integer.parseInt(request.getParameter("id"));
				List<Long> customerAccounts = new ArrayList<>();
				try
				{
					customerAccounts = customerMethods.getAccountsDetails(customerId, "ACTIVE");
				}
				catch(UserDefinedException ue)
				{
					request.setAttribute("redMessage", ue.getMessage());
//					out.println("<p style=\"color: red; margin-top: 3%;\">" + ue.getMessage() +"</p>");
					RequestDispatcher dispatch = request.getRequestDispatcher("jsp/AdminTransactionDetails.jsp");
					dispatch.include(request, response);
					break;
				}
//				HttpSession session = request.getSession(false);
				request.setAttribute("customerAccounts", customerAccounts);
				request.setAttribute("id", customerId);
				if(customerAccounts.isEmpty())
				{
					request.setAttribute("redMessage", "No Account is available for this User ID");
				}
				RequestDispatcher dispatch = request.getRequestDispatcher("jsp/AdminTransactionDetails.jsp");
				dispatch.forward(request, response);
				break;
			}

			case "Add New Customer":
			{
				String path = "jsp/AddCustomer.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}
			
			case "Add New User":
			{
				String path = "jsp/AddUser.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}
			
			case "newUser":
			{
				String name = request.getParameter("name");
				long mobile = Long.parseLong(request.getParameter("mobile"));
				String email = request.getParameter("email");
				String password = request.getParameter("pass");
				String dob = request.getParameter("dob");
				String userType = request.getParameter("userType");

				User userPojo = new User();
				userPojo.setName(name);
				userPojo.setMobile(mobile);
				userPojo.setEmail(email);
				userPojo.setPassword(password);
				userPojo.setDob(dob);
				userPojo.setUserType(userType);
				try
				{
					int userId = adminMethods.createNewUser(userPojo);
					request.setAttribute("message", "User Created Successfully"
							+ "\n User Id is " + userId);
				}
				catch (UserDefinedException ue)
				{
					out.println("<p style=\"text-align: center; color: red; margin-top: 3%;\">" + ue.getMessage() + "</p>");
				}
				String path = "jsp/AddUser.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.include(request, response);
				break;
			}
			
			case "Fill Customer Details":
			{
				String path = "jsp/AddCustomerDetailsOnly.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}
			
			case "newCustomerDetails":
			{
				int customerId = Integer.parseInt(request.getParameter("id"));
				long aadhar = Long.parseLong(request.getParameter("aadhar"));
				String pan = request.getParameter("pan");
				String address = request.getParameter("address");

				Customer customerPojo = new Customer();
				customerPojo.setCustomerId(customerId);
				customerPojo.setAadhar(aadhar);
				customerPojo.setPan(pan);
				customerPojo.setAddress(address);
				try
				{
					adminMethods.addCustomerDetailsOnly(customerPojo);
					request.setAttribute("message", " Customer Details Successfully Added");
				}
				catch (UserDefinedException ue)
				{
					out.println("<p style=\"text-align: center; color: red; margin-top: 3%;\">" + ue.getMessage() + "</p>");
				}
				String path = "jsp/AddCustomerDetailsOnly.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.include(request, response);
				break;
			}
			case "newCustomer":
			{
				String name = request.getParameter("name");
				long mobile = Long.parseLong(request.getParameter("mobile"));
				String email = request.getParameter("email");
				String password = request.getParameter("pass");
				String dob = request.getParameter("dob");
				String userType = request.getParameter("userType");
				long aadhar = Long.parseLong(request.getParameter("aadhar"));
				String pan = request.getParameter("pan");
				String address = request.getParameter("address");

				Customer customerPojo = new Customer();
				customerPojo.setName(name);
				customerPojo.setMobile(mobile);
				customerPojo.setEmail(email);
				customerPojo.setPassword(password);
				customerPojo.setDob(dob);
				customerPojo.setUserType(userType);
				customerPojo.setAadhar(aadhar);
				customerPojo.setPan(pan);
				customerPojo.setAddress(address);
				try
				{
					int customerId = adminMethods.createNewCustomer(customerPojo);
					request.setAttribute("message", "Customer Created Successfully"
							+ "\n Customer Id is " + customerId);
				}
				catch (UserDefinedException ue)
				{
					out.println("<p style=\"text-align: center; color: red; margin-top: 3%;\">" + ue.getMessage() + "</p>");
					ue.printStackTrace();
				}
				String path = "jsp/AddCustomer.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.include(request, response);
				break;
			}

			case "Add New Account":
			{
				String path = "jsp/AddAccount.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}

			case "newAccount":
			{
				int customerId = Integer.parseInt(request.getParameter("id"));
				double balance = Double.parseDouble(request.getParameter("balance"));
				String accountType = request.getParameter("accountType");
//				String ifsc = request.getParameter("ifsc");
				String ifsc="";
				String accountBranch = request.getParameter("accountBranch");
				if(accountBranch.equalsIgnoreCase("MADURAI"))
				{
					ifsc = "JOVIZ10124";
				}
				else if(accountBranch.equalsIgnoreCase("KARAIKUDI"))
				{
					ifsc = "JOVIZ10818";
				}
				else if(accountBranch.equalsIgnoreCase("CHENNAI"))
				{
					ifsc = "JOVIZ10116";
				}
				else if(accountBranch.equalsIgnoreCase("TRICHY"))
				{
					ifsc = "JOVIZ10713";
				}
				Account accountPojo = new Account();
				accountPojo.setCustomerId(customerId);
				accountPojo.setAccountBranch(accountBranch);
				accountPojo.setAccountType(accountType);
				accountPojo.setIfsc(ifsc);
				try
				{
					long accountNo = adminMethods.addAccountDetails(accountPojo);
					request.setAttribute("message", "Account Created Successfully"
							+ "\n Account Number is " + accountNo);
					customerMethods.depositMoney(customerId, accountNo, balance);
				}
				catch (UserDefinedException ue)
				{
					out.println("<p style=\"text-align: center; color: red; margin-top: 3%;\">" + ue.getMessage() + "</p>");
				}
				String path = "jsp/AddAccount.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.include(request, response);
				break;
			}

			case "View Transaction Request":
			{
				Map<Integer, TransactionRequest> requestMap = new HashMap<Integer, TransactionRequest>();
				requestMap = adminMethods.checkTransactionStatus("Pending");
				request.setAttribute("requestMap", requestMap);
				String path = "jsp/TransactionRequest.jsp";
				request.setAttribute("request", "Pending");
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}

			case "showTransactionRequest":
			{
				String type = request.getParameter("reqType");
				if(type.equalsIgnoreCase("Pending"))
				{
					Map<Integer, TransactionRequest> requestMap = new HashMap<Integer, TransactionRequest>();
					requestMap = adminMethods.checkTransactionStatus("Pending");
					request.setAttribute("requestMap", requestMap);
				}
				else
				{
					Map<Integer, TransactionRequest> statusMap = new HashMap<Integer, TransactionRequest>();
					statusMap = adminMethods.checkTransactionStatus(type);
					request.setAttribute("statusMap", statusMap);
				}
				request.setAttribute("request", type);
				String path = "jsp/TransactionRequest.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}

			case "ApprovedTransaction":
			{
				int reqNo = Integer.parseInt(request.getParameter("reqNo"));
				adminMethods.withdrawApproval(reqNo, "Approved");
				Map<Integer, TransactionRequest> requestMap = new HashMap<Integer, TransactionRequest>();
				requestMap = adminMethods.checkTransactionStatus("Pending");
				request.setAttribute("requestMap", requestMap);
				String path = "jsp/TransactionRequest.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}

			case "RejectedTransaction":
			{
				int reqNo = Integer.parseInt(request.getParameter("reqNo"));
				adminMethods.withdrawApproval(reqNo, "Rejected");
				Map<Integer, TransactionRequest> requestMap = new HashMap<Integer, TransactionRequest>();
				requestMap = adminMethods.checkTransactionStatus("Pending");
				request.setAttribute("requestMap", requestMap);
				String path = "jsp/TransactionRequest.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}

			case "View Customer Request":
			{
				Map<Integer, CustomerRequest> requestMap = new HashMap<Integer, CustomerRequest>();
				requestMap = adminMethods.viewMessage("Pending");
				request.setAttribute("requestMap", requestMap);
				request.setAttribute("request", "Pending");
				String path = "jsp/ViewCustomerRequest.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}

			case "showCustomerRequest":
			{
				String type = request.getParameter("reqType");
				if(type.equalsIgnoreCase("Pending"))
				{
					Map<Integer, CustomerRequest> requestMap = new HashMap<Integer, CustomerRequest>();
					requestMap = adminMethods.viewMessage("Pending");
					request.setAttribute("requestMap", requestMap);
				}
				else
				{
					Map<Integer, CustomerRequest> statusMap = new HashMap<Integer, CustomerRequest>();
					statusMap = adminMethods.viewMessage(type);
					request.setAttribute("statusMap", statusMap);
				}
				request.setAttribute("request", type);
				String path = "jsp/ViewCustomerRequest.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}

			case "ActivateAccount":
			{
				int reqNo = Integer.parseInt(request.getParameter("reqNo"));
				long acNo = Long.parseLong(request.getParameter("acNo"));
				Account accountPojo = new Account();
				accountPojo.setAccountNo(acNo);
				accountPojo.setAccountStatus("ACTIVE");
				adminMethods.modifyAccountDetails(accountPojo);
				adminMethods.replayMessage(reqNo, "Processed");
				Map<Integer, CustomerRequest> requestMap = new HashMap<Integer, CustomerRequest>();
				requestMap = adminMethods.viewMessage("Pending");
				request.setAttribute("requestMap", requestMap);
				String path = "jsp/ViewCustomerRequest.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}

			case "DeactivateAccount":
			{
				int reqNo = Integer.parseInt(request.getParameter("reqNo"));
				long acNo = Long.parseLong(request.getParameter("acNo"));
				Account accountPojo = new Account();
				accountPojo.setAccountNo(acNo);
				accountPojo.setAccountStatus("INACTIVE");
				adminMethods.modifyAccountDetails(accountPojo);
				adminMethods.replayMessage(reqNo, "Processed");
				Map<Integer, CustomerRequest> requestMap = new HashMap<Integer, CustomerRequest>();
				requestMap = adminMethods.viewMessage("Pending");
				request.setAttribute("requestMap", requestMap);
				String path = "jsp/ViewCustomerRequest.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}
			
			case "cancelCustomerRequest":
			{
				int reqNo = Integer.parseInt(request.getParameter("reqNo"));
				adminMethods.replayMessage(reqNo, "Rejected");
				Map<Integer, CustomerRequest> requestMap = new HashMap<Integer, CustomerRequest>();
				requestMap = adminMethods.viewMessage("Pending");
				request.setAttribute("requestMap", requestMap);
				String path = "jsp/ViewCustomerRequest.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}

			case "Change Password":
			{
				String path = "jsp/ChangePassword.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}

			case "passChange":
			{
				String oldPassword = request.getParameter("oldPassword");
				String newPassword = request.getParameter("newPassword");
				String confirmPassword = request.getParameter("confirmPassword");
				String path = "jsp/ChangePassword.jsp";
				if (newPassword.equals(confirmPassword))
				{
					HttpSession session = request.getSession(false);
					int id = (int) session.getAttribute("userId");
					try {
						customerMethods.changePassword(id, oldPassword, newPassword);
						request.setAttribute("message", "The Password Changed Sucessfully");
						RequestDispatcher dispatch = request.getRequestDispatcher(path);
						dispatch.forward(request, response);
						break;
					}
					catch (UserDefinedException ue) {
						out.println("<p style=\"text-align: center; color: red; margin-top: 3%;\">" + ue.getMessage() + "</p>");
						RequestDispatcher dispatch = request.getRequestDispatcher(path);
						dispatch.include(request, response);
						break;
					}
					
				}
				request.setAttribute("message", "Re entered password doesn't match with new password");
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}

			case "Customer Home":
			{
//				String path = "jsp/CustomerHome.jsp";
//				RequestDispatcher dispatch = request.getRequestDispatcher(path);
//				dispatch.forward(request, response);
//				break;
				
				
				Map<Long, Account> accountMap = new HashMap<>();
				HttpSession session = request.getSession(false);
				int id = (int) session.getAttribute("userId");
				try 
				{
					accountMap = customerMethods.viewAccount(id);
					request.setAttribute("accountMap", accountMap);
				} 
				catch (UserDefinedException ue) 
				{
					out.println("<p style=\"color: red; margin-top: 3%;\">" + ue.getMessage() + "</p>");
				}
				String path = "jsp/CustomerHome.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.include(request, response);
				break;
			}

			case "Deposit":
			{
				String path = "jsp/Deposit.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}

			case "depositAmount":
			{
				long accountNo = Long.parseLong(request.getParameter("accountNo"));
				double depositAmount = Double.parseDouble(request.getParameter("amount"));
				try
				{
					HttpSession session = request.getSession(false);
					int id = (int) session.getAttribute("userId");
					customerMethods.depositMoney(id, accountNo, depositAmount);
					request.setAttribute("message", "Successfully Deposited");
				}
				catch (UserDefinedException ue)
				{
					out.println("<p style=\"text-align: center; color: red; margin-top: 3%;\">" + ue.getMessage() + "</p>");
				}
				String path = "jsp/Deposit.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.include(request, response);
				break;
			}

			case "Withdraw":
			{
				String path = "jsp/Withdraw.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}

			case "withdrawRequest":
			{
				long accountNo = Long.parseLong(request.getParameter("accountNo"));
				double withdrawAmount = Double.parseDouble(request.getParameter("amount"));
				try 
				{
					HttpSession session = request.getSession(false);
					int id = (int) session.getAttribute("userId");
					customerMethods.withdrawMoney(id, accountNo, withdrawAmount);
					request.setAttribute("message", "Withdraw Request Submitted");
				}
				catch (UserDefinedException ue) 
				{
					out.println("<p style=\"text-align: center; color: red; margin-top: 3%;\">" + ue.getMessage() + "</p>");
				}
				String path = "jsp/Withdraw.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.include(request, response);
				break;
			}

			case "Transfer":
			{
				String path = "jsp/Transfer.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}

			case "transferAmount":
			{

				
				long accountNo = Long.parseLong(request.getParameter("accountNo"));
				long toAccount = Long.parseLong(request.getParameter("toAccount"));
				double depositAmount = Double.parseDouble(request.getParameter("amount"));
				try 
				{
					HttpSession session = request.getSession(false);
					int id = (int) session.getAttribute("userId");
					customerMethods.transferMoney(id, accountNo, toAccount, depositAmount);
					request.setAttribute("message", "Successfully Transfered to " + toAccount);
				} 
				catch (UserDefinedException ue) 
				{
					request.setAttribute("redMessage", ue.getMessage());
				}
				String path = "jsp/Transfer.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}

			case "Transaction Details":
			{
				int userId = 0;
				HttpSession session = request.getSession(false);
				String userType = (String) session.getAttribute("userType");
				if (userType.equalsIgnoreCase("Admin"))
				{
					try
					{
						userId = Integer.parseInt(request.getParameter("id"));
						List<Long> accountList = new ArrayList<>();
						accountList = customerMethods.getAccountsDetails(userId, "ACTIVE");
						session.setAttribute("accountList", accountList);
					}
					catch(UserDefinedException ue)
					{
						out.println("<p style=\"color: red; margin-top: 3%;\">" + ue.getMessage()  + "</p>");
						RequestDispatcher dispatch = request.getRequestDispatcher("jsp/TransactionDetails.jsp");
						dispatch.include(request, response);
						break;
					}
				}
				String path = "jsp/TransactionDetails.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}

			case "showTransaction":
			{
				long accountNo = Long.parseLong(request.getParameter("accountNo"));
				int days = Integer.parseInt(request.getParameter("days"));
				CustomerMethods customerMethods = new CustomerMethods();
				List<Transaction> transactionList = new ArrayList<>();
				transactionList = customerMethods.getTransactionDetails(accountNo, days);
				request.setAttribute("transactionList", transactionList);
				request.setAttribute("accountNo", accountNo);
				request.setAttribute("days", days);
				String path = "jsp/TransactionDetails.jsp";
//				if(userType.equalsIgnoreCase("Admin"))
//				{
//					path = "jsp/AdminTransactionDetails.jsp";
//				}
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}
			
			case "showAdminTransaction":
			{
				long accountNo = Long.parseLong(request.getParameter("accountNo"));
				int days = Integer.parseInt(request.getParameter("days"));
				CustomerMethods customerMethods = new CustomerMethods();
				List<Transaction> transactionList = new ArrayList<>();
				transactionList = customerMethods.getTransactionDetails(accountNo, days);
				request.setAttribute("transactionList", transactionList);
				request.setAttribute("accountNo", accountNo);
				request.setAttribute("days", days);
				String path = "jsp/AdminTransactionDetails.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}

			case "customerDetails":
			{
				int userId = 0;
				HttpSession session = request.getSession(false);
				String userType = (String) session.getAttribute("userType");
				int id = (int) session.getAttribute("userId");
				String path = "jsp/CustomerDetails.jsp";
				if (userType.equalsIgnoreCase("Admin"))
				{
					userId = Integer.parseInt(request.getParameter("id"));
				}
				List<Customer> customerList = new ArrayList<>();
				if(userId == 0)
				{
					customerList = userObj.viewCustomerDetails(id);
				}
				else
				{
					try
					{
						customerList = userObj.viewCustomerDetails(userId);
					}
					catch(UserDefinedException ue)
					{
//						out.println("<p style=\"color: red; margin-top: 3%;\">" + ue.getMessage() + "</p>");
						request.setAttribute("redMessage", ue.getMessage());
					}
					path = "jsp/CustomerDocuments.jsp";
				}
				if (!customerList.isEmpty())
				{
					Customer customerPojo = customerList.get(0);
					if (customerPojo == null)
					{
						request.setAttribute("redMessage", "No Details Availble for this User ID");
					}
					request.setAttribute("customer", customerPojo);
				}
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.include(request, response);
				break;
			}
			
			case "searchUser":
			{
				String path = "jsp/SearchUser.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}
			
			case "userProfile":
			{
				HttpSession session = request.getSession(false);
				int userId = (int) session.getAttribute("userId");
				User userPojo = new User();
				userPojo = userObj.userInfo(userId);
				request.setAttribute("userPojo", userPojo);
				RequestDispatcher dispatch = request.getRequestDispatcher("jsp/UserDetails.jsp");
				dispatch.include(request, response);
				break;
			}
			
			case "userDetails":
			{
				int userId = 0;
				HttpSession session = request.getSession(false);
				String userType = (String) session.getAttribute("userType");
				int id = (int) session.getAttribute("userId");
				if (userType.equalsIgnoreCase("Admin"))
				{
					try
					{
						userId = Integer.parseInt(request.getParameter("id"));
					}
					catch(NumberFormatException ne)
					{
						out.println("<p style=\"text-align: left; color: green; margin-top: 3%;\">Enter User ID</p>");
						RequestDispatcher dispatch = request.getRequestDispatcher("jsp/UserDetails.jsp");
						dispatch.include(request, response);
						break;
					}
				}
				User userPojo = new User();
				if(userId == 0)
				{
					userPojo = userObj.userInfo(id);
				}
				else
				{
					try
					{
						userPojo = userObj.userInfo(userId);
					}
					catch(UserDefinedException ue)
					{
						request.setAttribute("redMessage", ue.getMessage());
//						out.println("<p style=\"text-align: left; color: red; margin-top: 3%;\">" + ue.getMessage() + "</p>");
						RequestDispatcher dispatch = request.getRequestDispatcher("jsp/UserDetails.jsp");
						dispatch.include(request, response);
						break;
					}
				}
				request.setAttribute("userPojo", userPojo);
				String path = "jsp/UserDetails.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}
			
			case "AdminaccountDetails":
			{
				request.setAttribute("show", "hide");
				Map<Long, Account> accountMap = new HashMap<>();
				try
				{
					long userIdOrNo = Long.parseLong(request.getParameter("id"));
					request.setAttribute("id", userIdOrNo);
					try
					{
						accountMap = customerMethods.viewAccount(userIdOrNo);
					}
					catch(UserDefinedException ue)
					{
						request.setAttribute("message", ue.getMessage());
						String path = "jsp/AdminAccountDetails.jsp";
						RequestDispatcher dispatch = request.getRequestDispatcher(path);
						dispatch.forward(request, response);
						break;
					}
					request.setAttribute("accountMap", accountMap);
					String path = "jsp/AdminAccountDetails.jsp";
					RequestDispatcher dispatch = request.getRequestDispatcher(path);
					dispatch.forward(request, response);
					break;
				}
				catch (NumberFormatException ne)
				{
//					out.println("<p style=\"text-align: left; color: green; margin-top: 3%;\">Enter User ID</p>");
					String path = "jsp/SearchAccount.jsp";
					RequestDispatcher dispatch = request.getRequestDispatcher(path);
					dispatch.forward(request, response);
					break;
				}
			}
			
			case "AccountAction":
			{
				long userId = Long.parseLong(request.getParameter("id"));
				long acNumber = Long.parseLong(request.getParameter("accountNo"));
				Account accountPojo = new Account();
				accountPojo.setAccountNo(acNumber);
				accountPojo.setAccountStatus("INACTIVE");
				adminMethods.modifyAccountDetails(accountPojo);
				
				Map<Long, Account> accountMap = new HashMap<>();
				request.setAttribute("id", userId);
				accountMap = customerMethods.viewAccount(userId);
				request.setAttribute("accountMap", accountMap);
				String path = "jsp/AdminAccountDetails.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}
			
			case "AccountActivate":
			{
				long userId = Long.parseLong(request.getParameter("id"));
				long acNumber = Long.parseLong(request.getParameter("accountNo"));
				Account accountPojo = new Account();
				accountPojo.setAccountNo(acNumber);
				accountPojo.setAccountStatus("ACTIVE");
				adminMethods.modifyAccountDetails(accountPojo);
				
				Map<Long, Account> accountMap = new HashMap<>();
				request.setAttribute("id", userId);
				accountMap = customerMethods.viewAccount(userId);
				request.setAttribute("accountMap", accountMap);
				String path = "jsp/AdminAccountDetails.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}
			case "accountDetails":
			{
				int userId = 0;
				Map<Long, Account> accountMap = new HashMap<>();
				HttpSession session = request.getSession(false);
				String userType = (String) session.getAttribute("userType");
				try 
				{
					if (userType.equalsIgnoreCase("Admin"))
					{
						userId = Integer.parseInt(request.getParameter("id"));
						accountMap = customerMethods.viewAccount(userId);
					}
					else
					{
						int id = (int) session.getAttribute("userId");
						accountMap = customerMethods.viewAccount(id);
					}
					request.setAttribute("accountMap", accountMap);
				} 
				catch (UserDefinedException ue) 
				{
//					out.println("<p style=\"color: red; margin-top: 1%;\">" + ue.getMessage() + "</p>");
					request.setAttribute("message", ue.getMessage());
				}
				String path = "jsp/AccountDetails.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.include(request, response);
				break;
			}
			
			case "getAccount":
			{
				Map<Long, Account> accountMap = new HashMap<Long, Account>();
				Account account = new Account();
				try 
				{
					long accountNo = Long.parseLong(request.getParameter("accountNo"));
					accountMap = customerMethods.viewAccount(accountNo);
					account = accountMap.get(accountNo);
					Map<Integer, Account> acMap = new HashMap<Integer, Account>();
					acMap.put(1, account);
					request.setAttribute("account", acMap);
				} 
				catch (UserDefinedException ue) 
				{
					out.println("<p style=\"text-align: center; color: red; margin-top: 3%;\">" + ue.getMessage() + "</p>");
				}
				String path = "jsp/AccountDetails.jsp";
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.include(request, response);
				break;
			}

			case "modifyUserDetails":
			{
				long mobile = Long.parseLong(request.getParameter("mobile"));
				int id = Integer.parseInt(request.getParameter("id"));
				String mail = request.getParameter("mail");
				String dob = request.getParameter("dob");
				String name = request.getParameter("name");
				User userPojo = new User();
				userPojo.setEmail(mail);
				userPojo.setMobile(mobile);
				userPojo.setUserId(id);
				userPojo.setName(name);
				userPojo.setDob(dob);
				try
				{
					userObj.modifyUserDetails(userPojo);
					request.setAttribute("message", "Profile Updated");
				}
				catch (UserDefinedException ue)
				{
					request.setAttribute("message", ue.getMessage());
				}
				HttpSession session = request.getSession(false);
				String userType = (String) session.getAttribute("userType");
				String path = "jsp/CustomerDetails.jsp";
				if(userType.equalsIgnoreCase("Admin"))
				{
					userPojo = new User();
					userPojo = userObj.userInfo(id);
					request.setAttribute("userPojo", userPojo);
					path = "jsp/UserDetails.jsp";
				}
				else
				{
					List<Customer> customerList = userObj.viewCustomerDetails(id);
					Customer customerPojo = customerList.get(0);
					request.setAttribute("customer", customerPojo);
				}
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.forward(request, response);
				break;
			}
			
			case "modifyCustomerDetails":
			{
				long aadhaar = Long.parseLong(request.getParameter("aadhaar"));
				int id = Integer.parseInt(request.getParameter("id"));
				String pan = request.getParameter("pan");
				String dob = request.getParameter("dob");
				String name = request.getParameter("name");
				Customer customerPojo = new Customer();
				customerPojo.setAadhar(aadhaar);
				customerPojo.setPan(pan);
				customerPojo.setCustomerId(id);
				customerPojo.setName(name);
				customerPojo.setDob(dob);
				String path = "jsp/CustomerDocuments.jsp";
				try
				{
					adminMethods.modifyCustomerDetails(customerPojo);
					request.setAttribute("message", "Updated Successfully");
				}
				catch (UserDefinedException ue)
				{
					request.setAttribute("message", ue.getMessage());
				}
				List<Customer> customerList = new ArrayList<>();
				try
				{
					customerList = userObj.viewCustomerDetails(id);
				}
				catch(UserDefinedException ue)
				{
//					out.println("<p style=\"color: red; margin-top: 3%;\">" + ue.getMessage() + "</p>");
					request.setAttribute("redMessage", ue.getMessage());
				}
				if (!customerList.isEmpty())
				{
					Customer updatedCustomerPojo = customerList.get(0);
					if (updatedCustomerPojo == null)
					{
						request.setAttribute("redMessage", "No Details Availble for this User ID");
					}
					request.setAttribute("customer", updatedCustomerPojo);
				}
				RequestDispatcher dispatch = request.getRequestDispatcher(path);
				dispatch.include(request, response);
				break;
			}
			
			case "selectCustomerRequest":
			{
//				int customerId = Integer.parseInt(request.getParameter("uid"));
				List<Long> inactiveAccounts = new ArrayList<>();
				HttpSession session = request.getSession(false);
				int id = (int) session.getAttribute("userId");
				inactiveAccounts = customerMethods.getAccountsDetails(id, "INACTIVE");
				request.setAttribute("inactiveAccounts", inactiveAccounts);
				RequestDispatcher dispatch = request.getRequestDispatcher("jsp/CustomerRequest.jsp");
				dispatch.forward(request, response);
				break;
			}
			
			case "requestActivation":
			{
				long accountNo = Long.parseLong(request.getParameter("accountNo"));
				HttpSession session = request.getSession(false);
				int id = (int) session.getAttribute("userId");
				try
				{
					customerMethods.requestMessage(id, accountNo, "Requst for Activation");
					request.setAttribute("message", "Request Submitted");
				}
				catch (UserDefinedException ue)
				{
					request.setAttribute("message", ue.getMessage());
				}
				List<Long> inactiveAccounts = new ArrayList<>();
				inactiveAccounts = customerMethods.getAccountsDetails(id, "INACTIVE");
				request.setAttribute("inactiveAccounts", inactiveAccounts);
				RequestDispatcher dispatch = request.getRequestDispatcher("jsp/CustomerRequest.jsp");
				dispatch.forward(request, response);
				break;
			}
			
			case "requestDeactivation":
			{
				long accountNo = Long.parseLong(request.getParameter("accountNo"));
				HttpSession session = request.getSession(false);
				int id = (int) session.getAttribute("userId");
				try
				{
					customerMethods.requestMessage(id, accountNo, "Requst for Deactivation");
					request.setAttribute("message", "Request Submitted");
				}
				catch (UserDefinedException ue)
				{
					request.setAttribute("message", ue.getMessage());
				}
				List<Long> inactiveAccounts = new ArrayList<>();
				inactiveAccounts = customerMethods.getAccountsDetails(id, "INACTIVE");
				request.setAttribute("inactiveAccounts", inactiveAccounts);
				RequestDispatcher dispatch = request.getRequestDispatcher("jsp/CustomerRequest.jsp");
				dispatch.forward(request, response);
				break;
			}
			
			case "customerStatus":
			{
				RequestDispatcher dispatch = request.getRequestDispatcher("jsp/CustomerStatus.jsp");
				dispatch.forward(request, response);
				break;
			}
			
			case "modifyCustomerStatus":
			{
				int customerId = Integer.parseInt(request.getParameter("cid"));
				String status = request.getParameter("status");
				Customer customerPojo = new Customer();
				customerPojo.setCustomerId(customerId);
				customerPojo.setCustomerStatus(status);
				try
				{
					adminMethods.modifyCustomerDetails(customerPojo);
					if(status.equals("ACTIVE"))
					{
						request.setAttribute("greenMessage", "The CustomerId " + customerId + " is Activated");
					}
					else
					{
						request.setAttribute("redMessage", "The CustomerId " + customerId + " is De-Activated");
					}
				}
				catch (UserDefinedException ue) 
				{
					request.setAttribute("redMessage", ue.getMessage());
				}
				RequestDispatcher dispatch = request.getRequestDispatcher("jsp/CustomerStatus.jsp");
				dispatch.forward(request, response);
				break;
			}

			case "Logout":
			{
				HttpSession session = request.getSession(false);
				try
				{
					int id = (int) session.getAttribute("userId");
					userObj.setUserLogin(id, "OFFLINE");
					session.invalidate();
				}
				catch(Exception e)
				{
				
				}
				String path = "jsp/LoginPage.jsp";
				response.sendRedirect(path);
				break;
			}

			}
		}

	}
	
	

}
























