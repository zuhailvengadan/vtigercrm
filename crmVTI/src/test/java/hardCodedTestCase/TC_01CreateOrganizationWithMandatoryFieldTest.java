package hardCodedTestCase;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_01CreateOrganizationWithMandatoryFieldTest {
	/**1
	 * login to the application
	 * click organization tab
	 * create new organization with mandatory fields
	 * log out the application
	 * @param args
	 */
		public static void main(String[] args) {
			// TODO Auto-generated method stub

			Random r=new Random();
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
			
			if (driver.getTitle().contains("Administrator")) {
				System.out.println("Home page is displayed");
			}
			else
				System.out.println("home page is not displayed");
			// click on organization.
			driver.findElement(By.xpath("//a[text()='Organizations' and @href='index.php?module=Accounts&action=index']")).click();

			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			WebElement newOrgHeader=driver.findElement(By.className("lvtHeaderText"));
			if (newOrgHeader.getText().contains("Creating New Organization")) {
				
				System.out.println(" create new organisation page is displayed");
			}
			else
				System.out.println(" create new organisation page is not displayed");
			
			int randomNumber=r.nextInt(100);
			driver.findElement(By.name("accountname")).sendKeys("tcs"+randomNumber);
			
			WebElement radio=driver.findElement(By.xpath("//input[@value='T']"));
			radio.click();
			if (radio.isSelected()) {
				System.out.println("radio is selected");
				
			}
			else System.out.println("radio is not selected");

			driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
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
