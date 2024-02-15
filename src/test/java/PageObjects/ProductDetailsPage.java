package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailsPage {

	WebDriver driver;
	By color=By.id("pa_color");
	By size=By.id("pa_size");
	By addToCart=By.cssSelector(".single_add_to_cart_button");
	By cartItems=By.cssSelector(".cart-item");
	By incQty=By.className("icon_plus");
	
	
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void selectColour(String itemcolor)
	{
		Select colorDrop=new Select(driver.findElement(color));
		colorDrop.selectByValue(itemcolor);
	}
	
	public void selectSize(String itemsize)
	{
		Select sizeDrop=new Select(driver.findElement(size));
		sizeDrop.selectByValue(itemsize);
	}
	
	public void addTocart(int qty)
	{
		if(qty>1)
		{
			for(int i=0;i<=qty-2;i++)
				driver.findElement(incQty).click();
			
		}
		driver.findElement(addToCart).click();
		
	}
	
	public void proceedToCart()
	{
		driver.findElement(cartItems).click();
	}
	
	

}
