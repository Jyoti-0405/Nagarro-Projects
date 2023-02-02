package com.nagarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.TshirtDao;

@Service
public class TshirtCodeLoader {
	@Autowired
	private TshirtDao tshirtdao;
	
	public List<String> getUserColors(){
		List<String> userColors;
		userColors = tshirtdao.getTshirtColors();
		return userColors;
	}
	
	public List<String> getUserSizes(){
		List<String> userSizes;
		userSizes = tshirtdao.getTshirtSizes();
		return userSizes;
	}

}
