package selectclasspractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownTesting1 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/dropdown");
		driver.manage().window().maximize();
		
		//Here we are selecting using Select Class as the tag is Select
		WebElement selectCountryDropDown = driver.findElement(By.id("country"));
		Select selectAnyCountry = new Select(selectCountryDropDown);
		
		//To retrieve the text on the dropdown box we must use one of the methods in WebElement methods.
		System.out.println(selectAnyCountry.getFirstSelectedOption().getText());
		
		selectAnyCountry.selectByVisibleText("India");
		System.out.println(selectAnyCountry.getFirstSelectedOption().getText());
		driver.quit();

	}

}
