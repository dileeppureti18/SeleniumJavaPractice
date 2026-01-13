package webelementmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class GetAttributeMethod {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://login.credentipreview.io/");
		driver.manage().window().maximize();

		driver.findElement(By.name("email")).sendKeys("dpureti@credenti.io");
		driver.findElement(By.className("submit-button")).click();
		Thread.sleep(5000);

		// If an element is being used multiple times then make sure that the element
		// reference is created

		/*
		 * case 1 : attribute is present with value assigned 
		 * o/p : value of attribute
		 * case 2: attribute is not present 
		 * o/p : null or empty string
		 * case 3: attribute is present but value is not assigned (for check boxes and
		 * radio button)
		 *  o/p : true
		 */
		WebElement link = driver.findElement(By.linkText("Sign in with PIV / CAC card"));
		System.out.println(link.getText());
		System.out.println(link.getCssValue("color"));
		System.out.println(link.getAttribute("href"));
		link.click();

		System.out.println(driver.getCurrentUrl());
		driver.quit();

	}

}
