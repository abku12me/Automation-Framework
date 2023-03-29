package vtiger.objectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
/**
 * 
 * @author mishra
 *
 */
public class CreatingNewOrganizationPage extends WebDriverUtility{
	

	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	@FindBy(css="[title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(name="industry")
	private WebElement industrydropdwn;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDwn;
	
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getIndustrydropdwn() {
		return industrydropdwn;
	}

	public WebElement getTypeDropDwn() {
		return typeDropDwn;
	}

     /**
	 * This method will create organization only
	 * @param orgname
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void createOrg(String orgname) throws EncryptedDocumentException, IOException
	{
		orgNameEdt.sendKeys(orgname);
		SaveBtn.click();
	}
	/**
	 * This method will create org with industry and type dropdown
	 * @param orgname
	 * @param industrydrop
	 * @param typedrop
	 */
	
	public void createOrg(String orgname,String industrydrop,String typedrop )
	{
		orgNameEdt.sendKeys(orgname);
		dropDownHandle(industrydropdwn, industrydrop);
		dropDownHandle(industrydropdwn, typedrop);
		SaveBtn.click();
	}
	
	/**
	 * This method will create org with industry drop
	 * @param orgname
	 * @param industrydrop
	 */
	
	public void createOrg(String orgname,String industrydrop)
	{
		orgNameEdt.sendKeys(orgname);
		dropDownHandle(industrydropdwn, industrydrop);
		SaveBtn.click();
	}
	

}
