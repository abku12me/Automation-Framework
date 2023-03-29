package vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTicketsPage {
	
	@FindBy(css="[title='Create Ticket...']")
	private WebElement CreateTicketImg;
	
	public TroubleTicketsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getCreateTicketImg() {
		return CreateTicketImg;
	}
	
	// Business Libraries
	
	/**
	 * This method will perform click action on TroubleTicketImg
	 */
	public void clickOnTroubleTicketImg()
	{
		CreateTicketImg.click();
	}

}
