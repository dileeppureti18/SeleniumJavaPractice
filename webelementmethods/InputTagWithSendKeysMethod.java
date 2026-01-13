package webelementmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputTagWithSendKeysMethod {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://traveltriangle.com/");
		driver.manage().window().maximize();

		// If at all we are having tagname as INPUT remember that we can use sendKeys()
		// method directly
		driver.findElement(By.xpath("//input[@placeholder=\"Type a Destination\"]")).sendKeys("Kerala");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type=\"button\"])[1]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//label[@for=\"inputDays_7-9\"]")).click();

		Thread.sleep(3000);

		WebElement monthDropDown = driver.findElement(By.className("month-select-header"));
		monthDropDown.click();
		monthDropDown.getText();
		Thread.sleep(3000);

		WebElement selectingMonth = driver.findElement(By.xpath("//button[text()=\"January, 2026\"]"));
		selectingMonth.click();
		selectingMonth.getText();
		driver.quit();

	}

}
