package webdrivermethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetCurrentURLMethod {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.credentipreview.io");
		
//		this will return the url present in address bar in form of string
		System.out.println(driver.getCurrentUrl());
		driver.quit();
	}

}
