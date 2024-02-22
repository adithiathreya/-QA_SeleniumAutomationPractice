package practiceTestNG;

import org.testng.annotations.Test;

public class PracticeTestDisableClass {
	
	//This is the testing method 
	//no main method required
	@Test(enabled=false)
	public void firstTestcase() {
		System.out.println("this is first TestNG case");
	}

}
