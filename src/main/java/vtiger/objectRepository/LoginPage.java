package vtiger.objectRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.PropertyFileUtility;

/**
 * @author Abhishek
 */
public class LoginPage { 
	
	
	//rule 1: create the POM class for every web-page

	//rule 2: identify the web element by using @FindBy,@FindAll,@FindBys make it private
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	@FindAll({@FindBy(name="user_password"),@FindBy(xpath="//input[@type='password']")})
	private WebElement passwordEdt;
	@FindBy(id="submitButton")
	private WebElement submitbtn;
	
	// rule 3:initialize all the web-element by using constructor and page factory class
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
	//Business Layer- consist of generic method 
	/**
	 * This method will login into the application
	 * @param username
	 * @param password
	 * @throws IOException
	 */
	
	public void loginToApp(String username,String password) throws IOException
	{
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		submitbtn.click();
	}
	
	
}
