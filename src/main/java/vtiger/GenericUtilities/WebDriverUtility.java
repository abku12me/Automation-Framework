package vtiger.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consist of generic method related to webdriver 
 * @author mishra
 *@author Abhishek
 */
public class WebDriverUtility {
	
    public void maximizeWindow(WebDriver driver)
    {
    	/**
    	 * This method will maximize the window
    	 */
    	driver.manage().window().maximize();
    }
    public void minimize(WebDriver driver)
    {
    	 /**
    	  * This method will minimize the window
    	  */
    	driver.manage().window().minimize();
    }
    public void waitForPage(WebDriver driver)
    {
    	/**
    	 * This method will wait for the page to be load
    	 */
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	
    }
    public void waitForElementToBeVisible(WebDriver driver, WebElement element)
    {
    	/**
    	 * This method will wait untill the element is visible
    	 */
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForElementToBeclickable(WebDriver driver,WebElement element)
    {
    	/**
    	 * This method will wait until the element is click able
    	 */
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(element));
    }
/**
 * This method will handle drop down based on visible text
 * @param element
 * @param visibleText
 */
    
    public void dropDownHandle(WebElement element,String visibleText)
    {
    	
    	Select s=new Select(element);
    	s.selectByVisibleText(visibleText);
    }
    
    /**
     * This method will handle drop down based on index 
     * @param element
     * @param index
     */
    public void dropDownHandle(WebElement element,int index)
    {
    	Select s=new Select(element);
    	s.selectByIndex(index);
    }
    /**
     * This method will handle drop down based on Value 
     * @param value
     * @param element
     */
    public void dropDownHandle(String value,WebElement element)
    {
    	Select s=new Select(element);
    	s.selectByValue(value);
    }
    
    
    /**
     * This Method will move mouse to the particular web element
     * @param driver
     * @param element
     */
    
    public void mouseOverAction(WebDriver driver,WebElement element)
    {
    	
    	Actions act=new Actions(driver);
    	act.moveToElement(element).perform();
    }
    /**
     * This method will perform right click action anywhere in the web page
     * @param driver
     */
    public void rightClickAction(WebDriver driver)
    {
    	Actions act=new Actions(driver);
    	act.contextClick().perform();
    }
    
    /**
     * This method will perform right click action in particular web element
     * @param driver
     * @param element
     */
    public void rightClickAction(WebDriver driver,WebElement element)
    {
    	Actions act=new Actions(driver);
    	act.contextClick(element).perform();
    }
    /**
     * This method will perform double click action anywhere in the web page
     * @param driver
     */
    
    public void doubleClickAction(WebDriver driver)
    {
    	Actions act=new Actions(driver);
    	act.doubleClick().perform();
    }
    /**
     * This method will perform double click action on particular web element
     * @param driver
     * @param element
     */
    public void doubleClickAction(WebDriver driver, WebElement element)
   {
    	Actions act=new Actions(driver);
    	act.doubleClick(element).perform();
}
    /**
     * This method will perform drag and drop action
     * @param driver
     * @param srcelement
     * @param destelement
     */
    public void dragAndDrop(WebDriver driver,WebElement srcelement,WebElement destelement )
    {
    	Actions act=new Actions(driver);
    	act.dragAndDrop(srcelement, destelement).perform();
    }
    
    /**
     * This method will perform scroll action to the particular web element
     * @param driver
     * @param element
     */
    
    public void scrollAction(WebDriver driver,WebElement element)
    {
    	
    	JavascriptExecutor jse=(JavascriptExecutor)driver;
    	jse.executeScript("arguments[0].scrollIntoView(true)",element);
    	
    }
    /**
     * This Method will perform window scroll action 
     * @param driver
     * @param x
     * @param y
     */
    
