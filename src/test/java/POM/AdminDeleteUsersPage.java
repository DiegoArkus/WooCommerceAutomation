package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminDeleteUsersPage extends PageObject {
	WebDriverWait wait = new WebDriverWait(driver,20);
	
	@FindBy (id = "submit") private WebElement DeleteButton;

	public AdminDeleteUsersPage(WebDriver driver) {
		super(driver);
	}
	
	//This method confirm delete users
	public void confirmDeleteUser()
	{
		wait.until(ExpectedConditions.elementToBeClickable(DeleteButton));
		DeleteButton.click();
	}

}
