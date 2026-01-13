package testngpractice;

import org.testng.annotations.Test;

public class TestAnnotation {
	
	//Here in TestNG we don't use any main method as we directly do this with TestNG
	
	@Test
	public void browserLaunch() {
		System.out.println("Browser started...");
		
	}
	
	//Irrespective of its position this will always run alphabetical order wise
	@Test
	public void tearDown2() {
		System.out.println("Exiting from the 2nd browser...");
	}
	
	@Test
	public void loginTest1() {
		System.out.println("Login started...");
	}
	
	@Test
	public void loginTest2() {
		System.out.println("Login test 2 started...");
	}
	
	@Test
	public void tearDown() {
		System.out.println("Exiting from the browser...");
	}
	
	//If you have multiple @Test annotations without any parameter besides it then this will run Alphabetical wise

}
