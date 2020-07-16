package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageObject{
	@FindBy(xpath="//*[@id=\"content\"]" ) public WebElement productNotFound;
	@FindBy(xpath = "//*[@itemscope='itemscope']") List <WebElement> productsList;
	WebDriver driver;
	//By productNotFound = By.xpath("//*[@id=\"content\"]");
	//By productsList = By.xpath("\"//*[@itemscope='itemscope']\"");
	

	
	public SearchPage(WebDriver driver) {
		super(driver);
		
	}
	
	public int returnSearchCount() {
		return productsList.size();
	}
}
