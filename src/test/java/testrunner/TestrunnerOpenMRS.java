package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/FeaturesOpenMRS" }, 
glue = { "stepdefinations","com.openmrs.hooks" }, plugin = { "pretty"
}, monochrome = true, dryRun = false
//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
)
public class TestrunnerOpenMRS {

}
