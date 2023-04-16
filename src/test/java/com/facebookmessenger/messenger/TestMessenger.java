package com.facebookmessenger.messenger;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.facebook.generics.BaseClass;
import com.facebook.generics.FileLib;
import com.facebook.pom.HomePage;

@Listeners(com.facebook.generics.ListenersImplementation.class)
public class TestMessenger extends BaseClass {

	@Test
	public void testMsg() throws InterruptedException, IOException {

		FileLib f=new FileLib();
		String msgTxt = f.getProperty("msg");
		String friendName = f.getProperty("friendname");
		
		HomePage h=new HomePage(driver);
		h.getMessengerBtn().click(); 
		Thread.sleep(3000);
		h.getSeeAllInMsgLink().click();
		Thread.sleep(3000);

		h.getSearchMessengerBar().sendKeys(friendName);
		Thread.sleep(3000);


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

		//Thread.sleep(5000);
		h.getChatMsgTxtBox().sendKeys(msgTxt);

		//Thread.sleep(5000);
		h.getPressToSndBtn().click();
		
	}
}
