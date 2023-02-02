package com.nagarro.advancejava.assignment2.serviceimpl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.nagarro.advancejava.assignment2.daoimpl.SearchTshirtDaoImpl;
import com.nagarro.advancejava.assignment2.entities.TshirtsData;
import com.nagarro.advancejava.assignment2.entities.UserInputData;
import com.nagarro.advancejava.assignment2.service.DisplayService;

public class DisplayServiceImpl implements DisplayService {
	List<TshirtsData> availableTShirts;
	/**
	 * View tshirts.
	 *
	 * @param userData     the user data
	 */
	@Override
	public void viewTshirts(UserInputData userData) {
		SearchTshirtDaoImpl searchTshirt = new SearchTshirtDaoImpl(userData);
		availableTShirts = searchTshirt.getListOfTShirt();

		if (availableTShirts.size() == 0) {
			System.out.println("No Match Found");
		} else {
			switch (userData.getInputPreference()) {
			case 1:
				Collections.sort(availableTShirts, new sortByRating());
				break;
			case 2:
				Collections.sort(availableTShirts, new sortByPrice());
				break;
			case 3:
				Collections.sort(availableTShirts, new sortByPriceAndRating());
				break;
			default:
				System.out
						.println("\nInvalid preference.................\nThis result" + " is based on default sort.\n");
			}
			System.out.println("Id\t\t" + "Name\t\t\t\t   " + " Color    " + " Gender\t" + "Size " + "\tPrice "
					+ " Rating " + "Availability");

			for (TshirtsData tshirt : availableTShirts) {
				System.out.println(tshirt.toString());
			}
		}
	}

}

/* Custom Comparator */

class sortByRating implements Comparator<TshirtsData> {
	@Override
	public int compare(TshirtsData o1, TshirtsData o2) {
		if (o1.getTshirtRating() == o2.getTshirtRating()) {
			return 0;
		} else if (o1.getTshirtRating() > o2.getTshirtRating()) {
			return -1;
		}

		return 0;
	}
}

class sortByPrice implements Comparator<TshirtsData> {
	@Override
	public int compare(TshirtsData o1, TshirtsData o2) {
		if (o1.getTshirtPrice() == o2.getTshirtPrice()) {
			return 0;
		} else if (o1.getTshirtPrice() > o2.getTshirtPrice()) {
			return -1;
		}

		return 0;

	}
}

class sortByPriceAndRating implements Comparator<TshirtsData> {
	@Override
	public int compare(TshirtsData t1, TshirtsData t2) {
		if (t1.getTshirtPrice() == t2.getTshirtPrice()) {
			if (t1.getTshirtRating() < t2.getTshirtRating())
				return 1;
			if (t1.getTshirtRating() > t2.getTshirtRating())
				return -1;
			return 0;
		} else if (t1.getTshirtPrice() < t2.getTshirtPrice())
			return 1;
		if (t1.getTshirtPrice() > t2.getTshirtPrice())
			return -1;
		return 0;
	}
}
