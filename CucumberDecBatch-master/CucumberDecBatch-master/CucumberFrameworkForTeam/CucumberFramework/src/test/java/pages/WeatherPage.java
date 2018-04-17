package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import cucumber.api.java.en.*;
import wrappers.WeatherMethods;
public class WeatherPage extends WeatherMethods {

	public WeatherPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(id="city")
	private WebElement city;

	@When("Enter city name (.*)")
	public void enterUserName(String name){
		type(city, name);
	}

	@When("Hit Enter key")
	public void hitEnter(){
		pressEnter(city);
	}

	@Then("Verify 3 hourly forecast (.*)")
	public void verifyHourlyForecast(int day) {
		String hourXpath = "((//span[@class='name'])["+day+"]/following::div[@class='details'])[1]//span[@class='hour']";
		verifyIntervalOfElements(hourXpath, 3);
	}
	@FindAll({@FindBy(className="name")})
	private List<WebElement> dayElements;

	@When("Verify 5 day weather forecast displayed")
	public void verifyNumOfDays(){
		verifyCountOfElements(dayElements, 5);
	}

	@FindBy(xpath="//div[@data-test='error']")
	private WebElement error;	

	@When("Verify Error Message (.*)")
	public void verifyErrorMsg(String errorMsg){
		verifyText(error, errorMsg);
	}

	@When("Select Day (.*)")
	public void clickDay(int day){
		click(dayElements.get(day-1));
	}



	@Then("Verify hourly forecast is hidden (.*)")
	public void isHourlyForecastHidden(int day) {
		String hourXpath = "((//span[@class='name'])["+day+"]/following::div[@class='details'])[1]//span[@class='hour']";
		isHidden(hourXpath);
	}


	

	private boolean verifyIntervalOfElements(String xpath, int count) {
		boolean bIntervalMatch = true;
		List<WebElement> eles = getDriver().findElementsByXPath(xpath);
		for (int i = 1; i < eles.size(); i++) {
			int prevHour = Integer.parseInt(eles.get(i-1).getText()) + (count*100);			
			int presentHour = Integer.parseInt(eles.get(i).getText()) ;
			if(prevHour != presentHour) {
				bIntervalMatch = false;
				reportStep("The interval between hours "+prevHour+" and the following does not match.", "WARN");
				break;
			}
		}		
		if(bIntervalMatch)
			reportStep("The interval between all hours are within "+count+" hours.", "PASS");

		return false;
	}
	
	private boolean verifyContents(String xpath, int actualVal) {
		int expectedVal = Integer.parseInt(getTextByXpath(xpath).replaceAll("\\D", ""));
		if(expectedVal == actualVal) {
			reportStep("Expected value matches with actual value "+actualVal , "PASS");
			return true;
		}else {
			reportStep("Expected value :"+expectedVal+" does not matches with actual value "+actualVal , "PASS");
			return false;
		}
	}

}
