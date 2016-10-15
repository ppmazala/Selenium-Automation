package com.backbase.steps;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.backbase.context.TestContext;
import com.backbase.pages.ComputerHomePage;

import junit.framework.Assert;


public class HomePageSteps {

	ComputerHomePage p = new ComputerHomePage();

	@Given("The user is on Computer dataBase Home Page")
	public void navigateToSearchPage() {
		p.navigateToPage();
	}

	@When("User clicks on Create New Computer button")
	public void goTonewComputerPage() {
		p.clcikOnCreateNewCP();
	}

	@Alias("User searchs for the computer recentlly updated")
	@Given("User searchs for the computer recentlly created")
	public void performSearch() {
		p.typeSearchText((String) TestContext.get("Computer Name"));
	}
	
	@When("User searchs for the computer: $cpName")
	public void performSearchEdit(@Named("cpName") String cpName) {
		p.typeSearchText(cpName);
	}

	@When("User clicks on link result")
	@Then("User clicks on link result")
	public void clickOnLinkResult() {
		p.clickFirstLink();
	}
	
	@Then("User exit application")
	public void exitApplication() {
		p.closeBrowser();
	}
	
	@Then("A $createUpdateDelete Sucess Message displays on Home Page")
	public void verifyMessage(@Named("createOrUpdate") String createOrUpdate) {
		if ("create".equalsIgnoreCase(createOrUpdate)) {
			String expectedMessage = String.format("Done! Computer %s has been created", TestContext.get("Computer Name"));
			Assert.assertEquals(expectedMessage, p.getAlertMessageText());
		}else if ("update".equalsIgnoreCase(createOrUpdate)) {
			String expectedMessage = String.format("Done! Computer %s has been created", TestContext.get("Computer Name"));
			Assert.assertEquals(expectedMessage, p.getAlertMessageText());
		}else { 
			String expectedMessage = "Done! Computer has been deleted";
			Assert.assertEquals(expectedMessage, p.getAlertMessageText());
		}
	}
}
