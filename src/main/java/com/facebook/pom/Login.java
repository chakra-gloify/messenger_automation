package com.facebook.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	@FindBy (id = "email")
	private WebElement emailTxtBox;

	@FindBy (id = "pass")
	private WebElement pwdTxtBox;

	@FindBy (name = "login")
	private WebElement loginBtn;

	@FindBy (linkText = "Forgotten password?")
	private WebElement forgotPwdLink;

	@FindBy (id = "u_0_0_2Y")
	private WebElement createAcBtn;

	@FindBy (linkText = "Create a Page")
	private WebElement createAPgLink;

	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmailTxtBox() {
		return emailTxtBox;
	}

	public WebElement getPwdTxtBox() {
		return pwdTxtBox;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getForgotPwdLink() {
		return forgotPwdLink;
	}

	public WebElement getCreateAcBtn() {
		return createAcBtn;
	}

	public WebElement getCreateAPgLink() {
		return createAPgLink;
	}

}
