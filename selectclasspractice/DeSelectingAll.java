package selectclasspractice;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DeSelectingAll {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/select-menu");
		driver.manage().window().maximize();

		WebElement carOptions = driver.findElement(By.id("cars"));
		Select selectCar = new Select(carOptions);

		// Using VisibleText method
		selectCar.selectByVisibleText("Audi");
		System.out.println(selectCar.getFirstSelectedOption().getText());

		// Using index value method
		selectCar.selectByIndex(0);
		System.out.println(selectCar.getFirstSelectedOption().getText());

		// Using by Value Method which is nothing but Attribute VALUE
		selectCar.selectByValue("opel");
		System.out.println(selectCar.getFirstSelectedOption().getText());

		// Deselecting each by index value
		selectCar.deselectByIndex(0);
		System.out.println(selectCar.getFirstSelectedOption().getText());

		// Deselecting using visible text method
		selectCar.deselectByVisibleText("Audi");
		System.out.println(selectCar.getFirstSelectedOption().getText());

		// Deselecting using
		selectCar.deselectAll();

		//Here I'm trying to print something that is not there so the driver won't quit, reason I used Try Catch
		try {
			System.out.println(selectCar.getFirstSelectedOption().getText());
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

		driver.quit();

	}

}
