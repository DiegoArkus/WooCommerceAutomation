package happyPathTestCases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import POM.HomePage;
import POM.ShopPage;
import POM.ProductPage;

public class ShopTestCases {
	String driverChromePath = "./src/main/resources/Drivers/chromedriver.exe";
	String url = "http://itluma.com/";
	WebDriver driver;
	HomePage objHome;
	ShopPage objShop;
	ProductPage objProduct;
	
	@BeforeClass
	
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", driverChromePath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	
	public void shop() {
		objHome= new HomePage(driver);
		objHome.clickShop();
		String currentUrl = driver.getCurrentUrl();
		assertTrue(currentUrl.equals(url+"shop/"), "Link did not navigate to shop page");
	}
	
	@Test
	
	public void ProductDetail() {
		objHome= new HomePage(driver);
		objHome.clickShop();
		objShop= new ShopPage(driver);
		objShop.clickProduct(0);
		objProduct = new ProductPage(driver);
		String productTitle = objProduct.getTitleText();
		System.out.println(productTitle);
		assertTrue(!productTitle.isEmpty(), "No title present");
		
	}
	
	@AfterClass
	
	public void close() {
		driver.close();
		driver.quit();
	}
}
