package hardCodedTestCase;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_05CreateLeadWithMandatoryField {

	public static void main(String[] args) {
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
		

		driver.findElement(By.xpath("//a[text()='Leads' and @href=\"index.php?module=Leads&action=index\"]")).click();
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		String CreatenewLeadheader=driver.findElement(By.className("lvtHeaderText")).getText();
		if(CreatenewLeadheader.contains("Creating New Lead")) {
			System.out.println("lead creating page is displayed");
		}
		else
			System.out.println("lead creating page is not displayed");
		int randomNum=random.nextInt(100);
		driver.findElement(By.name("lastname")).sendKeys("raj"+randomNum);

		driver.findElement(By.name("company")).sendKeys("tcs"+randomNum);
        driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		String newOrgPageHeader=driver.findElement(By.xpath("//span[contains(text(),'  -  Lead Information')]")).getText();
		
		if(newOrgPageHeader.contains("raj"))
		{
			System.out.println("new lead saved");
		}
		else
		{
			System.out.println("new lead is not saved");
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


