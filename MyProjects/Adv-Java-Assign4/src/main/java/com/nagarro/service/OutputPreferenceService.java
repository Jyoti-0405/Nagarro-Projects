package com.nagarro.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dto.Tshirt;

/**
 * OutputPreferance class sorts the search result according to the user's
 * preference.
 * 
 * 
 */
@Service
public class OutputPreferenceService {

	final static Logger LOG = Logger.getLogger(OutputPreferenceService.class);

	@Autowired
	private TshirtComparatorService tshirtComparator;

	/**
	 * Sorts tshirts collection by user's output preference after retrieving
	 * appropriate comparator from TshirtComparator class.
	 * 
	 * @param searchResult List of Tshirts matching user's input.
	 * @param sortBy       user's output preference.
	 */
	public void sortTshirts(List<Tshirt> searchResult, int sortBy) {
		LOG.info("Sorting search result according to output preference.");

		Comparator<Tshirt> comparator;

		if (sortBy == 1) {
			comparator = tshirtComparator.getTshirtComparatorByPrice();
			Collections.sort(searchResult, comparator);
		}
		if (sortBy == 2) {
			comparator = tshirtComparator.getTshirtComparatorByRating();
			Collections.sort(searchResult, comparator);
		}
		else {
			comparator = tshirtComparator.getTshirtComparatorByPriceRating();
			Collections.sort(searchResult, comparator);
		}

	}
}