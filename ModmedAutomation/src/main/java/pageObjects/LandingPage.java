package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	public WebDriver driver;

	@FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory']")
	public List<WebElement> addToCart;

	// navjot

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}

	public boolean validatingAddToCartOptionsByAddingRandomItems() {
		boolean status = false;
		int click = 3;
		for (int i = 0; i < click; i++) {
			addToCart.get(i).click();
		}
		status = true;
		return status;
	}

}
