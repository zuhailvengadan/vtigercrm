package practise;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;

@Listeners(genericLibraries.ListenerImplimentation.class)
public class testScript extends BaseClass {
	WebDriver driver=BaseClass.driver;
	@Test()
	public void demoForListner() {
		System.out.println("this is testcase1");
	}
	@Test
	public void demoForListner1() {
		System.out.println("this is testcase2");
		
		Assert.assertEquals(false,true);
		
	}
	@Test(enabled=true)
	public void validateSkippedTest() {
		System.out.println("this is skipped");
	}
	

}
