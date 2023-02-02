package com.nagarro.advancejava.assignment2.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nagarro.advancejava.assignment2.dao.AddTshirtsDao;
import com.nagarro.advancejava.assignment2.entities.TshirtsData;

public class AddTshirtsDaoImpl implements AddTshirtsDao {

	/**
	 * Adds the tshirts dao.
	 *
	 * @param tShirtList the t shirt list
	 */
	@Override

	public void addTshirtsDao(List<TshirtsData> tShirtList) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(TshirtsData.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		for (TshirtsData tShirt : tShirtList) {
			session.save(tShirt);
		}
		transaction.commit();
		session.close();
	}

}
