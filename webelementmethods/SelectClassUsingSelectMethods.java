package webelementmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClassUsingSelectMethods {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		driver.manage().window().maximize();
		
		//Here we can use Select class methods to enter the value into the dropdown
		Select countryDropDown = new Select(driver.findElement(By.tagName("select")));
		Thread.sleep(3000);
		
		//Using visibleText we can directly select the value and it must be text b/w > <
		countryDropDown.selectByVisibleText("India");
		
		Thread.sleep(3000);
		//Using ByValue, which is nothing but the attribute and it's value so attribute is value and string =""
		countryDropDown.selectByValue("AUS");
		
		Thread.sleep(3000);
		//Using byIndex which may change at any time so max try to avoid this
		countryDropDown.selectByIndex(2);
		
		driver.quit();
		
	}
}
