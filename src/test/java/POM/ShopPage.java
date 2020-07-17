package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopPage extends PageObject {
	@FindBy(xpath="//*[@class='ld-sp-img loaded']") private List<WebElement> productsList;
	WebDriver driver;
	//By productsList = By.cssSelector("li.product:nth-child(1) > div:nth-child(1)");
	
	
	
	public ShopPage(WebDriver driver) {
		super(driver);
		
	}
//Click product by index	
	public List<WebElement> clickProduct (int index) {
		System.out.print(productsList.size());
		productsList.get(index).click();
		return productsList;
	}
//Get list of products 
	@SuppressWarnings("rawtypes")
	public List getProducts () {
		
		return productsList;
		
	}
}
