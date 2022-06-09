package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	public WebDriver driver;

	public CartPage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement goToCart;

	@FindBy(xpath = "//button[@class='btn btn_secondary btn_small cart_button']")
	private List<WebElement> removeButton;

	@FindBy(xpath = "//button[@class='btn btn_action btn_medium checkout_button']")
	private WebElement checkoutButton;

	@FindBy(xpath = "//input[@data-test='firstName']")
	private WebElement customerFirstName;

	@FindBy(xpath = "//input[@data-test='lastName']")
	private WebElement customerLastName;

	@FindBy(xpath = "//input[@data-test='postalCode']")
	private WebElement customerZipCode;

	@FindBy(xpath = "//input[@data-test='continue']")
	private WebElement continueButton;

	public void clickGoToCartButton() {
		goToCart.click();

	}

	public void clickRemoveButton() {
		removeButton.get(1).click();

	}

	public void clickCheckoutButton() {
		checkoutButton.click();
	}

	public boolean enterCustomerInfo(String firstName, String lastName, String pincode) {
		boolean status = false;
		customerFirstName.sendKeys(firstName);
		customerLastName.sendKeys(lastName);
		customerZipCode.sendKeys(pincode);

		status = true;
		return status;
	}

	public void continueButton() {
		continueButton.click();
	}

}
