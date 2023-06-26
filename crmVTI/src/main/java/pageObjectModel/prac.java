package pageObjectModel;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class prac {
	static String exactpath = System.getProperty("user.dir") + "./Errorshot/extend990.png";
	static WebDriver driver;

	@Test(enabled = false)
	public void googlepass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		WebElement logo = driver.findElement(By.xpath("//img[@alt=\"Google\"]"));
		boolean result = logo.isDisplayed();
		Assert.assertTrue(result, "ok");
		System.out.println("ok passed");
		driver.close();
	}

	@Test
	public void googlefail() {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		WebElement logo = driver.findElement(By.xpath("//img[@alt=\"Google\"]"));
        String logoText=logo.getText();
		if (logo.getText().equals(logo)) {
			System.out.println("ok");
		} else
			{
				System.out.println("wrong logo");
				shot();
				driver.close();
			}

	}

	public static void shot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File photo = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(exactpath);
		try {
			FileUtils.copyFile(photo, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void report(String path) {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./reports/vticrm.html");
		ExtentReports reports = new ExtentReports();
		reports.attachReporter(reporter);
		ExtentTest logger = reports.createTest("zuhiTest");
		logger.addScreenCaptureFromPath(path);
		logger.log(Status.FAIL, "this is fail");

		reports.flush();
	}

}
