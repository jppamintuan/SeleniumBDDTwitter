package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageTwitter {
	public WebDriver driver;

	By searchTxtBoxArea = By.xpath("//input[@data-testid='SearchBox_Search_Input']");
	By like = By.xpath("//div[@data-testid='like']");
	By unlike = By.xpath("//div[@data-testid='unlike']");

	By replyBtn = By.xpath("//div[@data-testid='reply']");
	By replyTweetTxtBoxArea = By
			.xpath("//div[@data-testid='tweetTextarea_0' and @aria-controls='typeaheadDropdownWrapped-1']");
	By replyTweetBtn = By.xpath("//div[@data-testid='tweetButton']");

	By homeTweetTxtBoxArea = By
			.xpath("//div[@data-testid='tweetTextarea_0' and @aria-controls='typeaheadDropdownWrapped-0']");
	By homeTweetBtn = By.xpath("//div[@data-testid='tweetButtonInline']");

	By caret = By.xpath("//div[@data-testid='caret']");
	By caretItem = By.xpath("//div[@role='menuitem']");

	By sentTweets = By.xpath("//div[@data-testid='tweet']");

	By deleteConfirmationBtn = By.xpath("//div[@data-testid='confirmationSheetConfirm']");

	public HomePageTwitter(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getSearchTxtBoxArea() {
		return driver.findElement(searchTxtBoxArea);
	}

	public WebElement getLike() {
		return driver.findElement(like);
	}

	public WebElement getUnlike() {
		return driver.findElement(unlike);
	}

	public List<WebElement> getReplyBtn() {
		return driver.findElements(replyBtn);
	}

	public WebElement getReplyTweetTxtBoxArea() {
		return driver.findElement(replyTweetTxtBoxArea);
	}

	public WebElement getReplyTweetBtn() {
		return driver.findElement(replyTweetBtn);
	}

	public WebElement getHomeTweetTxtBoxArea() {
		return driver.findElement(homeTweetTxtBoxArea);
	}

	public WebElement getHomeTweetBtn() {
		return driver.findElement(homeTweetBtn);
	}

	public List<WebElement> getCaret() {
		return driver.findElements(caret);
	}

	public List<WebElement> getCaretItem() {
		return driver.findElements(caretItem);
	}

	public List<WebElement> getSentTweets() {
		return driver.findElements(sentTweets);
	}

	public WebElement getDeleteConfirmationBtn() {
		return driver.findElement(deleteConfirmationBtn);
	}
}
