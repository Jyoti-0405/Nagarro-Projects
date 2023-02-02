package com.nagarro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nagarro.dao.LoginDao;
import com.nagarro.model.User;

/**
 * Servlet implementation class Authenticator
 */

public class Authenticator extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Authenticator() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("mypassword");
		System.out.println(username);
		System.out.println(password);
		if (authenticate(username, password)) {

			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("product.jsp");
			return;
		} else {
			response.sendRedirect("index.jsp");
			return;
		}
	}

	public boolean authenticate(String username, String password) {

		LoginDao control = new LoginDao();
		boolean result = false;

		List<User> list = control.readDatabase();

		for (User iter : list) {
			
			System.out.println(iter.getUsername());
			if (iter.getUsername().equals(username) && iter.getPassword().equals(password)) {
				result = true;
			}
		}

		return result;
	}

}
