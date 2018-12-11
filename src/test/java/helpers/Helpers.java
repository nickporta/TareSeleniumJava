package helpers;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import PageObjects.ProductsEbay;


public class Helpers {
	
	public List<Float> convertListPrice(List<WebElement> listPrice){
		List<Float> listPriceConvert = new ArrayList<Float>();
		
		for(int i = 0; i<listPrice.size();i++)
		{
			float price  = Float.parseFloat( listPrice.get(i).getText().substring(3,8));
			listPriceConvert.add(price);
		}
		return listPriceConvert;
	}
	public List<String> convertListNameProducts(List<WebElement> listNameProduct){
		List<String> listNameProductConvert = new ArrayList<String>();
		
		for(int i = 0; i<listNameProduct.size();i++)
		{
			String name  = listNameProduct.get(i).getText();
			listNameProductConvert.add(name);
		}
		return listNameProductConvert;
	}

	public void printResults(List<WebElement> listNameProduct, List<WebElement> listPrice) {
		 
		for(int i = 0; i < listNameProduct.size();i++) {
		 System.out.println(".-"+listNameProduct.get(i).getText()+':'+"   "+ listPrice.get(i).getText());
		}
	}
	
	public void printResults(List<ProductsEbay> listProduct) {
		for (ProductsEbay product : listProduct)
			   System.out.println(".-"+product.getName()+":   "+"USD"+product.getPrice());
	}

}
