package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReporterNG {
	
	
	public static ExtentReports getExtentObject() {
	String path = System.getProperty("user.dir")+"//reports//index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	ExtentReports extent = new ExtentReports();
	
	reporter.config().setReportName("Open Cart Test Automation Suite");
	reporter.config().setDocumentTitle("Test Results");
	reporter.config().setTheme(Theme.DARK);
	reporter.config().setTimelineEnabled(true);
	
	
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Harsh Patel");
	return extent;
	}

}
