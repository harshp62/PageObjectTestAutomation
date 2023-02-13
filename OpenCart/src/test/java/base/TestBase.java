package base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;

	public static Properties pr = new Properties();

	public static FileReader fr;
	public static Capabilities capabilities;
	
	

//	@BeforeTest
//	public void initialize() throws IOException {
//
//		if (driver == null) {
//
//			fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
//			pr.load(fr);
//
//		}
//
//		if (pr.getProperty("browser").equalsIgnoreCase("chrome")) {
//
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			driver.get(pr.getProperty("baseurl"));
//
//		}
//		
//		else if (pr.getProperty("browser").equalsIgnoreCase("firefox")) {
//
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//			driver.get(pr.getProperty("baseurl"));
//
//		}
//
//	}
	
	@BeforeMethod
	public void initializeTwo() throws IOException {

		if (driver == null) {

			fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
			pr.load(fr);

		}

		if (pr.getProperty("browser").equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(pr.getProperty("baseurl"));

		}
		
		else if (pr.getProperty("browser").equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(pr.getProperty("baseurl"));

		}

		capabilities = ((RemoteWebDriver) driver).getCapabilities();
		
		

	}
	
	
//	@AfterTest
//	public void tearDown() {
//		
//		driver.close();
//	}
	
	@AfterMethod
	public void tearDownTwo() {
		
		driver.close();
	}
	
	

}
