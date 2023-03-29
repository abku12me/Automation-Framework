package vtiger.OrganizationsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.objectRepository.CreatingNewOrganizationPage;
import vtiger.objectRepository.HomePage;
import vtiger.objectRepository.OrganizationPage;

public class CreateOrgWithMultipleDataTest extends BaseClass{

	
	@Test(dataProvider="getData")
	public void createOrgWithIndustry(String Orgname,String Industry) throws EncryptedDocumentException, IOException
	{
		String ORGNAME=Orgname+jutil.randomNumber();
		HomePage hp=new HomePage(driver);
		hp.clickOnOrg();
		
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnOrgbtn();
		
		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		cnop.createOrg(ORGNAME, Industry);
		
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		Object[][] datas = eutil.readMultipleData("Multiple");
		return datas;
	}
	
	
	
}
