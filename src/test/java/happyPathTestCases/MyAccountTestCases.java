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
	public static void LogInSimpleUser()
	{
		POM.MyAccountPage myaccount = new MyAccountPage(driver);
		
		myaccount.LogInSimpleUser();
		assertTrue(myaccount.getSuccessLogin());
	}
	
	@Test(priority = 1)
	public static void LogOutSimpleUser()
	{
		POM.MyAccountPage myaccount = new MyAccountPage(driver);
		
		myaccount.LogInSimpleUser();
		myaccount.LogOutSimpleUser();
		assertTrue(myaccount.getSuccessLogout());
	}
	
	@AfterMethod
	public static void TearDown()
	{
		driver.close();
	}

}
