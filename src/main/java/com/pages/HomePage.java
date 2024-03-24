package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
// Then user validate the location
public class HomePage {
	private WebDriver driver;
	
	private By homePageText=By.xpath("//a[@href='/openmrs/referenceapplication/home.page']");
	private By locationLink=By.xpath("//li[@class='change-location']//a/span");
	private By findPatientRecord = By.xpath("(//a[normalize-space()='Find Patient Record'])[1]");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean navigateToHomePage() {
		boolean homepagelogo=driver.findElement(homePageText).isDisplayed();
		return homepagelogo;
	}
	
	public String homePageTitle() {
		return driver.getTitle();		
	}
	
	public String locationSpecificLocation() {
		System.out.println("inside locationSpecificLocation");
		String actualLocation =driver.findElement(locationLink).getText();
		return actualLocation;
	}
	
	public FindPatientRecordPage navigateToPatientRecordPage() {
		System.out.println("inside navigateToPatientRecordPage ");
		driver.findElement(findPatientRecord).click();
		return new FindPatientRecordPage(driver);
	}
}
