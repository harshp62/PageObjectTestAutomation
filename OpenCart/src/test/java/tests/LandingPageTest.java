package tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

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

	@Test
	public void testFacebookLink() throws Exception {

		LandingPage lnd = new LandingPage(driver);
		sft.assertTrue(lnd.goToFacebookLink());

	}

	@Test
	public void testLoginInvalid() {

		LandingPage lnd = new LandingPage(driver);
		LoginPage log = lnd.goToLoginPage();
		log.login("ftcyvaaa333vy", "");
		assertEquals(log.getInvalidUserError(), "aaNo match for E-Mail and/or Password.\n×");

	}
	
	@Test
	public void forgotPassword() {
		
		LandingPage lnd = new LandingPage(driver);
		LoginPage log = lnd.goToLoginPage();
		ForgotPasswordPage fg =log.forgotPassword();
		fg.enterEmail("");
		assertEquals("E-Mail Address does not appear to be valid!", fg.getInvalidErrorMsg());
		
	}
	
	@Test
	public void testAllLinks() throws InterruptedException, IOException {
		
		LandingPage lnd = new LandingPage(driver);
		sft.assertTrue(lnd.goToFacebookLink());
		sft.assertTrue(lnd.goToLinkedinLink());
		sft.assertAll();
		
		
		
	}
}
