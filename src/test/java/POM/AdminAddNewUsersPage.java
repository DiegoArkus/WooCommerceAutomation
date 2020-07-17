package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminAddNewUsersPage extends PageObject {
	WebDriverWait wait = new WebDriverWait(driver,20);
	
	@FindBy (id = "user_login") private WebElement userName;
	@FindBy (id = "email") private WebElement userEmail;
	@FindBy (id = "first_name") private WebElement firstName;
	@FindBy (id = "last_name") private WebElement lastName;
	@FindBy (id = "url") private WebElement webSite;
	@FindBy (xpath = "//button[@class='button wp-generate-pw hide-if-no-js']") private WebElement PwdButton;
	@FindBy (id = "role") private WebElement userRole;
	@FindBy (id = "createusersub") private WebElement addUserButton;
	
	
	public Select userDropDown;

	public AdminAddNewUsersPage(WebDriver driver) {
		super(driver);
	}
	
	//This Method fill the information to create a new user
	public void fillNewUserForm(String UserName, String UserEmail, String FirstName, String LastName,
			String WebSite)
	{
		userName.sendKeys(UserName);
		userEmail.sendKeys(UserEmail);
		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		webSite.sendKeys(WebSite);
		PwdButton.click();
	}
	
	//This Method is used to select any role to assign it a new user
	public void selectRole(String Role)
	{
		userDropDown = new Select(userRole);
		userDropDown.selectByVisibleText(Role);
	}
	
	//This method creating a new user
	public void createUser()
	{
		wait.until(ExpectedConditions.elementToBeClickable(addUserButton));
		addUserButton.click();
	}
	

}
