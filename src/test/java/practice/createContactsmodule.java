package practice;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import java.util.Set;

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

public class createContactsmodule {
	//step 1: create the object of all generic utility
    ExcelFileUtility eutil=new ExcelFileUtility();
	PropertyFileUtility putil=new PropertyFileUtility();
    JavaUtility jutil=new JavaUtility();
	WebDriverUtility wutil=new WebDriverUtility();
	
	@Test
	public void windowpop() throws IOException
	{
		//step1: Launch the Browser
		
	WebDriver driver=new ChromeDriver();
	wutil.maximizeWindow(driver);
	wutil.waitForPage(driver);
	driver.get(putil.readDataFromPropertyFile("url"));
								
 //step 2: login to the application
 driver.findElement(By.name("user_name")).sendKeys(putil.readDataFromPropertyFile("username"),Keys.TAB,putil.readDataFromPropertyFile("password"),Keys.ENTER);
 
 //step 3: Navigate to Contacts link
 
 driver.findElement(By.linkText("Contacts")).click();
 
 //step 4: Click on Create contact look up image
 driver.findElement(By.cssSelector("[title='Create Contact...']")).click();

 
 //step 5:Create contact with manadatory fields
 driver.findElement(By.name("lastname")).sendKeys(eutil.readDataFromExcelsheet("Contacts", 1, 2));
 
 //Select the Organization from organization look up image
 
 driver.findElement(By.xpath("//img[contains(@onclick,'popuptype')]")).click();
 
 //step 7: handle window-popup
  wutil.handleMultipleWindow(driver, "module=Accounts");
  driver.findElement(By.cssSelector("[href='javascript:window.close();']")).click();
 wutil.handleMultipleWindow(driver, "Administrator ");
 driver.findElement(By.cssSelector("[title='Save [Alt+S]']")).click();
 
 // step: save and verify
 String actual=driver.findElement(By.className("dvHeaderText")).getText();
 if(actual.contains(eutil.readDataFromExcelsheet("Contacts", 1, 2)))
 {
	 System.out.println(actual+"---pass--");
 }
 else
 {
	 System.out.println("failed");
 }
//step : logout of Application
	 WebElement log=driver.findElement(By.xpath("//td[contains(@onmouseover,'fnDropDownUser')][1]"));
		wutil.mouseOverAction(driver, log);
		driver.findElement(By.linkText("Sign Out")).click();
		
		//step: close the browser
		    driver.close();
		
		
		
		
		
		
		
	}

}
