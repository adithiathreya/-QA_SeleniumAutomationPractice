package org.practice.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PracticeBrowserControlClass {
	
	WebDriver driver;
	
	@Test
	public void launchBrowser() throws InterruptedException {
		//launch the browser
		driver = new ChromeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		//pass first url
		driver.get("https://www.google.com/");
		Thread.sleep(1000);
		
		//pass second url
		driver.get("https://www.facebook.com/");
		Thread.sleep(1000);
		
		//go back to earlier page/first url
		driver.navigate().back();
		Thread.sleep(1000);
		
		//go forward to second url
		driver.navigate().forward();
		Thread.sleep(1000);
		
		//refresh the page
		driver.navigate().refresh();
		Thread.sleep(1000);
		
		//pass the url using navigate method
		driver.navigate().to("https://www.gmail.com");
		
		//close one window at a time
		driver.close();
		
		//close multiple window at a time
		//driver.quit();
	}
}
