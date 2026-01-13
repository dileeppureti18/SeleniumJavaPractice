package webelementmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsDisplayedMethod {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.credentipreview.io/");
		driver.manage().window().maximize();
		
		driver.findElement(By.className("submit-button")).click();
		WebElement validationMessage = driver.findElement(By.xpath("//div[text()='Email is required']"));
		System.out.println(validationMessage.getCssValue("color"));
		System.out.println(validationMessage.getText());
		
		//isDisplayed():boolean
		System.out.println(validationMessage.isDisplayed());
		driver.quit();

	}

}
