package com.nagarro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.entity.Author;

public interface AuthorDAO extends JpaRepository<Author, Integer>{
	
}
