package testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ZoomWindowInSelenium {

	@Test
	public void ZoomWindowWithRobotClass() throws InterruptedException, AWTException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.google.com");

		Thread.sleep(5000);

		//Zoom In code: To zoom in 3 times

		Robot robot=new Robot();
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		
		for (int i = 0; i < 3; i++) {

			robot.keyPress(KeyEvent.VK_ADD);
			robot.keyRelease(KeyEvent.VK_ADD);
			
		}
		
		robot.keyRelease(KeyEvent.VK_CONTROL);

		Thread.sleep(10000);

		//Zoom Out code: To zoom out 3 times

		/*
		 * for (int i = 0; i < 3; i++) {
		 * 
		 * robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_SUBTRACT);
		 * robot.keyRelease(KeyEvent.VK_SUBTRACT);
		 * robot.keyRelease(KeyEvent.VK_CONTROL); }
		 */
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_0);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_0);
		
		Thread.sleep(10000);

		driver.close();

	}
	
	
	
	
	

	@Test
	public void ZoomWindowWithJSExecutor() throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		 WebDriver driver=new ChromeDriver();

		 driver.manage().window().maximize();

		 driver.get("https://www.google.com");

		 Thread.sleep(5000);
		 
		 String zoomInJS;
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 
		 zoomInJS ="document.body.style.zoom='1.5'";
		 
		 js.executeScript(zoomInJS);
		 
		 Thread.sleep(5000);
		 
		 zoomInJS ="document.body.style.zoom='0.5'";
		 
		 js.executeScript(zoomInJS);
		 
		 Thread.sleep(5000);
		 
		 zoomInJS ="document.body.style.zoom='1'";
		 js.executeScript(zoomInJS);
		
		 Thread.sleep(10000);

		 driver.close();

	}
}
