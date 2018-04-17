package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends BaseSteps {
	
	@Before
	public void beforeCommon(Scenario scenario) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println(scenario.getId());
		System.out.println(scenario.getName());
	}
	
	@After
	public void afterCommon(Scenario scenario) {
		System.out.println(scenario.isFailed());
		System.out.println(scenario.getStatus());
		driver.quit();
	}

}
