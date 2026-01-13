package locatorsofseleniun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassNameLocator {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://login.credentipreview.io/");
		driver.manage().window().maximize();

		//Better not to use className as they will never be unique.
		//Also make sure that the spaces inbetween the classes are termed as multiple classes so use text before and after spaces
		//Or Else you may get this exception - compound names are not permitted
		
		driver.findElement(By.className("ant-input")).sendKeys("dpureti@credenti.io");
		Thread.sleep(3000);
		driver.findElement(By.className("submit-button")).click();
		Thread.sleep(3000);
		driver.quit();

	}

}
