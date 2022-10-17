package practice;

import org.testng.Assert;
import org.testng.annotations.Test;



public class RetryDemo {
@Test(retryAnalyzer=com.crm.Generic_Utilities.RetryAnalyser.class)
	public void sample() {
		Assert.assertEquals("A","B");
		System.out.println("hii");
	}
}
