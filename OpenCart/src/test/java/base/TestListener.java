package base;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import reporting.extentReporterNG;

public class TestListener implements ITestListener {
	
	ExtentTest test;
	public static ExtentReports extent;
	public Capabilities capabilities;
	public WebDriver driver;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(extent==null) {
		extent = extentReporterNG.getExtentObject();
		}
		System.out.println("hi test started");
	
		test = extent.createTest(result.getMethod().getMethodName());
		test.assignAuthor("Harsh");
		test.assignCategory("Smoke");
		test.assignDevice("Chrome");
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		test.info(MarkupHelper.createLabel("PASSED!!!", ExtentColor.GREEN));
		test.info("This was a test about"+result.getName());
		//test.log(Status.PASS, "test passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		Utility.takesnapshot(result.getName());
		test.fail(result.getThrowable());
		test.addScreenCaptureFromPath(System.getProperty("user.dir")+"//SS//" + result.getName() +".png", result.getName());
		test.info(MarkupHelper.createLabel("FAILED!!!", ExtentColor.RED));
		test.info("This was a test about"+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.skip(MarkupHelper.createLabel("SKIPPED", ExtentColor.YELLOW));
		test.info("This was a test about"+result.getName());
		test.info(MarkupHelper.createLabel("FAILED!!!", ExtentColor.YELLOW));
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}


	
}
