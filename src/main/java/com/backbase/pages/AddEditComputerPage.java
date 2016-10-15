package com.backbase.pages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AddEditComputerPage extends AbstractPage {

	public void navigateToCreateNewCP() {
		getDriver().get("http://computer-database.herokuapp.com/computers/new");
		getDriver().manage().window().maximize();
	}

	public String getNameText() {
		WebElement name = getElementByLocator(By.id("name")); 
		return name.getAttribute("value");
	}
	
	public void deleteComputer() {
		WebElement deleteBtn = getElementByLocator(By.className(("danger")));
		deleteBtn.click();
	}
	
	public void addUpdateComputer(String cpName, String companyName) {
		isLoaded();
		WebElement name = getElementByLocator(By.id("name")); 
		WebElement introduced = getElementByLocator(By.id("introduced"));
		WebElement discontinued = getElementByLocator(By.id("discontinued"));
		Select dropdown = new Select(getElementByLocator(By.id("company")));
		WebElement createCP = getElementByLocator(By.className("primary"));
		
		name.clear();
		name.sendKeys(cpName);
		introduced.clear();
		introduced.sendKeys("1991-10-10");
		discontinued.clear();
		discontinued.sendKeys("1991-10-10");
		dropdown.selectByVisibleText(companyName);
		createCP.click();
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> loadedCondition() {
		List<ExpectedCondition<WebElement>> ec = new ArrayList<ExpectedCondition<WebElement>>();
		ec.add(ExpectedConditions.presenceOfElementLocated(By.id("name")));
		return ec;
	}
}
