package PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProductsEbay {
	
	private WebDriver driver;
	private By nameProduct;
	private By priceProduct;
	
	private String name;
	private float price;
	
	public ProductsEbay( WebDriver driver) {
		this.driver = driver;
		nameProduct = By.xpath("//h3[@class='s-item__title']");
		priceProduct = By.xpath("//span[@class='s-item__price']");
	}
	public ProductsEbay(String name, float price) {
		this.name = name;
		this.price = price;
	}
	public List<WebElement> namesProducts() {
		List<WebElement> listNameProduct = driver.findElements(nameProduct);
		List<WebElement> listNameProductFirst5 = listNameProduct.subList(0,5);
		return listNameProductFirst5;
		
	}
	public List<WebElement> priceProducts() {
		List<WebElement> listPrice = driver.findElements(priceProduct);
		List<WebElement> listPriceFirst5 = listPrice.subList(0,5);
		return listPriceFirst5;
	}
	public List<ProductsEbay> listProducts (List<String> listName, List<Float> listPrice) {
		List<ProductsEbay> listproductsEbay = new ArrayList<ProductsEbay>();
		for(int i = 0; i<listPrice.size();i++)
		{
			listproductsEbay.add(new ProductsEbay(listName.get(i),listPrice.get(i)) );
		}
		return listproductsEbay;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}