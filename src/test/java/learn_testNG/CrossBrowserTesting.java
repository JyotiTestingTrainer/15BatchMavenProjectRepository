package learn_testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserTesting {
	WebDriver driver=null;
	@Parameters("browserName")
	@BeforeTest
	public void launchBrowser(String browserName) {

		System.out.println("BrowserName is : "+browserName);

		if(browserName.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}

		if(browserName.equalsIgnoreCase("firefox"))
		{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		}

		if(browserName.equalsIgnoreCase("Edge"))
		{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		}
	}


	@Test
	public void amazonAssertTitle()
	{
		driver.get("https://www.amazon.in/");
		String expectedTitle="Fails";
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertNotEquals(expectedTitle, actualTitle,"Different from Actuall Title");
	}

}



