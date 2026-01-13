package actionsclasspractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScrollingTechniques {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		driver = new ChromeDriver();
		driver.get("https://credenti.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void scrollingTechniquesTest() {

		Actions action = new Actions(driver);
		action.pause(3000);
		action.scrollByAmount(0, 4000).perform();
	}

	@Test
	public void scrollingTechniquesTest1() {
		Actions action = new Actions(driver);
		action.pause(5000);
		action.scrollToElement(driver.findElement(By.xpath("//a[text()='Trusted Machines']"))).perform();
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
