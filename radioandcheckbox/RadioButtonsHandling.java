package radioandcheckbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonsHandling {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://designsystem.digital.gov/components/radio-buttons/");
		driver.manage().window().maximize();

	}

	@Test
	public void radioButtonsHandlingTest() {
		Actions action = new Actions(driver);
		WebElement truthButton = driver.findElement(
				By.xpath("//input[@id='historical-truth']/following-sibling::label[text()='Sojourner Truth']"));
		action.scrollToElement(truthButton).perform();
		Assert.assertFalse(truthButton.isSelected());
		Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Frederick Douglass']")).isSelected());

	}

}
