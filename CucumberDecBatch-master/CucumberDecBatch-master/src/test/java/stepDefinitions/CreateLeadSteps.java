package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateLeadSteps extends BaseSteps {
	
	@And("Enter Company name (.*)")
	public void entercName(String CName) {
		driver.findElementById("createLeadForm_companyName").clear();
		driver.findElementById("createLeadForm_companyName").sendKeys(CName);
	}
	
	@And("Enter First name (.*)")
	public void enterfName(String fName) {
		driver.findElementById("createLeadForm_firstName").sendKeys(fName);
	}
	
	@And("Enter Last name (.*)")
	public void enterlName(String lName) {
		driver.findElementById("createLeadForm_lastName").sendKeys(lName);
	}
	
	@When("I click on Create Lead button")
	public void clickCreateLeadButton() {
		driver.findElementByName("submitButton").click();
	}
	
	@Then("Lead should be created successfully")
	public void validateCreateLead() {
		System.out.println("Lead created successfully");
	}

}
