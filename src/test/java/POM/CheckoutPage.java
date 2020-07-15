package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends PageObject {
	WebDriverWait wait = new WebDriverWait(driver,20);
	
	@FindBy (id = "billing_first_name") private WebElement firstName;
	@FindBy (id = "billing_last_name") private WebElement lastName;
	@FindBy (id = "billing_address_1") private WebElement address;
	@FindBy (id = "billing_city") private WebElement city;
	@FindBy (id = "billing_postcode") private WebElement postCode;
	@FindBy (id = "billing_phone") private WebElement phone;
	@FindBy (id = "billing_email") private WebElement email;
	@FindBy (id = "place_order") private WebElement placeOrder;
	@FindBy (xpath = "//*[@id=\"content\"]/div/div/div[2]/p") private WebElement SuccessMsg;
	
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Method to fill Billing required details of a non-logged user
	public void fillForm()
	{
		firstName.sendKeys("Alejandro");
		lastName.sendKeys("Gonzalez");
		address.sendKeys("Rio Tiber 406");
		city.sendKeys("Aguascalientes");
		postCode.sendKeys("20010");
		phone.sendKeys("4491697654");
		email.sendKeys("alejandro@gmail.com");
	}
	
	//Method to complete purchase
	public void placeOrderButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(placeOrder));
		placeOrder.click();
	}
	
	//Method to get success message
	public boolean getSuccessMsg()
	{
		System.out.println("This is result message: " + (SuccessMsg).getText());
		return SuccessMsg.isDisplayed();
	}

}
