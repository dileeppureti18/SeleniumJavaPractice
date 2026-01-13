package webelementmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeysMethod {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://login.credentipreview.io/");
		driver.manage().window().maximize();

		/*
		 * here CharSequence... is nothing but String this will type text or string
		 * passed on to webelement for textboxex,textarea,dropdown etc ..
		 */
		driver.findElement(By.name("email")).sendKeys("dpureti@credenti.io");
		Thread.sleep(3000);

		// this will click on any webelement (button , img ,radio button, link , check
		// box etc ..)
		driver.findElement(By.id("submit-button")).click();
		driver.quit();

	}

}
