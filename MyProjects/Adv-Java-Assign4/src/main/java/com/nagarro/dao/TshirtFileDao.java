package com.nagarro.dao;
import java.util.List;
import com.nagarro.dto.TshirtFile;

public interface TshirtFileDao {
	public List<TshirtFile> getAllTshirtFiles();
	public TshirtFile getTshirtFile(String filename);
	public void updateTshirtFile(TshirtFile tshirtfile);
	public void addTshirtFile(TshirtFile newTshirtFile);

}
