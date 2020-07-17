package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends PageObject {
	
	WebDriverWait wait = new WebDriverWait(driver,20);
	
	@FindBy (linkText = "DarkShirt") private WebElement DashboardButton;
	@FindBy (linkText = "My account") private WebElement MyAccountMenu;
	@FindBy (id = "username") private WebElement UserName;
	@FindBy (id = "password") private WebElement Password;
	@FindBy (name = "login") private WebElement LogInButton;
	@FindBy (xpath = "//nav[@class='woocommerce-MyAccount-navigation']") private WebElement MyAccountDashboard;
	@FindBy (linkText = "Logout") private WebElement LogOutButton;
	@FindBy (xpath = "//div[@class='u-column1 col-1']") private WebElement LoginForm;

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	//This method redirect you into administration dashboard menu
	public void GoAdminDashboard()
	{
		wait.until(ExpectedConditions.elementToBeClickable(DashboardButton));
		DashboardButton.click();
	}
	
	//Method to LogIn with a Simple User
	public void LogInUser(String Usr, String Pwd) 
	{
		MyAccountMenu.click();
		UserName.sendKeys(Usr);
		Password.sendKeys(Pwd);
		LogInButton.click();
	}
	
	//Method to validate success LogIn
	public boolean getSuccessLogin()
	{
		System.out.println("You are logged successfully with next available menu:\n" + (MyAccountDashboard).getText());
		return MyAccountDashboard.isDisplayed();
	}
	
	//Method to LogOut with a Simple User
	public void LogOutSimpleUser()
	{
		wait.until(ExpectedConditions.elementToBeClickable(LogOutButton));
		LogOutButton.click();
	}
	
	//Method to validate success LogOut
	public boolean getSuccessLogout()
	{
		System.out.println("You are close session successfully, with the following available options:\n" + (LoginForm).getText());
		return LoginForm.isDisplayed();
	}

}
