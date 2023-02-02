package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.dao.AuthorDAO;
import com.nagarro.entity.Author;

@RestController
public class AuthorController {

	private final AuthorDAO authorDAO;
	
	@Autowired
	public AuthorController(AuthorDAO authorDAO) {
		this.authorDAO = authorDAO;
	}
	
	@PostMapping("/addauthor")
	public Author addAuthor(@RequestBody Author author) {
		authorDAO.save(author);
		return author;
	}
	
	@GetMapping("/getauthors")
	public List<Author> getAuthors(){
		return authorDAO.findAll();
	}
}
