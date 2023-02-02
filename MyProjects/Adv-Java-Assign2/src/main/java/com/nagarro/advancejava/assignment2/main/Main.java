package com.nagarro.advancejava.assignment2.main;

import com.nagarro.advancejava.assignment2.entities.UserInputData;
import com.nagarro.advancejava.assignment2.serviceimpl.DisplayServiceImpl;
import com.nagarro.advancejava.assignment2.serviceimpl.FetchInputDataServiceImpl;
import com.nagarro.advancejava.assignment2.serviceimpl.InputServiceImpl;

/**
 * The Class Main.
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception {

		InputServiceImpl tshirtDetails = new InputServiceImpl();
		UserInputData userData = tshirtDetails.getTshirtDetails();

		FetchInputDataServiceImpl fetchData = new FetchInputDataServiceImpl();
		fetchData.getShirtList();

		DisplayServiceImpl viewData = new DisplayServiceImpl();
		viewData.viewTshirts(userData);

	}
}
