package vtiger.OrganizationsTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.IConstantUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class CreateOrganizationTest {
	
	public static void main(String[] args) throws IOException {
		//step 1: create the object of all generic utility
		ExcelFileUtility eutil=new ExcelFileUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		JavaUtility jutil=new JavaUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		
		/*Read data from properties file*/
		String URL=putil.readDataFromPropertyFile("url");
		String BROWSER=putil.readDataFromPropertyFile("browser");
		String USERNAME=putil.readDataFromPropertyFile("username");
		String PASSWORD=putil.readDataFromPropertyFile("password");
		
		/*Read data from Execl sheet*/
	       String orgname=eutil.readDataFromExcelsheet("Contacts", 1, 2)+jutil.randomNumber();
	  
			  
	WebDriver driver=null;
	
	//Step 2: Launch the browser  Run time polymorphism
	if(BROWSER.equals("chrome"))
	{
		driver=new ChromeDriver();
	}
	else if(BROWSER.equals("Firefox"))
	{
		driver=new FirefoxDriver();
	}
	else
	{
		System.out.println("invalid browser");
	}
	wutil.maximizeWindow(driver);
	wutil.waitForPage(driver);
	driver.get(putil.readDataFromPropertyFile("url"));
	
 
	
	//Login to application with valid credentials
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
	// step 3: Navigate to Organizations link
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.cssSelector("[title='Create Organization...']")).click();	
			
			driver.findElement(By.name("accountname")).sendKeys(orgname);
			driver.findElement(By.cssSelector("[title='Save [Alt+S]']")).click();
			
	// step6: Save and Verify
		String expected=driver.findElement(By.className("dvHeaderText")).getText();
			if(expected.contains(orgname))
			{
				System.out.println(expected+" pass ");
			}
			else
			{
				System.out.println("TC is failed");
			}
			
	//step 7: logout of Application
			
			WebElement log=driver.findElement(By.xpath("//td[contains(@onmouseover,'fnDropDownUser')][1]"));
			wutil.mouseOverAction(driver, log);
			driver.findElement(By.linkText("Sign Out")).click();
			
		//close the browser
			driver.close();
		
		
		
		
	}

}
