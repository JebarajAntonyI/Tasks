package com.java.servletpack;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

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

@WebServlet("/servlet")
public class BankAjaxServlet extends HttpServlet 
{
	private UserLogin userLogin = new UserLogin();
	private UserMethods userObj = new UserMethods();
	private CustomerMethods customerMethods = new CustomerMethods();
	private AdminMethods adminMethods = new AdminMethods();


	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BankAjaxServlet() 
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			runner(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UserDefinedException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UserDefinedException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void runner(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, UserDefinedException, SQLException 
	{
		String action=null;
		JSONObject jsonObj = new JSONObject();
		JSONObject jsonResponse = null;
		
		StringBuffer buffer = new StringBuffer();
		String line = null;
		
		try
		{
			BufferedReader reader = request.getReader();
			
			line = reader.readLine();
			if(line != null)
			{
				buffer.append(line);
			}
		}
		catch(Exception e)
		{
			
		}
		
		try
		{
			jsonObj = new JSONObject(String.valueOf(buffer));
			action = jsonObj.optString("button");
		}
		catch(JSONException e)
		{
			System.out.println("Erron in JSON request String");
			e.printStackTrace();
		}
		
		
		if(action != null)
		{
			switch (action)
			{
			case "login":
			{
				HttpSession session = request.getSession(true);
				int userId = Integer.parseInt(jsonObj.optString("userId"));
				session.setAttribute("userId", userId);
				String password = jsonObj.optString("password");
				try 
				{
					if (userLogin.userIdValidation(userId) == true) 
					{
						if (userLogin.passwordValidation(userId, password) != true) 
						{
							String  obj = "{message:'Password is Wrong'}";
							jsonResponse = new JSONObject(obj);
							String json = String.valueOf(jsonResponse);
							response.getWriter().write(json);
							break;
						}
						String userType = userLogin.getUserType(userId);
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
								session.setAttribute("name", customerPojo.getName());
								session.setAttribute("accountList", accountList);
								
								String  obj = "{path:'CustomerFrame.html'}";
								jsonResponse = new JSONObject(obj);
								String json = String.valueOf(jsonResponse);
								response.getWriter().write(json);
							}
							else
							{
								String  obj = "{message:'Your ID is InActive'}";
								jsonResponse = new JSONObject(obj);
								String json = String.valueOf(jsonResponse);
								response.getWriter().write(json);
								break;
							}
						}
						else if (userType.equals("ADMIN")) 
						{
							userObj.setUserLogin(id, "ONLINE");
							User userPojo = userObj.userInfo(userId);
							session.setAttribute("name", userPojo.getName());
							
							String  obj = "{path:'AdminFrame.html'}";
							jsonResponse = new JSONObject(obj);
							String json = String.valueOf(jsonResponse);
							response.getWriter().write(json);
						}
					}
				} 
				catch (UserDefinedException e) 
				{
					String  obj = "{message:'User ID is Invalid'}";
					jsonResponse = new JSONObject(obj);
					String json = String.valueOf(jsonResponse);
					response.getWriter().write(json);
				}
				break;	
			}
			
			case "menuName":
			{
				HttpSession session = request.getSession(false);
				String name = (String) session.getAttribute("name");
				String  obj = "{name:" + name + "}";
				jsonResponse = new JSONObject(obj);
				String json = String.valueOf(jsonResponse);
				response.getWriter().write(json);
				break;
			}

			case "View All User":
			{
				List<User> userList = new ArrayList<>();
				userList = adminMethods.viewAllUsers();
				Map<Integer, User> map = new HashMap<Integer, User>();
				for(User u: userList)
				{
					map.put(u.getUserId(), u);
				}
				jsonResponse = new  JSONObject(map);
				String json = String.valueOf(jsonResponse);
				response.getWriter().write(json);
				break;
			}

			case "View All Account":
			{
				List<Account> accountList = new ArrayList<>();
				accountList = adminMethods.viewAllAccount();
				Map<Integer, Account> map = new HashMap<Integer, Account>();
				int j=0;
				for(Account a: accountList)
				{
					map.put(j, a);
					j++;
				}
				jsonResponse = new JSONObject(map);
				String json = String.valueOf(jsonResponse);
				response.getWriter().write(json);
				break;
			}
			
			case "getAccountList":
			{
				int customerId = Integer.parseInt(jsonObj.optString("id"));
				List<Long> customerAccounts = new ArrayList<>();
				try
				{
					customerAccounts = customerMethods.getAccountsDetails(customerId, "ACTIVE");
				}
				catch(UserDefinedException ue)
				{
					String redMsg = "{redMessage: '" + ue.getMessage() + "'}";
					jsonResponse = new JSONObject(redMsg);
					String json = String.valueOf(jsonResponse);
					response.getWriter().write(json);
					break;
				}
				Map<Integer, Long> map = new HashMap<Integer, Long>();
				int j=0;
				for(long l: customerAccounts)
				{
					map.put(j, l);
					j++;
				}
				jsonResponse = new JSONObject(map);
				
				if(customerAccounts.isEmpty())
				{
					String redMsg = "{redMessage: No Account is available for this User ID}";
					jsonResponse = new JSONObject(redMsg);
				}
				String json = String.valueOf(jsonResponse);
				response.getWriter().write(json);
				break;
			}
			
			case "newUser":
			{
				User userPojo = new User();
				try
				{
					String name = jsonObj.optString("name");
					long mobile = Long.parseLong(jsonObj.optString("mobile"));
					String email = jsonObj.optString("email");
					String password = jsonObj.optString("pass");
					String dob = jsonObj.optString("dob");
					String userType = jsonObj.optString("userType");
					
					
					userPojo.setName(name);
					userPojo.setMobile(mobile);
					userPojo.setEmail(email);
					userPojo.setPassword(password);
					userPojo.setDob(dob);
					userPojo.setUserType(userType);
				}
				catch(Exception e)
				{
					String redMsg = "{redMessage: Fill All Details}";
					jsonResponse = new JSONObject(redMsg);
					String json = String.valueOf(jsonResponse);
					response.getWriter().write(json);
					break;
				}

				
				try
				{
					int userId = adminMethods.createNewUser(userPojo);
					String message = "{message: User Created Successfully & User Id is " + userId + "}";
					jsonResponse = new JSONObject(message);
				}
				catch (UserDefinedException ue)
				{
					String redMsg = "{redMessage: '" + ue.getMessage() + "'}";
					jsonResponse = new JSONObject(redMsg);
				}
				String json = String.valueOf(jsonResponse);
				response.getWriter().write(json);
				break;
			}
			
			case "newCustomerDetails":
			{
				Customer customerPojo = new Customer();
				
				try
				{
					int customerId = Integer.parseInt(jsonObj.optString("id"));
					long aadhar = Long.parseLong(jsonObj.optString("aadhar"));
					String pan = jsonObj.optString("pan");
					String address = jsonObj.optString("address");
					customerPojo.setCustomerId(customerId);
					customerPojo.setAadhar(aadhar);
					customerPojo.setPan(pan);
					customerPojo.setAddress(address);
				}
				catch(Exception e)
				{
					String redMsg = "{redMessage: Fill All Details}";
					jsonResponse = new JSONObject(redMsg);
					String json = String.valueOf(jsonResponse);
					response.getWriter().write(json);
					break;
				}
				
				try
				{
					adminMethods.addCustomerDetailsOnly(customerPojo);
					String message = "{message: Customer Details Successfully Added}";
					jsonResponse = new JSONObject(message);
				}
				catch (UserDefinedException ue)
				{
					String redMsg = "{redMessage: '" + ue.getMessage() + "'}";
					jsonResponse = new JSONObject(redMsg);
				}
				String json = String.valueOf(jsonResponse);
				response.getWriter().write(json);
				break;
			}
			
			case "newCustomer":
			{
				Customer customerPojo = new Customer();
				try
				{
					String name = jsonObj.optString("name");
					long mobile = Long.parseLong(jsonObj.optString("mobile"));
					String email = jsonObj.optString("email");
					String password = jsonObj.optString("pass");
					String dob = jsonObj.optString("dob");
					String userType = jsonObj.optString("userType");
					long aadhar = Long.parseLong(jsonObj.optString("aadhar"));
					String pan = jsonObj.optString("pan");
					String address = jsonObj.optString("address");
	
					customerPojo.setName(name);
					customerPojo.setMobile(mobile);
					customerPojo.setEmail(email);
					customerPojo.setPassword(password);
					customerPojo.setDob(dob);
					customerPojo.setUserType(userType);
					customerPojo.setAadhar(aadhar);
					customerPojo.setPan(pan);
					customerPojo.setAddress(address);
				}
				catch(Exception e)
				{
					String redMsg = "{redMessage: Fill All Details}";
					jsonResponse = new JSONObject(redMsg);
					String json = String.valueOf(jsonResponse);
					response.getWriter().write(json);
					break;
				}
				try
				{
					int customerId = adminMethods.createNewCustomer(customerPojo);
					String message = "{message: Customer Created Successfully & User Id is " + customerId + "}";
					jsonResponse = new JSONObject(message);
				}
				catch (UserDefinedException ue)
				{
					String redMsg = "{redMessage: '" + ue.getMessage() + "'}";
					jsonResponse = new JSONObject(redMsg);
				}
				String json = String.valueOf(jsonResponse);
				response.getWriter().write(json);
				break;
			}

			case "newAccount":
			{
				Account accountPojo = new Account();
				int customerId = 0;
				double balance = 0;
				try
				{
					customerId = Integer.parseInt(jsonObj.optString("id"));
					balance = Double.parseDouble(jsonObj.optString("balance"));
					String accountType = jsonObj.optString("accountType");
					String ifsc="";
					String accountBranch = jsonObj.optString("accountBranch");	
				
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
					
					accountPojo.setCustomerId(customerId);
					accountPojo.setAccountBranch(accountBranch);
					accountPojo.setAccountType(accountType);
					accountPojo.setIfsc(ifsc);
				}
				catch(Exception e)
				{
					String redMsg = "{redMessage: Fill All Details}";
					jsonResponse = new JSONObject(redMsg);
					String json = String.valueOf(jsonResponse);
					response.getWriter().write(json);
					break;
				}
				try
				{
					long accountNo = adminMethods.addAccountDetails(accountPojo);
					customerMethods.depositMoney(customerId, accountNo, balance);
					String message = "{message: Account Created Successfully & Account Number is " + accountNo + "}";
					jsonResponse = new JSONObject(message);
				}
				catch (UserDefinedException ue)
				{
					String redMsg = "{redMessage: '" + ue.getMessage() + "'}";
					jsonResponse = new JSONObject(redMsg);
				}
				String json = String.valueOf(jsonResponse);
				response.getWriter().write(json);
				break;
			}

			case "showTransactionRequest":
			{
				String type = jsonObj.optString("reqType");
				if(type.equalsIgnoreCase("Pending"))
				{
					Map<Integer, TransactionRequest> requestMap = new HashMap<Integer, TransactionRequest>();
					requestMap = adminMethods.checkTransactionStatus("Pending");
					jsonResponse = new JSONObject(requestMap);
				}
				else
				{
					Map<Integer, TransactionRequest> statusMap = new HashMap<Integer, TransactionRequest>();
					statusMap = adminMethods.checkTransactionStatus(type);
					jsonResponse = new JSONObject(statusMap);
				}
				String json = String.valueOf(jsonResponse);
				response.getWriter().write(json);
				break;
			}

			case "ApproveTransaction":
			{
				int reqNo = Integer.parseInt(jsonObj.optString("reqNo"));
				adminMethods.withdrawApproval(reqNo, "Approved");
				break;
			}

			case "RejectTransaction":
			{
				int reqNo = Integer.parseInt(jsonObj.optString("reqNo"));
				adminMethods.withdrawApproval(reqNo, "Rejected");
				break;
			}

			case "showCustomerRequest":
			{
				String type = jsonObj.optString("reqType");
				if(type.equalsIgnoreCase("Pending"))
				{
					Map<Integer, CustomerRequest> requestMap = new HashMap<Integer, CustomerRequest>();
					requestMap = adminMethods.viewMessage("Pending");
					jsonResponse = new JSONObject(requestMap);
				}
				else
				{
					Map<Integer, CustomerRequest> statusMap = new HashMap<Integer, CustomerRequest>();
					statusMap = adminMethods.viewMessage(type);
					jsonResponse = new JSONObject(statusMap);
				}
				String json = String.valueOf(jsonResponse);
				response.getWriter().write(json);
				break;
			}

			case "ActivateAccount":
			{
				int reqNo = Integer.parseInt(jsonObj.optString("reqNo"));
				long acNo = Long.parseLong(jsonObj.optString("acNo"));
				Account accountPojo = new Account();
				accountPojo.setAccountNo(acNo);
				accountPojo.setAccountStatus("ACTIVE");
				adminMethods.modifyAccountDetails(accountPojo);
				adminMethods.replayMessage(reqNo, "Processed");
				break;
			}

			case "DeactivateAccount":
			{
				int reqNo = Integer.parseInt(jsonObj.optString("reqNo"));
				long acNo = Long.parseLong(jsonObj.optString("acNo"));
				Account accountPojo = new Account();
				accountPojo.setAccountNo(acNo);
				accountPojo.setAccountStatus("INACTIVE");
				adminMethods.modifyAccountDetails(accountPojo);
				adminMethods.replayMessage(reqNo, "Processed");
				break;
			}
			
			case "cancelCustomerRequest":
			{
				int reqNo = Integer.parseInt(jsonObj.optString("reqNo"));
				adminMethods.replayMessage(reqNo, "Rejected");
				break;
			}

			case "passChange":
			{
				String oldPassword = jsonObj.optString("old");
				String newPassword = jsonObj.optString("new");
				String confirmPassword = jsonObj.optString("re");
				if (newPassword.equals(confirmPassword))
				{
					HttpSession session = request.getSession(false);
					int id = (int) session.getAttribute("userId");
					try 
					{
						customerMethods.changePassword(id, oldPassword, newPassword);
						
						String message = "{message: The Password Changed Successfully}";
						jsonResponse = new JSONObject(message);
					}
					catch (UserDefinedException ue) {
						
						String redMsg = "{redMessage: '" + ue.getMessage() + "'}";
						jsonResponse = new JSONObject(redMsg);
					}
					String json = String.valueOf(jsonResponse);
					response.getWriter().write(json);
					break;
				}
				String redMsg = "{redMessage: Re entered password doesn't match with new password}";
				jsonResponse = new JSONObject(redMsg);
				String json = String.valueOf(jsonResponse);
				response.getWriter().write(json);
				break;
			}

			case "getAccountNo":
			{
				HttpSession session = request.getSession(false);
				@SuppressWarnings("unchecked")
				List<Long> accountList = (List<Long>) session.getAttribute("accountList");
//				Map<Integer, Long> acMap = new HashMap<Integer, Long>();
//				int j = 0;
//				for(long i: accountList)
//				{
//					acMap.put(j, i);
//					j++;
//				}
				String add = "{list: " + accountList +"}";
				jsonResponse = new JSONObject(add);
				String json = String.valueOf(jsonResponse);
				response.getWriter().write(json);
				break;
			}

			case "depositAmount":
			{
				long accountNo = Long.parseLong(jsonObj.optString("accountNo"));
				double depositAmount = Double.parseDouble(jsonObj.optString("amount"));
				try
				{
					HttpSession session = request.getSession(false);
					int id = (int) session.getAttribute("userId");
					customerMethods.depositMoney(id, accountNo, depositAmount);
					String message = "{message: Successfully Deposited}";
					jsonResponse = new JSONObject(message);
				}
				catch (UserDefinedException ue)
				{
					String redMsg = "{redMessage: '" + ue.getMessage() +"'}";
					jsonResponse = new JSONObject(redMsg);
				}
				String json = String.valueOf(jsonResponse);
				response.getWriter().write(json);
				break;
			}

			case "withdrawRequest":
			{
				long accountNo = Long.parseLong(jsonObj.optString("accountNo"));
				double withdrawAmount = Double.parseDouble(jsonObj.optString("amount"));
				
				try 
				{
					HttpSession session = request.getSession(false);
					int id = (int) session.getAttribute("userId");
					customerMethods.withdrawMoney(id, accountNo, withdrawAmount);
					String message = "{message: Withdraw Request Submitted}";
					
					jsonResponse = new JSONObject(message);
				}
				catch (UserDefinedException ue) 
				{
					String redMsg = "{redMessage: '" + ue.getMessage() +"'}";
					jsonResponse = new JSONObject(redMsg);
				}
				String json = String.valueOf(jsonResponse);
				response.getWriter().write(json);
				break;
			}

			case "transferAmount":
			{
				long accountNo = Long.parseLong(jsonObj.optString("accountNo"));
				long toAccount = Long.parseLong(jsonObj.optString("toAccount"));
				double depositAmount = Double.parseDouble(jsonObj.optString("amount"));
				try 
				{
					HttpSession session = request.getSession(false);
					int id = (int) session.getAttribute("userId");
					customerMethods.transferMoney(id, accountNo, toAccount, depositAmount);
					String message = "{message: Successfully Transfered to " + toAccount + "}";
					jsonResponse = new JSONObject(message);
				} 
				catch (UserDefinedException ue) 
				{
					String redMsg = "{redMessage: '" + ue.getMessage() +"'}";
					jsonResponse = new JSONObject(redMsg);
				}
				String json = String.valueOf(jsonResponse);
				response.getWriter().write(json);
				break;
			}

			case "showTransaction":
			{
				long accountNo = Long.parseLong(jsonObj.optString("accountNo"));
				int days = Integer.parseInt(jsonObj.optString("days"));
				CustomerMethods customerMethods = new CustomerMethods();
				List<Transaction> transactionList = new ArrayList<>();
				transactionList = customerMethods.getTransactionDetails(accountNo, days);
				Map<Integer, Transaction> map = new HashMap<Integer, Transaction>();
				int j = 0;
				for(Transaction t: transactionList)
				{
					map.put(j, t);
					j++;
				}
				jsonResponse = new JSONObject(map);
				String json = String.valueOf(jsonResponse);
				response.getWriter().write(json);
				break;
			}

			case "customerDetails":
			{
				int userId = 0;
				HttpSession session = request.getSession(false);
				String userType = (String) session.getAttribute("userType");
				int id = (int) session.getAttribute("userId");
				if (userType.equalsIgnoreCase("Admin"))
				{
					userId = Integer.parseInt(jsonObj.optString("id"));
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
						String redMsg = "{redMessage: '" + ue.getMessage() +"'}";
						jsonResponse = new JSONObject(redMsg);
					}
				}
				if (!customerList.isEmpty())
				{
					Customer customerPojo = null;
					customerPojo = customerList.get(0);
					if (customerPojo == null)
					{
						String redMsg = "{redMessage: No Details Availble for this User ID}";
						jsonResponse = new JSONObject(redMsg);
						String json = String.valueOf(jsonResponse);
						response.getWriter().write(json);
						break;
					}
					jsonResponse = new JSONObject(customerPojo);
				}
				String json = String.valueOf(jsonResponse);
				response.getWriter().write(json);
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
						userId = Integer.parseInt(jsonObj.optString("id"));
					}
					catch(NumberFormatException ne)
					{
						String redMsg = "{redMessage: Enter User ID}";
						jsonResponse = new JSONObject(redMsg);
						String json = String.valueOf(jsonResponse);
						response.getWriter().write(json);
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
						String redMsg = "{redMessage: '" + ue.getMessage() + "'}";
						jsonResponse = new JSONObject(redMsg);
						String json = String.valueOf(jsonResponse);
						response.getWriter().write(json);
						break;
					}
				}
				jsonResponse = new JSONObject(userPojo);
				String json = String.valueOf(jsonResponse);
				response.getWriter().write(json);
				break;
			}
			
