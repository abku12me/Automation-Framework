package vtiger.objectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class CreatingNewContactPage extends WebDriverUtility{
	
	
	@FindAll({@FindBy(name="lastname"),@FindBy(xpath="//input[@name='lastname']")})
     private WebElement lastnameEdt;
	
	@FindBy(xpath="//img[contains(@onclick,'specific_contact')]")
	private WebElement orgLookUp;
	
	@FindBy(name="search_text")
	private WebElement searchText;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy(css="[accesskey='S']")
	private WebElement saveBtn;
	
	public CreatingNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getOrgLookUp() {
		return orgLookUp;
	}

	public WebElement getSearchText() {
		return searchText;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business liberies
	/**
	 * This method will create contact with org
	 * @param driver
	 * @param orgname
	 * @param lastName
	 */
	
	public void createContactWithOrg(WebDriver driver,String orgname,String lastName)
	{
		lastnameEdt.sendKeys(lastName);
		orgLookUp.click();
		handleMultipleWindow(driver,"Accounts&action");
		searchText.sendKeys(orgname);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		handleMultipleWindow(driver,"Contacts");
		saveBtn.click();
	}
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	

	
