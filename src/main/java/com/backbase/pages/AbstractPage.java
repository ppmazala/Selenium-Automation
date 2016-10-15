package com.backbase.pages;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class AbstractPage {
	
	private final static int TIMEOUT = 10;
	
	private static WebDriver browser; 
	
	protected abstract Collection<ExpectedCondition<WebElement>> loadedCondition();
	
	public AbstractPage() {
		if (browser == null) {
			browser = new FirefoxDriver();
			browser.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		}
	}

	public static WebDriver getDriver() {
		return browser;
	}
	
	public String getAlertMessageText() {
		WebElement alertMessage = getDriver().findElement(By.className("warning"));
		return alertMessage.getText();
	}
	
	//Method used because DOM do some changes on the page and the element invisible
	public static WebElement getElementByLocator( final By locator ) {
		  final long startTime = System.currentTimeMillis();
		  Wait<WebDriver> wait = new FluentWait<WebDriver>( getDriver() )
		    .withTimeout(30, TimeUnit.SECONDS)
		    .pollingEvery(5, TimeUnit.SECONDS)
		    .ignoring( StaleElementReferenceException.class ) ;
		  //int tries = 0;
		  boolean found = false;
		  WebElement we = null;
		  while ( (System.currentTimeMillis() - startTime) < 91000 ) {
		   try {
		    we = wait.until( ExpectedConditions.presenceOfElementLocated( locator ) );
		    found = true;
		    break;
		   } catch ( StaleElementReferenceException e ) {      
		   }
		  }
		 // long endTime = System.currentTimeMillis();
		//  long totalTime = endTime - startTime;
		  if ( found ) {
		  } else {
		  }
		  return we;
		}
	
	public void isLoaded() {
		List<ExpectedCondition<WebElement>> expectedConditions = (List<ExpectedCondition<WebElement>>) loadedCondition();
		for(ExpectedCondition<WebElement> ec: expectedConditions) {
			Wait<WebDriver> wait = new WebDriverWait(browser, TIMEOUT);
			wait.until(ec);
		}
	}
}