package vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author mishr
 *
 */
public class ContactsPage {
	
	@FindBy(css="[title='Create Contact...']")
	private WebElement CreateContactBtn;
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getCreateContactBtn() {
		return CreateContactBtn;
	}
    
	/*
	 * This method will click on create button
	 */
	public void clickOnContactsBtn()
	{
		CreateContactBtn.click();
	}
}
