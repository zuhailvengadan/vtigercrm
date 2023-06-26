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

public class TC_02CreateOrgWithTypeAndIndustryTest {
	/**
	 * login to the application
	 * click organization tab
	 * create new organization with type and industry
	 * log out the application
	 * @param args
	 */
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
		
		driver.findElement(By.xpath("//a[text()='Organizations' and @href='index.php?module=Accounts&action=index']")).click();
		
		if (driver.getTitle().contains("Administrator")) {
			System.out.println("organisation page is displayed");
		}
		else
			System.out.println("organisation page is not displayed");

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		int randomNumber=random.nextInt(150,200);
		
		
		driver.findElement(By.name("accountname")).sendKeys("tcs"+randomNumber);
		
		WebElement industryDD=driver.findElement(By.name("industry"));
		WebElement typeDD= driver.findElement(By.name("accounttype"));
		
		Select s=new Select(industryDD);
		s.selectByVisibleText("Banking");
		
		Select sa=new Select(typeDD);
		sa.selectByValue("Investor");
		
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		String newOrgPageHeader=driver.findElement(By.xpath("//span[contains(text(),'Organization Information')]")).getText();
		
		if(newOrgPageHeader.contains("Organization"))
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
