package stepDefinitions;

import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps extends BaseSteps {
	
	
	
	/*@Given("Launch the browser")
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.leaftaps.com/opentaps");
	}
	
	@And("Maximixe the window")
	public void maxWindow() {
		driver.manage().window().maximize();
	}
	
	@And("Set the Timeouts")
	public void setTimeout() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}*/
	
	@And("Enter the credentials")
	public void enterCredentials(DataTable dt) {
		List<List<String>> allList = dt.raw();
		String Uname = allList.get(1).get(0);
		String pwd = allList.get(1).get(1);
		driver.findElementById("username").sendKeys(Uname);
		driver.findElementById("password").sendKeys(pwd);
	}
	
	@And("I enter the username as (.*)")
	public void enterUName(String uName) {
		if(driver!=null) {
		driver.findElementById("username").sendKeys(uName);
		}
	}
	
	@And("I enter the password as (.*)")
	public void enterPassword(String pwd) {
		driver.findElementById("password").sendKeys(pwd);
	}
	
	@When("I click on the Login Button")
	public void clickLogin() {
		driver.findElementByClassName("decorativeSubmit").click();
	}
	
	@Then("I should see the Login successful")
	public void validateLogin() {
		System.out.println("Login is Successful");
	}
	
	@And("Close the Browser")
	public void closeBrowser() {
		driver.quit();
	}
	@But("Login should be failed")
	public void errorLogin() {
		System.out.println("Login Failed");
	}
	

}
