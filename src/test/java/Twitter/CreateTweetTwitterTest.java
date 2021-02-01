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

public class CreateTweetTwitterTest extends base {
	public WebDriver driver;

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void createTweet() throws IOException, InterruptedException {
		driver.get(prop.getProperty("twitter_url"));
		LandingPageTwitter landingPage = new LandingPageTwitter(driver);
		landingPage.getLoginBtn().click();

		LoginPageTwitter loginPage = new LoginPageTwitter(driver);
		loginPage.getUsernameTxtBox().sendKeys("HoolahTesting");
		loginPage.getPasswordTxtBox().sendKeys("hoolah39");
		loginPage.getLoginBtn().click();
		Thread.sleep(5000);

		String tweetText = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		HomePageTwitter homePage = new HomePageTwitter(driver);
		homePage.getHomeTweetTxtBoxArea().sendKeys(tweetText);
		homePage.getHomeTweetBtn().click();
		Thread.sleep(3000);

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

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
