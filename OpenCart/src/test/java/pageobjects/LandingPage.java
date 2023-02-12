package pageobjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Utility;

public class LandingPage extends Utility {

	public static WebDriver driver;

	public LandingPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(@class, 'navbar-right')]/a[text()='Login']")
	WebElement loginBtn;

	@FindBy(xpath = "//div[contains(@class, 'navbar-right')]/a[text()='Register']")
	WebElement registerBtn;

	@FindBy(xpath = "//p[@class='hidden-xs']/a[text()='Free Download']")
	WebElement freeDownloadLink;

	@FindBy(xpath = "//p[@class='hidden-xs']/a[text()='View Demo']")
	WebElement viewDemoLink;

	@FindBy(xpath = "//div[@class='hidden-xs hidden-sm']/a[text()='Visit Marketplace']")
	WebElement visitMarketPlLink;

	@FindBy(css = "img[title='OpenCart - Open Source Shopping Cart Solution']")
	WebElement titleLogo;

	@FindBy(xpath = "//li[@class='facebook-marketing-partner-logo']/a[contains(@href, 'facebook')]")
	WebElement facebookLink;
	
	@FindBy(xpath="//a[contains(text(),'Linkedin')]")
	WebElement linkedinLink;
	
	@FindBy (xpath="//a[contains(text(),'Twitter')]")
	WebElement twitterLink;

	public LoginPage goToLoginPage() {

		loginBtn.click();
		return new LoginPage(driver);

	}

	public RegistrationPage goToRegistrationPage() {

		registerBtn.click();
		return new RegistrationPage(driver);

	}

	public DemoPage goToDemoPage() {
		viewDemoLink.click();
		return new DemoPage(driver);
	}

	public boolean istitleDisplayed() {

		return waitForElement(By.cssSelector("img[title='OpenCart - Open Source Shopping Cart Solution']"))
				.isDisplayed();

	}

	public boolean isTitleCorrectt() {

		return driver.getTitle().equalsIgnoreCase("OpenCart - Open Source Shopping Cart Solution");
	}
	
	public boolean goToFacebookLink() throws InterruptedException, IOException {
		
		driver.get(getProperty("config.properties", "baseurl"));
		facebookLink.click();
		switchWindows("Commerce | partner badge");
		return driver.findElement(By.cssSelector("img._2qnn")).isDisplayed();
	}
	
	public boolean goToLinkedinLink() throws IOException {
		
		driver.get(getProperty("config.properties", "baseurl"));
		linkedinLink.click();
		switchWindows("LinkedIn Login, Sign in | LinkedIn");
		return driver.findElement(By.cssSelector("li-icon[type='linkedin-logo']")).isDisplayed();
		
		
	}

}
