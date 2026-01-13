package webelementmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClearMethod {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.credentipreview.io/");
		driver.manage().window().maximize();
		
		//this will clear text present in textboxes or text areas 

		driver.findElement(By.name("email")).sendKeys("dpureti@credenti.io");
		Thread.sleep(3000);
		driver.findElement(By.className("submit-button")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("okta-signin-username")).clear();
		Thread.sleep(3000);
		driver.quit();
	}

}
