package com.nagarro.Product_Search_App;

import java.util.Collections;
import java.util.Comparator;


public class ProductModel {
	private String id;
	private String name;
	private String color;
	private String gen_recom;
	private String size;
	private float price;
	private float rating;
	private String avail;
	
	public ProductModel(){}
	public ProductModel(String id, String name, String color, String gen_recom,String size, float price,float rating,String avail) {
		this.id = id;
		this.name = name;
		this.color = color;
		this.gen_recom  = gen_recom;
		this.size = size;
		this.price = price;
		this.rating= rating;
		this.avail = avail;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getGen_recom() {
		return gen_recom;
	}
	public void setGen_recom(String gen_recom) {
		this.gen_recom = gen_recom;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getAvail() {
		return avail;
	}
	public void setAvail(String avail) {
		this.avail = avail;
	}
	
	

}
