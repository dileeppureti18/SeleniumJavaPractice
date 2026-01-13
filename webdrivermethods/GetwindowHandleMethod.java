package webdrivermethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetwindowHandleMethod {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.credentipreview.io");
		
//		this will retrive the window id of the window/tab on which webdriver focus is 
//		in form string (which is in hex decimal format)
		System.out.println(driver.getWindowHandle());
		driver.quit();
		
	}

}
