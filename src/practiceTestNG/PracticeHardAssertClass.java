package practiceTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeHardAssertClass {
	
	//This is the testing method 
	//no main method required
	@Test
	public void firstTestcase() {
		System.out.println("this is first TestNG case");
		
		//to compare actual result with expected result
		//Hard and soft Assert
		Assert.assertEquals("Hello", "Hello World!");
	}

}
