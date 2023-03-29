package vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreatingNewVendorPage extends WebDriverUtility{
	
	@FindBy(name="vendorname")
	private WebElement vendornameEdt;
	@FindBy(name="glacct")
	private WebElement glacctdrop;
	@FindBy(css="[accesskey='S']")
	private WebElement saveBtn;
	
	public CreatingNewVendorPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getVendornameEdt() {
		return vendornameEdt;
	}

	public WebElement getGlacctdrop() {
		return glacctdrop;
	}
	public WebElement getsaveBtn()
	{
		return saveBtn;
	}
	
	//Business Libraries
	
	/**
	 * This method will create vendor with GL Account drop down
	 * @param vendorname
	 * @param indexno
	 */
	public void createVendorWithDrop(String vendorname,int indexno)
	{
		vendornameEdt.sendKeys(vendorname);
		dropDownHandle(glacctdrop,indexno);
		saveBtn.click();
	}
	

}
