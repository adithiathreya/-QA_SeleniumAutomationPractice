package practiceTestNG;

import org.testng.annotations.Test;

public class PracticeGroupTestClass {
	
	//This is the testing method 
	//no main method required
	@Test(groups="smoke")
	public void firstTestcase() {
		System.out.println("this is first TestNG case belongs to smoke group");
	}

	@Test(groups="sanity")
	public void secondTestcase() {
		System.out.println("this is second TestNG case belongs to sanity group");
	}
	
	@Test(groups="smoke")
	public void thirdTestcase() {
		System.out.println("this is third TestNG case belongs to smoke group");
	}
	
	@Test(groups="sanity")
	public void fourthTestcase() {
		System.out.println("this is fourth TestNG case belongs to sanity group");
	}
	
	@Test(groups={"smoke","sanity"})
	public void fifthTestcase() {
		System.out.println("this is fifth TestNG case belongs to smoke and sanity group");
	}
}
