package vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInformationPage {
	
	@FindBy(className="dvHeaderText")
	private WebElement HeaderText;
	
	public OpportunityInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getHeaderText() {
		return HeaderText;
	}
	
	//Business libraries
	/**
	 * This method will return the Opportunity header
	 * @return
	 */
	
	public String getoppHeader()
	{
		String oppttext=HeaderText.getText();
		return oppttext;
	}

}
