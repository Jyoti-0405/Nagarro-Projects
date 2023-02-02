package com.nagarro.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tshirt_Files")
public class TshirtFile {
	
	@Id
	private String fileName;
	private int row1;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public int getRow1() {
		return row1;
	}
	public void setRow1(int row1) {
		this.row1 = row1;
	}
	@Override
	public boolean equals(Object obj) {
		TshirtFile tshirtFile = (TshirtFile) obj;
		return this.getFileName().equals(tshirtFile.getFileName());
	}	
}
