package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageObject {
	WebDriverWait wait = new WebDriverWait(driver,20);
	
	@FindBy (css = "a[class='ld-sp-btn ld-sp-add-to-cart button product_type_simple add_to_cart_button ajax_add_to_cart']") private List<WebElement> addToCart;
	@FindBy (linkText = "Home") private WebElement HomeMenu;

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//Method to select Home menu
	public void selectHomeMenu()
	{
		wait.until(ExpectedConditions.elementToBeClickable(HomeMenu));
		HomeMenu.click();
	}
	
	//Method to adding products into the cart
	public List<WebElement> AddToCartButton()
	{
		
		addToCart.get(0).click();
		return addToCart;
	}

}
