package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import base.Utility;

public class ForgotPasswordPage extends Utility {
	
	public static WebDriver driver;
	
	public ForgotPasswordPage (WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="input-email")
	WebElement emailInputField;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submitButton;
	
	@FindBy(css=".text-danger")
	WebElement invalidEmailError;
	
	
	
	public void enterEmail(String email) {
		
		emailInputField.sendKeys(email);
		submitButton.click();
		
	}
	
	public String getInvalidErrorMsg() {
		
		return invalidEmailError.getText();
	}
	
	
	
}
