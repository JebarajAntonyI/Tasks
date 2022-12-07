package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet 
{
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		
	}

	/**
	 * @throws IOException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
    	response.getWriter().write("");
	}
    
    
//    private void runner(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, UserDefinedException, SQLException 
//	{
//		PrintWriter out = response.getWriter();
//
//		String action = request.getParameter("action");
//		System.out.println(action);
//		if(action != null)
//		{
//			switch (action)
//			{
//				case "allAccounts":
//				{
//					List<Account> accountList = new ArrayList<>();
//					accountList = adminMethods.viewAllAccount();
//					request.setAttribute("accountList", accountList);
//					String path = "jsp/AllAccount.jsp";
//					RequestDispatcher dispatch = request.getRequestDispatcher(path);
//					dispatch.forward(request, response);
//					break;
//				}
//			}
//		}
//
//	}


}
