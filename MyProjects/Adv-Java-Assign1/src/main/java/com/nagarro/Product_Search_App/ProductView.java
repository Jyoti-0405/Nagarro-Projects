package com.nagarro.Product_Search_App;

import java.util.ArrayList;

public class ProductView {
	
	public void viewProducts(ArrayList<ProductModel> productList) {
		System.out.println("\n \t\t ****WELCOME TO T-SHIRT SEARCH APPLICATION********");
		System.out.println("ID | NAME | COLOR | GENDER_RECOMENDATION | SIZE | PRICE | RATING | AVAILABILITY");
		for(ProductModel p : productList) {
			System.out.print(" "+p.getId());
			System.out.print("\t |\t"+p.getName());
			System.out.print("\t |\t"+p.getColor());
			System.out.print("\t |\t"+p.getGen_recom());
			System.out.print("\t |\t"+p.getSize());
			System.out.print("\t |\t"+p.getPrice());
			System.out.print("\t |\t"+p.getRating());
			System.out.println("\t| "+p.getAvail()+"\t |");
		}
		if(productList.isEmpty()) {
			System.out.println("Sorry!!! Products not Available");
		}
	}

}
