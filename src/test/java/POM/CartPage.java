package POM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends PageObject {
	WebDriverWait wait = new WebDriverWait(driver,20);
	
	@FindBy (css = "a[href='http://itluma.com/checkout/']") private WebElement ProceedToCheckout;

	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	//Method to proceed checkout page
	public void CheckOutButton()
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", ProceedToCheckout);
	}
}
