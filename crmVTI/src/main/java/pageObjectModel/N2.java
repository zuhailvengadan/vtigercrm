package pageObjectModel;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class N2  {

	protected a aa;
	@Test
	public void m() {
		aa=new a(null);
		WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		aa.closeloginbox();
		aa.searchipohones();
		aa.clickOnFirstProdect();
		aa.add();

	}

	@Test(enabled = false)
	public static void main() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();

		driver.findElement(By.className("_3704LK")).sendKeys("iphone");
		driver.findElement(By.className("L0Z3Pu")).click();
		driver.findElement(By.xpath("//div[text()='APPLE iPhone 14 (Midnight, 128 GB)']")).click();

		String parentwindow = driver.getWindowHandle();
		Set<String> windows1 = driver.getWindowHandles();
		for (String s : windows1) {
			windows1.remove(parentwindow);
			driver.switchTo().window(s);
		}

		WebElement button = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
		button.click();
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(parentwindow);
		driver.findElement(By.xpath("//div[text()='APPLE iPhone 14 (Purple, 128 GB)']")).click();
		Set<String> windows2 = driver.getWindowHandles();
		for (String s : windows2) {
			driver.switchTo().window(s);

		}
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
		Thread.sleep(3000);
		driver.close();

		driver.switchTo().window(parentwindow);
		driver.findElement(By.xpath("//div[text()='APPLE iPhone 14 (Starlight, 128 GB)']")).click();
		Set<String> windows3 = driver.getWindowHandles();
		for (String s : windows3) {
			driver.switchTo().window(s);
		}
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();

		Thread.sleep(3000);
		driver.quit();

	}
}
