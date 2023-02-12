package pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Utility;

public class RegistrationPage extends Utility {

	public static WebDriver driver;

	public RegistrationPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "input#input-username")
	WebElement userNameField;

	@FindBy(css = "input#input-firstname")
	WebElement firstNameField;

	@FindBy(css = "input#input-lastname")
	WebElement lastNameField;

	@FindBy(css = "input#input-email")
	WebElement emailField;

	@FindBy(css = "select#input-country")
	WebElement countryFieldDropDwn;

	@FindBy(css = "input#input-password")
	WebElement passwordField;

	@FindBy(xpath = "//div[@id='button-register']/button[@type='submit'][1]")
	WebElement registerBtn;

	public void register() throws Exception {

		userNameField.sendKeys(getProperty("register.properties", "username"));
		firstNameField.sendKeys(getProperty("register.properties", "firstname"));
		lastNameField.sendKeys(getProperty("register.properties", "lastname"));
		emailField.sendKeys(getProperty("register.properties", "email"));
		dropdownSelect(countryFieldDropDwn, "38");
		passwordField.sendKeys(getProperty("register.properties", "password"));

		if (registerBtn.isEnabled()) {
		
			registerBtn.click();
			
		} 
		
		else {
			
			throw new Exception("Registration button disabled");
		}
	}

}
