package com.pages;

import org.openqa.selenium.WebDriver;

public class FindPatientRecordPage {

	private WebDriver driver;

	public FindPatientRecordPage(WebDriver driver) {
		this.driver = driver;
	}

	public String FindPatientRecordPageTitle() {
		System.out.println("FindPatientRecordPageTitle : " + driver.getTitle());
		return driver.getTitle();
	}

}
