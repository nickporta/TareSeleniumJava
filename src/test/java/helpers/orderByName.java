package helpers;

import java.util.Comparator;

import PageObjects.ProductsEbay;

public class orderByName implements Comparator<ProductsEbay> {
	
	public orderByName() {
		
	}
	
	public int compare(ProductsEbay p1, ProductsEbay p2) {
		return new String(p1.getName()).compareTo(new String(p2.getName()));
	}

}