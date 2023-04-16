package com.facebook.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy (xpath = "//div[@aria-label='Messenger' and @tabindex=0]")
	private WebElement messengerBtn;
	
	@FindBy (xpath = "//div[@class='x78zum5 x1n2onr6']")
	private WebElement userImg;
	
	@FindBy (xpath = "//span[.='Log Out']")
	private WebElement logOutBtn;
	
	@FindBy (xpath = "//span/a[@href='/messages/t/new/']")
	private WebElement newMsgBtn;
	
	@FindBy (xpath = "//input[@placeholder='Search Messenger']")
	private WebElement searchMessengerBar;
	
	@FindBy (id=":r18p:")
	private WebElement toSearchBar;
	
	@FindBy (xpath = "//div[@class='x9f619 x1n2onr6 x1ja2u2z x78zum5 xdt5ytf x2lah0s x193iq5w xeuugli x1iyjqo2']/div/span/span")
	private List<WebElement> chatUserList;
	
	@FindBy (xpath = "//div[@class='x78zum5 x1iyjqo2 x1gja9t x16n37ib x1xmf6yo x1e56ztr xeuugli x1n2onr6']/div[@class='xzsf02u x1a2a7pz x1n2onr6 x14wi4xw x1iyjqo2 x1gh3ibb xisnujt xeuugli x1odjw0f notranslate']")
	private WebElement chatMsgTxtBox;
	
	@FindBy (xpath = "//div[@aria-label='Press enter to send']")
	private WebElement pressToSndBtn;
	
	@FindBy (linkText = "See all in Messenger")
	private WebElement seeAllInMsgLink;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getMessengerBtn() {
		return messengerBtn;
	}

	public WebElement getUserImg() {
		return userImg;
	}

	public WebElement getLogOutBtn() {
		return logOutBtn;
	}

	public WebElement getNewMsgBtn() {
		return newMsgBtn;
	}

	public WebElement getSearchMessengerBar() {
		return searchMessengerBar;
	}

	public WebElement getToSearchBar() {
		return toSearchBar;
	}

	public List<WebElement> getChatUserList() {
		return chatUserList;
	}

	public WebElement getChatMsgTxtBox() {
		return chatMsgTxtBox;
	}

	public WebElement getPressToSndBtn() {
		return pressToSndBtn;
	}

	public WebElement getSeeAllInMsgLink() {
		return seeAllInMsgLink;
	}
	
	
}
