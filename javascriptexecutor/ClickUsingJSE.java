package javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClickUsingJSE {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.pepperfry.com");
		driver.manage().window().maximize();
	}

	@Test
	public void clickUsingJSETest() {

		WebElement sellOnPPElement = driver.findElement(By.xpath("//div[text()='Sell on Pepperfry']"));

		// using this we can click on the element irrespective of the alerts and all.
		// This will directly click on the element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("arguments[0].click()", sellOnPPElement);
	}

}
