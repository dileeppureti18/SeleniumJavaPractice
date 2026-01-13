package locatorsofseleniun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingIDLocator {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.credentipreview.io/");
		driver.manage().window().maximize();
		
		//Ensure use Unique and Static ID
		//If it is with the FORM TagName then use submit() method for testcase
		
		driver.findElement(By.className("ant-input")).sendKeys("dpureti@credenti.io");
		
		//If it is with the FORM TagName then use submit() method for testcase
		driver.findElement(By.className("submit-button")).submit();
		Thread.sleep(5000);
		driver.findElement(By.id("okta-signin-submit")).click();
		driver.quit();
	}

}
