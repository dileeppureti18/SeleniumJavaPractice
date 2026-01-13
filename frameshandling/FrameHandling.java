package frameshandling;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrameHandling {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
	}

	@Test
	public void frameHandlingTest() throws InterruptedException {

		Actions action = new Actions(driver);
		action.scrollToElement(driver
				.findElement(By.xpath("//h3[text()='iFrame will not show if you have adBlock extension enabled']")))
				.perform();
		// As the Jmeter link is inside a frame switching to that frame using String
		driver.switchTo().frame("a077aa5e");
		// Here trying to store the Home Window ID as I'll moving to another window after clicking Jmeter

		driver.findElement(By.xpath("//img[contains(@src,'Jmeter720')]")).click();
		Thread.sleep(2000);

		Set<String> allWindowIds = driver.getWindowHandles();
		// Here we can also use for each but for best practice using iterator
		Iterator<String> allIds = allWindowIds.iterator();
		while (allIds.hasNext()) {

			driver.switchTo().window(allIds.next());
			if (driver.getTitle().equals("Selenium Live Project for Practice")) {
				System.out.println(driver.getTitle());
				break;
			}
		}

		//Here we must look for common thing for each element and travese though each and try to write the xpath
		action.scrollToElement(driver.findElement(By.xpath("//p[text()='Top Tutorials']"))).perform();
		
		//Here trying to store the list of webelement for looping
		List<WebElement> allTutorialNames = driver.findElements(By.xpath(
				"//p[text()='Top Tutorials']/ancestor::div[contains(@class,'wp-block-kadence-column')][2]/descendant::span[@class='kt-blocks-info-box-title']"));

		//Using for loop statement as we know the desired looping times
		System.out.println(allTutorialNames.size());
		for (int i = 0; i <= allTutorialNames.size(); i++) {
			System.out.println(allTutorialNames.get(i).getText());
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
