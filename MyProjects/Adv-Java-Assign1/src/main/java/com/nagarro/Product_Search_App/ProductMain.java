package com.nagarro.Product_Search_App;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProductMain {
	public static void main(String args[]) throws FileNotFoundException{
		Scanner sc = new Scanner(System.in);
		String color,size,gender;
		int choiceCode;
		System.out.print("Enter the color of t-shirt: ");
		color = sc.nextLine().toUpperCase();
		System.out.print("Enter the size of t-shirt: ");
		size = sc.nextLine().toUpperCase();
		System.out.print("Enter the gender: ");
		gender = sc.nextLine().toUpperCase();
		System.out.print("Enter output preference: 1.Price \t 2. Rating \t\nEnter Preference choice code : ");
		choiceCode = sc.nextInt();
		
		ProductController pc = new ProductController();
		pc.searchProduct("src/main/java/productInfo/Adidas.csv",color,size,gender);
		pc.searchProduct("src/main/java/productInfo/Nike.csv",color,size,gender);
		pc.searchProduct("src/main/java/productInfo/Puma.csv",color,size,gender);
		pc.updateView(choiceCode);
	}

}
