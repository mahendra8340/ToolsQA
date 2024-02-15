package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

	WebDriver driver;
	By proCheckOut=By.cssSelector(".checkout-button.alt");
	
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void proceedToCheckout()
	{
		driver.findElement(proCheckOut).click();
	}

}
