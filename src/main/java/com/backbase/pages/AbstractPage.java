package com.backbase.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class AbstractPage {
	
	private static WebDriver browser;

	public AbstractPage() {
		if (browser == null) {
			browser = new FirefoxDriver();
			browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}

	public WebDriver getDriver() {
		return browser;
	}

}
