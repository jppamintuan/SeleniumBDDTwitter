package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(  
	    features = "src/test/java/features/DeleteTweet.feature",
	    glue="stepDefinitions")
public class DeleteTweetTestRunner extends AbstractTestNGCucumberTests{

}