package com.nagarro.daoImp;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.dao.Dao;
import com.nagarro.dao.TshirtDao;
import com.nagarro.dto.Tshirt;

public class TshirtDaoImp implements TshirtDao {

	final static Logger LOG = Logger.getLogger(TshirtDaoImp.class);

	@Autowired
	private Dao dao;

	/**
	 * This method adds a tshirt object to the thsirt table in database.
	 */
	public void addTshirt(Tshirt tshirt) {
		LOG.info("Adding new tshirt : " + tshirt.getTshirtId());

		dao.begin();

		dao.getSession().save(tshirt);

		dao.commit();
		dao.close();

		LOG.info(tshirt.getTshirtNumber() + " tshirt added successfully.");
	}

	/**
	 * This method searches for tshirts that match the method parameters i.e. the
	 * user input. predicate is an array of all the restriction that are used to
	 * filter the tshirts according to user input.
	 */
	public List<Tshirt> getTshirts(String color, String size, String gender) {
		LOG.info("Searching for tshirts according to user's input.");
	
		Tshirt tshirt = new Tshirt();

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Tshirt.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = null;
		String color1= tshirt.getTshirtColor();
		String size1 = tshirt.getTshirtSize();
		String gender1 = tshirt.getTshirtGen_recomm();
		query = session.createQuery(
				"from Tshirt where tshirtColor=:c and tshirtSize=:s and tshirtGen_recomm=:g");
		query.setParameter("c", color);
		query.setParameter("s", size);
		query.setParameter("g", gender);
		
		List<Tshirt> searchResult = query.getResultList();

		searchResult = query.list();
		
		System.out.println("The searched result is: "+searchResult);
		transaction.commit();
		session.close();
		return searchResult;
	
	}

	/**
	 * This method fetches distinct colors.
	 * 
	 * @return List of distinct colors
	 */
	public List<String> getTshirtColors() {
		LOG.info("Retrieving distinct colors.");

		List<String> colors;

		dao.begin();
		CriteriaBuilder criteriaBuilder = dao.getSession().getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
		Root<Tshirt> root = criteriaQuery.from(Tshirt.class);
		criteriaQuery.multiselect(root.get("tshirtColor")).distinct(true);

		colors = dao.getSession().createQuery(criteriaQuery).getResultList();

		return colors;
	}

	/**
	 * This method fetches distinct sizes.
	 * 
	 * @return List of distinct Sizes.
	 */
	public List<String> getTshirtSizes() {
		LOG.info("Retrieving distinct sizes.");

		List<String> sizes;

		dao.begin();
		CriteriaBuilder criteriaBuilder = dao.getSession().getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
		Root<Tshirt> root = criteriaQuery.from(Tshirt.class);
		criteriaQuery.multiselect(root.get("tshirtSize")).distinct(true);

		sizes = dao.getSession().createQuery(criteriaQuery).getResultList();

		return sizes;
	}

	

}