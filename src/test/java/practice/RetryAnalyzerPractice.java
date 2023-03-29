package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractice {
	
	@Test(retryAnalyzer=vtiger.GenericUtilities.RetryAnalyzerImplementation.class)
	public void practice()
	{
		System.out.println("Hello");
		Assert.fail();
	}
	//retryAnalyzer we have make use when we called the retry analyzer implementaion

}
