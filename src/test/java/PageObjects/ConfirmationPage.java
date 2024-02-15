package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;

public class ConfirmationPage {

	WebDriver driver;
	
	By error=By.className("woocommerce-error");
	
	
	public ConfirmationPage(WebDriver driver) {
		this.driver=driver;
	}

	public Boolean verifyError()
	{
		return driver.findElement(error).isDisplayed();
	}
}
