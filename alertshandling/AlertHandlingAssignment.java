package alertshandling;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertHandlingAssignment {
	WebDriver driver;
	WebElement alertElement;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();

	}

	public void assertions(String expected) {

		String alertName = alertElement.getText();
		Assert.assertEquals(alertName, expected);
		System.out.println("Test passed...");

		alertElement.click();

	}

	@Test
	public void alertHandlingAssignmentTest() {

//		Alert alertSwitching = driver.switchTo().alert();

		alertElement = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
		assertions("Click for JS Alert");
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@Test
	public void alertHandlingAssignmentTest1() {

		alertElement = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
		assertions("Click for JS Confirm");
		Alert alert = driver.switchTo().alert();
		alert.dismiss();

	}

	@Test
	public void alertHandlingAssignmentTest2() {
		alertElement = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
		assertions("Click for JS Prompt");
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Selenium");
		alert.accept();
		String result = driver.findElement(By.xpath("//p[@id='result']")).getText();
		Assert.assertEquals(result, "You entered: Selenium");
		System.out.println("Result passed....");
	}

	@AfterMethod
	public void tearDown() {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
