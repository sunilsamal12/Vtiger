package com.crm.Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.Excel_Utility;
import com.crm.Generic_Utilities.File_Utility;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.WebDriver_Utility;
import com.crm.ObjectRepository.CampaignCreatePage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ValidationAndVerificationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignTest extends BaseClass {
	@Test(groups={"regressionTest"})
     public void createCampaignTest()  throws Throwable {
	
		Java_Utility jlib= new Java_Utility();
		Excel_Utility elib=new Excel_Utility();
		File_Utility flib=new File_Utility();
		WebDriver_Utility wlib=new WebDriver_Utility();
		

		
		
		int RanNum=jlib.getRandomNum();
		String data=elib.getDataFromExcelSheet("Campaign",0,0)+RanNum;
		//System.out.println(data);
		
		HomePage hp=new HomePage(driver);
		CampaignCreatePage campcp=new CampaignCreatePage(driver);
	
		hp.clickCampaign();
		campcp.clickOnCreateCampaign();
		campcp.createCampaign(data);
		campcp.saveCampaign();
		String actual_msg=campcp.getFetchText().getText();

		
		ValidationAndVerificationPage vvorg=new ValidationAndVerificationPage(driver);
		vvorg.verifyValidation(actual_msg, data);

   // hp.clicklogOut();

	}


}