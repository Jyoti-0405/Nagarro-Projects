package com.nagarro.advancejava.assignment2.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.nagarro.advancejava.assignment2.dao.SearchTshirtsDao;
import com.nagarro.advancejava.assignment2.entities.TshirtsData;
import com.nagarro.advancejava.assignment2.entities.UserInputData;

/**
 * The Class SearchTshirtDaoImpl.
 */
public class SearchTshirtDaoImpl implements SearchTshirtsDao {
	
	/** The tshirt list. */
	List<TshirtsData> tshirtList = new ArrayList<TshirtsData>();

	/** The user data. */
	UserInputData userData = null;

	/**
	 * Instantiates a new search tshirt dao impl.
	 *
	 * @param userData the user data
	 */
	public SearchTshirtDaoImpl(UserInputData userData) {
		this.userData = userData;

	}

	/**
	 * Gets the list of T shirt.
	 *
	 * @return the list of T shirt
	 */
	@Override
	public List<TshirtsData> getListOfTShirt() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(TshirtsData.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = null;
		String color = userData.getTshirtColor();
		String size = userData.getTshirtSize();
		String gender = userData.getTshirtGender();
		query = session.createQuery(
				"from TshirtsData where tshirtColor=:c and tshirtSize=:s and tshirtGender=:g and tshirtAvailability='Y' ");
		query.setParameter("c", color);
		query.setParameter("s", size);
		query.setParameter("g", gender);

		tshirtList = query.list();
		transaction.commit();
		session.close();
		return tshirtList;

	}
}
