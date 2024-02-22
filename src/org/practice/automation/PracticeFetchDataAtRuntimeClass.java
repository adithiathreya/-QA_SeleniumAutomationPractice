package org.practice.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeFetchDataAtRuntimeClass {
	
	WebDriver driver;
	
	@Test
	public void fetchData() throws InterruptedException {
		
		driver = new ChromeDriver();
		
		String passingURL = "https://www.facebook.com/";
		//pass url
		driver.get(passingURL);
		Thread.sleep(1000);

		//fetch url from browser
		String actualURL = driver.getCurrentUrl();
		System.out.println("actual url = " + actualURL);
		
		//compare actual url/title vs passed url/title to verify page actuality
		Assert.assertEquals(passingURL, actualURL);
		
		String passingTitle = "Facebook - log in or sign up";
		//fetch title from the browser
		String actualTitle = driver.getTitle();
		System.out.println("actual Title = " + actualTitle);
		Assert.assertEquals(passingTitle, actualTitle);
		
		String passingEmailPlaceholder = "Email or phone number";
		//fetch email address attribute value
		String actualEmailPlaceholder = driver.findElement(By.id("email")).getAttribute("placeholder");
		System.out.println("email Placeholder = " + actualEmailPlaceholder);
		Assert.assertEquals(passingEmailPlaceholder, actualEmailPlaceholder);
		
		String passingLoginLinkText = "Log In";
		//fetch Log In button linkText value
		String actualLoginLinkText = driver.findElement(By.xpath("//button[text() = 'Log In']")).getText();
		System.out.println("Login button Link Text = " + actualLoginLinkText);
		Assert.assertEquals(passingLoginLinkText, actualLoginLinkText);
		
		//fetch location coordinate of an element
		Point actualLocation = driver.findElement(By.name("login")).getLocation();
		System.out.println("Location cordinates = " + actualLocation);
		
		//fetch page html code
		System.out.println(driver.getPageSource());
		
		driver.close();
	}
	
	@Test
	public void fetchState() throws InterruptedException {
		
		driver = new ChromeDriver();
		
		String passingURL = "https://www.facebook.com/";
		//pass url
		driver.get(passingURL);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("firstname")).sendKeys("Practice");
		Thread.sleep(1000);
		driver.findElement(By.name("lastname")).sendKeys("Selenium");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("practiceselenium@gmail.com");
		Thread.sleep(1000);
		
		//fetch element state displayed for 'Re-enter email' textbox
		Boolean isDisplayed = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).isDisplayed();
		System.out.println("Re-enter email textbox is displayed ? " + isDisplayed);
		
		//fetch element state selected for 'Gender' radiobutton
		driver.findElement(By.xpath("//input[@type='radio' and @name='sex' and @value='1']")).click();
		Thread.sleep(1000);
		Boolean isSelected = driver.findElement(By.xpath("//input[@type='radio' and @name='sex' and @value='2']")).isSelected();
		System.out.println("Gender Male is selected ? " + isSelected);
		
		driver.close();
	}

}
