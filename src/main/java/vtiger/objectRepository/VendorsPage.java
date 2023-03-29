package vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage {
	
	@FindAll({@FindBy(css="[title='Create Vendor...']"),@FindBy(css="[alt='Create Vendor...']")})
    private WebElement CreateVendorBtn;
	
	public VendorsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getCreateVendorBtn() {
		return CreateVendorBtn;
	}
	
	//Business Libraries
	
	public void clickOnVendorImg()
	{
		CreateVendorBtn.click();
	}
	
	
	
}
