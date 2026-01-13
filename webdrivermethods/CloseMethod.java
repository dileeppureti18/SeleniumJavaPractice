package webdrivermethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseMethod {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.credentipreview.io");
		//here close will just kill the current current window focus but not the driverExecutable(in taskmanager)
		driver.close();
		

	}

}
