package practiceTestNG;

import org.testng.annotations.Test;

public class PracticeTestDependencyClass {
	
	//This is the testing method 
	//no main method required
	@Test
	public void firstTestcase() {
		System.out.println("this is first TestNG case");
	}

	@Test(dependsOnMethods="firstTestcase")
	public void secondTestcase() {
		System.out.println("this is TestNG case dependent on first test case");
	}
}
