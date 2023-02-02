package com.nagarro.advancejava.assignment2.dao;

import java.util.List;

import com.nagarro.advancejava.assignment2.entities.TshirtsData;

public interface SearchTshirtsDao {
	
	/**
	 * Gets the list of T shirt.
	 *
	 * @return the list of T shirt
	 */
	List<TshirtsData> getListOfTShirt();
}
