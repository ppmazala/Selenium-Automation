package com.backbase.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import com.backbase.pages.AddEditComputerPage;
import com.backbase.pages.ComputerHomePage;
import com.backbase.pages.SearchPage;

public class ResearchComputerSteps {

		ComputerHomePage page = new ComputerHomePage();
		
		@Given("The user is on Computer data Base Search Engine Home Page")
		public void navigateToSearchPage() {
			page.navigateToPage();
		}

		@When("performs a computer search with text '$searchText'")
		public void performSearch(@Named("searchText") String searchText) {
			page.typeSearchText(searchText);
		}

		@Then("clicks on the result on the table")
		public void clickonResult() {
			
		}
}
