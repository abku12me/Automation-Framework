package vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreatingNewTicketPage extends WebDriverUtility{
	
	@FindBy(name="ticket_title")
	private WebElement ticketTitleEdt;
	@FindBy(name="ticketpriorities")
	private WebElement ticketPriorities;
	@FindBy(name="ticketseverities")
	private WebElement ticketSeverities;
	@FindBy(name="ticketcategories")
	private WebElement ticketCategories;
	@FindBy(name="parent_type")
	private WebElement parentType;
	@FindBy(xpath="//img[contains(@onclick,'parent_type')]")
	private WebElement parentTypeLookUp;
	@FindBy(name="search_text")
	private WebElement searchTextEdt;
	@FindBy(name="search")
	private WebElement searchBtn;
	@FindBy(xpath="//img[contains(@onclick,'Products')]")
	private WebElement ProductNameLookUp;
	@FindBy(name="ticketstatus")
	private WebElement ticketStatus;
	
	@FindBy(css="[title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	public CreatingNewTicketPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public WebElement getTicketTitleEdt() {
		return ticketTitleEdt;
	}

	public WebElement getTicketPriorities() {
		return ticketPriorities;
	}


	public WebElement getTicketSeverities() {
		return ticketSeverities;
	}


	public WebElement getTicketCategories() {
		return ticketCategories;
	}


	public WebElement getParentType() {
		return parentType;
	}


	public WebElement getParentTypeLookUp() {
		return parentTypeLookUp;
	}

	public WebElement getSearchTextEdt() {
		return searchTextEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getProductNameLookUp() {
		return ProductNameLookUp;
	}

	public WebElement getTicketStatus() {
		return ticketStatus;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}


	// Business Libraries
	
	/**
	 * This Method will create TroubleTicket With Product And Contact 
	 * @param LastName
	 * @param indexno
	 * @param titleName
	 * @param index
	 * @param driver
	 * @param ProductName
	 */
    public void createTroubleTicketWithProductAndContact(String LastName, int indexno, String titleName,int index,WebDriver driver,String ProductName )
    {
    	ticketTitleEdt.sendKeys(titleName);
    	dropDownHandle(ticketPriorities,index);
    	dropDownHandle(ticketSeverities,"Major");
    	dropDownHandle(ticketCategories,indexno);
    	dropDownHandle(parentType,0);
    	parentTypeLookUp.click();
    	handleMultipleWindow(driver,"Contacts&action");
    	searchTextEdt.sendKeys(LastName);
    	searchBtn.click();
    	driver.findElement(By.linkText(LastName)).click();
    	handleMultipleWindow(driver,"HelpDesk&action");
    	ProductNameLookUp.click();
    	handleMultipleWindow(driver,"Products&action");
    	searchTextEdt.sendKeys(ProductName);
    	searchBtn.click();
    	driver.findElement(By.linkText(ProductName)).click();
    	handleMultipleWindow(driver,"HelpDesk&action");
    	dropDownHandle(ticketStatus,1);
    	SaveBtn.click();
    }
    
    /**
     * This method will create trouble ticket with organization and product info
     * @param Orgname
     * @param indexno
     * @param titleName
     * @param index
     * @param driver
     * @param ProductName
     */
    
    public void createTroubleTicketWithProductAndOrganization(String Orgname, int indexno, String titleName,int index,WebDriver driver,String ProductName )
    {
    	ticketTitleEdt.sendKeys(titleName);
    	dropDownHandle(ticketPriorities,index);
    	dropDownHandle(ticketSeverities,"Major");
    	dropDownHandle(ticketCategories,indexno);
    	dropDownHandle(parentType,1);
    	parentTypeLookUp.click();
    	handleMultipleWindow(driver,"Accounts&action");
    	searchTextEdt.sendKeys(Orgname);
    	searchBtn.click();
    	driver.findElement(By.linkText(Orgname)).click();
    	handleMultipleWindow(driver,"HelpDesk&action");
    	ProductNameLookUp.click();
    	handleMultipleWindow(driver,"Products&action");
    	searchTextEdt.sendKeys(ProductName);
    	searchBtn.click();
    	driver.findElement(By.linkText(ProductName)).click();
    	handleMultipleWindow(driver,"HelpDesk&action");
    	dropDownHandle(ticketStatus,1);
    	SaveBtn.click();
    	
    }
}
