package vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	@FindBy(css="[title='Create Product...']")
	private WebElement CreateProductImg;
	
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getCreateProductImg() {
		return CreateProductImg;
	}

	// Business libraries
	
	
	public void clickOnProductImg()
	{
		CreateProductImg.click();
	}
}
