package testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Take_Screenshots {

	@Test
	public void take_Screenshot_Test() throws IOException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();

		driver.get("https://www.linkedin.com/home");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		/*
		 	Create TakesScreenshot reference and cast the driver as a TakesScreenshot object. 
		 	and then call the "getScreenshotAs" method
		 	get the file and File object has that screehshot file
		 	copy file from "src" to your local machine 		*/

		// Method 1:

		TakesScreenshot ts=(TakesScreenshot)driver;

		File srcFile=ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(srcFile, new File("C:\\screenshot\\linkedin1.png"));
		
		// Method 2

		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//Single line declaration

		FileUtils.copyFile(src, new File("C:\\screenshot\\linkedin2.png"));


		driver.close();



	}



}
