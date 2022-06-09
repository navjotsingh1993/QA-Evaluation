package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.Loginpage2;
import pageObjects.PaymentPage;
import resources.base;

public class TestCase extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		
	}

	@Test(priority = 0)
	public void validateloginPage() throws IOException, InterruptedException {

		driver.get(prop.getProperty("url"));
		LoginPage l = new LoginPage(driver);
		l.loginToSauceDemo("standard_user", "secret_sauce");
		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.validatingAddToCartOptionsByAddingRandomItems());
		CartPage cp = new CartPage(driver);
		cp.clickGoToCartButton();
		cp.clickRemoveButton();
		cp.clickCheckoutButton();
		cp.enterCustomerInfo("Navjot", "Singh", "201309");
		cp.continueButton();

		PaymentPage pp=new PaymentPage(driver);
		
		Assert.assertTrue(pp.validatingPaymentConfirmation("SauceCard #31337"));
		
		Assert.assertTrue(pp.validatingPriceConfirmation());
		
		pp.finishButton();
		
		pp.validatingConfirmationMessage("THANK YOU FOR YOUR ORDER", "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
		
	}
	
	@Test(priority = 1)
	public void validateloginPageWithLockedOutUser() throws IOException, InterruptedException {

		driver.get(prop.getProperty("url"));
		Loginpage2 lg = new Loginpage2(driver);
		lg.loginToSauceDemo("locked_out_user", "secret_sauce","Epic sadface: Sorry, this user has been locked out.");
	
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
