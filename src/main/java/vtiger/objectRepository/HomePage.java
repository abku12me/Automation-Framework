package vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;
/**
 * 
 * @author mishr
 *
 */
public class HomePage extends WebDriverUtility{
	
	@FindBy(linkText="Contacts")
	private WebElement Contactslink;
	@FindBy(linkText="Organizations")
	private WebElement OrganizationsLink;
	@FindBy(linkText="Opportunities")
	private WebElement Opportunitieslink;
	@FindBy(linkText="Leads")
	private WebElement Leadslink;
	
	@FindBy(xpath="//td[contains(@onmouseout,'ondemand')]")
	private WebElement Administrator;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOut;
	
	@FindBy(linkText="More")
	private WebElement moreBtn;
	@FindBy(linkText="Campaigns")
	private WebElement CampaignsBtn;
	@FindBy(linkText="Products")
	private WebElement ProductsBtn;
	@FindBy(linkText="Vendors")
	private WebElement VendorsBtn;
	@FindBy(linkText="Trouble Tickets")
	private WebElement TroubleTicketsLink;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getContactslink() {
		return Contactslink;
	}
	public WebElement getOrganizationsLink() {
		return OrganizationsLink;
	}
	public WebElement getAdministrator() {
		return Administrator;
	}
	
	public WebElement getsignOut() {
		return signOut;
	}
	public WebElement getOpportunitieslink()
	{
		return Opportunitieslink;
	}
	public WebElement getLeadslink()
	{
		return Leadslink;
	}
	
	public WebElement getmoreBtn()
	{
		return moreBtn;
	}
	
	public WebElement getCampaignsBtn()
	{
		return CampaignsBtn;
	}
	public WebElement getProductsBtn()
	{
		return ProductsBtn;
	}
	public WebElement getVendors()
	{
		return VendorsBtn;
	}
	public WebElement getTroubleTicketsLink()
	{
		return TroubleTicketsLink;
	}
	
	
	
	
	//Business libraries 
	
/**
 * This Method will perform click action on contacts link
 */

	public void clickOnContacts()
	{
		Contactslink.click();
	}
	
	/**
	 * This Method will perform click action on Organization link
	 */
	
	public void clickOnOrg()
	{
		OrganizationsLink.click();
	}
	

	/**
	 * This method will perform sign out action
	 * @param driver
	 */
	public void logoutFromApp(WebDriver driver)
	{
		mouseOverAction(driver,Administrator);
		signOut.click();
	}
	
	/**
	 * This method will click operation on opportunity link
	 */
	public void clickOnOpp()
	{
		Opportunitieslink.click();
	}
	
	/**
	 * This method will click on leads link
	 */
	public void clickOnLead()
	{
		Leadslink.click();
	}
	
	
	/**
	 * This method will perform click action on product
	 */
	public void clickOnProduct()
	{
		ProductsBtn.click();
	}
	
	/**
	 * This Method will click on campaign link
	 * @param driver
	 */
	
	public void moveToMoreBtn(WebDriver driver)
	{
		mouseOverAction(driver,moreBtn);
		CampaignsBtn.click();
		
	}
	
	/**
	 * This method will perform click action on vendor link
	 * @param driver
	 */
	
	public void moveToMoreClickOnVen(WebDriver driver)
	{
		mouseOverAction(driver,moreBtn);
		VendorsBtn.click();
	}
	
	/**
	 * This Method will perform click action on TroubleTicket
	 */
	public void clickOnTroubleTicket()
	{
		TroubleTicketsLink.click();
	}
	
	

}
