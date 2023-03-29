package vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author mishra
 *
 */
public class ContactInformationPage {
	
	@FindBy(className="dvHeaderText")
	private WebElement HeaderText;
	
	public ContactInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getHeaderText() {
		return HeaderText;
	}
	
	//Business libraries
	/**
	 * This method will return the contact header
	 * @return
	 */
	
	public String getContactsHeader()
	{
		String contacttext=HeaderText.getText();
		return contacttext;
	}
	

}
