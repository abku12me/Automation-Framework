package vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreatingNewProductPage extends WebDriverUtility{
	
	@FindBy(name="productname")
	private WebElement productNameEdt;
	@FindBy(name="manufacturer")
	private WebElement manufacturerDropdown;
	@FindBy(css="[accesskey='S']")
	private WebElement saveBtn;
	
	@FindBy(css="[title='Select']")
	private WebElement Vendoricon;
	@FindBy(name="search_text")
	private WebElement searchtextEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
   
	
	public CreatingNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getProductNameEdt() {
		return productNameEdt;
	}


	public WebElement getManufacturerDropdown() {
		return manufacturerDropdown;
	}
	
	public WebElement getsaveBtn()
	{
		return saveBtn;
	}
	
	public WebElement getVendoricon()
	{
		return Vendoricon;
	}
	
	public WebElement getsearchtextEdt()
	{
		return searchtextEdt;
	}
	
	public WebElement getsearchBtn()
	{
		return searchBtn;
	}
	// Business Libraries
	
	/**
	 * This method will create product with Manufacturer
	 * @param productName
	 * @param indexno
	 */
	
	public void createProductWithManf(String productName,int indexno)
	{
		productNameEdt.sendKeys(productName);
		dropDownHandle(manufacturerDropdown,indexno);
		saveBtn.click();
	}
	
	/**
	 * This method will create product with vendor name
	 * @param productName
	 * @param indexno
	 * @param driver
	 * @param vendorname
	 */
	
	public void createProductwithVendorandManf(String productName,int indexno,WebDriver driver,String vendorname )
	{
		productNameEdt.sendKeys(productName);
		dropDownHandle(manufacturerDropdown,indexno);
		Vendoricon.click();
		handleMultipleWindow(driver,"Vendors&action");
		searchtextEdt.sendKeys(vendorname);
		searchBtn.click();
		driver.findElement(By.linkText(vendorname)).click();
		handleMultipleWindow(driver,"Products&action");
		saveBtn.click();
	}
	
	
}
