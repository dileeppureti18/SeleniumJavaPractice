package webdrivermethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManageWindowsMethods {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.credentipreview.io");
		
		//this is to handle cookies , synchronization or waits , window sizes
		driver.manage().window().maximize();
		driver.quit();
		

	}

}
