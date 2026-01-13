package tabletesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicTable {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().window().maximize();
	}

	@Test
	public void dynamicTableTest() {

		WebElement table = driver.findElement(By.xpath("//table[@id=\"countries\"]"));
		List<WebElement> rowsInATable = table.findElements(By.tagName("tr"));

		for (WebElement rows : rowsInATable) {
			List<WebElement> columnsInATable = rows.findElements(By.tagName("td"));
			for (WebElement columns : columnsInATable) {
				System.out.print(columns.getText() + "\t");
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
