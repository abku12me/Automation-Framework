package vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInformationPage {
	
	@FindBy(className="lvtHeaderText")
	private WebElement HeaderText;
	
	public VendorInformationPage(WebDriver driver)
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
	
	public String getVendorHeader()
	{
		String vendorText=HeaderText.getText();
		return vendorText;
	}

}
