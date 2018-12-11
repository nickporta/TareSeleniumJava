package misTests;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.PageHome;
import PageObjects.PageShoes;
import PageObjects.ProductsEbay;
import helpers.Helpers;
import helpers.orderByName;
import helpers.orderByPriceDescendents;

public class Tests {
	private WebDriver driver;
	public Tests() {
		
	}/*
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.navigate().to("https://ar.ebay.com/b/Cell-Phones-Smartphones/9355/bn_320094");
		
		//-------------------------------------------------------------------------
		
	}*/
	
	@Test
	public void searchPumaShoesSize10Test(){
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.navigate().to("https://www.ebay.com/");
		
		driver.manage().window().maximize();
		PageHome pageHome = new PageHome(driver);
		pageHome.selectBuscarField("shoes");
		pageHome.clickBuscar();
		
		PageShoes pageShoes = new PageShoes(driver);
		pageShoes.selectCheckBoxPuma();
		pageShoes.selectCheckBox10();
		pageShoes.selectCheckBoxFreeShipping();
		pageShoes.orderPriceUpward("shoes", "PUMA", "10");
		
		ProductsEbay productsEbay = new ProductsEbay(driver);
		List<WebElement> listNamesProduct = productsEbay.namesProducts();
		List<WebElement> listPriceProduct = productsEbay.priceProducts();
		
		System.out.println("______Numero de resultados totales:");
		pageShoes.printNumberResults();
		
		Helpers helpers = new Helpers();
		
		System.out.println("______Productos y precios:");
		helpers.printResults(listNamesProduct,listPriceProduct);
		
		List<String> listName = helpers.convertListNameProducts(listNamesProduct);
		List<Float> listPrice = helpers.convertListPrice(listPriceProduct);
		
		//Assert para verificación del orden de los precios
		pageShoes.assertOrderAscendentingPrice(listPrice);
		
		List<ProductsEbay> listProductsEbay = productsEbay.listProducts(listName,listPrice);
		System.out.println("______Productos desordenados por nombre:");
		helpers.printResults(listProductsEbay);
		
		System.out.println("______Productos ordenanos por nombre:");
		Collections.sort(listProductsEbay, new orderByName());
		helpers.printResults(listProductsEbay);
		
		System.out.println("______Productos ordenanos por precio de mayor a menor:");
		Collections.sort(listProductsEbay, new orderByPriceDescendents());
		helpers.printResults(listProductsEbay);
		driver.close();
		driver.quit();
	}
	/*
	@AfterMethod
	public void tearDown(ITestResult result) {
		driver.close();
		driver.quit();
	}*/
}
