package javascriptexecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScrollingUsingJavaScript2 {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.pepperfry.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void scrollingUsingJavaScriptTest() {

		// Here we can't use driver.JavaScript as it is having no relationship with
		// WebDriver
		// So do type casting where we're converting that WebDriver driver to JavaScript
		// driver

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scolling to the bottom of the page if you directly want to go to the bottom
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)","");
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
