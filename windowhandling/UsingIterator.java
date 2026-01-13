package windowhandling;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UsingIterator {

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

		// Using handles method to get all the window ID's and it's return type is
		// set<String>
		Set<String> allWindowIds = driver.getWindowHandles();

		// As the return type is Set - We have to use either for each or iterator
		// concept and can't use for loop
		for (String windowHandleIds : allWindowIds) {
			driver.switchTo().window(windowHandleIds);
			if (driver.getTitle().equals("TestFlight - Apple")) {
				System.out.println(driver.getTitle());
				break;
			}
		}

		Actions action = new Actions(driver);
//		action.keyDown(Keys.PAGE_DOWN);
		WebElement termsElement = driver.findElement(By.xpath("//a[text()='Terms Of Service']"));
		action.scrollToElement(termsElement).perform();
		Thread.sleep(1000);
		action.click(termsElement).build().perform();
		Thread.sleep(2000);

		//Here used Iterator which is more preferable in real time world.
		Set<String> allWindows = driver.getWindowHandles();

		Iterator<String> it = allWindows.iterator();
		while (it.hasNext()) {
//			String nextWindow = it.next();
			driver.switchTo().window(it.next());

			if (driver.getTitle().equals("Legal - Apple Media Services - Apple")) {
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
