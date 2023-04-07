package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class XpathPractice {
	
	public static void main(String[] args) {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		
		WebDriver driver=new ChromeDriver(opt);
		driver.get("https://www.jetcost.co.in/en");
		
		
		String month="April 2023";
		String date="20";
		
	//driver.findElement(By.xpath("//div[text()='"+month+"']/ancestor::div[@class='DayPicker-Month']/descendant::div[text()='"+date+"']")).click();
	//driver.findElement(By.xpath("//span[text()='Apple iPhone 14 Plus (128 GB) - Midnight']/ancestor::div[contains(@class,'card-container')]/descendant::span[contains(@class,'whole')][1]"));	
		
	/**
	 * 	ancestor- go to the common parent and descendant will go the dynamic element
	 */
	
		WebElement text=driver.findElement(By.id("originFrom"));
		text.click();
		text.sendKeys("CCU");
		
	driver.findElement(By.xpath("//span[text()='Kolkata - Netaji Subhash Chandra Bose,']")).click();
	
	
		
		
		
	}

}
