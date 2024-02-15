package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	
	TestContextSetup testContextSetup;
	
	public Hooks(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) throws WebDriverException, IOException
	{
		if(scenario.isFailed())
		{
			
			File srcPath=((TakesScreenshot) testContextSetup.webDriverManager.DriverManager()).getScreenshotAs(OutputType.FILE);
			byte[] fileContent=FileUtils.readFileToByteArray(srcPath);
			scenario.attach(fileContent, "image/png", "image1");
		}
	}
	
	@After
	public void tearDown() throws IOException
	{
		testContextSetup.webDriverManager.DriverManager().quit();
	}

}
