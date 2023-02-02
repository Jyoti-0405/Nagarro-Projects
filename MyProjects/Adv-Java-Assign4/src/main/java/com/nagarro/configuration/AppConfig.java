package com.nagarro.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.nagarro.dao.Dao;
import com.nagarro.dao.TshirtDao;
import com.nagarro.dao.TshirtFileDao;
import com.nagarro.dao.UserDao;
import com.nagarro.daoImp.DaoImp;
import com.nagarro.daoImp.TshirtDaoImp;
import com.nagarro.daoImp.TshirtFileDaoImp;
import com.nagarro.daoImp.UserDaoImp;
import com.nagarro.service.TshirtCodeLoader;
import com.nagarro.service.TshirtComparatorService;
import com.nagarro.service.TshirtLoaderService;
import com.nagarro.service.TshirtSearchService;
import com.nagarro.service.OutputPreferenceService;
import com.nagarro.service.UserService;

@Configuration
@EnableScheduling
public class AppConfig {

	@Bean
	public Dao getDao() {
		return new DaoImp();
	}

	@Bean
	public UserDao getUserDao() {
		return new UserDaoImp();
	}

	@Bean
	public TshirtDao getTshirtDao() {
		return new TshirtDaoImp();
	}

	@Bean
	public TshirtLoaderService getTshirtLoader() {
		return new TshirtLoaderService();
	}
	
	@Bean
	public TshirtSearchService getTshirtSearch() {
		return new TshirtSearchService();
	}

	@Bean
	public TshirtFileDao getTshirtFileDao() {
		return new TshirtFileDaoImp();
	}

	@Bean
	public TshirtCodeLoader getTshirtCodeLoader() {
		return new TshirtCodeLoader();
	}
	
	@Bean
	public OutputPreferenceService getOutputPreferance() {
		return new OutputPreferenceService();
	}
	
	@Bean
	public TshirtComparatorService getTshirtComparator() {
		return new TshirtComparatorService();
	}
	
	@Bean
	public UserService getUserService() {
		return new UserService();
	}

}