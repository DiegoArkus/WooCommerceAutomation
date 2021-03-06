package happyPathTestCases;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.MyAccountPage;

public class MyAccountTestCases {
	
	protected static String driverChromePath = "./src/test/resources/Drivers/chromedriver.exe";
	protected static WebDriver driver;
	static String User = "diegozamora.ita@hotmail.com";
	static String Password = "e-commerce_123";
	
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
	public static void LogInSimpleUser()
	{
		POM.MyAccountPage myaccount = new MyAccountPage(driver);
		
		myaccount.LogInUser(User,Password);
		assertTrue(myaccount.getSuccessLogin());
	}
	
	@Test(priority = 1)
	public static void LogOutSimpleUser()
	{
		POM.MyAccountPage myaccount = new MyAccountPage(driver);
		
		myaccount.LogInUser(User,Password);
		myaccount.LogOutSimpleUser();
		assertTrue(myaccount.getSuccessLogout());
	}
	
	@AfterMethod
	public static void TearDown()
	{
		driver.close();
	}

}
