package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class a  {

	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	private WebElement closeIcon;
	@FindBy(className = "_3704LK")
	private WebElement searchTB;
	@FindBy(className = "L0Z3Pu")
	private WebElement searchButton;

	@FindBy(xpath = "//div[text()='APPLE iPhone 14 (Midnight, 128 GB)']")
	private WebElement product1;

	@FindBy(xpath = "//div[text()='APPLE iPhone 14 (Purple, 128 GB)']")
	private WebElement product2;
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	private WebElement addButton;

	public a(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void closeloginbox() {

		closeIcon.click();
		

	}

	public void searchipohones() {
		searchTB.sendKeys("iphones");
		searchButton.click();
	}

	public void clickOnFirstProdect() {
		product1.click();
		
	}
	public void add() {
		addButton.click();
	}
}
