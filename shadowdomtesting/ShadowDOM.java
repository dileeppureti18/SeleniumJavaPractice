package shadowdomtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShadowDOM {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void shadowDOMTest() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// 1️⃣ Outer shadow host
		WebElement outerHost = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("salesforce-navigation")));

		// 2️⃣ First shadow root
		SearchContext shadowRoot1 = outerHost.getShadowRoot();

		// 3️⃣ Inner shadow host
		WebElement innerHost = shadowRoot1.findElement(By.cssSelector("nav-bar"));

		// 4️⃣ Second shadow root
		SearchContext shadowRoot2 = innerHost.getShadowRoot();

		// 5️⃣ Login button
		WebElement loginButton = shadowRoot2.findElement(By.cssSelector("a[title='Login']"));

		// 6️⃣ Click
		loginButton.click();
	}

}
