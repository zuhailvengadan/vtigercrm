package hardCodedTestCase;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_7createNewEventFromQuick {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

        Random random=new Random();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		if (driver.getTitle().contains("vtiger CRM 5")) {
			System.out.println("Login Page is Displayed");
			
		}
		else
			System.out.println("Login Page not displayed");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).submit();
		
		if (driver.getTitle().contains("Home")) {
			System.out.println("Home page is displayed");
		}
		else
			System.out.println("home page is not displayed");
		WebElement createDD=driver.findElement(By.id("qccombo"));
		Select s=new Select(createDD);
		s.selectByVisibleText("New Event");
		int rnumb=random.nextInt(30,70);
		driver.findElement(By.name("subject")).sendKeys("Campaign"+rnumb);
		String subject=driver.findElement(By.name("subject")).getText();
		System.out.println(subject);
		WebElement statusDD=driver.findElement(By.name("eventstatus"));
		Select sel=new Select(statusDD);
		sel.selectByIndex(1);
		WebElement starttime=driver.findElement(By.name("date_start"));
		starttime.clear();
		starttime.sendKeys("2023-06-10");
		WebElement time=driver.findElement(By.name("time_start"));
		time.clear();
		time.sendKeys("17:30");
		WebElement enddate=driver.findElement(By.name("due_date"));
		enddate.clear();
		enddate.sendKeys("2023-06-11");
		Thread.sleep(3000);
		WebElement actiDD=driver.findElement(By.name("activitytype"));

		Select se=new Select(actiDD);
		se.selectByIndex(1);
		driver.findElement(By.xpath("//input[@value='U']")).click();
		driver.findElement(By.xpath("//table[@class=\"qcTransport\"]/descendant::input[@accesskey='S']")).click();
		//driver
        String eventHeader=driver.findElement(By.className("lvtHeaderText")).getText();
		
		if(eventHeader.contains(subject))
		{
			System.out.println("new page saved");
		}
		else
		{
			System.out.println("new page not saved");
		}
		WebElement adminicon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action=new Actions(driver);
		action.moveToElement(adminicon).perform();
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		if (driver.getTitle().contains("vtiger CRM 5")) {
			System.out.println("sign out success");
			
		}
		else
			System.out.println("sign out not success ");
		
		driver.close();
		
	}

}
