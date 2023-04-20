package com.facebook.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatsPOM {
	
	@FindBy (xpath = "//div[@class='x78zum5 x1iyjqo2 x1gja9t x16n37ib x1xmf6yo x1e56ztr xeuugli x1n2onr6']/div[@class='xzsf02u x1a2a7pz x1n2onr6 x14wi4xw x1iyjqo2 x1gh3ibb xisnujt xeuugli x1odjw0f notranslate']")
	private WebElement chatMsgTxtBox;
	
	@FindBy (xpath = "//div[@aria-label='Press enter to send']")
	private WebElement pressToSndBtn;
	
	@FindBy (xpath = "//input[@placeholder='Search Messenger']")
	private WebElement searchMessengerBar;
	
	public ChatsPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getChatMsgTxtBox() {
		return chatMsgTxtBox;
	}

	public WebElement getPressToSndBtn() {
		return pressToSndBtn;
	}

	public WebElement getSearchMessengerBar() {
		return searchMessengerBar;
	}
	
	

}
