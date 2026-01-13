package selectclasspractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

public class GettingTheListOfOptions {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/dropdown");
		driver.manage().window().maximize();

		// Here I'm trying to fetch the no.of countries names present in the list
		WebElement selectCountryDropdown = driver.findElement(By.id("country"));
		Select selectCountry = new Select(selectCountryDropdown);

		// Using getOptions() methods we will get all the webElements as the tagName
		// will be Options and store in a vairable
		List<WebElement> allCountriesList = selectCountry.getOptions();

		// Used size()-1 as default 1st option is select country so we will get the
		// desired number excluding that
		System.out.println((allCountriesList.size() - 1));

		/*
		 * We cannot use forEach because it starts from select country which index
		 * starts from 0 So using for looping so that we can start from our desired
		 * index. Here we cannot use size()-1 in looping statement because it will not
		 * print the last country name. So array has to start from index 1
		 */

		for (int i = 1; i < allCountriesList.size(); i++) {
			System.out.println(allCountriesList.get(i).getText());
		}
		
		driver.quit();

	}

}
