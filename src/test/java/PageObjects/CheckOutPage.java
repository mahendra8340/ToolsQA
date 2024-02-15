package PageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage {

	WebDriver driver;
	By firstName=By.id("billing_first_name");
	By lastName=By.id("billing_last_name");
	By countrydrop=By.id("billing_country");
	By address1=By.id("billing_address_1");
	By address2=By.id("billing_address_2");
	By stateDrop=By.id("billing_state");
	By pincode=By.id("billing_postcode");
	By phone=By.id("billing_phone");
	By email=By.id("billing_email");
	By terms=By.id("terms");
	By placeOrder=By.id("place_order");
	By city=By.id("billing_city");
	
	
	
	public CheckOutPage(WebDriver driver) {
		this.driver=driver;
	}

	public void fillFormData(HashMap<String, String> userdata) throws InterruptedException
	{
		driver.findElement(firstName).sendKeys(userdata.get("firstName"));
		driver.findElement(lastName).sendKeys(userdata.get("lastName"));
		driver.findElement(address1).sendKeys(userdata.get("address1"));
		driver.findElement(address2).sendKeys(userdata.get("address2"));
		driver.findElement(pincode).sendKeys(userdata.get("pincode"));
		driver.findElement(phone).sendKeys(userdata.get("phone"));
		driver.findElement(email).sendKeys(userdata.get("email"));
		driver.findElement(city).sendKeys(userdata.get("city"));
		Select drop;
		drop=new Select(driver.findElement(countrydrop));
		drop.selectByValue(userdata.get("country"));
		drop=new Select(driver.findElement(stateDrop));
		drop.selectByValue(userdata.get("state"));
		Thread.sleep(2000);
		driver.findElement(terms).click();
		Thread.sleep(2000);
		
		
	}
	
	public void placeOrder()
	{
		driver.findElement(placeOrder).click();
	}
	
	
}
