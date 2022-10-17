package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//for organisation
	
	@FindBy(linkText="Organizations")
	private WebElement moduleNameOrg;
	
	public WebElement getModuleName() {
		return moduleNameOrg;
	}

	public void clickOrganisation() {
		moduleNameOrg.click();
		
	}
	//for production
	
	@FindBy(xpath="//a[text()='Products']")
	private WebElement moduleNameProd;
	
	
	public WebElement getModuleNameProd() {
		return moduleNameProd;
	}
	
	

	public void clickProduction() {
		moduleNameProd.click();
	}
	
	//for campaign
	
	@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement clickOnmore;
	@FindBy(xpath="//a[@name='Campaigns']")
	private WebElement moduleNameCamp;
	
	
	public WebElement getClickOnmore() {
		return clickOnmore;
	}
	public WebElement getModuleNameCamp() {
		return moduleNameCamp;
	}
	public void clickCampaign() {
		clickOnmore.click();
		moduleNameCamp.click();
	}
	//for logout
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement clickOnIcon;
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement clickOnLogout;

	public WebElement getClickOnIcon() {
		return clickOnIcon;
	}
	public WebElement getClickOnLogout() {
		return clickOnLogout;
	}
	public void clicklogOut() {
		clickOnIcon.click();
		clickOnLogout.click();
	}
}










