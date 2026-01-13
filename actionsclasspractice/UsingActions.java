package actionsclasspractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UsingActions {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.angelone.in/calculators/emi-calculator?");
		driver.manage().window().maximize();

	}

	@Test
	public void UsingActionsTest() {
		Actions action = new Actions(driver);
		//this method will hover over the element provided
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Trade & Invest']")));
		//Actions has inbuilt wait methods here
		action.pause(Duration.ofMillis(3000));
		//another way to click the element using Click method in actions class.
		action.click(driver.findElement(By.xpath("//a[text()='Upcoming IPO']"))).build().perform();
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
