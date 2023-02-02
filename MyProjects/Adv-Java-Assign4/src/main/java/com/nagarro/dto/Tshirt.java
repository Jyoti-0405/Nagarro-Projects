package com.nagarro.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tshirts")
public class Tshirt {
	
	@Id
	@GeneratedValue
	private int tshirtId;
	private String tshirtNumber;
	private String tshirtName;
	private String tshirtColor;
	private String tshirtGen_recomm;
	private String tshirtSize;
	private double tshirtPrice;
	private double tshirtRating;
	private String tshirtAvailability;
	
	public String getTshirtNumber() {
		return tshirtNumber;
	}
	public void setTshirtNumber(String tshirtNumber) {
		this.tshirtNumber = tshirtNumber;
	}
	public String getTshirtName() {
		return tshirtName;
	}
	public void setTshirtName(String tshirtName) {
		this.tshirtName = tshirtName;
	}
	public String getTshirtColor() {
		return tshirtColor;
	}
	public void setTshirtColor(String tshirtColor) {
		this.tshirtColor = tshirtColor;
	}
	public String getTshirtGen_recomm() {
		return tshirtGen_recomm;
	}
	public void setTshirtGen_recomm(String tshirtGen_recomm) {
		this.tshirtGen_recomm = tshirtGen_recomm;
	}
	public String getTshirtSize() {
		return tshirtSize;
	}
	public void setTshirtSize(String tshirtSize) {
		this.tshirtSize = tshirtSize;
	}
	public double getTshirtPrice() {
		return tshirtPrice;
	}
	public void setTshirtPrice(double tshirtPrice) {
		this.tshirtPrice = tshirtPrice;
	}
	public double getTshirtRating() {
		return tshirtRating;
	}
	public void setTshirtRating(double tshirtRating) {
		this.tshirtRating = tshirtRating;
	}
	public String getTshirtAvailability() {
		return tshirtAvailability;
	}
	public void setTshirtAvailability(String tshirtAvailability) {
		this.tshirtAvailability = tshirtAvailability;
	}
	
	public int getTshirtId() {
		return tshirtId;
	}
	public void setTshirtId(int tshirtId) {
		this.tshirtId = tshirtId;
	}
	@Override
	public String toString() {
		String tshirtDetails="";
		
		tshirtDetails = "[ "+this.getTshirtNumber()+"|"+ this.getTshirtName()+"|"+this.getTshirtColor()+"|"+this.getTshirtGen_recomm()
		+"|"+this.getTshirtSize()+"|"+this.getTshirtPrice()+"|"+this.getTshirtRating()+"|"+this.getTshirtAvailability()+"|";
		
		return tshirtDetails;
	}
	
	

}
