package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PageShoes {
	
	private WebDriver driver;
	
	private By checkBoxPuma;
	private By checkBoxSize10;
	private By numberResults;
	private By checkBoxFreeShipping;

	public PageShoes(WebDriver driver) {
		this.driver = driver;
		checkBoxPuma = By.xpath("//span[contains(text(),'PUMA')]");
		checkBoxSize10 = By.xpath("//span[text()='10']");
		checkBoxFreeShipping = By.xpath("//span[contains(text(),'Envío internacional')]");
		numberResults = By.className("srp-controls__count-heading"); //
	
	}
	
	public void selectCheckBoxPuma() {
		driver.findElement(checkBoxPuma).click();
	}
	public void selectCheckBox10() {
		driver.findElement(checkBoxSize10).click();
	}
	public void selectCheckBoxFreeShipping() {
		driver.findElement(checkBoxFreeShipping).click();
	}
	public void orderPriceUpward(String cosa,String MARCA,String size) {
		String urlPumaShoosSize10Free = "https://www.ebay.com/sch/i.html?_from=R40&_nkw="+cosa+"&_sacat=0&LH_TitleDesc=0&Brand="+MARCA+"&US%2520Shoe%2520Size%2520%2528Men%2527s%2529="+size+"&_dcat=93427&_sop=15&rt=nc&LH_FS=1";
		driver.navigate().to(urlPumaShoosSize10Free);
	}
	public void orderPriceUpward() {
		String urlPumaShoosSize10 = driver.getCurrentUrl();
		System.out.println(urlPumaShoosSize10);
		String urlPumaShoosSize10Free = urlPumaShoosSize10.substring(0, urlPumaShoosSize10.length()-13)+ "LH_FS=1&_sop=15";
		driver.navigate().to(urlPumaShoosSize10Free);	
	}
	
	public void assertOrderAscendentingPrice( List<Float> listPrice) {
		boolean order = true;
		
		for(int i=0; i<listPrice.size()-1;i++) {
			if(listPrice.get(i)>listPrice.get(i+1)) {
				order = false;
				break;
			}
		}
		Assert.assertTrue(order, "Los precios están ordenados de forma ascendente");
	}
	
	public void printNumberResults() {
		String numresult = driver.findElement(numberResults).getText();
		System.out.println(numresult);
	}
}