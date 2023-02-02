package com.nagarro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.dao.BookDAO;
import com.nagarro.entity.Book;

import jakarta.websocket.server.PathParam;

@RestController
public class BookController {

	private final BookDAO bookDao;

	@Autowired
	public BookController(BookDAO bookDao) {
		this.bookDao = bookDao;
	}

	@GetMapping("/getbooks")
	public List<Book> getBooks() {
		return bookDao.findAll(Sort.by("bookCode"));
	}

	@GetMapping("/getbook/{bookcode}")
	public Optional<Book> getBook(@PathVariable("bookcode") long bookcode) {
		System.out.println(bookcode);
		return bookDao.findById(bookcode);
	}

	@PostMapping("/addbook")
	public Book addBook(@RequestBody Book book) {
		try {
			bookDao.save(book);
		} catch (Exception e) {
			return null;
		}

		return book;
	}

	@DeleteMapping("/deletebook/{bookcode}")
	public void deleteBook(@PathVariable("bookcode") long bookcode) {
		bookDao.deleteById(bookcode);
	}
}
