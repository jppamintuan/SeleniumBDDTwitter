package Twitter;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.base;
import pageObjects.LandingPageTwitter;
import pageObjects.LoginPageTwitter;

public class ParameterizedLoginTwitterTest extends base {
	public WebDriver driver;

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "getData")
	public void login(String username, String password, String logTxt) throws IOException, InterruptedException {
		driver.get(prop.getProperty("twitter_url"));
		LandingPageTwitter landingPage = new LandingPageTwitter(driver);
		landingPage.getLoginBtn().click();

		LoginPageTwitter loginPage = new LoginPageTwitter(driver);
		loginPage.getUsernameTxtBox().sendKeys(username);
		loginPage.getPasswordTxtBox().sendKeys(password);
		loginPage.getLoginBtn().click();

		if (logTxt.equalsIgnoreCase("Invalid User")) {
			String currentURL = driver.getCurrentUrl();
			Assert.assertTrue(currentURL.contains("https://twitter.com/login"));
			log.info("Invalid credentials was used");
			log.info("Unsuccessful Login");
		}

		else if (logTxt.equalsIgnoreCase("Valid User")) {
			String currentURL = driver.getCurrentUrl();
			Assert.assertTrue(currentURL.contains("https://twitter.com/home"));
			log.info("Valid credentials was used");
			log.info("Successful Login");
		}
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		data[0][0] = "invalid@user.xxx";
		data[0][1] = "619tezcka39";
		data[0][2] = "Invalid User";

		data[1][0] = "HoolahTesting";
		data[1][1] = "hoolah39";
		data[1][2] = "Valid User";

		return data;
	}
}
