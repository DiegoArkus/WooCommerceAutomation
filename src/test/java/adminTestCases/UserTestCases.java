package adminTestCases;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.AdminAddNewUsersPage;
import POM.AdminDeleteUsersPage;
import POM.AdminUsersPage;
import POM.MyAccountPage;

public class UserTestCases {
	protected static String driverChromePath = "./src/test/resources/Drivers/chromedriver.exe";
	protected static WebDriver driver;
	
	static String AdminUser = "jzamora@arkusnexus.com";
	static String PwdAdminUser = "4(35JyMEtoKlBGTY";
	
	static String role1 = "Customer";
	static String role2 = "Administrator";
	static String role3 = "Subscriber";
	
	static String deleteAction = "Delete";
	
	static int CustomerUser = 2;
	
	
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
	public void CreateCustomerUser()
	{
		POM.MyAccountPage account = new MyAccountPage(driver);
		POM.AdminUsersPage admin = new AdminUsersPage(driver);
		POM.AdminAddNewUsersPage newuser = new AdminAddNewUsersPage(driver);
		
		account.LogInUser(AdminUser, PwdAdminUser);
		account.GoAdminDashboard();
		admin.GoUsersAdminDashboard();
		assertTrue(admin.getSuccessUsersPage());
		
		admin.GoAddNewUser();
		String userName = "Andrew";
		String userEmail = "a.reynolds@hotmail.com";
		String firstName = "Andrew";
		String lastName = "Reynols";
		String webSite = "www.birdhouse.com";
		newuser.fillNewUserForm(userName, userEmail, firstName, lastName, webSite);
		newuser.selectRole(role1);
		newuser.createUser();
		assertTrue(admin.getSuccessNotificationMsg());
	}
	
	@Test(priority = 1)
	public void CreateAdministratorUser()
	{
		POM.MyAccountPage account = new MyAccountPage(driver);
		POM.AdminUsersPage admin = new AdminUsersPage(driver);
		POM.AdminAddNewUsersPage newuser = new AdminAddNewUsersPage(driver);
		
		account.LogInUser(AdminUser, PwdAdminUser);
		account.GoAdminDashboard();
		admin.GoUsersAdminDashboard();
		assertTrue(admin.getSuccessUsersPage());
		
		admin.GoAddNewUser();
		String userName2 = "Emma";
		String userEmail2 = "emanuel@gmail.com";
		String firstName2 = "Emmanuel";
		String lastName2 = "Jimenez";
		String webSite2 = "www.dronfly.com";
		newuser.fillNewUserForm(userName2, userEmail2, firstName2, lastName2, webSite2);
		newuser.selectRole(role2);
		newuser.createUser();
		assertTrue(admin.getSuccessNotificationMsg());
	}
	
	@Test(priority = 2)
	public void ChangeUsersRoles()
	{
		POM.MyAccountPage account = new MyAccountPage(driver);
		POM.AdminUsersPage admin = new AdminUsersPage(driver);
		
		account.LogInUser(AdminUser, PwdAdminUser);
		account.GoAdminDashboard();
		admin.GoUsersAdminDashboard();
		assertTrue(admin.getSuccessUsersPage());
		
		admin.SelectUsersCheckBox(CustomerUser);
		admin.changeRoles(role3);
		admin.applyChanges();
		assertTrue(admin.getSuccessNotificationMsg());
	}
	
	@Test(priority = 3)
	public void DeleteSimpleUser()
	{
		POM.MyAccountPage account = new MyAccountPage(driver);
		POM.AdminUsersPage admin = new AdminUsersPage(driver);
		POM.AdminDeleteUsersPage delete = new AdminDeleteUsersPage(driver);
		
		account.LogInUser(AdminUser, PwdAdminUser);
		account.GoAdminDashboard();
		admin.GoUsersAdminDashboard();
		assertTrue(admin.getSuccessUsersPage());
		
		admin.SelectUsersCheckBox(CustomerUser);
		admin.bulkActions(deleteAction);
		admin.applyBulkActions();
		delete.confirmDeleteUser();
		assertTrue(admin.getSuccessNotificationMsg());
	}
	
	@AfterMethod
	public static void TearDown()
	{
		driver.close();
	}

}
