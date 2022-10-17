package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.Generic_Utilities.File_Utility;
import com.crm.Generic_Utilities.WebDriver_Utility;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class ParametersTest {
	public void paramethod() throws Throwable {
String BROWSER=System.getProperty("browser");
WebDriver driver;
System.out.println(BROWSER);
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
 driver=new ChromeDriver();

}

String URL=System.getProperty("url");
String user=System.getProperty("un");
String password=System.getProperty("pw");
WebDriver_Utility wlib=new WebDriver_Utility();

wlib.maximizeScreen(driver);
driver.get(URL);
wlib.waitForPageToLoad(driver);
LoginPage lp=new LoginPage(driver);
lp.login(user, password);
System.out.println("login to the application");

}
}