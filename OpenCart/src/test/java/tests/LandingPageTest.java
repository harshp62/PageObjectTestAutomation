package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pageobjects.ForgotPasswordPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import pageobjects.PinValidationPage;
import pageobjects.RegistrationPage;

public class LandingPageTest extends TestBase {

	public static SoftAssert sft = new SoftAssert();

	@Test(groups= {"Sanity"})
	public void testFacebookLink() throws Exception {

		LandingPage lnd = new LandingPage(driver);
		sft.assertTrue(lnd.goToFacebookLink());
		sft.assertAll();

	}

	@Test(groups= {"db"})
	public void testLoginInvalid() throws IOException, SQLException {

		LandingPage lnd = new LandingPage(driver);
		LoginPage log = lnd.goToLoginPage();
		PinValidationPage pg =log.login();
		

	}
	
	@Test(groups= {"Sanity"})
	public void forgotPassword() {
		
		LandingPage lnd = new LandingPage(driver);
		LoginPage log = lnd.goToLoginPage();
		ForgotPasswordPage fg =log.forgotPassword();
		fg.enterEmail("");
		assertEquals("E-Mail Address does not appear to be valid!", fg.getInvalidErrorMsg());
		
	}
	
	@Test(groups= {"Sanity"})
	public void testAllLinks() throws InterruptedException, IOException {
		
		LandingPage lnd = new LandingPage(driver);
		sft.assertTrue(lnd.goToFacebookLink());
		sft.assertTrue(lnd.goToLinkedinLink());
		sft.assertAll();
		
		
		
	}
	
	@Test(groups= {"Smoke"})
	public void testHeaders() {
		
		LandingPage lnd = new LandingPage(driver);
		assertTrue(lnd.validateHeaderIconText());
	}
}
