package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutUsingPageFactory {
	WebDriver driver;

	public LogoutUsingPageFactory(WebDriver wd)
	{
		driver=wd;
		PageFactory.initElements(driver, this); //this method will create WebElements
	}

	@FindBy(xpath="//p[@class='oxd-userdropdown-name']") WebElement userProfile;
	@FindBy(linkText = "Logout") WebElement logout;

	public void userProfile() throws InterruptedException
	{
		userProfile.click();
		Thread.sleep(1000);
	}

	public void logout() throws InterruptedException
	{
		logout.click();
		Thread.sleep(1000);
	}

	public void logoutProcess() throws InterruptedException
	{
		userProfile();
		logout();
	}
}
