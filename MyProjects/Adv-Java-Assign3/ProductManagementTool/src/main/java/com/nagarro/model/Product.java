package com.nagarro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	
	private String title;
	private int quantity;
	private int size;
	private String image;
	
	 public Product(String title, int quantity, int size, String image) {
		 this.title = title;
		 this.quantity = quantity;
		 this.size = size;
		 this.image = image;
	}
	 
	public Product() {
		
	}
	 
	public Product(int productId, String title, int quantity, int size, String image) {
		 this.title = title;
		 this.quantity = quantity;
		 this.size = size;
		 this.image = image;
		 this.productId = productId;
	}

	public int getProductId() {
		return this.productId;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}


}
