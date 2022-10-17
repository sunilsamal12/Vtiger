package com.crm.Organisation;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.Excel_Utility;
import com.crm.Generic_Utilities.File_Utility;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.WebDriver_Utility;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganisationCreatePage;
import com.crm.ObjectRepository.ValidationAndVerificationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Test(retryAnalyzer=com.crm.Generic_Utilities.RetryAnalyser.class)
public class CreateOrganisationTest extends BaseClass{
	@Test(groups={"regressionTest"})
  public void createOrganisationTest() throws Throwable {
	

		Java_Utility jlib= new Java_Utility();
		Excel_Utility elib=new Excel_Utility();
		File_Utility flib=new File_Utility();
		WebDriver_Utility wlib=new WebDriver_Utility();
		
		

		wlib.waitForPageToLoad(driver);
		
		int RanNum=jlib.getRandomNum();
		String data=elib.getDataFromExcelSheet("Organisation",0,0)+RanNum;
		System.out.println(data);
		
		//LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		OrganisationCreatePage orgcp=new OrganisationCreatePage(driver);
		
		
		//lp.login(user, password);
		hp.clickOrganisation();
        orgcp.clickOnCreateOrganisation();
        
       // Assert.assertEquals(true, false);
        
		orgcp.createOrganisation(data);
		
		//SoftAssert soft=new SoftAssert();
		//soft.assertEquals("A","B");
		
		String actual_msg=orgcp.getFetchText().getText();
		
		ValidationAndVerificationPage vvorg=new ValidationAndVerificationPage(driver);
		vvorg.verifyValidation(actual_msg, data);
   
		
		//soft.assertAll();

	}
//	@Test
//	public void modifyMethod() {
//		System.out.println("Modified");
//	}


}
