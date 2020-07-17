package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminUsersPage extends PageObject {
	WebDriverWait wait = new WebDriverWait(driver,20);
	
	@FindBy (linkText = "Users") private WebElement UsersButton;
	@FindBy (css = "h1[class='wp-heading-inline']") private WebElement UsersPageValidation;
	@FindBy (linkText = "Add New") private WebElement AddNewButton;
	@FindBy (xpath = "//div[@id='message']/p") private WebElement SuccessNotificationMsg;
	@FindBy (xpath = "//input[@class='customer']") private List<WebElement> CustomerList;
	@FindBy (id = "new_role") private WebElement NewRole;
	@FindBy (id = "changeit") private WebElement ChangeButton;
	@FindBy (id = "bulk-action-selector-top") private WebElement BulkActions;
	@FindBy (id = "doaction") private WebElement ApplyButton;
	@FindBy (xpath = "//div[@class='row-actions']/span[@class='edit']") private List<WebElement> EditLsit;
	
	public Select NewRoleDropDown;
	public Select Actions;

	public AdminUsersPage(WebDriver driver) {
		super(driver);
	}
	
	
	//This method redirect you into administration dashboard menu
	public void GoUsersAdminDashboard()
	{
		wait.until(ExpectedConditions.elementToBeClickable(UsersButton));
		UsersButton.click();
	}
	
	//This method redirect you into add new user form
	public void GoAddNewUser()
	{
		wait.until(ExpectedConditions.elementToBeClickable(AddNewButton));
		AddNewButton.click();
	}
	
	//This method helps to validate you are into Users administration page
	public boolean getSuccessUsersPage()
	{
		System.out.println("You are into the " + (UsersPageValidation).getText() + " administration page");
		return UsersPageValidation.isDisplayed();
	}
	
	//This method helps to validate all successfully messages when user do any action into the page
	public boolean getSuccessNotificationMsg()
	{
		System.out.println("Success Message: " + (SuccessNotificationMsg).getText());
		return SuccessNotificationMsg.isDisplayed();
	}
	
	//Method to select Customer Users
	public List<WebElement> SelectUsersCheckBox(int customerUser)
	{
		CustomerList.get(customerUser).click();
		return CustomerList;
	}
	
	//This Method is used to select roles to change actual role of any user
	public void changeRoles(String Roles)
	{
		NewRoleDropDown = new Select(NewRole);
		NewRoleDropDown.selectByVisibleText(Roles);
	}
	
	//This method redirect you into add new user form
	public void applyChanges()
	{
		wait.until(ExpectedConditions.elementToBeClickable(ChangeButton));
		ChangeButton.click();
	}
	
	//This Method is used to delete selected users
	public void bulkActions(String Action)
	{
		Actions = new Select(BulkActions);
		Actions.selectByVisibleText(Action);
	}
	
	//This method redirect you into add new user form
	public void applyBulkActions()
	{
		wait.until(ExpectedConditions.elementToBeClickable(ApplyButton));
		ApplyButton.click();
	}

	
}
