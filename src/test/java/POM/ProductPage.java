package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends PageObject{
	@FindBy(xpath="//*[@id=\"wrap\"]/div/div/div/div/div") WebElement title;
	WebDriver driver;
//	By title = By.xpath("//*[@id=\"wrap\"]/div/div/div/div/div") ;

	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	public String getTitleText() {
		return title.getText();
	}
}
