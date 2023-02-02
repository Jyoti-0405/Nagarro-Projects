package com.nagarro.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.nagarro.constants.Constants;
import com.nagarro.dao.TshirtDao;
import com.nagarro.dao.TshirtFileDao;
import com.nagarro.dto.Tshirt;
import com.nagarro.dto.TshirtFile;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

/**
 * TshirtLoader class loads tshirts from CSV files to the mySQL database. It
 * periodically checks for new tshirts and adds it to database when found.
 * 
 * 
 */
public class TshirtLoaderService {

	@Autowired
	TshirtFileDao tshirtFileDao;

	@Autowired
	TshirtDao tshirtDao;

	final static Logger LOG = Logger.getLogger(TshirtLoaderService.class);

	private File folder = new File(Constants.FOLDERPATH);
	private File[] folderFiles;
	private List<TshirtFile> dbFiles;
	private FileReader fileReader;
	private CSVParser parser = new CSVParserBuilder().withSeparator('|').build();
	private CSVReader csvReader;

	/**
	 * This method is executed periodically to check for new tshirts and update
	 * database if any new tshirts are found. dbFiles is list of TshirtFile objects
	 * from the database that are the objects of CSV files that are read already.
	 * folderFiles is a array of File objects of CSV files that are currently
	 * present in the target folder.
	 */
	@Scheduled(fixedRate = 7000, initialDelay = 5000)
	public void loadTshirts() {

		LOG.info("Starting files loading process. \n \n");

		dbFiles = tshirtFileDao.getAllTshirtFiles();
		folderFiles = folder.listFiles();

		checkNewTshirts();

		LOG.info("Tshirt loading process completed successfully. \n \n");
	}

	/**
	 * This method checks for new Tshirts by comparing dbFiles and folderFiles.
	 * Unmatched files are new files which are then loaded. Matched files are
	 * checked for new entries.
	 */
	private void checkNewTshirts() {
		LOG.info("Checking for new tshirts.");

		for (File folderFile : folderFiles) {

			TshirtFile foldertshirtFile = new TshirtFile();
			foldertshirtFile.setFileName(folderFile.getName());

			LOG.info("Checking for new files.");
			if (!dbFiles.contains(foldertshirtFile)) {
				readTshirtsFromFile(foldertshirtFile, folderFile);
			} else {
				LOG.info("No new files found.");
				checkForNewEntriesInFile(foldertshirtFile, folderFile);
			}
		}
	}

	/**
	 * This method creates tshirt object of entries present in the newly found CSV
	 * file and persist it in database. Also the a TshirtFile object of the new CSV
	 * file is created that stores file name and number of rows read.
	 * 
	 * @param folderflightFile
	 * @param folderFile
	 */
	private void readTshirtsFromFile(TshirtFile foldertshirtFile, File folderFile) {
		LOG.info("============== > New file found : " + foldertshirtFile.getFileName() + " < ============");
		try {

			fileReader = new FileReader(folderFile);
			csvReader = new CSVReaderBuilder(fileReader).withCSVParser(parser).build();
			List<String[]> allTshirtData = csvReader.readAll();
			int noOfEntries = allTshirtData.size() - 1;

			for (int rowNumber = 1; rowNumber < allTshirtData.size(); rowNumber++) {
				Tshirt newTshirt = createTshirtObject(allTshirtData.get(rowNumber));
				tshirtDao.addTshirt(newTshirt);
			}

			foldertshirtFile.setRow1(noOfEntries);
			tshirtFileDao.addTshirtFile(foldertshirtFile);

		} catch (FileNotFoundException fileNotFoundException) {
			LOG.error("File not found : " + folderFile.getName());

		} catch (IOException ioException) {
			LOG.error("Input Output Exception occured while reading : " + folderFile.getName());

		} catch (Exception exception) {
			LOG.fatal("Unknown Exception occured while reading : " + folderFile.getName());
		}

	}

	/**
	 * This method compares the number of rows present in the matching files. In
	 * case new rows are found it creates the Tshirt object of that row and persist
	 * it in Tshirt table. Also the TshirtFile object is updated and persisted.
	 * 
	 * @param folderflightFile
	 * @param folderFile
	 */
	private void checkForNewEntriesInFile(TshirtFile foldertshirtFile, File folderFile) {
		LOG.info("Checking for new entries in existing file : " + foldertshirtFile.getFileName());

		try {

			fileReader = new FileReader(folderFile);
			csvReader = new CSVReaderBuilder(fileReader).withCSVParser(parser).build();
			List<String[]> allTshirtData = csvReader.readAll();
			int noOfEntries = allTshirtData.size() - 1;

			TshirtFile dbFlightFile = (TshirtFile) tshirtFileDao.getTshirtFile(foldertshirtFile.getFileName());
			int noOfEntriesDB = dbFlightFile.getRow1();

			if (noOfEntriesDB != noOfEntries) {
				LOG.info("========= >> New entries found in file : " + foldertshirtFile.getFileName() + " << =========");

				for (int rowNumber = 1 + noOfEntriesDB; rowNumber < allTshirtData.size(); rowNumber++) {
					Tshirt newFlight = createTshirtObject(allTshirtData.get(rowNumber));
					tshirtDao.addTshirt(newFlight);
				}

				foldertshirtFile.setRow1(noOfEntries);
				tshirtFileDao.updateTshirtFile(foldertshirtFile);
			} else {
				LOG.info("No new tshirts found in " + folderFile.getName());
			}

		} catch (FileNotFoundException fileNotFoundException) {
			LOG.error("File not found : " + folderFile.getName());

		} catch (IOException ioException) {
			LOG.error("Input Output Exception occured while reading : " + folderFile.getName());

		} catch (Exception exception) {
			LOG.fatal("Unknown Exception occured while reading : " + folderFile.getName());
		}
	}

	/**
	 * This method creates a Tshirt object of a row from CSV file.
	 * 
	 * @param tshirtData CSV file row data.
	 * @return Tshirt object
	 */
	private Tshirt createTshirtObject(String[] tshirtData) {
		Tshirt tshirt = new Tshirt();
		tshirt.setTshirtNumber(tshirtData[0]);
		tshirt.setTshirtName(tshirtData[1]);
		tshirt.setTshirtColor(tshirtData[2]);
		tshirt.setTshirtGen_recomm(tshirtData[3]);
		tshirt.setTshirtSize(tshirtData[4]);
		tshirt.setTshirtPrice(Double.parseDouble(tshirtData[5]));
		tshirt.setTshirtRating(Double.parseDouble(tshirtData[6]));
		tshirt.setTshirtAvailability(tshirtData[7]);
		return tshirt;
	
	}
}