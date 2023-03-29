package vtiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class will perform IRetryAnalyzer which is present in TestNG
 * @author Abhishek
 *
 */
public class RetryAnalyzerImplementation implements IRetryAnalyzer{

	int count=0;
	int retryCount=3;
	/**
	 * This method will retry 3 times only for failed test script
	 */
	
	public boolean retry(ITestResult result) {
		
		while(count<retryCount)
		{
			count++;
			return true;
		}
		
	return false;
		
	}
	

}
