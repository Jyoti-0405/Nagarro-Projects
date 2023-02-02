package com.nagarro.dao;

import org.hibernate.Session;

public interface Dao {
	public Session getSession();
	public void begin();
	public void commit();
	public void rollback();
	public void close();

}
