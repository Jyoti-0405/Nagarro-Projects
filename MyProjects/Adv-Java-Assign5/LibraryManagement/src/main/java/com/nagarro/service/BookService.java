package com.nagarro.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.nagarro.entity.Book;

@Component
public interface BookService {
	
	public List<Book> getBooks();
	
	public Book getBook(long bookcode);
	
	public boolean addBook(Book book);

	void deleteBook(long bookcode);
}
