package assignments;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLaunching {

	public static void main(String[] args) {

		System.out.println("Enter the browser name that you want to be launched...");
		Scanner browser = new Scanner(System.in);
		String launchBrowser = browser.next();

		WebDriver driver = null;

		switch (launchBrowser) {
		case "Chrome":
			driver = new ChromeDriver();
			break;
		case "FireFox":
			driver = new FirefoxDriver();
			break;
		case "Edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Entered invalid browser option");

		}
		
		browser.close();

	}

}