    public void scrollAction(WebDriver driver)
    {
    	
    	JavascriptExecutor jse=(JavascriptExecutor)driver;
    	jse.executeScript("window.scrollBy(x,500);");
    	
  }
    /**
     * This method will accept the alert
     * @param driver
     */
    public void acceptalert(WebDriver driver)
    {
    	
    	Alert alt=driver.switchTo().alert();
    	alt.accept();
    }
    /**
     * This method will dismiss the alert
     * @param driver
     */
    
    public void dismissalert(WebDriver driver)
    {
    	driver.switchTo().alert().dismiss();
    }
    /**
     * This method will get the Text Message from the alert pop up
     * @param driver
     * @return
     */
    
    public String getAlertMessage(WebDriver driver)
    {
    	return driver.switchTo().alert().getText();
    }
    
    /**
     * This method will handle frame based on index
     * @param driver
     * @param index
     */
    public void frameHandle(WebDriver driver,int index)
    {
    	driver.switchTo().frame(index);
    }
    /**
     * This method will handle the frame based on id or name attribute value
     * @param driver
     * @param nameorid
     */
    public void frameHandle(WebDriver driver,String nameorid)
    {
    	driver.switchTo().frame(nameorid);
    }
    /**
     * This method will handle the frame based on web element 
     * @param driver
     * @param element
     */
    public void frameHandle(WebDriver driver,WebElement element)
    {
    	driver.switchTo().frame(element);
    }
    
    /**
     * This method will move frame to parent frame
     * @param driver
     */
    public void moveToParentFrame(WebDriver driver)
    {
    	driver.switchTo().parentFrame();
    }
    /**
     * This method will move frame to default web-page
     * @param driver
     */
    
    public void moveToDefaultFrame(WebDriver driver)
    {
    	driver.switchTo().defaultContent();
    }
    
    /**
     * This method will handle notification pop up
     */
    public void notificationPop()
    {
    	ChromeOptions opt=new ChromeOptions();
    	opt.addArguments("--disable-notifications");
    }
    /**
     * This Method will handle window pop-up based on partial title
     * @param driver
     * @param titles
     */
    
    public void handleMultipleWindow(WebDriver driver,String windowpartialtitles)
    {
    	//step 1: capture all the window ID's
    	Set<String> allid=driver.getWindowHandles();
    	
    	//step 2: Navigate to each window
    	for(String id:allid)
    	{
    		// step 3: switch to window and capture the title
    		String wintitle=driver.switchTo().window(id).getTitle();
    		
    		// step 3: compare the title with required partial title
    	     if(wintitle.contains(windowpartialtitles))
    	     {
    	    	break;
    	     }
    	}
    }
    /**
     * This method will take the screenshot of failed test cases
     * @param driver
     * @param screenshotname
     * @return
     * @throws IOException
     */
    public String takeScreenshot(WebDriver driver,String screenshotname) throws IOException
    {
    	TakesScreenshot ts=(TakesScreenshot)driver;
    	File src=ts.getScreenshotAs(OutputType.FILE);
    	File dst=new File(".\\Screenshot\\"+screenshotname+".png");
    	FileUtils.copyFile(src, dst);
    	
    	return dst.getAbsolutePath();//used to extent report
    	
     }
    
    /**
     * This method will perform upload action from the local desktop
     * @param pathoffile
     * @throws AWTException
     */
    
    public void uploadPop(String pathoffile) throws AWTException
    {
    	StringSelection path=new StringSelection(pathoffile);//setting the path
    	Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();//copy the path
    	cb.setContents(path, null);
    	Robot r=new Robot();//paste the path
    	r.keyPress(KeyEvent.VK_CONTROL);
    	r.keyPress(KeyEvent.VK_V);
    	r.keyRelease(KeyEvent.VK_CONTROL);
    	r.keyRelease(KeyEvent.VK_V);
    	r.keyPress(KeyEvent.VK_ENTER);
    	r.keyRelease(KeyEvent.VK_ENTER);
    }
    
    
	
	
	
	
}
