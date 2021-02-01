package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import common.base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPageTwitter;
import pageObjects.LoginPageTwitter;

public class LoginStepDefinition extends base {

	public static Logger log = LogManager.getLogger(base.class.getName());

	@Given("^Chrome browser is initialized$")
	public void chrome_browser_is_initialized() throws Throwable {
		driver = initializeDriver();
		driver.manage().window().maximize();
	}

	@And("^Navigate to \"([^\"]*)\"$")
	public void navigate_to_something(String url) throws Throwable {
		driver.get(url);
	}

	@And("^Click on Login button on landing page$")
	public void click_on_login_button_on_landing_page() throws Throwable {
		LandingPageTwitter landingPage = new LandingPageTwitter(driver);
		landingPage.getLoginBtn().click();
	}

	@When("^User enters (.+) and (.+) and clicks Login button on Login Page$")
	public void user_enters_and_and_clicks_login_button_on_login_page(String username, String password) {
		LoginPageTwitter loginPage = new LoginPageTwitter(driver);
		loginPage.getUsernameTxtBox().sendKeys(username);
		loginPage.getPasswordTxtBox().sendKeys(password);
		loginPage.getLoginBtn().click();
	}

	@Then("^Verify that user is succesfully logged in or not depending on (.+)$")
	public void verify_that_user_is_succesfully_logged_in_or_not_depending_on_credentials(String credentials)
			throws Throwable {
		if (credentials.equalsIgnoreCase("Invalid User")) {
			String currentURL = driver.getCurrentUrl();
			Assert.assertTrue(currentURL.contains("https://twitter.com/login"));
			log.info("Invalid credentials was used");
			log.info("Unsuccessful Login");
		}

		else if (credentials.equalsIgnoreCase("Valid User")) {
			String currentURL = driver.getCurrentUrl();
			Assert.assertTrue(currentURL.contains("https://twitter.com/home"));
			log.info("Valid credentials was used");
			log.info("Successful Login");
		}
	}

	@And("^Quit browser$")
	public void quit_browser() throws Throwable {
		driver.quit();
	}
}