package com.nagarro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.nagarro.entity.User;

public interface UserDAO extends JpaRepository<User, Integer> {
	
	@Query("from User user where user.username=?1 and user.password=?2")
	List<User> getUser(String username,String password);
}
