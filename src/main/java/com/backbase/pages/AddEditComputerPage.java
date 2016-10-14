package com.backbase.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEditComputerPage {
	
	@FindBy(id = "name")
	private WebElement name;
	
	@FindBy(id = "introduced")
	private WebElement introduced;
	
	@FindBy(id = "discontinued")
	private WebElement discontinued;
	
	@FindBy(id = "company")
	private WebElement company;
	
	@FindBy(id = "Create this computer")
	private WebElement createComputer;
	
	@FindBy(className = "btn")
	private WebElement cancelButton;
	
	@FindBy(className = "btn danger")
	private WebElement deleteComputer;
	
	
	
	
	
}
