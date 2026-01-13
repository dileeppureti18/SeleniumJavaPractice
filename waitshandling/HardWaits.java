package waitshandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HardWaits {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.pepperfry.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void hardWaitsTest() throws InterruptedException {
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		WebElement bedRoom = driver.findElement(By.xpath("//button[@id='Bed Room']"));

		action.scrollToElement(bedRoom).perform();
		// If I didn't use the below I got no element interception
		Thread.sleep(5000);
		bedRoom.click();

	}

	@AfterMethod
	public void tearDown() {
		try {

		} catch (Exception e) {

		}
		driver.quit();
	}

}
