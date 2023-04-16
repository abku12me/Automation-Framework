package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTablePratice {
	
	@Test
	public void webtablePractice()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
		driver.findElement(By.linkText("Organizations")).click();
		
		// click on all the checkbox
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td/input")).click();
		
		// fetch the allorg name
		List<WebElement> allorg=driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
		for(WebElement org:allorg)
		{
			    System.out.println(org.getText());
			
			
		}
		
		
		//click on 10th check box
		
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[10]/td/input")).click();
		
		driver.close();
		
	}
	


}
