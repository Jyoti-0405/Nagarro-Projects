package com.nagarro.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	@Id
	String uId;
	String uPswd;
	
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuPswd() {
		return uPswd;
	}
	public void setuPswd(String uPswd) {
		this.uPswd = uPswd;
	}
	

}
