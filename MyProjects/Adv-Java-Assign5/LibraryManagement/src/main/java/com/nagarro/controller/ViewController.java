package com.nagarro.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.Session;
import com.nagarro.entity.Book;
import com.nagarro.service.AuthorsListService;
import com.nagarro.service.BookService;

@Controller
public class ViewController {

	private final AuthorsListService authorsListService;

	private final BookService bookService;

	@Autowired
	public ViewController(AuthorsListService authorsListService, BookService bookService) {
		this.authorsListService = authorsListService;
		this.bookService = bookService;
	}

	@RequestMapping(value = "/booksList")
	public ModelAndView booksList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("bookslist");
		modelAndView.addObject("books", bookService.getBooks());
		return modelAndView;
	}

	@RequestMapping(value = "/editbookpage")
	public ModelAndView editBookPage(@RequestParam("bookcode") long bookcode, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("editbooks");
		modelAndView.addObject("book", bookService.getBook(bookcode));
		modelAndView.addObject("authors", authorsListService.getAuthors());
		return modelAndView;
	}

	@RequestMapping(value = "/editbook/{bookcode}")
	public ModelAndView editBook(@PathVariable("bookcode") long bookcode, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("redirect:/editbookpage");
		modelAndView.addObject("bookcode", bookcode);
		return modelAndView;
	}

	@RequestMapping(value = "/editbookdetail")
	public ModelAndView editBookDetail(@RequestParam("bookcode") long bookcode,
			@RequestParam("bookname") String bookname, @RequestParam("author") String author,
			@RequestParam("date") String date, HttpServletRequest request, HttpServletResponse response) {

		Book book = new Book(bookcode, bookname, author, date);
		bookService.addBook(book);

		ModelAndView modelAndView = new ModelAndView("redirect:/booksList");
		modelAndView.addObject("bookcode", bookcode);
		return modelAndView;
	}

	@RequestMapping(value = "/deletebook/{bookcode}")
	public ModelAndView deleteBook(@PathVariable("bookcode") long bookcode, HttpServletRequest request,
			HttpServletResponse response) {
		bookService.deleteBook(bookcode);
		ModelAndView modelAndView = new ModelAndView("redirect:/booksList");
		modelAndView.addObject("books", bookService.getBooks());
		return modelAndView;
	}

	@RequestMapping(value = "/addbook")
	public ModelAndView addBook(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("addbook");
		modelAndView.addObject("authors", authorsListService.getAuthors());
		modelAndView.addObject("date", getCurrentDate());
		return modelAndView;
	}

	@RequestMapping(value = "/addingbook", method = RequestMethod.POST)
	public String addingBook(@RequestParam("bookcode") long bookcode, @RequestParam("bookname") String bookname,
			@RequestParam("author") String author, @RequestParam("date") String date, HttpServletRequest request,
			HttpServletResponse response) {
		boolean isValid = checkBookCode(bookcode);
		if (isValid) {
			Book book = new Book(bookcode, bookname, author, date);
			bookService.addBook(book);
			return "redirect:/booksList";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("isCodeUnique", true);
			return "redirect:/addbook";
		}
	}

	private boolean checkBookCode(long bookcode) {
		Book book = bookService.getBook(bookcode);
		if (book == null) {
			return true;
		}
		return false;
	}

	private String getCurrentDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
		Date date = new Date();
		return formatter.format(date).toString();
	}
}
