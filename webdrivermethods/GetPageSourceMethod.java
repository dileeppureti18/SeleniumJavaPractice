package webdrivermethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetPageSourceMethod {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.credentipreview.io");
		
//		it will retrive the html page source
		System.out.println(driver.getPageSource());
		driver.quit();
	}

}
