package locatorsofseleniun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingNameLocator {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.credentipreview.io/");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.name("email")).sendKeys("dpureti@credenti.io");
		Thread.sleep(3000);
		driver.quit();

	}

}
