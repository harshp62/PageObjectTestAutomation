package pageobjects;

import java.io.FileNotFoundException;
import base.Database;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
	
	public static WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="input-email")
	WebElement emailTextBox;
	
	@FindBy(id="input-password")
	WebElement passwordTextBox;
	
	@FindBy(xpath="//div[@class='col-sm-6']/button[text()='Login'][1]")
	WebElement loginButton;
	
	@FindBy(xpath="//div[contains(text(), 'No match')]")
	WebElement invalidUserError;
	
	@FindBy(linkText="Forgot your password?")
	WebElement forgotPasswordLink;
	
	
	
	public PinValidationPage login() throws IOException, SQLException {
		
		Properties pr = new Properties();
		FileReader fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		pr.load(fr);
		
		String usernamedb = Database.getCredentials().get(0);
		String passworddb = Database.getCredentials().get(1);
		
		emailTextBox.sendKeys(usernamedb);
		passwordTextBox.sendKeys(passworddb);
		loginButton.click();
		return new PinValidationPage(driver);
		
	}
	
	public PinValidationPage login(String username, String password) {
		
		emailTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);
		loginButton.click();
		
		return new PinValidationPage(driver);
		
		
	}
	
	public String getInvalidUserError() {
		
		return invalidUserError.getText();
	}
	
	public ForgotPasswordPage forgotPassword() {
		
		forgotPasswordLink.click();
		return new ForgotPasswordPage(driver);
	}

}
