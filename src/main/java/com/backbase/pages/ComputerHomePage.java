package com.backbase.pages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.backbase.context.TestContext;

public class ComputerHomePage extends AbstractPage {

	public void clcikOnCreateNewCP() {
		isLoaded();
		WebElement add = getDriver().findElement(By.id("add"));
		add.click();
	}
	
	/*public List<String> clickOnFirstLinkResults() {
	 List<WebElement> tableResult = getDriver().findElements(By.xpath("//table//tr/td[1]"));
	 WebElement link = getDriver().findElement(By.xpath("(//td/a)[1]"));
	 List<String> results = new ArrayList<>();
	 
	 for (WebElement row : tableResult) {
		 	
		 	if (TestContext.get("Computer Name").equals(row.getText())) {
		 		link.click();
		 		break;
			}
		}
	 
	    return results;
	}*/
	
	public void clickFirstLink() {
		WebElement link = getDriver().findElement(By.xpath("(//td/a)[1]"));
		link.click();
	}

	public void typeSearchText(String searchText) {
		isLoaded();
		WebElement searchBox = getDriver().findElement(By.id("searchbox"));
		WebElement searchSubmit = getDriver().findElement(By.id("searchsubmit"));
		searchBox.sendKeys(searchText);
		searchSubmit.click();
	}
	
	public void navigateToPage() {
		getDriver().get("https://computer-database.herokuapp.com/computers");
		getDriver().manage().window().maximize();
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> loadedCondition() {
		List<ExpectedCondition<WebElement>> ec = new ArrayList<ExpectedCondition<WebElement>>();
		ec.add(ExpectedConditions.visibilityOfElementLocated(By.id("searchbox")));
		return ec;
	}
}
