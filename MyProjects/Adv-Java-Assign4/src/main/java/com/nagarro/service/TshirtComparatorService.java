package com.nagarro.service;

import java.util.Comparator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.nagarro.dto.Tshirt;

public class TshirtComparatorService {
	final static Logger LOG = Logger.getLogger(TshirtComparatorService.class);
	
	public Comparator<Tshirt> getTshirtComparatorByPrice(){
		LOG.info("Creating comparator to sort tshirts by Price");
		return new Comparator<Tshirt>() {
			public int compare(Tshirt tshirt1, Tshirt tshirt2) {
				return Double.compare(tshirt2.getTshirtPrice(), tshirt1.getTshirtPrice());
			}
		};
	}
	
	public Comparator<Tshirt> getTshirtComparatorByRating(){
		LOG.info("Creating comparator to sort tshirts by Rating");
		return new Comparator<Tshirt>() {
			public int compare(Tshirt tshirt1, Tshirt tshirt2) {
				return Double.compare(tshirt2.getTshirtRating(), tshirt1.getTshirtRating());
			}
		};
	}
	
	public Comparator<Tshirt> getTshirtComparatorByPriceRating(){
		LOG.info("Creating Comparator to sort by both price and rating.");
		return new Comparator<Tshirt>() {
		public int compare(Tshirt tshirt1, Tshirt tshirt2) {
			int sortLevel1 = Double.compare(tshirt2.getTshirtPrice(), tshirt1.getTshirtPrice());
			if(sortLevel1==0) {
				int sortLevel2 = Double.compare(tshirt2.getTshirtRating(), tshirt1.getTshirtRating());
				return sortLevel2;
			}
			return sortLevel1;
		}
};
	}

}
