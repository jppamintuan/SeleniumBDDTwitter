package Twitter;

import java.io.IOException;
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

public class DeleteTweetTwitterTest extends base {
	public WebDriver driver;

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void deleteTweet() throws IOException, InterruptedException {
		driver.get(prop.getProperty("twitter_url"));
		LandingPageTwitter landingPage = new LandingPageTwitter(driver);
		landingPage.getLoginBtn().click();

		LoginPageTwitter loginPage = new LoginPageTwitter(driver);
		loginPage.getUsernameTxtBox().sendKeys("HoolahTesting");
		loginPage.getPasswordTxtBox().sendKeys("hoolah39");
		loginPage.getLoginBtn().click();
		Thread.sleep(3000);

		HomePageTwitter homePage = new HomePageTwitter(driver);

		List<WebElement> beforeDeleteTweet = homePage.getSentTweets();
		int beforeDelete = beforeDeleteTweet.size();

		List<WebElement> caret = homePage.getCaret();
		caret.get(0).click();

		List<WebElement> caretItem = homePage.getCaretItem();
		caretItem.get(0).click();
		homePage.getDeleteConfirmationBtn().click();
		Thread.sleep(3000);

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

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}