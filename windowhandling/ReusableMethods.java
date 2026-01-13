package windowhandling;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReusableMethods {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void multipleWindowHandlingTest() throws InterruptedException {
		String homeWindowId = driver.getWindowHandle();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[contains(@src,'ios-button')]")).click();

		setOfWindowHanldes("TestFlight - Apple");

		Actions action = new Actions(driver);
		WebElement termsElement = driver.findElement(By.xpath("//a[text()='Terms Of Service']"));
		action.scrollToElement(termsElement).perform();
		Thread.sleep(1000);
		action.click(termsElement).build().perform();
		Thread.sleep(2000);

		setOfWindowHanldes("Legal - Apple Media Services - Apple");
		Thread.sleep(1000);
		driver.switchTo().window(homeWindowId);
		System.out.println(driver.getTitle());

	}

	public void setOfWindowHanldes(String expTitle) {
		Set<String> allWindowIds = driver.getWindowHandles();

		// As the return type is Set - We have to use either for each or iterator
		// concept and can't use for loop
		for (String windowHandleIds : allWindowIds) {
			driver.switchTo().window(windowHandleIds);
			if (driver.getTitle().equals(expTitle)) {
				System.out.println(driver.getTitle());
				break;
			}
		}

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
