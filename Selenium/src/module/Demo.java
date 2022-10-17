package module;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Demo {
	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver","C:\\Selenium app\\chromedriver_win32\\chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
		System.setProperty("webdriver.edge.driver","C:\\Selenium app\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.flipkart.com/");
	}

}
