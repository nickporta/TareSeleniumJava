package helpers;

import java.util.Comparator;

import PageObjects.ProductsEbay;


public class orderByPriceDescendents implements Comparator<ProductsEbay>{

	public orderByPriceDescendents() {
		
	}
	public int compare(ProductsEbay p1, ProductsEbay p2) {
		return new Float(p2.getPrice()).compareTo(new Float(p1.getPrice()));
	}
}