package com.backbase.pages;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class SearchPage extends AbstractPage{
	
	@FindBy(id = "lst-ib")
	private WebElement searchField;

	public SearchPage() {
		super();
		PageFactory.initElements(getDriver(), this);
	}
	
	public void typeSearchText(String searchText){
		searchField.sendKeys(searchText);
	}
	
	public void navigateToPage (){
		getDriver().get("https://www.google.com");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> loadedCondition() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
