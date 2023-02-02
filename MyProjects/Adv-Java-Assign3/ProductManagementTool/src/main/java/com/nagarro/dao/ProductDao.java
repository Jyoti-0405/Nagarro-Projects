package com.nagarro.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nagarro.model.Product;


public class ProductDao {
	
	public void writeToDatabase(Product product) {
		
			Product prod = new Product();
			
			prod.setTitle(product.getTitle());
			prod.setQuantity(product.getQuantity());
			prod.setSize(product.getSize());
			prod.setImage(product.getImage());
			
			Configuration con = new Configuration().configure().addAnnotatedClass(Product.class);
			
	        SessionFactory sf = con.buildSessionFactory();
    		
	        Session session = sf.openSession();

	
	        Transaction tx = session.beginTransaction();
	
	        session.save(prod);
	        
	        tx.commit();
		
	}
	
	public List<Product> fetchProduct(){

		Configuration con = new Configuration().configure().addAnnotatedClass(Product.class);
	    SessionFactory sf = con.buildSessionFactory();
	    Session session = sf.openSession();
	 
	    Transaction tx = null;
	    
	    try {
	    	
		    tx = session.beginTransaction();
	    	@SuppressWarnings("unchecked")
	    	List<Product> list = session.createQuery("from Product").list();
	    	tx.commit();
	    	session.close();
	    	return list;
	    }
	    catch(Exception e) {
	    	System.out.println(e.getStackTrace());
	    	System.out.println(e.getMessage());
	    }
		return null;
	}
	
	public List<Product> buildProductModel(List<Product> list) {
		
		
		Iterator<Product> iterator = list.iterator();
    	List<Product> productList = new ArrayList<Product>();
		while(iterator.hasNext()) {
			Product product = (Product) iterator.next();
    		productList.add(new Product(product.getProductId(), product.getTitle(), product.getQuantity(), product.getSize(), product.getImage()));
    	}
		return productList;
	}
	
	public List<Product> getProduct(){
		
		List<Product> list = fetchProduct();
		List<Product> productList = buildProductModel(list);
		return productList;
	}
}
