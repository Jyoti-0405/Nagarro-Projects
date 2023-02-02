package com.nagarro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.dto.Tshirt;
import com.nagarro.service.TshirtSearchService;
import com.nagarro.service.OutputPreferenceService;

@Controller
public class SearchController {

	@Autowired
	private TshirtSearchService tshirtSearch;
	
	@Autowired
	private OutputPreferenceService outputPreference;

	@RequestMapping("/search")
	public ModelAndView searchTshirts(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		String color = request.getParameter("color").toString();
		String size = request.getParameter("size").toString();
		
		String gender = request.getParameter("gender").toString();
		int sortBy = Integer.parseInt(request.getParameter("sortBy").toString());
		
		System.out.print("color: "+color);
		System.out.print("size: " +size);
		System.out.print("gender :"+gender);
		System.out.print("sortBy:"+sortBy);
		
		
		List<Tshirt> searchResult = tshirtSearch.getSearchResult(color,size,gender);
		outputPreference.sortTshirts(searchResult, sortBy);
		
		
		mv.addObject("searchResult", searchResult);
		mv.setViewName("result");
		return mv;
	}

}