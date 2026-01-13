package tabletesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StaticTable2 {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().window().maximize();
	}

	@Test
	public void staticTableTest2() {
		// Here I'm printing only a specific column...Based on the input we have given.
		String part1 = "//table/tbody/tr[";
		String part2 = "]/td[2]";

		for (int i = 2; i <= 197; i++) {

			System.out.println(driver.findElement(By.xpath(part1 + i + part2)).getText());

		}

	}

	@AfterMethod
	public void tearDown() {
		try {

		} catch (Exception e) {

		}
		driver.quit();
	}

}
