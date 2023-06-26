package hardCodedTestCase;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_03CreateContactWithMandatoryField {

	/**3
	 * login to the application
	 * click contact tab
	 * create create contact with mandatory field
	 * log out the application
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random=new Random();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		if (driver.getTitle().contains("Commercial Open Source CRM")) {
			System.out.println("login page is displayed");
			
		}
		else
			System.out.println("login page is not displayed");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).submit();
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		WebElement contacticon=driver.findElement(By.className("hdrLink"));
		WebDriverWait wait=new WebDriverWait(driver,10);
		WebElement result = wait.until(ExpectedConditions.visibilityOf(contacticon));
		
		if (result.getText().contains("Contacts")) {
			System.out.println("contacts page is displayed");
			
		}
		else
			System.out.println("contact page is not displayed");
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		WebElement pageHeaderContact=driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
		
		
		SoftAssert s=new SoftAssert();
		s.assertTrue(pageHeaderContact.isDisplayed());
		s.assertAll();
		int RandomNumber=random.nextInt(100);
		String Lastname="raj"+RandomNumber;
		driver.findElement(By.name("lastname")).sendKeys(Lastname);
		driver.findElement(By.xpath("//input[@type='radio' and @value='T']")).click();
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[2]")).click();
		WebElement createdcontact=driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		
		
		if (createdcontact.getText().contains(Lastname+" Contact Information")) {
			System.out.println("contact is create succesfully");
			
		}
		System.out.println("contact is not created");
		
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
