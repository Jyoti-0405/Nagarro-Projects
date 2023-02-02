package com.nagarro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.service.TshirtCodeLoader;
import com.nagarro.service.UserService;

@Controller
public class SignController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private TshirtCodeLoader tshirtCodeLoader;

	@RequestMapping("/SignIn")
	public ModelAndView signIn(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		String uId = request.getParameter("uId");
		String uPswd = request.getParameter("uPswd");

		if(!userService.validateUser(uId, uPswd)) {
			mv.setViewName("index");
			return mv;
		}

		List<String> userColors = tshirtCodeLoader.getUserColors();
		List<String> userSizes = tshirtCodeLoader.getUserSizes();

		mv.addObject("uId", uId);
		mv.addObject("userColors", userColors);
		mv.addObject("userSizes", userSizes);
		mv.setViewName("home");

		return mv;
	}

	@RequestMapping("/SignUp")
	public ModelAndView signUp(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		String uId = request.getParameter("uId");
		String uPswd = request.getParameter("uPswd");
		String cuPswd = request.getParameter("cuPswd");

		if (!uPswd.equals(cuPswd)) {
			mv.setViewName("index");
			return mv;
		}

		userService.saveUser(uId, uPswd);

		List<String> userColors = tshirtCodeLoader.getUserColors();
		List<String> userSizes = tshirtCodeLoader.getUserSizes();

		mv.addObject("uId", uId);
		mv.addObject("userColors", userColors);
		mv.addObject("userSizes", userSizes);
		mv.setViewName("home");
		return mv;
	}

	
	
	@RequestMapping("/SignOut")
	public ModelAndView signOut(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("uId", null);
		mv.setViewName("index");
		return mv;
	}
}