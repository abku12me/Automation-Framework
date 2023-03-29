package vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {
	
	@FindBy(className="lvtHeaderText")
	private WebElement HeaderText;
	
	public ProductInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getHeaderText() {
		return HeaderText;
	}
	
	//Business libraries
	/**
	 * This method will return the product header
	 * @return
	 */
	
	public String getProductHeader()
	{
		String ProductText=HeaderText.getText();
		return ProductText;
	}

}
