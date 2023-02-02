package com.nagarro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.dao.LoginDao;
import com.nagarro.model.User;



/**
 * Servlet implementation class Password
 */
public class Password extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Password() {
        super();
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
		
		String username = request.getParameter("myusername");

		LoginDao control = new LoginDao();
		
		String result = "Invalid username....";
		
		List<User> list = control.readDatabase();
		
		for(User iter:list) {
			if(iter.getUsername().equals(username)) {
				result = iter.getPassword();
			}
		}
		
		
		
		request.setAttribute("password", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("password.jsp");
		rd.forward(request, response);
		
		
	}

}
