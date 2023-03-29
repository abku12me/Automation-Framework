package vtiger.CreateVendorWithCampaign$Product;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.objectRepository.CampaignInformationPage;
import vtiger.objectRepository.CampaignsPage;
import vtiger.objectRepository.CreatingNewCampaignPage;
import vtiger.objectRepository.CreatingNewProductPage;
import vtiger.objectRepository.CreatingNewVendorPage;
import vtiger.objectRepository.HomePage;
import vtiger.objectRepository.ProductInformationPage;
import vtiger.objectRepository.ProductPage;
import vtiger.objectRepository.VendorInformationPage;
import vtiger.objectRepository.VendorsPage;

public class CreateVendorWithCampProductTest extends BaseClass{
	
	@Test
	public void createVenWithCampAndProduct() throws EncryptedDocumentException, IOException
	{
		/* create vendor first*/
		
		/*Read the data from excel sheet*/
		String vendorname=eutil.readDataFromExcelsheet("Products", 8, 2);
		String productname=eutil.readDataFromExcelsheet("Products", 1, 2);
		String campaignName=eutil.readDataFromExcelsheet("Products", 5, 2);
		
		// click on vendor link
		HomePage hp=new HomePage(driver);
		hp.moveToMoreClickOnVen(driver);
		Reporter.log("click on vendor link created successfully");
		
	// click on vendor img
		VendorsPage vp=new VendorsPage(driver);
		vp.clickOnVendorImg();
		Reporter.log("click on vendor img created successfully");
		
	// create vendor with GL Account
		CreatingNewVendorPage cnv=new CreatingNewVendorPage(driver);
		cnv.createVendorWithDrop(vendorname, 5);
		Reporter.log("create vendor with GL Account created successfully");
		
	// validation
		VendorInformationPage vip=new VendorInformationPage(driver);
		String vendortext=vip.getVendorHeader();
		Assert.assertTrue(vendortext.contains(vendorname));
		Reporter.log("Vendor created successfully",true);
		
	/*create product with vendor name*/
		
		// click on product link
		hp.clickOnProduct();
		
		// click on product icon
		ProductPage pp=new ProductPage(driver);
		pp.clickOnProductImg();
		
		// create product with vendor name& Manufacturer and save
		CreatingNewProductPage cnp=new CreatingNewProductPage(driver);
		cnp.createProductwithVendorandManf(productname, 2, driver, vendorname);
		
		// validation
		ProductInformationPage pip=new ProductInformationPage(driver);
		String prodheader=pip.getProductHeader();
		Assert.assertTrue(prodheader.contains(productname));
		Reporter.log("product created sucessfully",true);
		
	/* Create campaign with product*/
		
	// click on campaign
	 hp.moveToMoreBtn(driver);
				 
	// click on campaign img
		CampaignsPage cp=new CampaignsPage(driver);
		cp.clickOnCampaignBtn();
		
	// create the campaign
	 CreatingNewCampaignPage cncp=new CreatingNewCampaignPage(driver);
	 cncp.createCampaignWithProduct(campaignName, driver, productname);
				
	// validation
	 CampaignInformationPage cip=new CampaignInformationPage(driver);
	String camtext=cip.getcampaignHeader();
	Assert.assertTrue(camtext.contains(campaignName));
	Reporter.log("Campaign created with product",true);
		
		
	}
	

}
