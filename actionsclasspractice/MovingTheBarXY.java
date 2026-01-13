package actionsclasspractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MovingTheBarXY {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.angelone.in/calculators/emi-calculator?");
		driver.manage().window().maximize();

	}

	@Test
	public void usingActionsTest() {
		Actions action = new Actions(driver);
		// this method will hover over the element provided
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Trade & Invest']")));
		// Actions has inbuilt wait methods here
		action.pause(Duration.ofMillis(3000));
		// another way to click the element using Click method in actions class.
		action.click(driver.findElement(By.xpath("//a[text()='Upcoming IPO']"))).build().perform();
	}

//	Here this will not work as the element is having attribute TYPE and value RANGE so JS Exec is preferable in real time
	@Test
	public void usingActionsTest2() {

		Actions action = new Actions(driver);
		action.pause(3000);
		action.dragAndDropBy(driver.findElement(By.xpath("//input[@id='emi-interest']")), 200, 0);
		action.pause(5000);
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
