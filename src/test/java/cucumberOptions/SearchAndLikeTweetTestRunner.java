package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(  
	    features = "src/test/java/features/SearchAndLikeTweet.feature",
	    glue="stepDefinitions")
public class SearchAndLikeTweetTestRunner extends AbstractTestNGCucumberTests{

}