package com.backbase.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.seleniumhq.selenium.fluent.FluentWebDriver;

public class ComputerHomePage extends AbstractPage {
	
	@FindBy(id = "searchbox")
	private WebElement searchBox;
	
	@FindBy(id = "searchsubmit")
	private WebElement searchsubmitButton;
	
	@FindBy(id = "add")
	private WebElement addNewComputer;
	
	@FindBy(className = "next")
	private WebElement nextButton;
	
	@FindBy(className = "prev")
	private WebElement prevButton;
	
	@FindBy(className = "computers zebra-striped")
	private FluentWebDriver resultTable;
	
	public void clickOnResultLink() {
		resultTable.tbody().tr().link().click();
	}
	
	public void typeSearchText(String searchText) {
		searchBox.sendKeys(searchText);
	}
	
	public void clickOnSearchButton() {
		searchsubmitButton.click();
	}
	
	public void navigateToPage() {
		getDriver().get("https://computer-database.herokuapp.com/computers");
	}
}
