package POM;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageObject {
	WebDriverWait wait = new WebDriverWait(driver,20);
	
	@FindBy (css = "a[class='ld-sp-btn ld-sp-add-to-cart button product_type_simple add_to_cart_button ajax_add_to_cart']") private List<WebElement> addToCart;
	@FindBy (linkText = "Home") private WebElement HomeMenu;
	@FindBy(xpath="//i[@class='icon-ld-search']") List <WebElement> searchButton;
	@FindBy(xpath ="//input[@type='search']" ) List <WebElement> searchBar;
	@FindBy(xpath="//*[@id=\"menu-item-3574\"]/a/span[2]") WebElement shopLink;

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
	public List<WebElement> AddToCartButton(int product)
	{
		addToCart.get(product).click();
		return addToCart;
	}
	//Method to navigate to Shop page
	public void clickShop() {
		shopLink.click();
	}
	//Method to open search bar
	public void clickSearchButton() {
		searchButton.get(2).click();
	}
	//Method to search item
	public void searchElement(String searchText) {

		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(searchBar.get(1)));
		searchBar.get(1).sendKeys(searchText);
		searchBar.get(1).sendKeys(Keys.ENTER);
	}


}
