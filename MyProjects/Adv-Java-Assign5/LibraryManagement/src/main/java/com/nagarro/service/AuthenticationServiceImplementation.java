package com.nagarro.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.entity.User;

@Component
@Service
public class AuthenticationServiceImplementation implements AuthenticationService {

	private final RestTemplate restTemplate;

	@Autowired
	public AuthenticationServiceImplementation(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	@Override
	public boolean isAuthenticated(User user) {
		// TODO Auto-generated method stub
		ResponseEntity<User[]> response = restTemplate.postForEntity(
				"http://localhost:8083/userauth",user, User[].class);
		List<User> userfound = Arrays.asList(response.getBody());
		return !userfound.isEmpty();
	}
	
	
}
