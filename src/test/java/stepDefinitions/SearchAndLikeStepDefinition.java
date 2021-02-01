package stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;

import common.base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePageTwitter;
import pageObjects.LandingPageTwitter;
import pageObjects.LoginPageTwitter;

public class SearchAndLikeStepDefinition extends base {

	public static Logger log = LogManager.getLogger(base.class.getName());

	@Given("^Chrome Browser is initialized$")
	public void chrome_browser_is_initialized() throws Throwable {
		driver = initializeDriver();
		driver.manage().window().maximize();
	}

	@And("^Navigate To \"([^\"]*)\"$")
	public void navigate_to_something(String url) throws Throwable {
		driver.get(url);
	}

	@And("^Click on Login button on Landing page$")
	public void click_on_login_button_on_landing_page() throws Throwable {
		LandingPageTwitter landingPage = new LandingPageTwitter(driver);
		landingPage.getLoginBtn().click();
	}

	@And("^User enters valid username and password clicks Login Button on Login Page$")
	public void user_enters_valid_username_and_password_clicks_login_button_on_login_page() throws Throwable {
		LoginPageTwitter loginPage = new LoginPageTwitter(driver);
		loginPage.getUsernameTxtBox().sendKeys("HoolahTesting");
		loginPage.getPasswordTxtBox().sendKeys("hoolah39");
		loginPage.getLoginBtn().click();
		Thread.sleep(5000);
	}

	@When("^User enters \"([^\"]*)\" and clicks enter key on search text box area on home page$")
	public void user_enters_something_and_clicks_enter_key_on_search_text_box_area_on_home_page(String strArg1)
			throws Throwable {
		HomePageTwitter homePage = new HomePageTwitter(driver);
		homePage.getSearchTxtBoxArea().sendKeys(strArg1);
		homePage.getSearchTxtBoxArea().sendKeys(Keys.RETURN);
	}

	@And("^User clicks like button$")
	public void user_clicks_like_button() throws Throwable {
		HomePageTwitter homePage = new HomePageTwitter(driver);
		homePage.getLike().click();
	}

	@Then("^Tweet should be liked$")
	public void tweet_should_be_liked() throws Throwable {
		HomePageTwitter homePage = new HomePageTwitter(driver);
		boolean flag = homePage.getUnlike().isDisplayed();
		assertTrue(flag);
		log.info("Tweet was liked");
	}

	@And("^Tweet is to be unliked for data cleanup$")
	public void tweet_is_to_be_unliked_for_data_cleanup() throws Throwable {
		HomePageTwitter homePage = new HomePageTwitter(driver);
		homePage.getUnlike().click();
		boolean flag = homePage.getLike().isDisplayed();
		assertTrue(flag);
		log.info("Tweet was unliked");
	}

	@And("^Quit Browser$")
	public void quit_browser() throws Throwable {
		driver.quit();
	}
}