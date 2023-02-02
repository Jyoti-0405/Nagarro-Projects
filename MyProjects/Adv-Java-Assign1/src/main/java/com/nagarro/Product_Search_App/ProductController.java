package com.nagarro.Product_Search_App;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Collections;
import java.util.Comparator;

public class ProductController {
	ArrayList<ProductModel> productList=new ArrayList<ProductModel>();
    ArrayList<String> arr;
    ProductView view=new ProductView();

    public void searchProduct(String filename,String color,String size,String gender) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File(filename));
        while(sc.hasNext()) {
            String line = sc.nextLine().toUpperCase().toString();
            if (!line.isEmpty()) {
                StringTokenizer token = new StringTokenizer(line, "|");
                arr = new ArrayList<>(line.length());
                while (token.hasMoreTokens()) {
                    arr.add(token.nextToken());
                }
                if (arr.get(2).equals(color) && arr.get(4).equals(size) && arr.get(3).equals(gender)) {
                    ProductModel model = new ProductModel(arr.get(0), arr.get(1), arr.get(2), arr.get(3), arr.get(4), Float.parseFloat(arr.get(5)), Float.parseFloat(arr.get(6)), arr.get(7));
                    productList.add(model);
                }
            }
        }
    }

    public void updateView(int choiceCode)
    {
        if(choiceCode==1)
        {
            Collections.sort(productList, new Comparator<ProductModel>() {
				@Override
				public int compare(ProductModel o1, ProductModel o2) {
					// TODO Auto-generated method stub
					return (int)(o2.getPrice()-o1.getPrice());
				}
            });
        }
        else if(choiceCode==2)
        {
            Collections.sort(productList, new Comparator<ProductModel>() {
				@Override
				public int compare(ProductModel o1, ProductModel o2) {
					// TODO Auto-generated method stub
					return (int)(o2.getRating()-o1.getRating());
				}
            });
        }
        else
        {
            System.out.println("Wrong Choice.");
            return;
        }
        view.viewProducts(productList);

    }

}
