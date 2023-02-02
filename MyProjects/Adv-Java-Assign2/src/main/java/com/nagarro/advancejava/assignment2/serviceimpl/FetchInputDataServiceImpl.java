package com.nagarro.advancejava.assignment2.serviceimpl;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.nagarro.advancejava.assignment2.daoimpl.AddTshirtsDaoImpl;
import com.nagarro.advancejava.assignment2.entities.TshirtsData;
import com.nagarro.advancejava.assignment2.service.FetchInputDataService;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

/**
 * The Class FetchInputDataServiceImpl.
 */
public class FetchInputDataServiceImpl implements FetchInputDataService {
	
	/** The t shirt list. */
	List<TshirtsData> tShirtList = new ArrayList<TshirtsData>();
	
	/** The reader. */
	CSVReader reader = null;

	/**
	 * Gets the shirt list.
	 *
	 * @return the shirt list
	 */
	@Override
	public void getShirtList() {
		AddTshirtsDaoImpl dao=new AddTshirtsDaoImpl();
		try {
			List<String> filePath = new ArrayList<>();
			filePath.add(".\\Files\\Adidas.csv");
			filePath.add(".\\Files\\Nike.csv");
			filePath.add(".\\Files\\Puma.csv");

			for (String file : filePath) {
				// parsing a CSV file into CSVReader class constructor

				// reader = new CSVReader(new FileReader(file),'|');
				reader = new CSVReaderBuilder(new FileReader(file))
						.withCSVParser(new CSVParserBuilder().withSeparator('|').build()).build();
				String[] row;
				boolean firstLine = true;

				// reads one line at a time
				while ((row = reader.readNext()) != null) {

					// Skips first row..
					if (firstLine == true) {
						firstLine = false;
						continue;
					}

					TshirtsData tShirt = new TshirtsData();

					tShirt.setTshirtId(row[0]);
					tShirt.setModelName(row[1]);
					tShirt.setTshirtColor(row[2]);
					tShirt.setTshirtGender(row[3]);
					tShirt.setTshirtSize(row[4]);
					tShirt.setTshirtPrice(Double.parseDouble(row[5]));
					tShirt.setTshirtRating(Float.parseFloat(row[6]));
					tShirt.setTshirtAvailability(row[7]);
					tShirtList.add(tShirt);
				
				}
			}
			 dao.addTshirtsDao(tShirtList);
				

		} catch (Exception e) {
			System.out.println("Files are missing.Please check CSV files again...");
		}

	
	}
}
