package vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
	
	@FindBy(css="[title='Create Opportunity...']")
	private WebElement CreateOppoBtn;
	
	public OpportunitiesPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		//this.driver=driver;
	}

	public WebElement getCreateOppoBtn() {
		return CreateOppoBtn;
	}
	
	// Business Libraries
	
	public void clickonOPPBtn()
	{
		CreateOppoBtn.click();
	}

}
