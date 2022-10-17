package com.crm.Generic_Utilities;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Utility {
	/**
	 * wait for page to load identifying any synchronized in DOM
	 * @param driver
	 * Sunil
	 */
	public void waitForPageToLoad(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	public void waitForElementToClick(WebDriver driver,WebElement Element) {
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}
	
	/**
	 * used to Switch to Any Window based on Window
	 * @param driver
	 * @param patialWindowTitle
	 * Sunil
	 */
	public void switchToWindow(WebDriver driver,String patialWindowTitle) {
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		while(it.hasNext()) {
			String wid=it.next();
			driver.switchTo().window(wid);
			String currentWindowTitle=driver.getTitle();
			if(currentWindowTitle.contains(patialWindowTitle)) {
				break;
			}
		}
	}
	/**
	 * used to place mouse cursor on specified element

	 * @param driver
	 * @param Element
	 * Sunil
	 */
	public void mouseOverAction(WebDriver driver,WebElement Element) {
		Actions act=new Actions(driver);
		act.moveToElement(Element).perform();
		
	}
	/**
	 * used to right click  on specified element
	 * @param driver
	 * @param elemnet
	 */
	public void rightClickOnElement(WebDriver driver , WebElement elemnet)
	{
		Actions act = new Actions(driver);
		act.contextClick(elemnet).perform();
	}
	
	  /**
     * pass enter Key appertain in to Browser
     * @param driver
     */
	
   public void passEnterKey(WebDriver driver) {
	   Actions act = new Actions(driver);
	   act.sendKeys(Keys.ENTER).perform();
   } 

/**
 * used to select the value from the dropDwon  based on index
 * @param element
 * @param index
 */
	public void selectbyIndex(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * used to select the value from the dropDwon  based on index
	 * @param element
	 * @param text
	 */
	public void selectbyText(WebElement element,String text) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
  
}
	
	/**
	 * used to select the value from the dropDwon  based on index
	 * @param element
	 * @param value
	 */
	public void selectbyValue(WebElement element,String value) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * used to Switch to Frame Window based on index
	 * @param driver
	 * @param index
	 */
  public void switchToFrameIndex(WebDriver driver,int index) {
	  driver.switchTo().frame(index);
  }
  /**
   * used to Switch to Frame Window based on id or name attribute
   * @param driver
   * @param id_name
   */
  public void switchToFrameName(WebDriver driver,int id_name) {
	  driver.switchTo().frame(id_name);
  }
  /**
   * used to Switch to Frame Window based on webElement
   * @param driver
   * @param element
   */
  public void switchToFrameWeb(WebDriver driver,WebElement element) {
	  driver.switchTo().frame(element);
}
  /**
   * used to Switch to Alert Window & click on OK button
   * @param driver
   */
  public void alertAcept(WebDriver driver) {
	  Alert alt=driver.switchTo().alert();
	  alt.accept();
  }
  /**
   * used to Switch to Alert Window & click on cancel button
   * @param driver
   */
  public void alertDismiss(WebDriver driver) {
	  Alert alt=driver.switchTo().alert();
	  alt.dismiss();
 
  }
  public void maximizeScreen(WebDriver driver) {
	  driver.manage().window().maximize();
  }
  
}



















