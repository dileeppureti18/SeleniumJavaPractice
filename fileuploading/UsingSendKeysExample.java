package fileuploading;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.netty.handler.codec.http.multipart.FileUpload;

public class UsingSendKeysExample {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/upload");
		driver.manage().window().maximize();
	}

	@Test
	public void usingSendKeysExampleTest() throws IOException {
		// Here I'm taking the screenshot
		TakesScreenshot screenshotImage = (TakesScreenshot) driver;
		File srcImage = screenshotImage.getScreenshotAs(OutputType.FILE);
		File destImage = new File("C:\\Users\\Dileep_K\\Desktop\\DCP_18\\Practice.png");
		
		//here I used Files class from google and copy method to set the image.
		Files.copy(srcImage, destImage);

		// Using Actions class to scroll into the element to click
		Actions action = new Actions(driver);
		action.scrollToElement(driver.findElement(By.xpath("//input[@id='fileInput']"))).perform();

		// Here I'm using sendkeys method as the element contains Input tag with typefile
		
		driver.findElement(By.xpath("//input[@type='file']"))
				.sendKeys("C:\\Users\\Dileep_K\\Desktop\\DCP_18\\API Codes.jpg");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement uploadButton = driver.findElement(By.xpath("//button[@id='fileSubmit']"));
		wait.until(ExpectedConditions.elementToBeClickable(uploadButton));
		uploadButton.click();
		

	}

}
