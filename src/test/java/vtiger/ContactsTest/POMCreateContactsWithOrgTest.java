package vtiger.ContactsTest;




import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.objectRepository.ContactInformationPage;
import vtiger.objectRepository.ContactsPage;
import vtiger.objectRepository.CreatingNewContactPage;
import vtiger.objectRepository.CreatingNewOrganizationPage;
import vtiger.objectRepository.HomePage;
import vtiger.objectRepository.LoginPage;
import vtiger.objectRepository.OrganizationInformationPage;
import vtiger.objectRepository.OrganizationPage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class POMCreateContactsWithOrgTest extends BaseClass{
	
	@Test(retryAnalyzer=vtiger.GenericUtilities.RetryAnalyzerImplementation.class)
	public void createContactWithOrgTest() throws IOException
	{
       /* Read data from excel sheet*/
		String lastname=eutil.readDataFromExcelsheet("Contacts", 4, 2);
		String orgname=eutil.readDataFromExcelsheet("Contacts", 4, 3)+jutil.randomNumber();
		
   /*create the organization first*/
		
		// click on organization link
		HomePage hp=new HomePage(driver);
	      hp.clickOnOrg();
		
		// click on org button from org page
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnOrgbtn();
		
		//creating org with org name
		CreatingNewOrganizationPage cno=new CreatingNewOrganizationPage(driver);
		cno.createOrg(orgname);
		
		//verify if org is created or not
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String header=oip.getHeaderOfOrg();
		Assert.assertTrue(header.contains(orgname));
		Reporter.log("organization created",true);
		
	/*create the contacts modules*/ 
		
		// click on contacts
		hp.clickOnContacts();
		
		// click on contacts button
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnContactsBtn();
		
		// create contacts with last name and org name
		CreatingNewContactPage cncp= new CreatingNewContactPage(driver);
		cncp.createContactWithOrg(driver, orgname, lastname);
  
	   
	   // validate
	    ContactInformationPage cip=new ContactInformationPage(driver);
	   String contheader=cip.getContactsHeader();
	   Assert.assertTrue(contheader.contains(lastname));
	   Reporter.log("contact created",true);
	   
	  
	}
	@Test(retryAnalyzer=vtiger.GenericUtilities.RetryAnalyzerImplementation.class)
	public void regional()
	{
		System.out.println("Regional testing");
	  Assert.fail();
	}

}
