package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(  
	    features = "src/test/java/features/CreateTweet.feature",
	    glue="stepDefinitions")
public class CreateTweetTestRunner extends AbstractTestNGCucumberTests{

}