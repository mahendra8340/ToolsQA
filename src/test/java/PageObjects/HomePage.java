package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	WebDriver driver;
	By search=By.className("noo-search");
	By input=By.xpath("//input[@name='s']");
	By product=By.cssSelector(".noo-product-thumbnail");
	
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void searchforProduct(String prodName)
	{
		driver.findElement(search).click();
		driver.findElement(input).sendKeys(prodName);
		driver.findElement(input).submit();
	}
	
	public List<WebElement> getProducts()
	{
		List<WebElement> products=driver.findElements(product);
		return products;
	}

	
}
