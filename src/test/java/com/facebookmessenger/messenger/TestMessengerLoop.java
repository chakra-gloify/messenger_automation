package com.facebookmessenger.messenger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.facebook.generics.BaseClass;
import com.facebook.generics.FileLib;
import com.facebook.pom.ChatsPOM;
import com.facebook.pom.HomePage;

public class TestMessengerLoop extends BaseClass {
	@Test
	public void testMsg() throws InterruptedException, IOException {

		FileLib f=new FileLib();
		String msgTxt = f.getProperty("msg");
		String friendName = f.getProperty("friendname");
		String friendName2 = f.getProperty("friendname2");
		String friendName3 = f.getProperty("friendname3");

		ArrayList<String>a=new ArrayList<String>();
		a.add(friendName);
		a.add(friendName2);
		a.add(friendName3);

		HomePage h=new HomePage(driver);
		h.getMessengerBtn().click(); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		h.getSeeAllInMsgLink().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ChatsPOM c=new ChatsPOM(driver);
		for (Iterator<String> iterator = a.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			c.getSearchMessengerBar().sendKeys(string);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//li/div/a[.='"+string+"']")).click();
			WebDriverWait wait=new WebDriverWait(driver, 10);
			WebElement title = driver.findElement(By.xpath("//a[@aria-label='"+string+"']"));
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(title)));

			try {
				c.getChatMsgTxtBox().sendKeys(msgTxt);
			} 
			catch (StaleElementReferenceException e) {
				c.getChatMsgTxtBox().sendKeys(msgTxt);
			}
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			c.getPressToSndBtn().click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} 		
	}
}
