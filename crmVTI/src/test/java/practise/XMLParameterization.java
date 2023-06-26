package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XMLParameterization {
	@Test
	public void swiggyTest(XmlTest xml) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		long time=Long.parseLong(xml.getParameter("time"));
		driver.manage().window().maximize();
		driver.get(xml.getParameter("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
		WebElement logo=driver.findElement(By.xpath("//*[name()='svg']"));
		
		Assert.assertTrue(logo.isDisplayed(),"okkk");
		driver.close();
		
	}
}
