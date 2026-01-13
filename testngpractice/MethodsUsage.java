package testngpractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MethodsUsage {

	// Here we have to initialize the driver outside the method so that in class
	// level we can use it anywhere
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void selectDropDown() throws InterruptedException {
		// Here it is a select class
		// Also that this element I used axes as directly there is no tags for this
		// element.
		WebElement defaultCountry = driver
				.findElement(By.xpath("//div[@class='information closable']/following-sibling::p/child::select"));
		List<WebElement> allCountriesList = defaultCountry.findElements(By.tagName("option"));
		System.out.println(allCountriesList.size());
		Thread.sleep(1000);
		Select selectCountry = new Select(defaultCountry);
		selectCountry.selectByVisibleText("India");
		System.out.println(selectCountry.getFirstSelectedOption().getText());

		List<WebElement> allCountriesNames = selectCountry.getOptions();
		for (int i = 0; i < allCountriesNames.size(); i++) {
			System.out.println(allCountriesNames.get(i).getText());
		}
	}

	@Test(priority = 2)

	public void selectCountryText() {
		System.out
				.println(driver.findElement(By.xpath("//strong[text()='Select country from below drop down list:']")).getText());
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
