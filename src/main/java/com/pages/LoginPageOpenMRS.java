package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class LoginPageOpenMRS {
	private WebDriver driver;
	private By userNameField = By.id("username");
	private By passwordField = By.id("password");
	private By locationsList = By.xpath("//ul[@id='sessionLocation']/li");
	private By loginButton = By.id("loginButton");
	
	//span[text()='Isolation Ward']
	public LoginPageOpenMRS(WebDriver driver) {
		this.driver=driver;
	}
	
	public HomePage doLogin(String userName,String password,String location) {
		driver.findElement(userNameField).sendKeys(userName);
		driver.findElement(passwordField).sendKeys(password);
		List<WebElement> locationForThisSession= driver.findElements(locationsList);
	    for (int i = 0; i < locationForThisSession.size(); i++) {
			WebElement locationCount = locationForThisSession.get(i);
			String locationName = locationCount.getText();
			System.out.println("locationName : " + locationName);
			if (locationName.equalsIgnoreCase(location)) {
				locationCount.click();
			}
		}
		driver.findElement(loginButton).click();
		return new HomePage(driver);
	}
	
	public HomePage dologinInpatientWardLocation(String userName,String password,String location) {
		doLogin(userName, password, location);
		return new HomePage(driver);
	}
	
	public HomePage dologinIsolationWard(String userName,String password,String location) {
		doLogin(userName, password, location);
		return new HomePage(driver);
	}
	
	public HomePage dologinLaboratory(String userName,String password,String location) {
		doLogin(userName, password, location);		
		return new HomePage(driver);
	}
	
	public HomePage dologinOutpatient(String userName,String password,String location) {
		doLogin(userName, password, location);
		return new HomePage(driver);
	}
	
	public HomePage dologinPharmacy(String userName,String password,String location) {
		doLogin(userName, password, location);
		return new HomePage(driver);
	}
	
	public HomePage dologinRegistrationDesk(String userName,String password,String location) {
		doLogin(userName, password, location);
		return new HomePage(driver);
	}
	
	
}
