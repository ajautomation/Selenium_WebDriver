package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames_Handeling {

	@Test
	public void frameTest() throws InterruptedException {

		WebDriverManager.chromedriver().setup();//opening the chrome driver

		WebDriver driver=new ChromeDriver();

		driver.get("https://jqueryui.com/droppable/");		
		
		driver.switchTo().frame(0);//Switch to frame
		
		Actions a=new Actions(driver);
		WebElement src=driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
		
		WebElement dst=driver.findElement(By.id("droppable"));

		a.dragAndDrop(src, dst).build().perform();
		
		Thread.sleep(3000);
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().parentFrame();
		driver.close();
	}
}
