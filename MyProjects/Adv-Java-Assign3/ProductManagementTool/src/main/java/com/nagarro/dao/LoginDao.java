package com.nagarro.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nagarro.model.User;



public class LoginDao {
	
	public List<User> readDatabase() {
		
		Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
	    SessionFactory sf = con.buildSessionFactory();
	    Session session = sf.openSession();
	 
	    Transaction tx = null;
	    
	    try {
	    	
		    tx = session.beginTransaction();
	    	@SuppressWarnings("unchecked")
	    	List<User> list = session.createQuery("from User").list();
	    	tx.commit();
	    	session.close();
	    	return list;
	    }
	    catch(Exception e) {
	    	System.out.println(e.getStackTrace());
	    }
		return null;
	}

}
