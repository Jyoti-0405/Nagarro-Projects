package com.nagarro.dao;

import java.util.List;

import com.nagarro.dto.Tshirt;

public interface TshirtDao {
	public void addTshirt(Tshirt tshirt);
	public List<Tshirt> getTshirts(String color,String size,String gender);
	public List getTshirtColors();
	public List getTshirtSizes();

}
