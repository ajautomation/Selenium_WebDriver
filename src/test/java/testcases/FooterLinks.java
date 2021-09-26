package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterLinks {
	
	@Test
	public void linktest() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.goibibo.com/");
		
		WebElement footer1=driver.findElement(By.xpath("//ul[@data-reactid='6']"));
		
		List<WebElement> links=footer1.findElements(By.tagName("a"));
		
		int noOfLinks=links.size();
		
		System.out.println("*****The number of links in OUR PRODUCTS are " +noOfLinks);
		
		int count=0;
		
		for(int j=0;j<noOfLinks;j++) {
			
			WebElement footer1New=driver.findElement(By.xpath("//ul[@data-reactid='6']"));
			
			List<WebElement> linksNew=footer1New.findElements(By.tagName("a"));
			
			JavascriptExecutor js=(JavascriptExecutor) driver;
			
			WebElement link=linksNew.get(j);
			
			js.executeScript("arguments[0].scrollIntoView(true);", link);
			
			link.click();
			
			Thread.sleep(3000);
			
			String title=driver.getTitle();
			
			System.out.println("*****Title of the page is " +title);
			
			if(title.contains("404")) {
				
				System.out.println("**** Broken link found");
				
				count++;
			}
			
			driver.navigate().back();
			
			Thread.sleep(3000);
			
		}
		
		if(count==0) {
			
			System.out.println("**** No broken / dead links found");
		}
		
		driver.close();
		
	}

}
