package com.nagarro.daoImp;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.dao.Dao;
import com.nagarro.dao.TshirtFileDao;
import com.nagarro.dto.Tshirt;
import com.nagarro.dto.TshirtFile;

public class TshirtFileDaoImp implements TshirtFileDao {

	final static Logger LOG = Logger.getLogger(TshirtFileDaoImp.class);

	@Autowired
	Dao dao;

	public List<TshirtFile> getAllTshirtFiles() {
		LOG.info("Retrieving all tshirtFile  object of read files.");

		dao.begin();
		
//		Criteria criteria = dao.getSession().createCriteria(TshirtFile.class);
//		List<TshirtFile> tshirtFiles = (List<TshirtFile>) criteria.list();
		
		CriteriaBuilder criteriaBuilder = dao.getSession().getCriteriaBuilder();
		CriteriaQuery<TshirtFile> criteriaQuery = criteriaBuilder.createQuery(TshirtFile.class);
		Root<TshirtFile> root = criteriaQuery.from(TshirtFile.class);
	    
		Query<TshirtFile> query = dao.getSession().createQuery(criteriaQuery);
		List<TshirtFile> tshirtFiles = query.getResultList();
		
		dao.commit();
		dao.close();

		LOG.info("Retrieved all tshirtFile  objects of read files successfully.");
		return tshirtFiles;
	}

	public TshirtFile getTshirtFile(String fileName) {
		LOG.info("Retrieving tshirtFile  object of : " + fileName);

		dao.begin();

		TshirtFile tshirtFile = (TshirtFile) dao.getSession().get(TshirtFile.class, fileName);

		dao.commit();
		dao.close();
		
		LOG.info("Retrieved TshirtFile object of " + fileName + " successfully.");
		return tshirtFile;
	}

	public void updateTshirtFile(TshirtFile tshirtFile) {
		LOG.info("Updating tshirtFile  object of " + tshirtFile.getFileName());
		
		dao.begin();

		dao.getSession().update(tshirtFile);

		dao.commit();
		dao.close();
		
		LOG.info("Updated tshirtFile  object of " + tshirtFile.getFileName() + " successfully.");
	}

	public void addTshirtFile(TshirtFile newTshirtFile) {
		LOG.info("Adding tshirtFile object of " + newTshirtFile.getFileName());
		
		dao.begin();

		dao.getSession().save(newTshirtFile);

		dao.commit();
		dao.close();

		LOG.info("Added tshirtFile object of " + newTshirtFile.getFileName() + " successfully.");
	}

}