package webelementmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetCssValueMethod {

	public static void main(String[] args) throws InterruptedException {
		

		WebDriver driver = new ChromeDriver();
		driver.get("https://login.credentipreview.io/");
		driver.manage().window().maximize();

		driver.findElement(By.name("email")).sendKeys("dpureti@credenti.io");
		driver.findElement(By.className("submit-button")).click();
		Thread.sleep(5000);

		WebElement link = driver.findElement(By.linkText("Sign in with PIV / CAC card"));
		System.out.println(link.getText());
		
//		to retrive css values like color,font-size etc ..
		
		System.out.println(link.getCssValue("color"));
		System.out.println(link.getAttribute("href"));
		link.click();

		System.out.println(driver.getCurrentUrl());
		driver.quit();

	}

}
