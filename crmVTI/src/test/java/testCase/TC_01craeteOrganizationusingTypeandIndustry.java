package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;

public class TC_01craeteOrganizationusingTypeandIndustry extends BaseClass {
	@Test
	public void TC_01() {
		loginPag.setUserName(propertyUti.readingDataFromPropertyFile("username"));
		loginPag.setPassword(propertyUti.readingDataFromPropertyFile("password"));
		loginPag.clickLoginButton();
		homePag.clickOnOrganizationIcon();
		Assert.assertEquals(organizationPag.getPageHeader().getText(), "Organizations");
		System.out.println("organization page is displayed");
		organizationPag.getCreateButton().click();
		String orgName="qspider"+javauti.generatingRandomNumber(100);
	    organizationPag.getOrganizationNameTB().sendKeys(orgName);
	    webDriverUti.handlingDropdown(organizationPag.getIndstryDD(),1);
	    webDriverUti.handlingDropdown(organizationPag.getTypeDD(),1);
	    organizationPag.getSaveButton().click();
	    if(organizationPag.getCreatedOrgHeader().getText().contains(orgName)) {
	    	System.out.println("new organization is created successfully");
	    }
	    else
	    	System.out.println("new organization is not created successfully");

	
	
	}
}
