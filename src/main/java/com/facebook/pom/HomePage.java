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

	@FindBy (id=":r18p:")
	private WebElement toSearchBar;

	@FindBy (xpath = "//div[@class='x9f619 x1n2onr6 x1ja2u2z x78zum5 xdt5ytf x2lah0s x193iq5w xeuugli x1iyjqo2']/div/span/span")
	private List<WebElement> chatUserList;

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

	public WebElement getToSearchBar() {
		return toSearchBar;
	}

	public List<WebElement> getChatUserList() {
		return chatUserList;
	}

	public WebElement getSeeAllInMsgLink() {
		return seeAllInMsgLink;
	}


}
