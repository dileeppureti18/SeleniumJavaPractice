package fileuploading;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class UsingRobotClass {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/FileUpload.html");
		driver.manage().window().maximize();
	}

	@Test
	public void usingSendKeysExampleTest() throws IOException, AWTException {
		// Here I'm taking the screenshot
		TakesScreenshot screenshotImage = (TakesScreenshot) driver;
		File srcImage = screenshotImage.getScreenshotAs(OutputType.FILE);
		File destImage = new File("C:\\Users\\Dileep_K\\Desktop\\DCP_18\\Practice.png");

		// here I used Files class from google and copy method to set the image.
		Files.copy(srcImage, destImage);

//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

		// Here I got invalid argument because typefile cannot be clicked
		driver.findElement(By.xpath("//span[@id='input-4']")).click();

		// Here I'm using RobotClass
		String filePath = "C:\\Users\\Dileep_K\\Desktop\\DCP_18\\API Codes.jpg";

		Robot uploadFile = new Robot();

		// Here I'm copying the path to the system clipboard
		StringSelection selectedStringPath = new StringSelection(filePath);
		Clipboard copiedPath = Toolkit.getDefaultToolkit().getSystemClipboard();
		copiedPath.setContents(selectedStringPath, null);

		// Simulating pressing ctrl+v (using KeyEvent class)
		uploadFile.keyPress(KeyEvent.VK_CONTROL);
		uploadFile.keyRelease(KeyEvent.VK_V);

		// Releasing the keys using same as above but vice-verse
		uploadFile.keyPress(KeyEvent.VK_V);
		uploadFile.keyRelease(KeyEvent.VK_CONTROL);

		// After this we must click enter button to let this path get uploaded in the
		// desired path
		uploadFile.keyPress(KeyEvent.VK_ENTER);
		uploadFile.keyRelease(KeyEvent.VK_ENTER);

		driver.findElement(By.xpath("//button[@id='fileSubmit']")).click();

	}

}
