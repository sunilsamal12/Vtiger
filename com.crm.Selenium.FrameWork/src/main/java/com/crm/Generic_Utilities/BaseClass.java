package com.crm.Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void BS() { 
		System.out.println(" database connection");
	}
	
	@BeforeTest(groups= {"smokeTest","regressionTest"})
  public void BT() {
	  System.out.println("execute parallel mode");
  }
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
 // public void BC(String BROWSER) throws Throwable {
	 public void BC() throws Throwable {
		File_Utility flib=new File_Utility();
		String BROWSER=flib.getPropertyKeyValue1("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
        else if(BROWSER.equalsIgnoreCase("firefox")) {
        	WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
        else
        {
         sdriver=driver;
        	//driver=new ChromeDriver();
        }

		
	  System.out.println("launching browser");
  }
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void BM() throws Throwable {
		File_Utility flib=new File_Utility();
		String URL=flib.getPropertyKeyValue1("url");
		String user=flib.getPropertyKeyValue1("un");
		String password=flib.getPropertyKeyValue1("pw");
		WebDriver_Utility wlib=new WebDriver_Utility();
		
		wlib.maximizeScreen(driver);
		driver.get(URL);
		wlib.waitForPageToLoad(driver);
		LoginPage lp=new LoginPage(driver);
		lp.login(user, password);
		System.out.println("login to the application");
	}
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void AM() {
		HomePage hp=new HomePage(driver);
		//hp.clicklogOut();
		System.out.println("logout to the application");
	}
	@AfterClass(groups= {"smokeTest","regressionTest"})
	  public void AC() {
		 // driver.close();
		  System.out.println("close the browser");
	  }
	@AfterTest(groups= {"smokeTest","regressionTest"})
	  public void AT() {
		  System.out.println(" execute sucessfully");
	  }
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void AS() {
		System.out.println("close database connection");
	}
	
	
}
