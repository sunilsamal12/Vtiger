package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTrip {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Selenium app\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://www.makemytrip.com/");
        FileInputStream fis1=new FileInputStream("Book2.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh=wb.getSheet("Sheet1");
		Row row=sh.getRow(0);
		Cell cel1=row.getCell(0);
		Cell cel2=row.getCell(1);
		String Fdata=cel1.getStringCellValue();
		String Tdata=cel2.getStringCellValue();
		System.out.println(Fdata);
		System.out.println(Tdata);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='fromCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(Fdata);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul/li[@id='react-autowhatever-1-section-0-item-0']")).click();
		driver.findElement(By.xpath("//input[@id='toCity']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(Tdata);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul/li[@id='react-autowhatever-1-section-0-item-0']")).click();
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		Thread.sleep(2000);
		String month="September 2022";
		String date="30";
		
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();  //close adds
		
		driver.findElement(By.xpath("//div[text()='"+month+"']/ancestor::div[@class='DayPicker-Months']/descendant::p[text()='"+date+"']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='RETURN']")).click();
		
		String year="2022";
		String monthR="October";
		String dateR="3";
	
		driver.findElement(By.xpath("//div[text()='"+monthR+"']/span[text()='"+year+"']/ancestor::div[@class='DayPicker-Month']//p[text()='"+dateR+"']")).click();
		
		driver.findElement(By.xpath("//span[text()='Travellers & CLASS']")).click();
		
		int adultNo=2;
		int child=1;
		int infant=1;
		
		
		  ++child;
		  ++infant;
		
		driver.findElement(By.xpath("//div[@class='appendBottom20']/ul/li["+adultNo+"]")).click();
		driver.findElement(By.xpath("//div[@class='makeFlex column childCounter']/ul/li["+child+"]")).click();
		driver.findElement(By.xpath("//div[@class='makeFlex column pushRight infantCounter']/ul/li["+infant+"]")).click();
		//driver.findElement(By.xpath("//ul[@class='guestCounter classSelect font12 darkText']/li[1]")).click();
		driver.findElement(By.xpath("//button[@class='primaryBtn btnApply pushRight']")).click();
	}

}
