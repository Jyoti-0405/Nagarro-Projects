package com.nagarro.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserModel {
	
	@Id
	private String username;
	private String password;
	
	public UserModel() {}
	
	public UserModel(String userName,String password)
	{
		this.username = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return username;
	}
	public void setUserName(String userName) {
		this.username = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
