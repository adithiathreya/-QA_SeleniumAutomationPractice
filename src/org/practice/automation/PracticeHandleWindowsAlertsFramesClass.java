package org.practice.automation;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class PracticeHandleWindowsAlertsFramesClass {
	
	WebDriver driver;
	
	//using (enable=false), when testing another method only
	@Test(enabled=false)
	public void handleWindowsorTabs() throws InterruptedException {

		driver = new ChromeDriver();
		String passingURL = "https://demoqa.com/browser-windows/";
		driver.get(passingURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Actions action = new Actions(driver);
		action.keyDown(Keys.COMMAND).click(driver.findElement(By.xpath("//button[text()='New Tab']"))).perform();
		
		//switching between windows or tabs
		//get Set of windows to be handled
		Set<String> windowsID = driver.getWindowHandles(); //windows and tabs are same in automation
		System.out.println("Windows string " + windowsID);
		
		//iterator to go through the set of windows
		Iterator<String> windowsIterator = windowsID.iterator();
		
		//iterator.next() method to access the next window/tab
		String window1 = windowsIterator.next();
		String window2 = windowsIterator.next();
		
		//switching between tabs to handle them
		driver.switchTo().window(window2);
		Thread.sleep(1000);
		driver.switchTo().window(window1);
		Thread.sleep(1000);
		
		driver.quit();
		
	}

	@Test(enabled=false)
	public void handleAlerts() throws InterruptedException {
		
		driver = new ChromeDriver();
		String passingURL = "https://demoqa.com/alerts";
		driver.get(passingURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		//click "Click me" button for alert to pop-up
		driver.findElement(By.cssSelector("button[id='alertButton']")).click();
		
		//alert with only 'ok' button to close the pop-up
		driver.switchTo().alert().accept();
		
		//alert with ok and cancel button to close the pop-up
		driver.navigate().refresh();
		driver.findElement(By.cssSelector("button[id='confirmButton']")).click();
		driver.switchTo().alert().dismiss();
		
		Thread.sleep(2000);
		
		//alert with textbox to fill
		driver.navigate().refresh();
		driver.findElement(By.cssSelector("button[id='promtButton']")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("PracticeSelenium");
		alert.accept();
		
		driver.close();
	}
	
	@Test
	public void handleFrames() {
		
		driver = new ChromeDriver();
		String passingURL = "https://demoqa.com/frames";
		driver.get(passingURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		//get text on the page
		System.out.println(driver.findElement(By.xpath("//*[contains(text(), 'Sample Iframe')]")).getText());
		
		//get text on the frame1
		//System.out.println(driver.findElement(By.xpath("//*[contains(text(), 'This is a sample page')]")).getText()); -->no such element: Unable to locate element because it is a frame
		driver.switchTo().frame("frame1");
		System.out.println(driver.findElement(By.xpath("//*[contains(text(), 'This is a sample page')]")).getText());
		
		//get text on frame2
		driver.navigate().refresh();
		driver.switchTo().frame("frame2");
		System.out.println(driver.findElement(By.xpath("//*[contains(text(), 'This is a sample page')]")).getText());
		
		driver.close();
	}
	
}
