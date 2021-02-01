package Twitter;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.base;
import pageObjects.HomePageTwitter;
import pageObjects.LandingPageTwitter;
import pageObjects.LoginPageTwitter;

public class SearchAndLikeTwitterTest extends base {
	public WebDriver driver;

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void searchAndLike() throws IOException, InterruptedException {
		driver.get(prop.getProperty("twitter_url"));
		LandingPageTwitter landingPage = new LandingPageTwitter(driver);
		landingPage.getLoginBtn().click();

		LoginPageTwitter loginPage = new LoginPageTwitter(driver);
		loginPage.getUsernameTxtBox().sendKeys("HoolahTesting");
		loginPage.getPasswordTxtBox().sendKeys("hoolah39");
		loginPage.getLoginBtn().click();
		Thread.sleep(5000);

		HomePageTwitter homePage = new HomePageTwitter(driver);
		homePage.getSearchTxtBoxArea().sendKeys("\"Wishclusive performance of \"Panalo\" now on Wish USA!\"");
		homePage.getSearchTxtBoxArea().sendKeys(Keys.RETURN);

		homePage.getLike().click();
		boolean flag = homePage.getUnlike().isDisplayed();
		assertTrue(flag);
		log.info("Tweet was liked");

		homePage.getUnlike().click();
		flag = homePage.getLike().isDisplayed();
		assertTrue(flag);
		log.info("Tweet was unliked");
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
