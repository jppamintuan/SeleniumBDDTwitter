package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPageTwitter {
	public WebDriver driver;

	By loginBtn = By.xpath("//a[@href='/login']");

	public LandingPageTwitter(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLoginBtn() {
		return driver.findElement(loginBtn);
	}
}
