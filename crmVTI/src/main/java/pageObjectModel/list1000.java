package pageObjectModel;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class list1000 implements ITestListener {
	ExtentSparkReporter reporter=new ExtentSparkReporter("./reports/testz.html");
	ExtentReports reports=new ExtentReports();
	public ExtentTest logger=reports.createTest("testcase1");
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("this test is start "+result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println("this test is start "+result.getMethod().getMethodName());
	
	}

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("this test is start "+result.getName());
	
	}

	@Override
	public void onStart(ITestContext context) {

		System.out.println("this test is start "+context.getName());
	reports.attachReporter(reporter);
	}

	@Override
	public void onFinish(ITestContext context) {

		System.out.println("this test is start "+context.getName());
	
	}

}
