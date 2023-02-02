package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.dao.UserDAO;
import com.nagarro.entity.User;

@RestController
public class LoginController {

	private final UserDAO userDAO;

	@Autowired
	public LoginController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@PostMapping("/userauth")
	public List<User> findUser(@RequestBody User user) {
		return userDAO.getUser(user.getUsername(), user.getPassword());
	}

	@GetMapping("/users")
	public List<User> getUser() {
		return userDAO.findAll();
	}
}
