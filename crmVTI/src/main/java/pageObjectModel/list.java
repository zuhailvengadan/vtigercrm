package pageObjectModel;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class list extends TestListenerAdapter {

	public void onTestStart(ITestResult tr) {
		System.out.println("started");
		prac.report(prac.exactpath);
		System.out.println("is failed");
		
	}
	public void onTestSuccess() {
		
		
	}
	public void onTestFailure(ITestResult tr) {
		
		
	}
	public void onTestSkip(ITestResult tr) {
		System.out.println("okk");
	}
}
