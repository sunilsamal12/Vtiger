package com.crm.Product;

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
import org.openqa.selenium.Alert;
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
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ProductCreatePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteProductTest extends BaseClass{
    @Test(groups={"smokeTest"})
	public void deleteProductTest() throws Throwable {
	
		Java_Utility jlib= new Java_Utility();
		Excel_Utility elib=new Excel_Utility();
		File_Utility flib=new File_Utility();
		WebDriver_Utility wlib=new WebDriver_Utility();

	wlib.waitForPageToLoad(driver);
	
		int RanNum=jlib.getRandomNum();
		String data=elib.getDataFromExcelSheet("Product",0,0)+RanNum;
		System.out.println(data);
		
		//LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		ProductCreatePage prodcp=new ProductCreatePage(driver);
		
		//login page
		//lp.login(user, password);
		
		//click product on home page
		hp.clickProduction();
		
		//create product
		prodcp.clickOncreateProduct();
		
		//pass the data in product textbox and save it
		prodcp.createProduct(data);
		
		//delete product
		prodcp.deleteProduct();
		
		//handle alert pop up
		wlib.alertAcept(driver);
		
      //  hp.clicklogOut();


}
}
