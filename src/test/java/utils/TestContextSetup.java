package utils;

import java.io.IOException;

import PageObjects.PageObjectManager;

public class TestContextSetup {
	
	public WebDriverManager webDriverManager;
	public PageObjectManager pageObjectManager;
	public GenericUtils genericUtils;
	
	public TestContextSetup() throws IOException
	{
		webDriverManager=new WebDriverManager();
		pageObjectManager= new PageObjectManager(webDriverManager.DriverManager());
		genericUtils= new GenericUtils(webDriverManager.DriverManager());
	}

}
