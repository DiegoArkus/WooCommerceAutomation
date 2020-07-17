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
	
	protected static String driverChromePath = "./src/test/resources/Drivers/chromedriver.exe";
	protected static WebDriver driver;
	static String User = "diegozamora.ita@hotmail.com";
	static String Password = "e-commerce_123";
	static int firstProduct = 0;
	static int secondProduct = 1;

	@BeforeMethod
	public static void SetUp()
	{
		System.setProperty("webdriver.chrome.driver", driverChromePath);
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
		
		home.AddToCartButton(firstProduct);
		cart.CheckOutButton();
		String firstName = "Alejandro";
		String lastName = "Vazquez";
		String address = "Rio Tiber 406";
		String city = "Aguascalientes";
		String postCode = "20010";
		String phone = "4498765647";
		String email = "alejandro_rivas@hotmail.com";
		checkout.fillForm(firstName, lastName, address, city, postCode, phone, email);
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
		
		myaccount.LogInUser(User,Password);
		home.selectHomeMenu();
		home.AddToCartButton(secondProduct);
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
