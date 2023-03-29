package vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TicketInformationPage {
	
	@FindBy(className="dvHeaderText")
	private WebElement HeaderText;
	
	public TicketInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getHeaderText() {
		return HeaderText;
	}
	
	//Business libraries
	/**
	 * This method will return the Ticket header
	 * @return
	 */
	
	public String getTicketHeader()
	{
		String ticketText=HeaderText.getText();
		return ticketText;
	}
	

}
