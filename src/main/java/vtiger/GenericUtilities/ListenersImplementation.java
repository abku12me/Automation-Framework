package vtiger.GenericUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * This class will implements the ITestListener of TestNG
 * @author Abhishek
 *
 */
public class ListenersImplementation implements ITestListener{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test=report.createTest(methodName+"-- Execution started--");
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"--pass-- ");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		JavaUtility jutil= new JavaUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		String methodName=result.getMethod().getMethodName();
		
		test.log(Status.FAIL, methodName+"--fail-- ");
		
		String Screenshotname=result.getName()+" "+jutil.calendarFormatHandle(0);
		
		try {
			
		String path=wutil.takeScreenshot(BaseClass.Listenerdriver, Screenshotname);
		test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			 
			
		}
		
		
		/*                Optional */
		//String failedpagename=result.getName();
		
		//TakesScreenshot ts=(TakesScreenshot)BaseClass.Listenerdriver;
    	//File src=ts.getScreenshotAs(OutputType.FILE);
    	//File dst=new File(".\\Screenshot\\"+failedpagename+".png");
    	//try {
			//FileUtils.copyFile(src, dst);
		//} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		
		test.log(Status.SKIP, methodName+"--skip-- ");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("suite execution started");
		ExtentSparkReporter htmlreport=new ExtentSparkReporter(".\\ExtentRepor\\Reports.html"/*+new JavaUtility().getSystemDate()+".html*/);
		htmlreport.config().setDocumentTitle("Vtiger Execution Reports");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("Vtiger Execution Reports line");
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base url", "https://localhost:8888");
		report.setSystemInfo("Browser", "firefox");
		report.setSystemInfo("Reporter name","Abhishek");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("suite execution finished");
		report.flush();
		
	}
	
	
	

}
