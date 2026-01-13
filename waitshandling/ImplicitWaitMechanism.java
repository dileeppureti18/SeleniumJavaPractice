package waitshandling;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ImplicitWaitMechanism {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://cosmocode.io/automation-practice-handling-waits/#google_vignette");
		driver.manage().window().maximize();

		// Using Implicit wait which will be applied on all webelements but not on
		// coditional based.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Test
	public void implicitWaitMechanismTest() throws InterruptedException {

		driver.findElement(By.xpath("//a[@id='changeColor']")).click();

		driver.findElement(By.xpath("//a[@id='changeText']")).click();

		driver.findElement(By.xpath("//a[@id='Click me to enable the below button']")).click();
	}

	@AfterMethod
	public void tearDown() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		driver.quit();
	}

}
