package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;	

public class WebDriverManager {

	public WebDriver driver;

	public WebDriver DriverManager() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("src/test/resources/GlobalProperties.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser").toLowerCase();
		String URL = prop.getProperty("url");
		if (driver == null) {

			switch (browser) {
			case "chrome":

				driver = new ChromeDriver();
				break;

			case "firefox":
				driver = new FirefoxDriver();
				break;

			case "edge":
				driver = new EdgeDriver();
				break;

			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();
			driver.get(URL);
		}
		return driver;
	}
}