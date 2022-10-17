package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCreatePage {
   
    
	public ProductCreatePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement clickCreatePageP;
	@FindBy(xpath="//input[@name='productname']")
	private WebElement sendTextOrgName;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement clickOnSave;
	public WebElement getClickCreatePageP() {
		return clickCreatePageP;
	}
	public WebElement getSendTextOrgName() {
		return sendTextOrgName;
	}
	public WebElement getClickOnSave() {
		return clickOnSave;
	}
	public void clickOncreateProduct() {
		clickCreatePageP.click();
	}
	public void createProduct(String prod) {
		
		sendTextOrgName.sendKeys(prod);
		clickOnSave.click();
		}
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement fetchText;

	public WebElement getFetchText() {
		return fetchText;
	}
	
	@FindBy(xpath="//input[@title='Delete [Alt+D]']")
	private WebElement proddelete;
	
	public WebElement getProddelete() {
		return proddelete;
}
	public void deleteProduct() {
		proddelete.click();
	}
	
}	
	
	
	
	
	
	
	
	
