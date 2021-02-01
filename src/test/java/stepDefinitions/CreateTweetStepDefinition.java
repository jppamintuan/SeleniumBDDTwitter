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

public class CreateTweetStepDefinition extends base {

	public static Logger log = LogManager.getLogger(base.class.getName());
	String tweetText = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	@Given("^Open Chrome Browser$")
	public void open_chrome_browser() throws Throwable {
		driver = initializeDriver();
		driver.manage().window().maximize();
	}

	@And("^Go to \"([^\"]*)\" site$")
	public void go_to_something_site(String url) throws Throwable {
		driver.get(url);
	}

	@And("^Click Login Button on landing page$")
	public void click_login_button_on_landing_page() throws Throwable {
		LandingPageTwitter landingPage = new LandingPageTwitter(driver);
		landingPage.getLoginBtn().click();
	}

	@And("^User enters Valid Username and Password then click Login Button on Login Page$")
	public void user_enters_valid_username_and_password_then_click_login_button_on_login_page() throws Throwable {
		LoginPageTwitter loginPage = new LoginPageTwitter(driver);
		loginPage.getUsernameTxtBox().sendKeys("HoolahTesting");
		loginPage.getPasswordTxtBox().sendKeys("hoolah39");
		loginPage.getLoginBtn().click();
		Thread.sleep(5000);
	}

	@When("^User enters a tweet on home page textbox area$")
	public void user_enters_a_tweet_on_home_page_textbox_area() throws Throwable {
		HomePageTwitter homePage = new HomePageTwitter(driver);
		homePage.getHomeTweetTxtBoxArea().sendKeys(tweetText);
	}

	@And("^User clicks Tweet Button$")
	public void user_clicks_tweet_button() throws Throwable {
		HomePageTwitter homePage = new HomePageTwitter(driver);
		homePage.getHomeTweetBtn().click();
		Thread.sleep(3000);
	}

	@Then("^Tweet should be posted$")
	public void tweet_should_be_posted() throws Throwable {
		HomePageTwitter homePage = new HomePageTwitter(driver);
		List<WebElement> sentTweets = homePage.getSentTweets();

		boolean exist = false;
		for (int i = 0; i < sentTweets.size(); i++) {
			String tweet = sentTweets.get(i).getText();
			if (tweet.contains(tweetText)) {
				log.info("Tweet was posted");
				exist = true;
				Assert.assertTrue(exist);
				break;
			}
		}

		if (!exist) {
			Assert.fail();
			log.info("Tweet was not posted");
		}
	}

	@And("^Close browser$")
	public void close_browser() throws Throwable {
		driver.quit();
	}
}
