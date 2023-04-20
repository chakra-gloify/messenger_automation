package com.facebookmessenger.messenger;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.facebook.generics.BaseClass;
import com.facebook.generics.FileLib;
import com.facebook.pom.ChatsPOM;
import com.facebook.pom.HomePage;

@Listeners(com.facebook.generics.ListenersImplementation.class)
public class TestMessenger extends BaseClass {

	@Test
	public void testMsg() throws InterruptedException, IOException {

		FileLib f=new FileLib();
		String msgTxt = f.getProperty("msg");
		String friendName = f.getProperty("friendname");
		String friendName2 = f.getProperty("friendname2");
		String friendName3 = f.getProperty("friendname3");

		HomePage h=new HomePage(driver);
		h.getMessengerBtn().click(); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(3000);
		h.getSeeAllInMsgLink().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(3000);
		ChatsPOM c=new ChatsPOM(driver);
		c.getSearchMessengerBar().sendKeys(friendName);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(3000)
		driver.findElement(By.xpath("//li/div/a[.='"+friendName+"']")).click();

		/*List<WebElement> autoSugg = driver.findElements(By.xpath("//div[@class='x1n2onr6']/div/div/div/a"));

		for (WebElement webElement : autoSugg) {
			System.out.println(webElement.getText());
			if (friendName.equals(webElement.getText())) {
				webElement.click();
				System.out.println(driver.findElement(By.xpath("(//span[normalize-space()='"+friendName+"'])[3]")).getText());
				break;
			}			
		}*/
		try {
			c.getChatMsgTxtBox().sendKeys(msgTxt);
		} 
		catch (StaleElementReferenceException e) {
			c.getChatMsgTxtBox().sendKeys(msgTxt);
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		c.getPressToSndBtn().click();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.wait();

		//Second Message

		c.getSearchMessengerBar().sendKeys(friendName2);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//li/div/a[.='"+friendName2+"']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		try {
			c.getChatMsgTxtBox().sendKeys(msgTxt);
		} 
		catch (StaleElementReferenceException e) {
			c.getChatMsgTxtBox().sendKeys(msgTxt);
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		c.getPressToSndBtn().click();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.wait();

		//Third Message

		c.getSearchMessengerBar().sendKeys(friendName3);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//li/div/a[.='"+friendName3+"']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		try {
			c.getChatMsgTxtBox().sendKeys(msgTxt);
		} 
		catch (StaleElementReferenceException e) {
			c.getChatMsgTxtBox().sendKeys(msgTxt);
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		c.getPressToSndBtn().click();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

	}
}