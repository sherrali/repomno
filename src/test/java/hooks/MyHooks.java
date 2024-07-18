package hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import factory.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;

public class MyHooks {
	WebDriver driver;
	@Before
	public void setup() {
		Properties prop = ConfigReader.intializeProperties();
	 BrowserFactory.initializeBrowser(prop.getProperty("browser"));
	 driver = BrowserFactory.getDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.get(prop.getProperty("url"));
	}
	@After
	public void teardown() {
		driver.quit();
	}
}
