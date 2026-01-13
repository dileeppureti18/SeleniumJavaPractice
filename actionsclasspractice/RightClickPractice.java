package actionsclasspractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RightClickPractice {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		driver = new ChromeDriver();
		driver.get("https://selenium-prd.firebaseapp.com/");
		driver.manage().window().maximize();

	}

	@Test
	public void rightClickPracticeTest() throws InterruptedException {

		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("admin123@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()='Login to Account']")).click();
		Thread.sleep(5000);

		Actions action = new Actions(driver);
		for (int i = 0; i <= 1; i++) {
			action.moveToElement(driver.findElement(By.xpath(
					"//a[text()='Drag & Drop']/parent::div[@class='dropdown-content']/preceding-sibling::button")));
			action.click(driver.findElement(By.xpath("//a[text()='Double Click']"))).build().perform();
		}

		for (int i = 0; i <= 4; i++) {
			action.doubleClick(driver.findElement(By.xpath("//button[text()='Double Click']"))).perform();
			System.out.println(driver.findElement(By.xpath("//p[@id='Selenium']")).isDisplayed());

		}
		System.out.println(driver.findElement(By.xpath("//p[@id='Selenium']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//p[@id='Selenium']")).getText());

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
