package vtiger.ProductsTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.objectRepository.CampaignInformationPage;
import vtiger.objectRepository.CampaignsPage;
import vtiger.objectRepository.CreatingNewCampaignPage;
import vtiger.objectRepository.CreatingNewProductPage;
import vtiger.objectRepository.HomePage;
import vtiger.objectRepository.LoginPage;
import vtiger.objectRepository.ProductInformationPage;
import vtiger.objectRepository.ProductPage;
@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateProductWithCampaignTest extends BaseClass{
	
	@Test
	public void createProductTest() throws IOException
	{
		/*Read the data from Excel sheet*/	
		String productName=eutil.readDataFromExcelsheet("Products", 1, 2);
		String campaignName=eutil.readDataFromExcelsheet("Products", 5, 2);
	
	/* create  product*/
		 
	// click on product link
		 HomePage hp=new HomePage(driver);
		 hp.clickOnProduct();
		 
	// step 4: click on product img
		 ProductPage pp=new ProductPage(driver);
		 pp.clickOnProductImg();
		 
	// step 5: create product
		 CreatingNewProductPage cnp=new CreatingNewProductPage(driver);
		 cnp.createProductWithManf(productName,2);
   // validation
		 ProductInformationPage pip=new ProductInformationPage(driver);
		 String popText=pip.getProductHeader();
		 SoftAssert ast=new SoftAssert();
		 ast.assertTrue(popText.contains(productName));
		 ast.assertAll();
		 Reporter.log("Product created",true);
		 
	/* create campaign*/
		 
	// click on campaign
		 hp.moveToMoreBtn(driver);
		 
	// click on campaign img
		 CampaignsPage cp=new CampaignsPage(driver);
		 cp.clickOnCampaignBtn();
	// create the campaign
		 CreatingNewCampaignPage cncp=new CreatingNewCampaignPage(driver);
		 cncp.createCampaignWithProduct(campaignName, driver, productName);
		
	// validation
		 CampaignInformationPage cip=new CampaignInformationPage(driver);
		 String camtext=cip.getcampaignHeader();
		 Assert.assertTrue(camtext.contains(campaignName));
		 Reporter.log(camtext+" "+"Campaign created with product",true);
	
	}

}
