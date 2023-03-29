package vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {
	
	@FindBy(css="[title='Create Campaign...']")
	private WebElement CreateCampaignImg;
	
	public CampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getCreateCampaignImg() {
		return CreateCampaignImg;
	}
	
	//Business Libraries
	
	/**
	 * This method will click on campaign button
	 */
	public void clickOnCampaignBtn()
	{
		CreateCampaignImg.click();
	}

}
