package com.backbase.steps;

import org.jbehave.core.annotations.*;
import com.backbase.context.TestContext;
import com.backbase.pages.AddEditComputerPage;

import junit.framework.Assert;

public class CreateComputersSteps {

		AddEditComputerPage p = new AddEditComputerPage();
		
		@Given("User is on create new computer Page")
		public void newComputerPage() {
			p.navigateToCreateNewCP();
		}
		
		@Then("User modifies the computer named to: $name and with company to: $company")
		@When("User creates a new computer named: $name and with company: $company")
		public void createNewComputer(@Named("name") String name, @Named("company") String company) {
			p.addUpdateComputer(name,company);
			TestContext.put("Computer Name", name);
		}

		@Then("User checks with the Computer Name was updated")
		public void verifyChangesMade() {
			Assert.assertEquals(TestContext.get("Computer Name"), p.getNameText());
		}
		
		@When("User delete the create computer")
		public void deleteAcomputer() {
			p.deleteComputer();
		}
}
