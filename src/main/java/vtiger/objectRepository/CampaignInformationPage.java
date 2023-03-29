package vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformationPage {
	
	@FindBy(className="dvHeaderText")
	private WebElement HeaderText;
	
	public CampaignInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getHeaderText() {
		return HeaderText;
	}
	
	//Business libraries
	/**
	 * This method will return the campaign header
	 * @return
	 */
	
	public String getcampaignHeader()
	{
		String campaignText=HeaderText.getText();
		return campaignText;
	}

}