			case "userProfile":
			{
				HttpSession session = request.getSession(false);
				int id = (int) session.getAttribute("userId");
				User userPojo = new User();
				
				try
				{
					userPojo = userObj.userInfo(id);
				}
				catch(UserDefinedException ue)
				{
					String redMsg = "{redMessage: '" + ue.getMessage() + "'}";
					jsonResponse = new JSONObject(redMsg);
				}
				jsonResponse = new JSONObject(userPojo);
				String json = String.valueOf(jsonResponse);
				response.getWriter().write(json);
				break;
			}
			
			case "AdminaccountDetails":
			{
				Map<Long, Account> accountMap = new HashMap<>();
				long userIdOrNo = Long.parseLong(jsonObj.optString("accountNo"));
				try
				{
					accountMap = customerMethods.viewAccount(userIdOrNo);
				}
				catch(UserDefinedException ue)
				{
					String redMsg = "{redMessage: '" + ue.getMessage() + "'}";
					jsonResponse = new JSONObject(redMsg);
					String json = String.valueOf(jsonResponse);
					response.getWriter().write(json);
					break;
				}
				jsonResponse = new JSONObject(accountMap);
				String json = String.valueOf(jsonResponse);
				response.getWriter().write(json);
				break;
			}
			
			case "AccountAction":
			{
				long acNumber = Long.parseLong(jsonObj.optString("accountNo"));
				Account accountPojo = new Account();
				accountPojo.setAccountNo(acNumber);
				accountPojo.setAccountStatus("INACTIVE");
				adminMethods.modifyAccountDetails(accountPojo);
				break;
			}
			
