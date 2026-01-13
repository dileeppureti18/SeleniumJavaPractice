package tabletesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StaticTable {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().window().maximize();
	}

	@Test
	public void staticTableTest() {
		
		//Here I've used nested for loop to go through each row and column to print the values
		String part1 = "//table/tbody/tr[";
		String part2 = "]/td[";
		String part3 = "]";

		for (int i = 2; i <= 197; i++) {

			for (int j = 2; j <= 5; j++) {

				System.out.print(driver.findElement(By.xpath(part1 + i + part2 + j+part3)).getText()+"\t");
			}
			System.out.println();
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
