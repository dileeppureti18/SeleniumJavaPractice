package linkstesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoopingAllLinks {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
		driver.manage().window().maximize();

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());

		for (int i = 0; i < allLinks.size(); i++) {
			System.out.println(allLinks.get(i).getText());
			System.out.println(allLinks.get(i).getAttribute("href"));
			WebElement link = allLinks.get(i);
			link.click();
			System.out.println(driver.getTitle());
			Thread.sleep(1000);
			driver.navigate().back();

		}

		driver.quit();
	}

}
