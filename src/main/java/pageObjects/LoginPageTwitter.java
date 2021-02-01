package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageTwitter {
	public WebDriver driver;

	By usernameTxtBox = By.xpath("//input[@name='session[username_or_email]' and @type='text']");
	By passwordTxtBox = By.xpath("//input[@name='session[password]' and @type='password']");
	By loginBtn = By.xpath("//div[@data-testid='LoginForm_Login_Button']");

	public LoginPageTwitter(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUsernameTxtBox() {
		return driver.findElement(usernameTxtBox);
	}

	public WebElement getPasswordTxtBox() {
		return driver.findElement(passwordTxtBox);
	}

	public WebElement getLoginBtn() {
		return driver.findElement(loginBtn);
	}
}
