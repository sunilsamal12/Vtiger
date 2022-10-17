package practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	
	     @Test
		public void createCustomerTest(){
			System.out.println("Step1");
			System.out.println("Step2");
			SoftAssert soft=new SoftAssert();
			soft.assertEquals("A","A");
			System.out.println("step3");
			System.out.println("Step4");
			soft.assertAll();
		}
	     @Test
	     public void modifyCustTest() {
	    	 System.out.println("***************************");
	    	 System.out.println("Step1");
	    	 System.out.println("Step2");
	     }

}
