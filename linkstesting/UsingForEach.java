package linkstesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingForEach {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
		driver.manage().window().maximize();

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());

		for (int i = 0; i < allLinks.size(); i++) {
			allLinks = driver.findElements(By.tagName("a"));
			WebElement link = allLinks.get(i);

			String href = link.getAttribute("href");
			if (href == null || href.isEmpty()) {
				continue;
			}
			link.click();
			Thread.sleep(2000);
			driver.navigate().back();
		}
		driver.quit();

	}

}
