package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

public WebDriver driver;
	
	public PaymentPage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//div[@class='summary_value_label'][1]")
	private List<WebElement> paymentInformation;
	
	@FindBy(xpath = "//div[@class='summary_total_label']")
	private WebElement totalPrice;
	
	@FindBy(xpath = "//button[@data-test='finish']")
	private WebElement finishButton;
	
	@FindBy(xpath = "//h2[@class='complete-header']")
	private WebElement headerTextMessage;
	
	@FindBy(xpath = "//div[@class='complete-text']")
	private WebElement textMessage;
	
	@FindBy(xpath = "//img[@class='pony_express']")
	private WebElement ponnyExpressImage;
	
	
	
	
	
 public boolean validatingPaymentConfirmation(String paymentInfo) {
		boolean status=true;
		status &= paymentInformation.get(0).getText().equalsIgnoreCase(paymentInfo);
		return status;
	}
 
 public boolean validatingPriceConfirmation() {
		boolean	status = totalPrice.isDisplayed();
		return status;
	}

 public void finishButton() {
		
	 finishButton.click();
	}
	
 
 public boolean validatingConfirmationMessage(String headerMessage, String exptext) { 
		boolean status =true;
		status &= headerTextMessage.getText().equalsIgnoreCase(headerMessage);
		status &= textMessage.getText().equalsIgnoreCase(exptext);
		System.out.println("Thank you message is displayed");
		status &= ponnyExpressImage.isDisplayed();
		System.out.println("");
		return status;
	}

	
	
	
	
}
