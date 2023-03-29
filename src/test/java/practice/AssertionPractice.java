package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	
	@Test
	public void sample1()
	{
		System.out.println("step 1");
		System.out.println("step 2");
		Assert.assertEquals(true, false);
		
		System.out.println("step 4");
		System.out.println("step 5");
	}
	
	@Test
	public void sample2()
	{
		System.out.println(" second step 1");
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(false);
		
		System.out.println(" second step 2");
		System.out.println(" second step 3");
		sa.assertAll();// log to all the failure
		
	}

}
