package com.crm.Generic_Utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenerImplementationclass implements ITestListener{

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
	
	}
  
	public void onTestFailure(ITestResult result) {
		String testdata=result.getMethod().getMethodName();
		System.out.println(testdata+"execute the listener");
		
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		File src=edriver.getScreenshotAs(OutputType.FILE);
		
		try {
			File des=new File("./com.crm.Selenium.FrameWork/screenshot/"+testdata+".png");
			FileUtils.copyFile(src, des);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	
	
}
