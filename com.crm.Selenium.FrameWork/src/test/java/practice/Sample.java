package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium app\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		FileInputStream fis=new FileInputStream("Common_data_properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String URL=pro.getProperty("url");
		String user=pro.getProperty("un");
		String password=pro.getProperty("pw");
		
		FileInputStream fis1=new FileInputStream("Book1.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh=wb.getSheet("Sheet1");
		Row row=sh.getRow(0);
		Cell cel=row.getCell(0);
		String data=cel.getStringCellValue();
		System.out.println(data);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(user);
	 driver.findElement(By.name("user_password")).sendKeys(password);
	 driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
	driver.findElement(By.name("accountname")).sendKeys(data);
	driver.findElement(By.name("button")).click();
	
	String actual_msg=driver.findElement(By.className("dvHeaderText")).getText();
		if(actual_msg.contains(data)) {
			System.out.println("pass");
		}
		else {
			System.out.println("not pass");
		}

	}

}
