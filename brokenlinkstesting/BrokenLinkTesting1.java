package brokenlinkstesting;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinkTesting1 {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void BrokenLinkTesting1Test() throws IOException {

		List<WebElement> allLinksInApp = driver.findElements(By.tagName("a"));

		int validLinkCount = 0;
		int invalidlinkCount = 0;

		for (WebElement link : allLinksInApp) {

		    String hrefPath = link.getAttribute("href");

		    if (hrefPath == null || hrefPath.isEmpty() || hrefPath.startsWith("javascript")) {
		        continue;
		    }

		    try {
		        URL url = new URL(hrefPath);
		        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		        connection.setRequestMethod("GET");
		        connection.setConnectTimeout(5000);
		        connection.connect();

		        int responseCode = connection.getResponseCode();

		        if (responseCode >= 400) {
		            System.out.println("Broken Link: " + hrefPath + " | Status Code: " + responseCode);
		            invalidlinkCount++;
		        } else {
		            System.out.println("Valid Link: " + hrefPath + " | Status Code: " + responseCode);
		            validLinkCount++;
		        }

		    } catch (Exception e) {
		        System.out.println("Exception for link: " + hrefPath);
		    }
		}


	}

	@AfterMethod
	public void tearDown() {
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
		driver.quit();

	}
}
