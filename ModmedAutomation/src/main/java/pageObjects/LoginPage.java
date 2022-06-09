package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	@FindBy(xpath = "//*[@id='user-name']")
	public WebElement userName;

	@FindBy(xpath = "//input[@id='password']")
	public WebElement password;

	@FindBy(id = "login-button")
	public WebElement loginButton;

	

	public LoginPage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	public void setUserName(String strUserName) {

		userName.sendKeys(strUserName);
	}

	 void setPassword(String strPassword) {

		password.sendKeys(strPassword);

	}

	public void clickLogin() {

		loginButton.click();

	}

	public void loginToSauceDemo(String strUserName, String strPasword) {

		// Fill user name

		this.setUserName(strUserName);

		// Fill password

		this.setPassword(strPasword);

		// Click Login button

		this.clickLogin();

	}


}

/*
 * By email = By.xpath("//input[@id='user-name']"); By password =
 * By.xpath("//input[@id='password']"); By login = By.id("login-button");
 * 
 * 
 * 
 * public LoginPage(WebDriver driver) { this.driver = driver; }
 * 
 * public WebElement getEmail() { return driver.findElement(email);
 * 
 * }
 * 
 * public WebElement getPassword() { return driver.findElement(password);
 * 
 * }
 * 
 * public WebElement login() { return driver.findElement(login);
 * 
 * }
 */
