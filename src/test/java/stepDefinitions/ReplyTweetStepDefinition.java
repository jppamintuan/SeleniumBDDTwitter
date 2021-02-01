package stepDefinitions;

import java.text.SimpleDateFormat;
import java.util.Date;
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

public class ReplyTweetStepDefinition extends base {

	public static Logger log = LogManager.getLogger(base.class.getName());
	String tweetText = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	@Given("^Initialize Chrome browser$")
	public void initialize_chrome_browser() throws Throwable {
		driver = initializeDriver();
		driver.manage().window().maximize();
	}

	@And("^Go to \"([^\"]*)\"$")
	public void go_to_something(String url) throws Throwable {
		driver.get(url);
	}

	@And("^Click on Login Button on Landing page$")
	public void click_on_login_button_on_landing_page() throws Throwable {
		LandingPageTwitter landingPage = new LandingPageTwitter(driver);
		landingPage.getLoginBtn().click();
	}

	@And("^User enters Valid Username and Password then clicks Login Button on Login Page$")
	public void user_enters_valid_username_and_password_then_clicks_login_button_on_login_page() throws Throwable {
		LoginPageTwitter loginPage = new LoginPageTwitter(driver);
		loginPage.getUsernameTxtBox().sendKeys("HoolahTesting");
		loginPage.getPasswordTxtBox().sendKeys("hoolah39");
		loginPage.getLoginBtn().click();
		Thread.sleep(5000);
	}

	@When("^User clicks reply button and enters a tweet on reply textbox area$")
	public void user_clicks_reply_button_and_enters_a_tweet_on_reply_textbox_area() throws Throwable {
		HomePageTwitter homePage = new HomePageTwitter(driver);
		List<WebElement> replyTweet = homePage.getReplyBtn();
		replyTweet.get(0).click();
		homePage.getReplyTweetTxtBoxArea().sendKeys(tweetText);
	}

	@And("^User clicks Reply Tweet Button$")
	public void user_clicks_reply_tweet_button() throws Throwable {
		HomePageTwitter homePage = new HomePageTwitter(driver);
		homePage.getReplyTweetBtn().click();
		Thread.sleep(3000);
	}

	@Then("^Replied Tweet should be displayed$")
	public void replied_tweet_should_be_displayed() throws Throwable {
		HomePageTwitter homePage = new HomePageTwitter(driver);
		List<WebElement> sentTweets = homePage.getSentTweets();

		String tweet = sentTweets.get(0).getText();
		boolean exist = false;
		if (tweet.contains(tweetText)) {
			log.info("Replied to recent tweet");
			exist = true;
			Assert.assertTrue(exist);
		}

		if (!exist) {
			Assert.fail();
			log.info("Didn't replied to recent tweet");
		}
	}

	@And("^Close Browser$")
	public void close_browser() throws Throwable {
		driver.quit();
	}
}