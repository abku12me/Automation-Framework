package practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class CreateLeadspractice {
	ExcelFileUtility eutil=new ExcelFileUtility();
	PropertyFileUtility putil=new PropertyFileUtility();
	JavaUtility jutil=new JavaUtility();
	WebDriverUtility wutil=new WebDriverUtility();
	@Test
	public void createlead() throws AWTException, IOException
	{  // Launch the Browse
		WebDriver driver=new ChromeDriver();
		wutil.maximizeWindow(driver);
		wutil.waitForPage(driver);
		driver.get(putil.readDataFromPropertyFile("url"));
		
		//Login to application with valid credentials
		driver.findElement(By.name("user_name")).sendKeys(putil.readDataFromPropertyFile("username"));
		driver.findElement(By.name("user_password")).sendKeys(putil.readDataFromPropertyFile("password"));
		driver.findElement(By.id("submitButton")).click();
		
		//Navigate to Contacts link
		driver.findElement(By.linkText("Leads")).click();
		//Click on Create contact look Up Image
		driver.findElement(By.cssSelector("[alt='Create Lead...']")).click();
		
		//Create Contact with Mandatory fields and save
		driver.findElement(By.name("lastname")).sendKeys(eutil.readDataFromExcelsheet("Contacts", 1, 2));
		WebElement save=driver.findElement(By.name("company"));
		save.sendKeys(eutil.readDataFromExcelsheet("Contacts", 4, 3));
		driver.findElement(By.cssSelector("[class='crmButton small save']")).click();
		
		//Save and Verify
		String leadname=driver.findElement(By.className("dvHeaderText")).getText();
		if(leadname.contains(eutil.readDataFromExcelsheet("Contacts", 1, 2)))
		{
			System.out.println(leadname+"...pass...");
		}
		else
		{
			System.out.println("...fail...");
		}
		
		//logout of Application
		WebElement log=driver.findElement(By.xpath("//td[contains(@onmouseover,'fnDropDownUser')][1]"));
		wutil.mouseOverAction(driver, log);
		driver.findElement(By.linkText("Sign Out")).click();
		
		
	}

}
