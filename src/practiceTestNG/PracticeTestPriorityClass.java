package practiceTestNG;

import org.testng.annotations.Test;

public class PracticeTestPriorityClass {
	
	//This is the testing method 
	//no main method required
	//tests run in alphabetical order
	//priority with positive numbers run in priority order AFTER rest of the tests run in alphabetical order
	//priority with negative numbers run in priority order BEFORE rest of the tests run in alphabetical order
	
	@Test(priority=1)
	public void firstTestcase() {
		System.out.println("this is first TestNG case");
	}
	
	@Test(priority=2)
	public void secondTestcase() {
		System.out.println("this is second TestNG case");
	}
	@Test(priority=3)
	public void thirdTestcase() {
		System.out.println("this is third TestNG case");
	}
	@Test(priority=-1)
	public void fourthTestcase() {
		System.out.println("this is fourth TestNG case");
	}
	@Test(priority=-2)
	public void fifthTestcase() {
		System.out.println("this is fifth TestNG case");
	}
	

}
