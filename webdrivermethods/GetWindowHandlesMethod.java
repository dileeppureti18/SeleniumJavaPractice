package webdrivermethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetWindowHandlesMethod {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://login.credentipreview.io");

		/*
		 * getWindowHandles():Set<String> this will retrive the window ids of the all
		 * windows/tabs open and aactive till that point in form collection of string
		 * (which is in hex decimal format)
		 */
		System.out.println(driver.getWindowHandles());
		driver.quit();

	}

}
