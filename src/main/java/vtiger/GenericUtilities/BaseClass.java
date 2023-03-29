package vtiger.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import vtiger.objectRepository.HomePage;
import vtiger.objectRepository.LoginPage;
/**
 * This class consists of basic configuration annotation of TestNG
 * @author Abhishek
 *
 */
public class BaseClass {
	
	public ExcelFileUtility eutil=new ExcelFileUtility();
	public PropertyFileUtility putil=new PropertyFileUtility();
	public JavaUtility jutil=new JavaUtility();
	public WebDriverUtility wutil=new WebDriverUtility();
	
	public static WebDriver Listenerdriver;//listener
	
	public WebDriver driver;
	
	
	@BeforeSuite(alwaysRun=true)
	public void bsConfig( )
	{
		System.out.println("***Database Connection sucessfully******");
	}
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(alwaysRun=true)
	public void bcConfig(/*String browser*/ )
	{
		//if(browser.contains("chrome"))
		//{
		//driver=new ChromeDriver();
		//}
		//else if(browser.contains("firefox"))
		//{
			driver=new FirefoxDriver();
			Listenerdriver=driver;//listener
		//}
		
		wutil.maximizeWindow(driver);
		wutil.waitForPage(driver);
		System.out.println("****Launching the Browser****");
	}
	
	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws IOException
	{
		String username=putil.readDataFromPropertyFile("username");
		String password=putil.readDataFromPropertyFile("password");
		driver.get(putil.readDataFromPropertyFile("url"));
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(username, password);
		System.out.println("*****Login into Application******");
	}
	
	@AfterMethod(alwaysRun=true)
	public void amConfig()
	{
		 HomePage hp=new HomePage(driver);
		 hp.logoutFromApp(driver);
		 System.out.println("***Logout from the application*****");
	}
	@AfterClass(alwaysRun=true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("****Close the Browser******");
	}
	@AfterSuite(alwaysRun=true)
	public void asConfig()
	{
		System.out.println("***Database Connection closed sucessfully****");
	}

}
