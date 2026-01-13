package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsClassAssignment {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://groww.in/calculators/emi-calculator");
		driver.manage().window().maximize();

	}

	@Test
	public void EMICalculatorTest() {
		Actions sliderAction = new Actions(driver);
		sliderAction.pause(Duration.ofMillis(3000));

		// Using dragAndDropBy method to drag the coordinates like x and y axis - eg-
		// EMI calculator
		sliderAction.dragAndDropBy(
				driver.findElement(By.xpath("(//div[@class='cis93SliderThumb cis93SliderThumb-0 '])[1]")), 200, 0)
				.pause(3000).build().perform();

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
