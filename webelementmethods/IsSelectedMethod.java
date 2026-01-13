package webelementmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsSelectedMethod {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://login.credentipreview.io/");
		driver.manage().window().maximize();

		driver.findElement(By.name("email")).sendKeys("dpureti@credenti.io");
		Thread.sleep(3000);

		driver.findElement(By.className("submit-button")).click();
		Thread.sleep(5000);

		// will be used to check radio buttons , check boxes , dropdown items

		WebElement rememberMeCheckBox = driver.findElement(By.xpath("//input[@type=\"checkbox\"]"));
		System.out.println(rememberMeCheckBox.isSelected());
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[@for=\"input47\"]")).click();
		System.out.println(rememberMeCheckBox.isSelected());
		driver.quit();
	}
}
