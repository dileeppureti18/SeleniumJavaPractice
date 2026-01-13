package webdrivermethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethods {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.credentipreview.io/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		driver.navigate().back();
		Thread.sleep(3000);
		Thread.sleep(3000);
		
		driver.navigate().forward();
		Thread.sleep(3000);
		
		//This is not different to get(URL) method
		driver.navigate().to("https://login.credenti.xyz/");
		Thread.sleep(3000);
		
		//This is not different to get(URL) method and to(String URL) methods
		driver.navigate().to("https://login.credentipreview.io/");
		Thread.sleep(3000);
		driver.quit();

	}

}
