package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)


@CucumberOptions(features = {"src/test/resources/features/Login.feature"},
				 glue = {"stepDefinitions"}, monochrome = true,
				 plugin = {"pretty", "html:target"},
				 strict = true)

public class RunCucumber {

}
