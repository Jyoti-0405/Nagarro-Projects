package com.nagarro.advancejava.assignment2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The Class TshirtsData.
 */
@Entity
public class TshirtsData {
	
	/** The tshirt id. */
	@Id
	@Column(name="ID")
	private String tshirtId;
	
	/** The model name. */
	@Column(name="NAME")
	private String modelName;
	
	/** The tshirt color. */
	@Column(name="COLOR")
	private String tshirtColor;
	
	/** The tshirt size. */
	@Column(name="SIZE")
	private String tshirtSize;
	
	/** The tshirt gender. */
	@Column(name="GENDER_RECOMMENDATION")
	private String tshirtGender;
	
	/** The tshirt price. */
	@Column(name="PRICE")
	private double tshirtPrice;
	
	/** The tshirt rating. */
	@Column(name="RATING")
	private float tshirtRating;
	
	/** The tshirt availability. */
	@Column(name="AVAILABILITY")
	private String tshirtAvailability;

	/**
	 * Instantiates a new tshirts data.
	 *
	 * @param tshirtId the tshirt id
	 * @param modelName the model name
	 * @param tshirtColor the tshirt color
	 * @param tshirtSize the tshirt size
	 * @param tshirtGender the tshirt gender
	 * @param tshirtPrice the tshirt price
	 * @param tshirtRating the tshirt rating
	 * @param tshirtAvailability the tshirt availability
	 */
	public TshirtsData(String tshirtId, String modelName, String tshirtColor, String tshirtSize, String tshirtGender,
			double tshirtPrice, float tshirtRating, String tshirtAvailability) {
		super();
		this.tshirtId = tshirtId;
		this.modelName = modelName;
		this.tshirtColor = tshirtColor;
		this.tshirtSize = tshirtSize;
		this.tshirtGender = tshirtGender;
		this.tshirtPrice = tshirtPrice;
		this.tshirtRating = tshirtRating;
		this.tshirtAvailability = tshirtAvailability;
	}

	/**
	 * Instantiates a new tshirts data.
	 */
	public TshirtsData() {
	}

	/**
	 * Gets the tshirt id.
	 *
	 * @return the tshirt id
	 */
	public String getTshirtId() {
		return tshirtId;
	}

	/**
	 * Sets the tshirt id.
	 *
	 * @param tshirtId the new tshirt id
	 */
	public void setTshirtId(String tshirtId) {
		this.tshirtId = tshirtId;
	}

	/**
	 * Gets the model name.
	 *
	 * @return the model name
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * Sets the model name.
	 *
	 * @param modelName the new model name
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	/**
	 * Gets the tshirt color.
	 *
	 * @return the tshirt color
	 */
	public String getTshirtColor() {
		return tshirtColor;
	}

	/**
	 * Sets the tshirt color.
	 *
	 * @param tshirtColor the new tshirt color
	 */
	public void setTshirtColor(String tshirtColor) {
		this.tshirtColor = tshirtColor;
	}

	/**
	 * Gets the tshirt size.
	 *
	 * @return the tshirt size
	 */
	public String getTshirtSize() {
		return tshirtSize;
	}

	/**
	 * Sets the tshirt size.
	 *
	 * @param tshirtSize the new tshirt size
	 */
	public void setTshirtSize(String tshirtSize) {
		this.tshirtSize = tshirtSize;
	}

	/**
	 * Gets the tshirt gender.
	 *
	 * @return the tshirt gender
	 */
	public String getTshirtGender() {
		return tshirtGender;
	}

	/**
	 * Sets the tshirt gender.
	 *
	 * @param tshirtGender the new tshirt gender
	 */
	public void setTshirtGender(String tshirtGender) {
		this.tshirtGender = tshirtGender;
	}

	/**
	 * Gets the tshirt price.
	 *
	 * @return the tshirt price
	 */
	public double getTshirtPrice() {
		return tshirtPrice;
	}

	/**
	 * Sets the tshirt price.
	 *
	 * @param tshirtPrice the new tshirt price
	 */
	public void setTshirtPrice(double tshirtPrice) {
		this.tshirtPrice = tshirtPrice;
	}

	/**
	 * Gets the tshirt rating.
	 *
	 * @return the tshirt rating
	 */
	public float getTshirtRating() {
		return tshirtRating;
	}

	/**
	 * Sets the tshirt rating.
	 *
	 * @param tshirtRating the new tshirt rating
	 */
	public void setTshirtRating(float tshirtRating) {
		this.tshirtRating = tshirtRating;
	}

	/**
	 * Gets the tshirt availability.
	 *
	 * @return the tshirt availability
	 */
	public String getTshirtAvailability() {
		return tshirtAvailability;
	}

	/**
	 * Sets the tshirt availability.
	 *
	 * @param tshirtAvailability the new tshirt availability
	 */
	public void setTshirtAvailability(String tshirtAvailability) {
		this.tshirtAvailability = tshirtAvailability;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return String.format("%-14s", this.tshirtId) + "|" + String.format("%-37s", this.modelName) + "|"
				+ String.format("%-10s", this.tshirtColor) + "|" + String.format("%-5s", this.tshirtGender) + "|"
				+ String.format("%-10s", this.tshirtSize) + "|" + String.format("%-6s", this.tshirtPrice) + "|"
				+ String.format("%-6s", this.tshirtRating) + "|" + this.tshirtAvailability;
	}
}
