package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Get_All_options_from_DD {

	@Test
	public void Get_All_options_from_DD_Test(){

		WebDriverManager.chromedriver().setup();//opening the chrome driver

		WebDriver driver=new ChromeDriver();

		driver.get("https://facebook.com/");
		
		
		
		
		//Method 1: Using Select class
		
		Select a=new Select(driver.findElement(By.id("month")));
		
		List<WebElement> list=a.getOptions();
		
		for(WebElement p:list) {
		
			System.out.println(p.getText());
		}
		
		
		
		
		
		
		//Method 2: Using Custom xpath
		
		List<WebElement> list_Options=driver.findElements(By.xpath("//select[@id='month']//option"));
		
		System.out.println("Total options in the month drop down " +list_Options.size());//13
		
		System.out.println("options in the month drop down are " );
		
		//enhanced for loop
		for(WebElement option:list_Options) {
			
			System.out.println(option.getText());
		}
		
		driver.close();
	}


}
