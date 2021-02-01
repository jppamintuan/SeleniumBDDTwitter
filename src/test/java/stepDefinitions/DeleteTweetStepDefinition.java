package stepDefinitions;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import common.base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePageTwitter;
import pageObjects.LandingPageTwitter;
import pageObjects.LoginPageTwitter;

public class DeleteTweetStepDefinition extends base {

	public static Logger log = LogManager.getLogger(base.class.getName());

	int beforeDelete;

	@Given("^Chrome browser initialization$")
	public void chrome_browser_initialization() throws Throwable {
		driver = initializeDriver();
		driver.manage().window().maximize();
	}

	@And("^Go to \"([^\"]*)\" website$")
	public void go_to_something_website(String url) throws Throwable {
		driver.get(url);
	}

	@And("^Click login button on landing Page$")
	public void click_login_button_on_landing_page() throws Throwable {
		LandingPageTwitter landingPage = new LandingPageTwitter(driver);
		landingPage.getLoginBtn().click();
	}

	@And("^User enters valid Username and Password then click Login Button on Login Page$")
	public void user_enters_valid_username_and_password_then_click_login_button_on_login_page() throws Throwable {
		LoginPageTwitter loginPage = new LoginPageTwitter(driver);
		loginPage.getUsernameTxtBox().sendKeys("HoolahTesting");
		loginPage.getPasswordTxtBox().sendKeys("hoolah39");
		loginPage.getLoginBtn().click();
		Thread.sleep(5000);
		HomePageTwitter homePage = new HomePageTwitter(driver);
		List<WebElement> beforeDeleteTweet = homePage.getSentTweets();
		int beforeDelete = beforeDeleteTweet.size();
		this.beforeDelete = beforeDelete;
	}

	@When("^User clicks caret button$")
	public void user_clicks_caret_button() throws Throwable {
		HomePageTwitter homePage = new HomePageTwitter(driver);
		List<WebElement> caret = homePage.getCaret();
		caret.get(0).click();
	}

	@And("^User clicks delete button$")
	public void user_clicks_delete_button() throws Throwable {
		HomePageTwitter homePage = new HomePageTwitter(driver);
		List<WebElement> caretItem = homePage.getCaretItem();
		caretItem.get(0).click();
	}

	@And("^User clicks delete confirmation button$")
	public void user_clicks_delete_confirmation_button() throws Throwable {
		HomePageTwitter homePage = new HomePageTwitter(driver);
		homePage.getDeleteConfirmationBtn().click();
		Thread.sleep(3000);
	}

	@Then("^Most recent tweet should be deleted$")
	public void most_recent_tweet_should_be_deleted() throws Throwable {
		HomePageTwitter homePage = new HomePageTwitter(driver);
		List<WebElement> afterDeleteTweet = homePage.getSentTweets();
		int afterDelete = afterDeleteTweet.size();

		boolean tweetCountDecreased = false;
		if (beforeDelete > afterDelete) {
			tweetCountDecreased = true;
			log.info("Deleted recent tweet");
			Assert.assertTrue(tweetCountDecreased);
		}

		if (!tweetCountDecreased) {
			Assert.fail();
			log.info("Didn't delete recent tweet");
		}
	}

	@And("^Close the browser$")
	public void close_the_browser() throws Throwable {
		driver.quit();
	}
}
