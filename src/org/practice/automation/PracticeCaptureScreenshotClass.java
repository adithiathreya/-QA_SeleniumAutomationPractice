package org.practice.automation;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PracticeCaptureScreenshotClass {
	
	static WebDriver driver;
	
	public static void saveResult(WebDriver driver, String fileName) throws IOException {
		
		//takes screenshot
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		
		//save into file
		File screenshotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File resultFile = new File("./ResultScreenshot/" + fileName + ".png");
		FileUtils.copyFile(screenshotFile, resultFile);
		
	}
	
	@Test
	public void handleFramesToTakeScreenshot() throws IOException {
		
		driver = new ChromeDriver();
		String passingURL = "https://demoqa.com/frames";
		driver.get(passingURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//*[contains(text(), 'This is a sample page')]")).getText();
		
		//filename should be testcase name
		saveResult(driver, "handleFramesToTakeScreenshot");
		
		driver.close();
		
	}

}
