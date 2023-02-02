package com.nagarro.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nagarro.entity.Author;
import com.nagarro.entity.Book;

@Component
public class BookServiceImplementation implements BookService {

	private final RestTemplate restTemplate;

	@Autowired
	public BookServiceImplementation(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		ResponseEntity<Book[]> response = restTemplate.getForEntity("http://localhost:8083/getbooks", Book[].class);
		List<Book> book = Arrays.asList(response.getBody());
		return book;
	}

	@Override
	public Book getBook(long bookcode) {
		// TODO Auto-generated method stub

		ResponseEntity<Book> response = restTemplate
				.getForEntity("http://localhost:8083/getbook/" + Long.toString(bookcode), Book.class);
		Book book = response.getBody();
		return book;
	}

	@Override
	public boolean addBook(Book book) {
		// TODO Auto-generated method stub
		ResponseEntity<Book> response = restTemplate.postForEntity("http://localhost:8083/addbook", book, Book.class);
		Book books = response.getBody();
		return !books.equals(null);
	}

	@Override
	public void deleteBook(long bookcode) {
		restTemplate.delete("http://localhost:8083/deletebook/" + Long.toString(bookcode));
	}
}
