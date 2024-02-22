package org.practice.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class PracticeHandleKeyboardMouse {
	
	WebDriver driver;
	
	@Test
	public void handleKeyboard() throws InterruptedException {
		driver = new ChromeDriver();
		
		String passingURL = "https://www.facebook.com/";
		driver.get(passingURL);
		
		//Action class to access special keys in keyboard
		Actions action = new Actions(driver);
		
		//as cursor is directly in 'Email or phone number' textbox, directly enter email
		action.sendKeys("practiceselenium@gmail.com").perform();
		
		//ctrlA+back_space key to delete all the text in textbox
		action.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).sendKeys(Keys.DELETE).perform(); //keys.CONTROL for windows
		action.sendKeys("practiceselenium@gmail.com").perform();
		
		//tab key to go to 'Password' textbox
		action.sendKeys(Keys.TAB).perform();
		action.sendKeys("password123").perform();
		
		//page down key
		action.sendKeys(Keys.PAGE_DOWN);
		
		//enter key to click 'Log In' button
		action.sendKeys(Keys.ENTER).perform();
		
		driver.close();
	}
	
	@Test
	public void handleMouse() throws InterruptedException {
		driver = new ChromeDriver();
		
		String passingURL = "https://www.facebook.com/";
		driver.get(passingURL);
		
		//Action class to access mouse keys
		Actions action = new Actions(driver);
		
		//mouse click action on'Forgot password' link text
		action.click(driver.findElement(By.xpath("//a[text()='Forgot password?']"))).perform(); // single click
		//action.doubleClick(driver.findElement(By.xpath("//a[text()='Forgot password?']"))).perform(); // double click
		//action.contextClick(driver.findElement(By.xpath("//a[text()='Forgot password?']"))).perform(); // right click
		
		//go back to home page
		driver.navigate().back();
		
		//advance mouse operation where mouse hovering will trigger new action
		//action.moveToElement(......).perform();
		
		//mouse click + command key to open in new tab
		action.keyDown(Keys.COMMAND).click(driver.findElement(By.xpath("//a[text()='Forgot password?']"))).perform();
		Thread.sleep(3000);
		
		driver.quit();
		
	}

}
