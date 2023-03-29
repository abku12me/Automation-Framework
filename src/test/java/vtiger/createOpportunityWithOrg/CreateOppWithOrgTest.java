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
import vtiger.objectRepository.CreatingNewOpportunityPage;
import vtiger.objectRepository.CreatingNewOrganizationPage;
import vtiger.objectRepository.HomePage;
import vtiger.objectRepository.LoginPage;
import vtiger.objectRepository.OpportunitiesPage;
import vtiger.objectRepository.OpportunityInformationPage;
import vtiger.objectRepository.OrganizationInformationPage;
import vtiger.objectRepository.OrganizationPage;
@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateOppWithOrgTest extends BaseClass{
	@Test(groups="RegressionSuite")
	public void createOppWithOTest() throws IOException
	{
	    /*Read data from property and excel sheet*/
		String oppname=eutil.readDataFromExcelsheet("Opportunity", 1, 2);
		String orgname=eutil.readDataFromExcelsheet("Organizations", 1, 2)+jutil.randomNumber();
		String date=jutil.getSystemDateInformat();
		
	/*Create the organization */	
		// click on organization link
		HomePage hp=new HomePage(driver);
		hp.clickOnOrg();
		
		// click on org img
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnOrgbtn();
		
		// create the organization with manadatory field
		CreatingNewOrganizationPage cnp=new CreatingNewOrganizationPage(driver);
		cnp.createOrg(orgname);
		
		// validation
		OrganizationInformationPage cip=new OrganizationInformationPage(driver);
		String orgheader=cip.getHeaderOfOrg();
		Assert.assertTrue(orgheader.contains(orgname));
		Reporter.log("Organization created successfully",true);
		
	/*Create the opportunity*/
		
		
	//click on opportunity link
		
		hp.clickOnOpp();
		
	//click on opp img
		OpportunitiesPage ops=new OpportunitiesPage(driver);
		ops.clickonOPPBtn();
		
		// create opportunity with orgname
		
		CreatingNewOpportunityPage cnps=new CreatingNewOpportunityPage(driver);
		cnps.createOpp(driver, oppname, 0, orgname, date, "Needs Analysis");
		
		// validation
		OpportunityInformationPage oip=new OpportunityInformationPage(driver);
		String oppheader=oip.getoppHeader();
		Assert.assertTrue(oppheader.contains(oppname));
		Reporter.log("opportunity created",true);
		
	}
	

}
