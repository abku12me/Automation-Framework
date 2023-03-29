package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test(dataProvider="phone")
	public void dataProviderPractice(String phone,int price)
	{
		System.out.println(phone+"-----"+price);
		
	}
	
	
	@Test(dataProvider="getLogin")
	public void getCorrectLogin(String username,String password)
	{
		
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
		driver.findElement(By.id("loginButton")).click();
	}
	
	
	
	
	
	@DataProvider(name="phone")
	public Object[][] getData()
	{                               // row//column(cells)
		Object[][] data=new Object[3][2];// 3 sets of data in 2 column
		
		data[0][0]="Samsung";
		data[0][1]=1200;
		
		data[1][0]="Iphone";
		data[1][1]=28444;
		
		data[2][0]="Nokia";
		data[2][1]=3456;	
		
		return data;
	}
	
	
	
	@DataProvider
	public Object[][] getLogin()
	{
		Object[][] data=new Object[2][2];
		data[0][0]="admin";
		data[0][1]="manager";
		
		data[1][0]="managerw";
		data[1][1]="managert";
		
		
	return data;
	
	}
	

}
