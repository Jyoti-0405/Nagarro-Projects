package com.nagarro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.entity.User;
import com.nagarro.service.AuthenticationService;

@Controller
public class LoginController {

	private final AuthenticationService authenticationService;
	
	@Autowired
	public LoginController(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}
	
	@RequestMapping(value = "UserAuthentication", method = RequestMethod.POST)
	public String userAuthentication(@RequestParam("username") String username,
			@RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response) {

		User user = new User(username,password);
		
		boolean isauth = authenticationService.isAuthenticated(user);
		
		if (isauth == false) {
			setAuth(request, null);
			return "redirect:/login";
		}

		setAuth(request, user);
		return "redirect:/booksList";
	}

	@RequestMapping(value = "/login")
	public String loginPage(HttpServletRequest request, HttpServletResponse response) {
		return "login";
	}

	@RequestMapping(value = "/")
	public String homePage(HttpServletRequest request, HttpServletResponse response) {
		setAuth(request, new User());
		return "login";
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response)
	{
		setAuth(request,null);
		removeSession(request);
		return "redirect:/";
	}
	
	private void setAuth(HttpServletRequest request, User user) {
		HttpSession session = request.getSession();
		session.setAttribute("authentication", user);
	}
	
	private void removeSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("authentication");
		session.invalidate();
	}
}
