package runner;

import java.util.ArrayList;
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
import cucumber.runtime.ClassFinder;
import cucumber.runtime.FeatureBuilder;
import cucumber.runtime.Runtime;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.RuntimeOptionsFactory;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;
import cucumber.runtime.model.CucumberFeature;
import gherkin.events.PickleEvent;

@RunWith(Cucumber.class)

@CucumberOptions(features = {"src/test/resources/features"},
glue 	  = {"stepDefinitions"})

public class RunTest {
	private TestNGCucumberRunner testNGCucumberRunner;
	private Runtime runtime;
    private RuntimeOptions runtimeOptions;
    private ResourceLoader resourceLoader;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        ClassLoader classLoader = this.getClass().getClassLoader();

        MultiLoader resourceLoader = new MultiLoader(classLoader);

        RuntimeOptionsFactory runtimeOptionsFactory = new RuntimeOptionsFactory(this.getClass());
        runtimeOptions = runtimeOptionsFactory.create();
		ClassFinder classFinder = new ResourceLoaderClassFinder(resourceLoader, classLoader);
		runtime = new Runtime(resourceLoader, classFinder, classLoader, runtimeOptions);


	}

	@Test(dataProvider = "features")
	public void runScenario(CucumberFeatureWrapper featureWrapper) throws Throwable {
		//testNGCucumberRunner.runCucumber(featureWrapper.getCucumberFeature());
		System.out.println(featureWrapper.getCucumberFeature().getUri());

		List<PickleEvent> pickles = runtime.compileFeature(featureWrapper.getCucumberFeature());

		for (PickleEvent pickle : pickles) {
			System.out.println(pickle.pickle.getName());
			Thread.sleep(5000);
		}

	}

	/**
	 * Returns two dimensional array of PickleEventWrapper scenarios with their associated CucumberFeatureWrapper feature.
	 *
	 * @return a two dimensional array of scenarios features.
	 */
	@DataProvider(name="features",parallel=true)
	public Object[][] scenarios() {
		return testNGCucumberRunner.provideFeatures();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		testNGCucumberRunner.finish();
	}}

