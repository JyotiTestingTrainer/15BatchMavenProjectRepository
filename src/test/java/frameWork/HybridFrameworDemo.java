package frameWork;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectModel.OperationLoginOHM;
import pageObjectModel.OperationLogoutOHM;

public class HybridFrameworDemo {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		OperationLoginOHM loginOHM=new OperationLoginOHM(driver);
		OperationLogoutOHM logoutOHM=new OperationLogoutOHM(driver);

		FileInputStream inputStream=new FileInputStream("D:\\LoginCredentials.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(inputStream);
		XSSFSheet dataSheet=wb.getSheet("Data");
		XSSFSheet keySheet=wb.getSheet("Keyword");

		int dataRows=dataSheet.getLastRowNum();
		System.out.println("Rows numbers of DDF :"+dataRows);

		int keyRows=keySheet.getLastRowNum();
		System.out.println("Rows numbers of KeywordDF :"+keyRows);

		for(int dr=1;dr<=dataRows;dr++)
		{
			XSSFRow dataRow=dataSheet.getRow(dr);
			XSSFCell userName=dataRow.getCell(0);
			XSSFCell passWord=dataRow.getCell(1);
			XSSFCell result=dataRow.createCell(2);

			try {
			for(int kr=1;kr<=keyRows;kr++)
			{
				XSSFRow keyRow=keySheet.getRow(kr);
				XSSFCell key=keyRow.getCell(1);
				XSSFCell keyResult=keyRow.createCell(2);
				System.out.println(key);

				switch(key.toString())
				{
					case "url":
						loginOHM.url();
						keyResult.setCellValue("Valid");
						break;
					case "username":
						loginOHM.userName(userName.toString());
						keyResult.setCellValue("Valid");
						break;
					case "password":
						loginOHM.passWord(passWord.toString());
						keyResult.setCellValue("Valid");
						break;
					case "login":
						loginOHM.loginBtn();
						keyResult.setCellValue("Valid");
						break;
					case "userProfile":
						logoutOHM.userProfile();
						keyResult.setCellValue("Valid");
						break;
					case "logout" :
						logoutOHM.logOut();
						keyResult.setCellValue("Valid");
						break;
					default:
						System.out.println("Invalid Keyword");
						keyResult.setCellValue("Invalid");
						break;
				}
			}
			System.out.println("Pass");
			result.setCellValue("PASS");
			}catch(Exception e)
			{
				System.out.println("Fail");
				result.setCellValue("FAIL");
			}
		}
		inputStream.close();
		FileOutputStream outputStream=new FileOutputStream("D:\\LoginCredentials.xlsx");
		Thread.sleep(1000);
		wb.write(outputStream);

	}

}
