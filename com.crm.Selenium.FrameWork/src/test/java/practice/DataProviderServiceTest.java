package practice;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.Generic_Utilities.BaseClass;

public class DataProviderServiceTest extends BaseClass {
	@Test(dataProvider="dataProvider_test")
	public void serviceDetail(String name,String unit,String website) {
		driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();
		driver.findElement(By.xpath("//a[@name='Services']")).click();
		driver.findElement(By.xpath("//img[@title='Create Service...']")).click();
		driver.findElement(By.name("servicename")).sendKeys(name);
		driver.findElement(By.name("qty_per_unit")).sendKeys(unit);
		driver.findElement(By.name("website")).sendKeys(website+".com");
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		//driver.quit();
	}
	@DataProvider
	public Object[][] dataProvider_test(){
		Object[][] objarr=new Object[1][3];
		objarr[0][0]="Service1";
		objarr[0][1]="1";
		objarr[0][2]="web1";
		
//		objarr[1][0]="Service2";
//		objarr[1][1]="2";
//		objarr[1][2]="web2";
//		
//		objarr[2][0]="Service";
//		objarr[2][1]="3";
//		objarr[2][2]="web3";
//		
		return objarr;
		
	}

}
