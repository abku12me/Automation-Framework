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
public class OrganizationInformationPage {
	
	@FindBy(className="dvHeaderText")
	private WebElement HeaderTextOrg;
	
	public OrganizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getHeaderTextOrg() {
		return HeaderTextOrg;
	}
	
	/**
	 * This method will return header of the org
	 * @return
	 */
	public String getHeaderOfOrg()
	{
		String headertext=HeaderTextOrg.getText();
		return headertext;
	}
	

}
