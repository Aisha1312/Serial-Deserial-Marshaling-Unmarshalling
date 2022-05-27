package RunnnerPackage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"resources/MarshallingUnmarshallingFeatureFiles"},
		glue = {"StepDefenition"},
		plugin = {"pretty", "html:target/cucumber-html-report","json:target/cucumber.json"},
		monochrome = true)
public class MarshallingUnmarshallingRunner extends AbstractTestNGCucumberTests {

}
