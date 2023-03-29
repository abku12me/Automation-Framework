package vtiger.createOpportunityWithOrg;

import java.io.IOException;

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
import vtiger.objectRepository.CreatingNewOpportunityPage;
import vtiger.objectRepository.CreatingNewOrganizationPage;
import vtiger.objectRepository.HomePage;
import vtiger.objectRepository.LoginPage;
import vtiger.objectRepository.OpportunitiesPage;
import vtiger.objectRepository.OpportunityInformationPage;
import vtiger.objectRepository.OrganizationInformationPage;
import vtiger.objectRepository.OrganizationPage;
@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateOppWithContactTest extends BaseClass {
	@Test(groups="SmokeSuite")
	public void createOppWithContTest() throws IOException
	{
	   
	/*Read data from property and excel sheet*/
		String oppname=eutil.readDataFromExcelsheet("Opportunity", 1, 2);
		String lastname=eutil.readDataFromExcelsheet("Contacts", 4, 2);
		String orgname=eutil.readDataFromExcelsheet("Contacts", 4, 3)+jutil.randomNumber();
		String date=jutil.getSystemDateInformat();
				
	/*create the organization first*/
				
		// click on organization link
				HomePage hp=new HomePage(driver);
			      hp.clickOnOrg();
			      Reporter.log("click on organization link created successfully");
				
	// click on org button from org page
				OrganizationPage op=new OrganizationPage(driver);
				op.clickOnOrgbtn();
				Reporter.log("click on org button from org page created successfully");	
				
	//creating org with org name
				CreatingNewOrganizationPage cno=new CreatingNewOrganizationPage(driver);
				cno.createOrg(orgname);
			Reporter.log("creating org with org name successfully");
				
	//verify if org is created or not
				OrganizationInformationPage oip=new OrganizationInformationPage(driver);
				String header=oip.getHeaderOfOrg();
				Assert.assertTrue(header.contains(orgname));
				Reporter.log("organization created successfully",true);	
				
	/*create the contacts modules*/ 
				
		// click on contacts
			hp.clickOnContacts();
			Reporter.log("click on contacts created successfully");
				
		// click on contacts button
				ContactsPage cp=new ContactsPage(driver);
				cp.clickOnContactsBtn();
			Reporter.log("click on contacts button created successfully");	
				
	// create contacts with last name and org name
				CreatingNewContactPage cncp= new CreatingNewContactPage(driver);
				cncp.createContactWithOrg(driver, orgname, lastname);
			Reporter.log("create contacts with last name and org name successfully");
				
		// validate
			    ContactInformationPage cip=new ContactInformationPage(driver);
			   String contheader=cip.getContactsHeader();
			   Assert.assertTrue(contheader.contains(lastname));
			   Reporter.log("contact created successfully",true);	
		
	/* Create opportunity with contacts*/
					
		    //click on opportunity link
		   	hp.clickOnOpp();
		   	Reporter.log("click on opportunity link created successfully");
					
		//click on opp img
		OpportunitiesPage ops=new OpportunitiesPage(driver);
		ops.clickonOPPBtn();
		Reporter.log("click on opp img created successfully");
					
	// create opportunity with orgname
		CreatingNewOpportunityPage cnps=new CreatingNewOpportunityPage(driver);
		cnps.createOppwithContactDrop(driver, oppname, 1, lastname, date, "Needs Analysis");
		Reporter.log("create opportunity with orgname created successfully");
		
	// validation
	OpportunityInformationPage oips=new OpportunityInformationPage(driver);
	String oppheader=oips.getoppHeader();
	Assert.assertTrue(oppheader.contains(oppname));
	Reporter.log("opportunity with orgname created",true);
	
	}
	
}

	


