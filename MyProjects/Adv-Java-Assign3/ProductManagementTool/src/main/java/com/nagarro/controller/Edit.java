package com.nagarro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nagarro.model.Product;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
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
		Product prod = new Product();
		
		int productId = Integer.parseInt(request.getParameter("submit"));
		
		org.hibernate.cfg.Configuration con = new Configuration().configure().addAnnotatedClass(Product.class);
		
        SessionFactory sf = con.buildSessionFactory();
		
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        prod = (Product) session.get(Product.class, productId);
        session.update(prod);
        session.delete(prod);
        tx.commit();
        session.close();
        
        RequestDispatcher rd = request.getRequestDispatcher("product.jsp");
		rd.forward(request, response);
		
	}

}