			case "AccountActivate":
			{
				long acNumber = Long.parseLong(jsonObj.optString("accountNo"));
				Account accountPojo = new Account();
				accountPojo.setAccountNo(acNumber);
				accountPojo.setAccountStatus("ACTIVE");
				adminMethods.modifyAccountDetails(accountPojo);
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
						userId = Integer.parseInt(jsonObj.optString("id"));
						accountMap = customerMethods.viewAccount(userId);
					}
					else
					{
						int id = (int) session.getAttribute("userId");
						accountMap = customerMethods.viewAccount(id);
					}
					jsonResponse = new JSONObject(accountMap);
				} 
				catch (UserDefinedException ue) 
				{
					String redMsg = "{redMessage: '" + ue.getMessage() + "'}";
					jsonResponse = new JSONObject(redMsg);
				}
				String json = String.valueOf(jsonResponse);
				response.getWriter().write(json);
				break;
			}

			case "modifyUserDetails":
			{
				int id = Integer.parseInt(jsonObj.optString("id"));
				String mail = jsonObj.optString("mail");
				long mobile = Long.parseLong(jsonObj.optString("mobile"));
				String name = jsonObj.optString("name");
				String dob = jsonObj.optString("dob");
				
				User userPojo = new User();
				userPojo.setEmail(mail);
				userPojo.setMobile(mobile);
				userPojo.setUserId(id);
				userPojo.setName(name);
				userPojo.setDob(dob);
				try
				{
					userObj.modifyUserDetails(userPojo);
					String message = "{message: Profile Updated}";
					jsonResponse = new JSONObject(message);
				}
				catch (UserDefinedException ue)
				{
					String redMsg = "{redMessage: '" + ue.getMessage() + "'}";
					jsonResponse = new JSONObject(redMsg);
				}
				String json = String.valueOf(jsonResponse);
				response.getWriter().write(json);
				break;
			}
			
			case "modifyCustomerDetails":
			{
				long aadhaar = Long.parseLong(jsonObj.optString("aadhaar"));
				int id = Integer.parseInt(jsonObj.optString("id"));
				String pan = jsonObj.optString("pan");
				String dob = jsonObj.optString("dob");
				String name = jsonObj.optString("name");
				
				Customer customerPojo = new Customer();
				customerPojo.setAadhar(aadhaar);
				customerPojo.setPan(pan);
				customerPojo.setCustomerId(id);
				customerPojo.setName(name);
				customerPojo.setDob(dob);
				try
				{
					adminMethods.modifyCustomerDetails(customerPojo);
					String message = "{message: Updated Successfully}";
					jsonResponse = new JSONObject(message);
				}
				catch (UserDefinedException ue)
				{
					String redMsg = "{redMessage: '" + ue.getMessage() + "'}";
					jsonResponse = new JSONObject(redMsg);
				}
				String json = String.valueOf(jsonResponse);
				response.getWriter().write(json);
				break;
			}
			
			case "selectCustomerRequest":
			{
				HttpSession session = request.getSession(false);
				@SuppressWarnings("unchecked")
				List<Long> accountList = (List<Long>) session.getAttribute("accountList");
				List<Long> inactiveAccounts = new ArrayList<>();
				int id = (int) session.getAttribute("userId");
				inactiveAccounts = customerMethods.getAccountsDetails(id, "INACTIVE");
				String add = "{accountList: " + accountList +", inactiveAcc: " + inactiveAccounts + "}";
				jsonResponse = new JSONObject(add);
				String json = String.valueOf(jsonResponse);
				response.getWriter().write(json);
				break;
			}
			
			case "requestActivation":
			{
				try
				{
					long accountNo = Long.parseLong(jsonObj.optString("accountNo"));
					
					HttpSession session = request.getSession(false);
					int id = (int) session.getAttribute("userId");
					try
					{
						customerMethods.requestMessage(id, accountNo, "Requst for Activation");
						String message = "{message: Request Submitted}";
						jsonResponse = new JSONObject(message);
					}
					catch (UserDefinedException ue)
					{
						String redMsg = "{redMessage: '" + ue.getMessage() +"'}";
						jsonResponse = new JSONObject(redMsg);
					}
				}
				catch(NumberFormatException ne)
				{
					String redMsg = "{redMessage: Select Account}";
					jsonResponse = new JSONObject(redMsg);
				}
				String json = String.valueOf(jsonResponse);
				response.getWriter().write(json);
				break;
			}
			
			case "requestDeactivation":
			{
				try
				{
					long accountNo = Long.parseLong(jsonObj.optString("accountNo"));
					HttpSession session = request.getSession(false);
					int id = (int) session.getAttribute("userId");
					try
					{
						customerMethods.requestMessage(id, accountNo, "Requst for Deactivation");
						String message = "{message: Request Submitted}";
						jsonResponse = new JSONObject(message);
					}
					catch (UserDefinedException ue)
					{
						String redMsg = "{redMessage: '" + ue.getMessage() +"'}";
						jsonResponse = new JSONObject(redMsg);
					}
				}
				catch(NumberFormatException ne)
				{
					String redMsg = "{redMessage: Select Account}";
					jsonResponse = new JSONObject(redMsg);
				}
				String json = String.valueOf(jsonResponse);
				response.getWriter().write(json);
				break;
			}
			
			case "modifyCustomerStatus":
			{
				int customerId = Integer.parseInt(jsonObj.optString("cid"));
				String status = jsonObj.optString("status");
				Customer customerPojo = new Customer();
				customerPojo.setCustomerId(customerId);
				customerPojo.setCustomerStatus(status);
				try
				{
					adminMethods.modifyCustomerDetails(customerPojo);
					if(status.equals("ACTIVE"))
					{
						String message = "{message: The CustomerId " + customerId + " is Activated}";
						jsonResponse = new JSONObject(message);
					}
					else
					{
						String redMsg = "{redMessage: The CustomerId " + customerId + " is De-Activated}";
						jsonResponse = new JSONObject(redMsg);
					}
				}
				catch (UserDefinedException ue) 
				{
					String redMsg = "{redMessage: '" + ue.getMessage() +"'}";
					jsonResponse = new JSONObject(redMsg);
				}
				String json = String.valueOf(jsonResponse);
				response.getWriter().write(json);
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
				break;
			}

			}
		}

	}
	
	

}
























