package com.nagarro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.entity.Book;

public interface BookDAO extends JpaRepository<Book, Long>{
	
}
