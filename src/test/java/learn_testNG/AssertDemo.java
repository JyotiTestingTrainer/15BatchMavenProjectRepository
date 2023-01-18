package learn_testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertDemo {

	@Test
	public void amazonAssertTitle()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		String expectedTitle="Fails";
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertNotEquals(expectedTitle, actualTitle,"Different from Actuall Title");
	}

}
