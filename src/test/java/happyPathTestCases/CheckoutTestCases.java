package happyPathTestCases;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.CartPage;
import POM.CheckoutPage;
import POM.HomePage;
import POM.MyAccountPage;

public class CheckoutTestCases {
	
	protected static WebDriver driver;

	@BeforeMethod
	public static void SetUp()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://itluma.com/");
	}
	
	@Test(priority = 0)
	public void NonLoggedUserPurchase()
	{
		POM.HomePage home = new HomePage(driver);
		POM.CartPage cart = new CartPage(driver);
		POM.CheckoutPage checkout = new CheckoutPage(driver);
		
		home.AddToCartButton();
		cart.CheckOutButton();
		checkout.fillForm();
		checkout.placeOrderButton();
		assertTrue(checkout.getSuccessMsg());
	}
	
	@Test(priority = 1)
	public void LoggedUserPurchase()
	{
		POM.HomePage home = new HomePage(driver);
		POM.CartPage cart = new CartPage(driver);
		POM.CheckoutPage checkout = new CheckoutPage(driver);
		POM.MyAccountPage myaccount = new MyAccountPage(driver);
		
		myaccount.LogInSimpleUser();
		home.selectHomeMenu();
		home.AddToCartButton();
		cart.CheckOutButton();
		checkout.placeOrderButton();
		assertTrue(checkout.getSuccessMsg());
	}
	
	@AfterMethod
	public static void TearDown()
	{
		driver.close();
	}

}
