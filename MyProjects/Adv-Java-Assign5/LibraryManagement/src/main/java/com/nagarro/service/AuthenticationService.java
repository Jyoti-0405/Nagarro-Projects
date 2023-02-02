package com.nagarro.service;

import org.springframework.stereotype.Component;

import com.nagarro.entity.User;

@Component
public interface AuthenticationService {
	public boolean isAuthenticated(User user);
}
