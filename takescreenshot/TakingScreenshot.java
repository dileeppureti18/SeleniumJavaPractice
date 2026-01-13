package takescreenshot;

import java.io.File;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class TakingScreenshot {

	WebDriver driver;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://credenti.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@Test
	public void takingScreenshotTest() throws IOException {
		// As Take screenshot is being used only once then it is not necessary to create
		// memory variable. Instead we can directly do it by replacing variable name
		// TakesScreenshot ts = (TakesScreenshot) driver;
		// File srcMain = ts

		File srcMain = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\Dileep_K\\Desktop\\DCP_18\\FileUploadTesting\\credenti.png");

//		Files.copy(srcMain.toPath(), destFile.toPath()); Here I've imported different package so need to used .toPath()
		Files.copy(srcMain, destFile); // Better we import com.google.common.io.Files so that we can directly use it.

	}

	@AfterMethod
	public void tearDown() {
		try {
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		driver.quit();
	}

}
