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
public class OrganizationPage {
	
	@FindBy(css="[title='Create Organization...']")
	private WebElement CreateOrgBtn;
	 public OrganizationPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver,this);
	 }
	public WebElement getCreateOrgBtn() {
		return CreateOrgBtn;
	}
	 
	// This method will click on Org Name
	public void clickOnOrgbtn()
	{
		CreateOrgBtn.click();
	}
	

}
