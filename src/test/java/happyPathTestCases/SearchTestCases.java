package happyPathTestCases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import POM.HomePage;
import POM.SearchPage;

public class SearchTestCases {
	String url = "http://itluma.com/";
	WebDriver driver;
	HomePage objHome;
	SearchPage objSearch;
	
	@BeforeClass
	
	public void Setup() {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	
	@Test(priority=0)
	
	public void search(){
		objHome= new homePage(driver);
		objHome.clickSearchButton();
		objHome.searchElement("Blouse");
		objSearch= new searchPage(driver);
		//System.out.print(objSearch.returnSearchCount());
		assertTrue(objSearch.returnSearchCount()>0, "Products not found");
		
	}
	
   @Test(priority=1)
	
	public void searchInvalid(){
		objHome= new homePage(driver);
		objHome.clickSearchButton();
		objHome.searchElement("non existing");
		objSearch= new searchPage(driver);
		assertTrue(objSearch.returnSearchCount()==0, "Products not found");
		
	}
	@AfterClass
	public void close() {
		driver.close();
		driver.quit();
	}
}
