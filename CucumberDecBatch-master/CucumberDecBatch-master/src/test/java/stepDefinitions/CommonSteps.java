package stepDefinitions;

import cucumber.api.java.en.And;

public class CommonSteps extends BaseSteps {
	
	@And("Click CRM/SFA")
	public void clickCRMSFA() {
		driver.findElementByLinkText("CRM/SFA").click();
	}
	
	@And("Click Leads Link")
	public void clickLeads() {
		driver.findElementByLinkText("Leads").click();
	}
	
	@And("Click Find Leads")
	public void clickFindLeadsLink() {
		driver.findElementByLinkText("Find Leads").click();
	}
	
	@And("Enter first name as (.*)")
	public void enterFName(String fName) {
		driver.findElementByXPath("//input[@name='firstName']").sendKeys(fName);
	}
	
	@And("Click Find leads button")
	public void clickFindLeadsButton() throws Exception {
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(3000);
	}
	
	@And("Click Create Lead Link")
	public void clickCreateLeadLink() {
		driver.findElementByLinkText("Create Lead").click();
	}
	
	@And("Click on first resulting lead")
	public void clickFirstResultingLeadID() {
		driver.findElementByXPath("//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a").click();
	}
	
	@And("Click Edit button")
	public void clickEditbutton() {
		driver.findElementByLinkText("Edit").click();
	}

}
