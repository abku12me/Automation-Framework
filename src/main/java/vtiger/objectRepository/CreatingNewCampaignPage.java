package vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreatingNewCampaignPage extends WebDriverUtility{
	
	@FindBy(name="campaignname")
	private WebElement campaignnameEdt;
	@FindBy(css="[title='Select']")
	private WebElement Selecticon;
	@FindBy(name="search_text")
	private WebElement searchTextEdt;
	@FindBy(name="search")
	private WebElement searchBtn;
	@FindBy(css="[accesskey='S']")
	private WebElement saveBtn;
	
	
	@FindBy(linkText="Dell Laptop")
	private WebElement DellLaptop;
	
	
	public CreatingNewCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getCampaignnameEdt() {
		return campaignnameEdt;
	}

	public WebElement getSelecticon() {
		return Selecticon;
	}

	public WebElement getSearchTextEdt() {
		return searchTextEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public WebElement getsaveBtn() {
		return saveBtn;
	}
	
	
	// Business libraries
	
	/**
	 * This method will create campaign
	 * @param campaigName
	 * @param driver
	 * @param productName
	 */
	
	public void createCampaignWithProduct(String campaigName,WebDriver driver,String productName)
	{
		campaignnameEdt.sendKeys(campaigName);
		Selecticon.click();
		handleMultipleWindow(driver,"Products&action");
		searchTextEdt.sendKeys(productName);
		driver.findElement(By.linkText(productName)).click();
		handleMultipleWindow(driver,"Campaigns&action");
		saveBtn.click();
		}

}
