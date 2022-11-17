package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/Feature" }, glue = { "StepDefinitions", "Hooks" }, plugin = {
		"pretty", "html:target/HtmlReports" },

		monochrome = true)
public class ebayTestRunner extends AbstractTestNGCucumberTests {

}
