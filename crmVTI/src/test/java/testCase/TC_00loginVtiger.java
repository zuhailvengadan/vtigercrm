package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;


public class TC_00loginVtiger extends BaseClass {

	@Test
	public void TC_00() {
		SoftAssert soft = new SoftAssert();
		if (loginPag.getPageHeader().getText().contains("vtiger")) {
			soft.assertEquals(true, true);
			System.out.println("login page is displayed");
		} else {

			System.out.println("login page is not displayed");
		}

		loginPag.setUserName(propertyUti.readingDataFromPropertyFile("username"));
		loginPag.setPassword(propertyUti.readingDataFromPropertyFile("password"));
		Assert.assertEquals(loginPag.Loginbuttonisenabled(), true);
		System.out.println("loginPag Button is enabled");
		loginPag.clickLoginButton();
		if (driver.getTitle().contains("Home")) {
			System.out.println("login is successfull");
		} else {
			System.out.println("login not successful");
		}
		soft.assertAll();

	}

}
