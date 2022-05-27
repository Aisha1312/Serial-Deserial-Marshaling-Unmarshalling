package RunnnerPackage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features = {"resources/BestBuyFeaturesFiles"},
	glue = {"StepDefenition"},
	plugin = {"pretty", "html:target/cucumber-html-report","json:target/cucumber.json"},
	monochrome = true)
public class BestBuyRunner extends AbstractTestNGCucumberTests{

}
