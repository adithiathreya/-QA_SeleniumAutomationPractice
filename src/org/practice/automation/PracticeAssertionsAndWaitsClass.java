package org.practice.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PracticeAssertionsAndWaitsClass {
	
	WebDriver driver;
	
	@Test
	public void hardAndSoftAsserts() throws InterruptedException {
		
		driver = new ChromeDriver();
		
		String passingURL = "https://www.facebook.com";
		//pass url
		driver.get(passingURL);
		Thread.sleep(1000);

		//fetch url from browser
		String actualURL = driver.getCurrentUrl();
		System.out.println("actual url = " + actualURL);
		
		//soft assert - where assertion decision happens at the end of the method and rest of the method gets executed
		SoftAssert softAssert = new SoftAssert();
		
		//compare actual url/title vs passed url/title to verify page actuality
		softAssert.assertEquals(passingURL, actualURL);
		
		//just for our understanding
		System.out.println("this line will get executed as it is soft assertion");
		
		String passingTitle = "Facebook - log in or sign up";
		//fetch title from the browser
		String actualTitle = driver.getTitle();
		System.out.println("actual Title = " + actualTitle);
		softAssert.assertEquals(passingTitle, actualTitle);
		
		String passingEmailPlaceholder = "Email or phone number";
		//fetch email address attribute value
		String actualEmailPlaceholder = driver.findElement(By.id("email")).getAttribute("placeholder");
		System.out.println("email Placeholder = " + actualEmailPlaceholder);
		softAssert.assertEquals(passingEmailPlaceholder, actualEmailPlaceholder);
		
		String passingLoginLinkText = "LogIn";
		//fetch Log In button linkText value
		String actualLoginLinkText = driver.findElement(By.xpath("//button[text() = 'Log In']")).getText();
		System.out.println("Login button Link Text = " + actualLoginLinkText);
		
		//hard assert - just for comaprision
		Assert.assertEquals(passingLoginLinkText, actualLoginLinkText);
		
		//just for our understanding
		System.out.println("this line will not get executed as it is hard assertion");
		
		//fetch location coordinate of an element
		Point actualLocation = driver.findElement(By.name("login")).getLocation();
		System.out.println("Location cordinates = " + actualLocation);
		
		//fetch page html code
		System.out.println(driver.getPageSource());
		
		driver.close();
		
		//assertion decision at the end of the method
		softAssert.assertAll();
	}
	
	@Test
	public void waitTime() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		//with page load wait added
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100)); //default page load wait time is 60sec, but if the wait has to be more than 60 seconds use this
		//implicit wait added
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		/*//without wait time added
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		driver.findElement(By.name("firstname")).sendKeys("Practice"); --> FAILED: no such element: Unable to locate element: {"method":"css selector","selector":"*[name='firstname']"}
		as the create new account window was not open yet*/
		
		/*//with wait time added
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		Thread.sleep(2000); //this needs to be given everytime a new page gets loaded. 
		driver.findElement(By.name("firstname")).sendKeys("Practice");*/
		
		//with implicit wait added
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		driver.findElement(By.name("firstname")).sendKeys("Practice"); //implicit wait after page load wait, will take care of maximum new wait times
		
		//with explicit wait added
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("practiceselenium@gmail.com");
		WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds(2));
		wdw.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"))));
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("practiceselenium@gmail.com");
		
		driver.close();
	}

}
