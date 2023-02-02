package com.nagarro.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.nagarro.entity.Author;

@Component
public interface AuthorsListService {
	
	public List<Author> getAuthors();
}
