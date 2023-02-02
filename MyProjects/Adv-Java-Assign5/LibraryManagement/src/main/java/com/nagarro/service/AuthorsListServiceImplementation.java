package com.nagarro.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nagarro.entity.Author;
import com.nagarro.entity.User;

@Component
public class AuthorsListServiceImplementation implements AuthorsListService {

	private final RestTemplate restTemplate;
	
	@Autowired
	public AuthorsListServiceImplementation(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@Override
	public List<Author> getAuthors() {
		// TODO Auto-generated method stub
		ResponseEntity<Author[]> response = restTemplate.getForEntity(
				"http://localhost:8083/getauthors", Author[].class);
		List<Author> authors = Arrays.asList(response.getBody());
		return authors;
	}
}
