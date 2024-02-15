package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	CartPage cartPage;
	CheckOutPage checkOutPage;
	ConfirmationPage confirmationPage;
	HomePage homePage;
	ProductDetailsPage productDetailsPage;
	WebDriver driver;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}
	public CartPage getCartPage()
	{
		if(cartPage==null)
			cartPage=new CartPage(driver);
		return cartPage;
	}
	
	public CheckOutPage getCheckOut()
	{
		if(checkOutPage==null)
			checkOutPage=new CheckOutPage(driver);
		return checkOutPage;
	}
	
	
	public ConfirmationPage getConfirmationPage()
	{
		if(confirmationPage==null)
			confirmationPage=new ConfirmationPage(driver);
		return confirmationPage;
	}
	
	public HomePage getHomePage()
	{
		if(homePage==null)
			homePage=new HomePage(driver);
		return homePage;
	}
	
	public ProductDetailsPage getProductDetailsPage()
	{
		if(productDetailsPage==null)
			productDetailsPage=new ProductDetailsPage(driver);
		return productDetailsPage;
	}
	
	

}
