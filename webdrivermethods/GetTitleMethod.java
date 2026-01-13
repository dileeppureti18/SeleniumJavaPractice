package webdrivermethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleMethod {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.credentipreview.io");
		
		//this will return the title of page in form of string
		//If this is for a single time use then no need of reference variable.
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
