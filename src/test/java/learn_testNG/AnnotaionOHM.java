package learn_testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AnnotaionOHM {

	WebDriver driver;
	@BeforeSuite
	public void launchBrowser() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
	}

	@BeforeTest
	public void loginProcess() throws InterruptedException
	{

		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Test(priority=1, description="To Test PIM Functionality")
	public void testPIM() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='oxd-main-menu']/child::li[2]")).click();
		System.out.println("Clicked on PIM SuccessFully");
		Thread.sleep(2000);
	}
	@Test(priority=2, description="To Test PIM Reports Functionality")
	public void pIMReport() throws InterruptedException
	{
		driver.findElement(By.linkText("Reports")).click();
		Thread.sleep(2000);
		System.out.println("Clicked on Reports SuccessFully");
	}
	@Test(priority=3, description="To Test PIM- Add Employee Functionality")
	public void addEmployee() throws InterruptedException
	{
		driver.findElement(By.linkText("Add Employee")).click();
		Thread.sleep(2000);
		System.out.println("Clicked on Add Employees SuccessFully");
	}

	@AfterTest
	public void logoutProcess() throws InterruptedException
	{

		driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
	}

	@AfterSuite
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}

}
