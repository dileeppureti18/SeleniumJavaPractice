package waitshandling;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitsHandling {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.pepperfry.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void explicitWaitsHandlingTest() {

		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement popUp = driver
				.findElement(By.xpath("//*[local-name()='svg' and @xmlns='http://www.w3.org/2000/svg']"));

		myWait.until(ExpectedConditions.visibilityOf(popUp)).click();
		driver.findElement(By.xpath("//button[@id='Study Room']")).click();
	}

}
