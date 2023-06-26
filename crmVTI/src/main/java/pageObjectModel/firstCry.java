package pageObjectModel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class firstCry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
		options.addArguments("disable-notification");
		options.addArguments("disable-geolocation");
		WebDriver driver = new ChromeDriver(options);
		WebDriverManager.chromedriver().setup();
		driver.get("https://www.firstcry.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement searchbox=driver.findElement(By.id("search_box"));
		searchbox.clear();
		searchbox.sendKeys("cap");
		driver.findElement(By.className("search-button")).click();
		WebElement addButton=driver.findElement(By.id("13400971"));

		WebElement cap1=driver.findElement(By.xpath("//img[@src=\"//cdn.fcglcdn.com/brainbees/images/products/300x364/13400971a.webp\"]"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("argument[0].ScrollIntoView(true)",cap1);
		
		Actions a=new Actions(driver);
		a.moveToElement(cap1).perform();
		
		//WebElement addButton=driver.findElement(By.id("13400971"));

		
	}

}
