package com.nagarro.advancejava.assignment2.entities;
/**
 * The Class UserInputData.
 */
public class UserInputData {
	
	/** The tshirt color. */
	private String tshirtColor;
	
	/** The tshirt size. */
	private String tshirtSize;
	
	/** The tshirt gender. */
	private String tshirtGender;
	
	/** The input preference. */
	private int inputPreference;

	/**
	 * Instantiates a new user input data.
	 */
	public UserInputData() {

	}

	/**
	 * Instantiates a new user input data.
	 *
	 * @param tshirtColor the tshirt color
	 * @param tshirtSize the tshirt size
	 * @param tshirtGender the tshirt gender
	 * @param inputPreference the input preference
	 */
	public UserInputData(String tshirtColor, String tshirtSize, String tshirtGender, int inputPreference) {
		super();
		this.tshirtColor = tshirtColor;
		this.tshirtSize = tshirtSize;
		this.tshirtGender = tshirtGender;
		this.inputPreference = inputPreference;
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
	 * Gets the input preference.
	 *
	 * @return the input preference
	 */
	public int getInputPreference() {
		return inputPreference;
	}

	/**
	 * Sets the input preference.
	 *
	 * @param inputPreference the new input preference
	 */
	public void setInputPreference(int inputPreference) {
		this.inputPreference = inputPreference;
	}

}
