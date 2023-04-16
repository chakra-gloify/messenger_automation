package com.facebook.generics;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.facebook.pom.HomePage;
import com.facebook.pom.Login;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	static {
		WebDriverManager.chromedriver().setup();
	}

	public static WebDriver driver;
	

	@BeforeClass
	public void openBrowser() {

		driver=new ChromeDriver(notificationPopup());			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@AfterClass
	public void closeBrowser() {

		driver.close();
	}

	@BeforeMethod
	public void login() throws IOException, InterruptedException {

		FileLib f=new FileLib();
		String url = f.getProperty("url");
		String email = f.getProperty("email");
		String pwd = f.getProperty("password");

		driver.get(url);
		Login l=new Login(driver);
		l.getEmailTxtBox().sendKeys(email);
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		l.getPwdTxtBox().sendKeys(pwd);
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Thread.sleep(5000);
		l.getLoginBtn().click();
	}

	@AfterMethod
	public void logOut() throws InterruptedException {
		
		HomePage h=new HomePage(driver);
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		h.getUserImg().click();
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		h.getLogOutBtn().click();
	}

	public ChromeOptions notificationPopup() {
		
		ChromeOptions option=new ChromeOptions();
		ChromeOptions value = option.addArguments("--disable-notifications");
		return value;
	}
}
