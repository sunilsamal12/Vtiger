package com.crm.Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.Excel_Utility;
import com.crm.Generic_Utilities.File_Utility;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.WebDriver_Utility;
import com.crm.ObjectRepository.CampaignCreatePage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ProductCreatePage;
import com.crm.ObjectRepository.ProductNewWindowPage;
import com.crm.ObjectRepository.ValidationAndVerificationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWithProductTest extends BaseClass{
	@Test(groups={"smokeTest"})
     public void createCampaignWithProductTest() throws Throwable {
	
		Java_Utility jlib= new Java_Utility();
		Excel_Utility elib=new Excel_Utility();
		File_Utility flib=new File_Utility();
		WebDriver_Utility wlib=new WebDriver_Utility();
				
		

//		wlib.waitForPageToLoad(driver);
		
		int RanNum=jlib.getRandomNum();
		String productdata=elib.getDataFromExcelSheet("Product",0,0)+RanNum;
		System.out.println(productdata);
		
		
		HomePage hp=new HomePage(driver);
		ProductCreatePage prodcp=new ProductCreatePage(driver);
		
		
		//click on production on homepage
		hp.clickProduction();
		//click on new product page
		prodcp.clickOncreateProduct();
		//create product page
		prodcp.createProduct(productdata);
		String actual_msg=prodcp.getFetchText().getText();


	 
	// WebElement element=driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
	//  wlib.waitForElementToClick(driver,element);
//	 WebDriverWait wait=new WebDriverWait(driver,20);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")));
       
		//click on campaign
		hp.clickCampaign();
	
	    
	    //campaign name input

		Excel_Utility elib1=new Excel_Utility();
		String data=elib1.getDataFromExcelSheet("Campaign",0,0)+RanNum;
		System.out.println(data);
		
		CampaignCreatePage campcp=new CampaignCreatePage(driver);
		campcp.clickOnCreateCampaign();
		
		//send data in campaign textbox
		
		campcp.createCampaign(data);
		
		//click on new product in campaign page
		 campcp.clickOnProductInCamp();
		
         //driver focus to new window
     wlib.switchToWindow(driver,"Products&action");
   
     //search product name in new window
     ProductNewWindowPage newpPage=new ProductNewWindowPage(driver);
     newpPage.newWindowPageAction(productdata);
     
     
    // select product using dynamic xpath
     driver.findElement(By.xpath("//a[text()='"+productdata+"']")).click();
   
   //window switching and focus to mainpage
        wlib.switchToWindow(driver,"Campaigns&action");
        
       campcp.saveCampaign();
      String camp_msg=campcp.getFetchText().getText();
   // System.out.println(camp_msg);

      //validation
      
	ValidationAndVerificationPage vvorg=new ValidationAndVerificationPage(driver);
	vvorg.verifyValidation(camp_msg, data);
    

    
     //  hp.clicklogOut();
 
	
	}

}
