package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
    public WebDriver driver ;
    public static ThreadLocal<WebDriver> threadLocaldriver = new ThreadLocal<>();
    
	public WebDriver init_driver(String browser) {
		System.out.println("browser : " + browser);
		
	
	    if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			threadLocaldriver.set(new ChromeDriver());
		}
	     else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			threadLocaldriver.set(new FirefoxDriver());
		}
	     getDriver().manage().deleteAllCookies();
	     getDriver().manage().window().maximize();
	     getDriver().get("https://demo.openmrs.org/openmrs/login.htm");
	     return getDriver();
	}
	
	  public static synchronized WebDriver getDriver() {
		return threadLocaldriver.get();
	}
	
	
}
