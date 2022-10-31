package com.java.servletpack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TrailServlet
 */
@WebServlet("/servlet")
public class TrailServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrailServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		runner(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		runner(request, response);
	}

	private void runner(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action = request.getParameter("action");
		System.out.println(action);
		String url = request.getServletPath();
		System.out.println(url);
//		switch(url)
//		{
//		case"/":
//			String path = "jsp/LoginPage.jsp";
//			response.sendRedirect(path);
//			break;
//		}
		if(action != null)
		switch (action)
		{
		case "Login":
		{
			int userId = Integer.parseInt(request.getParameter("uid"));
			String path = "jsp/CustomerFrame.jsp";
			if (userId == 1) 
			{
				path = "jsp/AdminFrame.jsp";
			}
			RequestDispatcher dispatch = request.getRequestDispatcher(path);
			dispatch.forward(request, response);
			break;
		}
		
		case "Admin Home":
		{
			String path = "jsp/AdminHome.jsp";
//			response.sendRedirect(path);
			RequestDispatcher dispatch = request.getRequestDispatcher(path);
			dispatch.forward(request, response);
			break;
		}
		
		case "View All User":
		{
			String path = "jsp/AllUser.jsp";
			RequestDispatcher dispatch = request.getRequestDispatcher(path);
			dispatch.forward(request, response);
			break;
		}
		
		case "View All Account":
		{
			String path = "jsp/AllAccount.jsp";
			RequestDispatcher dispatch = request.getRequestDispatcher(path);
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
		
		case "Add New Account":
		{
			String path = "jsp/AddAccount.jsp";
			RequestDispatcher dispatch = request.getRequestDispatcher(path);
			dispatch.forward(request, response);
			break;
		}
		
		case "View Transaction Request":
		{
			String path = "jsp/TransactionRequest.jsp";
			RequestDispatcher dispatch = request.getRequestDispatcher(path);
			dispatch.forward(request, response);
			break;
		}
		
		case "View Customer Request":
		{
			String path = "jsp/CustomerRequest.jsp";
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
		
		case "Customer Home":
		{
			String path = "jsp/CustomerHome.jsp";
			RequestDispatcher dispatch = request.getRequestDispatcher(path);
			dispatch.forward(request, response);
			break;
		}
		
		case "Deposit":
		{
			String path = "jsp/Deposit.jsp";
			RequestDispatcher dispatch = request.getRequestDispatcher(path);
			dispatch.forward(request, response);
			break;
		}
		
		case "Withdraw":
		{
			String path = "jsp/Deposit.jsp";
			RequestDispatcher dispatch = request.getRequestDispatcher(path);
			dispatch.forward(request, response);
			break;
		}
		
		case "Transfer":
		{
			String path = "jsp/Transfer.jsp";
			RequestDispatcher dispatch = request.getRequestDispatcher(path);
			dispatch.forward(request, response);
			break;
		}
		
		case "Transaction Details":
		{
			String path = "jsp/TransactionDetails.jsp";
			RequestDispatcher dispatch = request.getRequestDispatcher(path);
			dispatch.forward(request, response);
			break;
		}
		
		case "Profile":
		{
			String path = "jsp/CustomerDetails.jsp";
			RequestDispatcher dispatch = request.getRequestDispatcher(path);
			dispatch.forward(request, response);
			break;
		}
		
		case "Logout":
		{
			String path = "jsp/LoginPage.jsp";
			response.sendRedirect(path);
			break;
		}
		
		}
	}

}
























