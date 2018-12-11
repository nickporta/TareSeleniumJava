package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageHome {
	private WebDriver driver;
	
	private By buscarField;
	private By buttonSearch;

	public PageHome(WebDriver driver) {
		this.driver = driver;
		buscarField = By.name("_nkw");
		buttonSearch = By.id("gh-btn");
	}
	
	public void selectBuscarField(String product){
		
		driver.findElement(buscarField).sendKeys(product);
	}
	public void clickBuscar() {
		driver.findElement(buttonSearch).click();
	}

}