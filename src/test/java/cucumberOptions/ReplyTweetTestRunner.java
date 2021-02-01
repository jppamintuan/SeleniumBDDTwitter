package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(  
	    features = "src/test/java/features/ReplyTweet.feature",
	    glue="stepDefinitions")
public class ReplyTweetTestRunner extends AbstractTestNGCucumberTests{

}