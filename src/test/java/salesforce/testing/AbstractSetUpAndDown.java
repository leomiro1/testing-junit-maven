package salesforce.testing;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import util.PropertyManager;
import util.WebDriverUtils;


public class AbstractSetUpAndDown {

	protected WebDriver driver;
	WebDriverUtils util = new WebDriverUtils(driver);
	PropertyManager property;
		
	@Before
	public void testSetUp() {
		// create a property var that it will be used to manage parameters
		property = new PropertyManager();
		property.genarateProperty();
		// create an instance of Webdriver
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	    capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
    	System.setProperty("webdriver.chrome.driver", property.chromedriverPath);
    	driver = new ChromeDriver();
    	
		driver.navigate().to("http://www.google.com");

		driver.findElement(By.id(property.idInputGoogleSearch)).sendKeys(property.inputSearch);

		driver.findElement(By.id(property.idInputGoogleSearch)).sendKeys(Keys.ENTER);
		util.wait(5);
	}
	
	@After
	public void testShutDown() {
		driver.quit();		
	}
	
	
}
