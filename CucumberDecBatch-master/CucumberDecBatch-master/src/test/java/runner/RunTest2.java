package runner;

import java.util.List;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.runtime.FeatureBuilder;
import cucumber.runtime.model.CucumberFeature;

@RunWith(Cucumber.class)

@CucumberOptions(features = {"src/test/resources/features"},
glue 	  = {"stepDefinitions"})

public class RunTest2 {
	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		
	}

	@Test(dataProvider = "features")
	public void runScenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper featureWrapper) throws Throwable {
		//testNGCucumberRunner.runCucumber(featureWrapper.getCucumberFeature());
		System.out.println(featureWrapper.getCucumberFeature().getUri());
		System.out.println(pickleEvent.toString());
		Thread.sleep(5000);
	}

	/**
	 * Returns two dimensional array of PickleEventWrapper scenarios with their associated CucumberFeatureWrapper feature.
	 *
	 * @return a two dimensional array of scenarios features.
	 */
	@DataProvider(name="features",parallel=false)
	public Object[][] scenarios() {
		return testNGCucumberRunner.provideScenarios();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		testNGCucumberRunner.finish();
	}}

