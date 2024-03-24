package com.openmrs.hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.factory.DriverFactory;
import com.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
   private DriverFactory factory;
   private WebDriver driver;
   private ConfigReader configReader;
   private Properties properties;
   
   @Before(order = 0)
   public void getProperty() throws IOException {
	   System.out.println(" step 1: read config file");
	   this.configReader=new ConfigReader();
	 this.properties= configReader.init_prop();
			   
}
   @Before(order = 1)
   public void launchBrowser() {
	factory=new DriverFactory();
	String browserName= properties.getProperty("browser");
	driver=factory.init_driver(browserName);
	   System.out.println(" step 2: launchBrowser successfully ");
	  
}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}


}
