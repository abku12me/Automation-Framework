package practice;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class createOrganizationslinkpractice {
	//step 1: create the object of all generic utility
	ExcelFileUtility eutil=new ExcelFileUtility();
	PropertyFileUtility putil=new PropertyFileUtility();
	JavaUtility jutil=new JavaUtility();
	WebDriverUtility wutil=new WebDriverUtility();
	@Test
	public void drophandle() throws IOException
	{
		
		//step1: Launch the Browser
		WebDriver driver=new ChromeDriver();
		wutil.maximizeWindow(driver);
		wutil.waitForPage(driver);
		driver.get(putil.readDataFromPropertyFile("url"));
				
		//step 2: login to the application
		driver.findElement(By.name("user_name")).sendKeys(putil.readDataFromPropertyFile("username"),Keys.TAB,putil.readDataFromPropertyFile("password"),Keys.ENTER);
				
		// step 3: Navigate to Organizations link
		driver.findElement(By.linkText("Organizations")).click();
				
		//step 4:Click on Create Organization look Up Image
				
		driver.findElement(By.cssSelector("[title='Create Organization...']")).click();
		//step 5:Create Organization with Mandatory fields and save
	     String actualresult=eutil.readDataFromExcelsheet("Contacts", 7, 3)+jutil.randomNumber();
	      driver.findElement(By.name("accountname")).sendKeys(actualresult);
		
		// step 6: Select "Chemicals" in the industry drop down
		WebElement	dropdowns=driver.findElement(By.name("industry"));
	     wutil.dropDownHandle(dropdowns, "Chemicals"); 
	     driver.findElement(By.cssSelector("[title='Save [Alt+S]']")).click();
				
	// step6: Save and Verify
	 
	 String actual=driver.findElement(By.className("dvHeaderText")).getText();
	 if(actual.contains(actualresult))
	 {
		 System.out.println(actual+" pass");
	 }
	 else
	 {
		 System.out.println(" failed");
	 }
		
	//step 7: logout of Application
	 WebElement log=driver.findElement(By.xpath("//td[contains(@onmouseover,'fnDropDownUser')][1]"));
		wutil.mouseOverAction(driver, log);
		driver.findElement(By.linkText("Sign Out")).click();
	}

}
