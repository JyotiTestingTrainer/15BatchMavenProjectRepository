package learn_testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderDemo {
	@DataProvider(name="searchDataSet")
	public Object[][] searchData()
	{
		Object[][] searchPhone=new Object[3][2];
		searchPhone[0][0]="iPhone";
		searchPhone[0][1]="14 pro max";
		searchPhone[1][0]="Oppo";
		searchPhone[1][1]="Reno 2z";
		searchPhone[2][0]="OnePlus";
		searchPhone[2][1]="Nord";
		return searchPhone;
	}

	@Test(dataProvider="searchDataSet")
	public void flipkartSearch(String brand, String phoneVarient) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(1000);
		WebElement loginPopUp=driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		if(loginPopUp.isDisplayed())
		{
			loginPopUp.click();
		}
		Thread.sleep(1000);
		driver.findElement(By.name("q")).sendKeys(brand+" "+phoneVarient);
		driver.findElement(By.xpath("//button[@type='submit']")).click();


	}

}
