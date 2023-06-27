package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dataproviders {


	@Test(dataProvider = "testdata", dataProviderClass =genericLibraries.ExcelUtility.class)
	public void ReadingFrmExternalData(String un, String pwd) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys(un);
		Thread.sleep(3000);
		driver.findElement(By.name("pwd")).sendKeys(pwd);
		Thread.sleep(3000);
		driver.close();
	}

}
