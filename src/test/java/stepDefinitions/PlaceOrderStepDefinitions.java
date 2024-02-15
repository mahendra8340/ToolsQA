package stepDefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetup;

public class PlaceOrderStepDefinitions {
	
	
	TestContextSetup testContextSetup;
	WebDriver driver;
	List<WebElement> products;
	HashMap<String,String> customer;
	public PlaceOrderStepDefinitions(TestContextSetup testContextSetup) throws IOException
	{
		this.testContextSetup=testContextSetup;
		this.driver=this.testContextSetup.webDriverManager.DriverManager();
	}

	@Given("user is on Home Page")
	public void user_is_on_home_page() {
	    String title=driver.getTitle();
	    Assert.assertTrue(title.contains("Demo E-Commerce Site"));
	}
	@When("he search for {string}")
	public void he_search_for(String item) {
		testContextSetup.pageObjectManager.getHomePage().searchforProduct(item);
		products = testContextSetup.pageObjectManager.getHomePage().getProducts();
	    
	}
	@When("choose to buy the {string} item")
	public void choose_to_buy_the_first_item(String itemNumber) throws InterruptedException {
	    int item=Integer.parseInt(itemNumber);
	    
	    products.get(item).click();
	    Thread.sleep(2000);
	    
	}
	@When("add {string} products also moves to checkout from mini cart")
	public void moves_to_checkout_from_mini_cart(String qty) {
		int qty1=Integer.parseInt(qty);
		testContextSetup.pageObjectManager.getProductDetailsPage().selectColour("white");
		testContextSetup.pageObjectManager.getProductDetailsPage().selectSize("medium");
		testContextSetup.pageObjectManager.getProductDetailsPage().addTocart(qty1);
		testContextSetup.pageObjectManager.getProductDetailsPage().proceedToCart();	 
		testContextSetup.pageObjectManager.getCartPage().proceedToCheckout();
		
	}
	@When("enter {string} personal details on checkout page")
	public void enter_personal_details_on_checkout_page(String customerName) throws IOException, InterruptedException {
		customer=testContextSetup.genericUtils.getExcelData(customerName);
		testContextSetup.pageObjectManager.getCheckOut().fillFormData(customer);
	    
	}
	@When("place the order")
	public void place_the_order() {
		testContextSetup.pageObjectManager.getCheckOut().placeOrder();
	}
	@Then("verify Order Placed")
	public void verify_order_placed() {
	    Assert.assertTrue(testContextSetup.pageObjectManager.getConfirmationPage().verifyError());
	}

}
