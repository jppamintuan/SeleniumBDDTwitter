package Twitter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.base;
import pageObjects.HomePageTwitter;
import pageObjects.LandingPageTwitter;
import pageObjects.LoginPageTwitter;

public class ReplyTweetTwitterTest extends base {

	public WebDriver driver;

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void replyTweet() throws IOException, InterruptedException {
		driver.get(prop.getProperty("twitter_url"));
		LandingPageTwitter landingPage = new LandingPageTwitter(driver);
		landingPage.getLoginBtn().click();

		LoginPageTwitter loginPage = new LoginPageTwitter(driver);
		loginPage.getUsernameTxtBox().sendKeys("HoolahTesting");
		loginPage.getPasswordTxtBox().sendKeys("hoolah39");
		loginPage.getLoginBtn().click();
		Thread.sleep(3000);

		String tweetText = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		HomePageTwitter homePage = new HomePageTwitter(driver);

		List<WebElement> replyTweet = homePage.getReplyBtn();

		replyTweet.get(0).click();
		homePage.getReplyTweetTxtBoxArea().sendKeys(tweetText);
		homePage.getReplyTweetBtn().click();
		Thread.sleep(3000);

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

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
