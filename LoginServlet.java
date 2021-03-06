package com.niit.onlineshoping.controler;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.onlineshoping.dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String userid=(String) request.getParameter("userid");
		String passid=(String) request.getParameter("passid");
		
		UserDao UserDao = new UserDao();
		
		if(UserDao.isValidCredentials(userid, passid) == true)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("newindex.jsp");
			dispatcher.forward(request, response);
		}
		else{
			PrintWriter out= response.getWriter();
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
			out.append("<div  style=color:white>Invalid Credentials</div> ");
			dispatcher.include(request, response);
			
			
			
			
		}
		
		
	}

}
