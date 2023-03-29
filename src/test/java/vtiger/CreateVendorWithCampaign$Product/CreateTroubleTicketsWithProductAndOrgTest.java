package vtiger.CreateVendorWithCampaign$Product;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import vtiger.GenericUtilities.BaseClass;
import vtiger.objectRepository.ContactInformationPage;
import vtiger.objectRepository.ContactsPage;
import vtiger.objectRepository.CreatingNewContactPage;
import vtiger.objectRepository.CreatingNewOrganizationPage;
import vtiger.objectRepository.CreatingNewProductPage;
import vtiger.objectRepository.CreatingNewTicketPage;
import vtiger.objectRepository.HomePage;
import vtiger.objectRepository.OrganizationInformationPage;
import vtiger.objectRepository.OrganizationPage;
import vtiger.objectRepository.ProductInformationPage;
import vtiger.objectRepository.ProductPage;
import vtiger.objectRepository.TicketInformationPage;
import vtiger.objectRepository.TroubleTicketsPage;
@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateTroubleTicketsWithProductAndOrgTest extends BaseClass{
	
	@Test(groups={"Smokesuite","Regressionsuite"})
	public void createTroubleTicket() throws EncryptedDocumentException, IOException
	{
		
	   /* Read data from excel sheet*/
	  String lastname=eutil.readDataFromExcelsheet("Trouble Ticket", 1, 4);
	  String orgname=eutil.readDataFromExcelsheet("Trouble Ticket", 1, 5)+jutil.randomNumber();
	  String productName=eutil.readDataFromExcelsheet("Trouble Ticket", 1, 3);
	  String TitleName=eutil.readDataFromExcelsheet("Trouble Ticket", 1, 2);
	
    /*create the organization first*/
	
	// click on organization link
	HomePage hp=new HomePage(driver);
      hp.clickOnOrg();
      Reporter.log("click on organization link created successfully",true);
	
	// click on org button from org page
	OrganizationPage op=new OrganizationPage(driver);
	op.clickOnOrgbtn();
	Reporter.log("click on org button from org page created successfully",true);
	
	//creating org with org name
	CreatingNewOrganizationPage cno=new CreatingNewOrganizationPage(driver);
	cno.createOrg(orgname);
	Reporter.log("creating org with org name successfully",true);
	
	//verify if org is created or not
	OrganizationInformationPage oip=new OrganizationInformationPage(driver);
	String header=oip.getHeaderOfOrg();
	Assert.assertTrue(header.contains(orgname));
	Reporter.log("Organization is created",true);
	
/*create the contacts modules*/ 
	
	// click on contacts
	hp.clickOnContacts();
	Reporter.log("click on contacts created successful",true);
	
	// click on contacts button
	ContactsPage cp=new ContactsPage(driver);
	cp.clickOnContactsBtn();
	Reporter.log("click on contacts button successful",true);
	
	// create contacts with last name and org name
	CreatingNewContactPage cncp= new CreatingNewContactPage(driver);
	cncp.createContactWithOrg(driver, orgname, lastname);
	Reporter.log("create contacts with last name and org name successful",true);
   
   // validate
    ContactInformationPage cip=new ContactInformationPage(driver);
    String contheader=cip.getContactsHeader();
   Assert.assertTrue(contheader.contains(lastname));
   Reporter.log("contact is created",true);
   
   /* create  product*/
	 
	// click on product link
		hp.clickOnProduct();
		Reporter.log("click on product link created successful",true);
		 
	// step : click on product img
		 ProductPage pp=new ProductPage(driver);
		 pp.clickOnProductImg();
		 Reporter.log("click on product img created successful",true);
		 
	// step : create product
		 CreatingNewProductPage cnp=new CreatingNewProductPage(driver);
		 cnp.createProductWithManf(productName,2);
  // validation
		 ProductInformationPage pip=new ProductInformationPage(driver);
		 String popText=pip.getProductHeader();
		 SoftAssert ast=new SoftAssert();
		 ast.assertTrue(popText.contains(productName));
		 ast.assertAll();
		 Reporter.log("Product created",true);
   
   /*Create Trouble Ticket*/
		 
	 // click on Trouble Ticket
		 hp.clickOnTroubleTicket();
		 Reporter.log("click on Trouble Ticket successful",true);
		 
	// click on Trouble Ticket img
		 TroubleTicketsPage ttp=new TroubleTicketsPage(driver);
		 ttp.clickOnTroubleTicketImg();
		 Reporter.log("click on Trouble Ticket img successful",true);
		 
	// create Trouble Ticket with contact
		 CreatingNewTicketPage cntp=new CreatingNewTicketPage(driver);
         //cntp.createTroubleTicketWithProductAndContact(lastname, 1, TitleName, 1, driver, productName);
	
	// 	 create Trouble Ticket with Organization
         cntp.createTroubleTicketWithProductAndOrganization(orgname, 1, TitleName, 1, driver, productName);
         
   //validation
         TicketInformationPage tip=new TicketInformationPage(driver);
         String ticketText=tip.getTicketHeader();
         ast.assertTrue(ticketText.contains(TitleName));
         ast.assertAll();
         Reporter.log("Ticket created successfully",true);
	}

}
