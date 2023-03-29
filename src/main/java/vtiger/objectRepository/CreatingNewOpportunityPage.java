package vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreatingNewOpportunityPage extends WebDriverUtility{
	
	@FindAll({@FindBy(name="potentialname"),@FindBy(className="class=\"detailedViewTextBox\"")})
    private WebElement OpportunityNameEdt;
	@FindBy(id="related_to_type")
	private WebElement RelatedToDrop;
	@FindBy(name="closingdate")
	private WebElement closingdateEdt;
	@FindBy(name="sales_stage")
	private WebElement salesstageDrop;
	@FindBy(xpath="//img[contains(@onclick,'Potentials')]")
	private WebElement oppLookImg;
	@FindBy(name="search_text")
	private WebElement searchText;
	@FindBy(name="search")
	private WebElement searchBtn;
	@FindBy(linkText="Avinash")
	private WebElement lastnameser;
	
	@FindBy(css="[accesskey='S']")
	private WebElement saveBtn;
	
	public CreatingNewOpportunityPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getOpportunityNameEdt() {
		return OpportunityNameEdt;
	}

	public WebElement getRelatedToDrop() {
		return RelatedToDrop;
	}

	public WebElement getClosingdateEdt() {
		return closingdateEdt;
	}

	public WebElement getSalesstageDrop() {
		return salesstageDrop;
	}
	public WebElement getoppLookImg()
	{
		return oppLookImg;
	}
	public WebElement getsearchText()
	{
		return searchText;
	}
	public WebElement getsearchBtn()
	{
		return searchBtn;
	}
	public WebElement getsaveBtn()
	{
		return saveBtn;
	}
	public WebElement getlastnameser()
	{
		return lastnameser;
	}
	
	// Business Libraries
	
	/**
	 * This method with create opp with orgname
	 * @param driver
	 * @param oppname
	 * @param index
	 * @param orgname
	 * @param datefield
	 * @param visibleText
	 */
	public void createOpp(WebDriver driver,String oppname,int index ,String orgname,String datefield,String visibleText)
	{
		OpportunityNameEdt.sendKeys(oppname);
		dropDownHandle(RelatedToDrop,index);
		oppLookImg.click();
		handleMultipleWindow(driver,"Accounts&action");
		searchText.sendKeys(orgname);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		handleMultipleWindow(driver,"Potentials&action");
		closingdateEdt.sendKeys(datefield);
		dropDownHandle(salesstageDrop,visibleText);
		saveBtn.click();
		
	}
	 
	/**
	 * This method will create opportunity with contact drop-down
	 * @param driver
	 * @param oppname
	 * @param index
	 * @param lastname
	 * @param datefield
	 * @param visibleText
	 */
	public void createOppwithContactDrop(WebDriver driver,String oppname,int index ,String lastname,String datefield,String visibleText)
	{
		OpportunityNameEdt.sendKeys(oppname);
		dropDownHandle(RelatedToDrop,index);
		oppLookImg.click();
		handleMultipleWindow(driver,"Accounts&action");
		searchText.sendKeys(lastname);
		searchBtn.click();
		lastnameser.click();
		handleMultipleWindow(driver,"Potentials&action");
		closingdateEdt.sendKeys(datefield);
		dropDownHandle(salesstageDrop,visibleText);
		saveBtn.click();
	}
	
	
}
