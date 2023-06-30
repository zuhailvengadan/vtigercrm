package testCase;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

@Listeners(genericLibraries.ListenerImplimentation.class)
public class TC_09loginWithInvalidData extends BaseClass {
	@Test(dataProvider = "loginData", dataProviderClass = genericLibraries.ExcelUtility.class )
	
	public void TC_09(String user, String pass) throws InterruptedException {
		SoftAssert soft = new SoftAssert();
		boolean visibilityofHeader=loginPag.getPageHeader().getText().contains("vtiger");
		Assert.assertEquals(true,visibilityofHeader);
		System.out.println("login page is displayed");
		loginPag.getUserName().sendKeys(user);
		loginPag.getPassword().sendKeys(pass);

		Assert.assertEquals(loginPag.Loginbuttonisenabled(), true);
		System.out.println("loginPag Button is enabled");
		loginPag.clickLoginButton();
		if (loginPag.getErrorMessage().isDisplayed()) {
			System.out.println("Invalid user name or password");
		soft.assertEquals(true, false);
	

		} else 
			System.out.println("login successful");
		//driver.close();

		soft.assertAll();
       
	}

}
