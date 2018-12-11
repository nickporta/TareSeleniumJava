package helpers;

import java.util.Comparator;

import PageObjects.ProductsEbay;

public class orderByPriceAscendents implements  Comparator<ProductsEbay>{

	public orderByPriceAscendents() {
		// TODO Auto-generated constructor stub
	}

	public int compare(ProductsEbay p1, ProductsEbay p2) {
		return new Float(p1.getPrice()).compareTo(new Float(p2.getPrice()));
	}

}