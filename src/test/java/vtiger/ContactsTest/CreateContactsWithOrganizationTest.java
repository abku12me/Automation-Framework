package vtiger.ContactsTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class CreateContactsWithOrganizationTest {
	@Test
	public void createContactWithOrgTest() throws EncryptedDocumentException, IOException
	{
	
		// step 1:Create the object of all the generic utility class
		ExcelFileUtility eutil=new ExcelFileUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		JavaUtility jutil=new JavaUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		
		//step2: Launch the Browser
		WebDriver driver=new FirefoxDriver();
		wutil.maximizeWindow(driver);
		wutil.waitForPage(driver);
		driver.get(putil.readDataFromPropertyFile("url"));
		
		//step 3: login to the application
		driver.findElement(By.name("user_name")).sendKeys(putil.readDataFromPropertyFile("username"),Keys.TAB,putil.readDataFromPropertyFile("password"),Keys.ENTER);
						
		// step 4: Navigate to Organizations link
		driver.findElement(By.linkText("Organizations")).click();
						
		//step 5:Click on Create Organization look Up Image
		driver.findElement(By.cssSelector("[title='Create Organization...']")).click();
		
		//step 6:Create Organization with Mandatory fields and save
			String orgName=eutil.readDataFromExcelsheet("Contacts", 4, 3)+jutil.randomNumber();
			driver.findElement(By.name("accountname")).sendKeys(orgName);
				
	  // step 7: Save and Verify
	         driver.findElement(By.cssSelector("[title='Save [Alt+S]']")).click();
			 String actual=driver.findElement(By.className("dvHeaderText")).getText();
			 if(actual.contains(orgName))
			 {
				 System.out.println(actual+" Organization created");
			 }
			 else
			 {
				 System.out.println(" Organization not created");
			 }
	//step 8: Navigate to Contacts link
	driver.findElement(By.linkText("Contacts")).click();
	
	//step 9: Click on Create contact look up image
     driver.findElement(By.cssSelector("[title='Create Contact...']")).click(); 
   
     //step 10:Create contact with manadatory fields
     String lastname=eutil.readDataFromExcelsheet("Contacts", 4, 2);
     driver.findElement(By.name("lastname")).sendKeys(lastname);
     
   // step 11: Select the Organization from organization look up image
    driver.findElement(By.xpath("//img[contains(@onclick,'popuptype')]")).click();
    
    //step 12: switch the driver focus to new window
    wutil.handleMultipleWindow(driver, "module=Accounts");
    
    //step 13:search the org name and click
    driver.findElement(By.id("search_txt")).sendKeys(orgName);
    driver.findElement(By.name("search")).click();
    
    //step 14: click on org name
    driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
    
    // step 15: switching and save
    wutil.handleMultipleWindow(driver, "Contacts");
    driver.findElement(By.cssSelector("[title='Save [Alt+S]']")).click();
    
    // step 16: verify
    
    String actuals=driver.findElement(By.className("dvHeaderText")).getText();
	 if(actuals.contains(lastname))
	 {
		 System.out.println(actual+" TC is passed");
	 }
	 else
	 {
		 System.out.println(" contacts created with organization not done");
	 }
	 
	 // logout from the application
	    WebElement log=driver.findElement(By.xpath("//td[contains(@onmouseover,'fnDropDownUser')][1]"));
		wutil.mouseOverAction(driver, log);
		driver.findElement(By.linkText("Sign Out")).click();
    
    
    
    
    
    
    

}
}