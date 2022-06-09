package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage2 {

	public WebDriver driver;

	@FindBy(xpath = "//*[@id='user-name']")
	public WebElement userName;

	@FindBy(xpath = "//input[@id='password']")
	public WebElement password;

	@FindBy(id = "login-button")
	public WebElement loginButton;
	
	@FindBy(xpath = "//div[@class='error-message-container error']")
	public WebElement loginErrorMessage;

	

	public Loginpage2(WebDriver driver) {

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
	
	public void errorMessage(String message) {
		loginErrorMessage.getText().equalsIgnoreCase(message);
	}

	public void loginToSauceDemo(String strUserName, String strPasword, String message) {

		// Fill user name

		this.setUserName(strUserName);

		// Fill password

		this.setPassword(strPasword);

		// Click Login button

		this.clickLogin();
		
		//verify message
		
		this.errorMessage(message);

	}
}
