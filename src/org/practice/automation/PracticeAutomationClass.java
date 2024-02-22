//org.___.___ is the syntax for automation package creation
package org.practice.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//Java class for automation methods
public class PracticeAutomationClass {
	
	WebDriver driver;//web driver interface
	
	//before @Test methods are run
	@BeforeMethod
	public void launchBrowser() {
		//launch the browser
		driver = new ChromeDriver();//Web Driver interface with it's child class ChromeDriver, where the website can be accessed
				
		//pass the url
		driver.get("https://www.facebook.com/");		
	}
	
	//after @Test methods are run
	@AfterMethod
	public void closeBrowser() {
		//close the browser
		driver.close();
	}
	
	@Test
	//automation methods
	public void practiceLoginFunction() {
		
		//find 'emailID' textbox/element by 'id' and input Email
		driver.findElement(By.id("email")).sendKeys("xyz.gmail.com"); //web element
		
		//find 'password' textbox/element by 'name' and input password
		driver.findElement(By.name("pass")).sendKeys("xyz123");
		
		//find 'Log In' button using linktext
		//driver.findElement(By.linkText("Log In")).click(); --> will not work as there are 2 elements with link text as Log In on the page
		
		//find 'Log In' button using css
		driver.findElement(By.cssSelector("[type='submit']")).click();
	}
	
	@Test
	public void practiceSignupFunction() throws InterruptedException {

		//find 'Create new account' link using xpath
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		
		//find 'First name' textbox/element using 'name'
		//driver.findElement(By.name("firstname")).sendKeys("Practice"); --> as the new window/page is loaded, selenium cannot find 'firstname' in main page. so give a delay
		Thread.sleep(2000);
		driver.findElement(By.name("firstname")).sendKeys("Practice");
		Thread.sleep(1000);
		
		//find 'Last name' textbox/element using 'name'
		driver.findElement(By.name("lastname")).sendKeys("Selenium");
		Thread.sleep(1000);
		
		//find 'Mobile number or email' textbox/element using xpath
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("practiceselenium@gmail.com");
		Thread.sleep(1000);
		
		//find 'Re-enter email' textbox/element using xpath
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("practiceselenium@gmail.com");
		Thread.sleep(1000);
		
		//find 'New password' textbox/element using xpath
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("password123");
		Thread.sleep(1000);
		
		//select 'birthday month' dropdown/element using xpath
		Select birthday = new Select(driver.findElement(By.xpath("//select[@name='birthday_month']")));
		birthday.selectByIndex(0); //select by index : indexing starts from 0, thus index of Jan is 0
		Thread.sleep(1000);
		
		//select 'birthday day' dropdown/element using xpath
		birthday = new Select(driver.findElement(By.xpath("//select[@name='birthday_day']")));
		birthday.selectByValue("1"); //select by value 
		Thread.sleep(1000);
		
		//select 'birthday year' dropdown/element using xpath
		birthday = new Select(driver.findElement(By.xpath("//select[@name='birthday_year']")));
		//birthday.selectByVisibleText("2000"); //select by visible text
		//Thread.sleep(1000);
		birthday.selectByVisibleText("1905");
		Thread.sleep(1000);
		
		//deselecting values
		//birthday.deselectByVisibleText("2000"); --> this will work if multiple select is allowed
		
		//select 'Gender' radiobutton/element
		driver.findElement(By.xpath("//input[@type='radio' and @name='sex' and @value='1']")).click();
		Thread.sleep(1000);
		
		//find 'Sign Up' button using xpath
		driver.findElement(By.xpath("//button[@type='submit' and @name='websubmit']")).click();
	}
	
}
