package com.nagarro.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.TshirtDao;
import com.nagarro.dto.Tshirt;


/**
 * TshirtSearch class searches tshirts according to user's input.
 * 
 * 
 */
@Service
public class TshirtSearchService {

	@Autowired
	private TshirtDao tshirtdao;

	/**
	 * This method takes in arguments from the controller method and passes it to
	 * the dao layer to get the list of matching tshirts.
	 * 
	 * @param color
	 * @param size
	 * @param gender
	 * @return List of matching tshirts.
	 */
	public List<Tshirt> getSearchResult(String color,String size,String gender) {
		List<Tshirt> searchResult;

		searchResult = tshirtdao.getTshirts(color,size, gender);

		return searchResult;
	}

}