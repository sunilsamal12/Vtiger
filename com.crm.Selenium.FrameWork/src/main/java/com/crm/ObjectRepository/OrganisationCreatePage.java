package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationCreatePage {
        
	public OrganisationCreatePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement clickCreatePage;
	@FindBy(name="accountname")
	private WebElement sendTextOrgName;
	@FindBy(name="button")
	private WebElement clickOnSave;
	
	public WebElement getClickCreatePage() {
		return clickCreatePage;
	}
	public WebElement getSendTextOrgName() {
		return sendTextOrgName;
	}
	public WebElement getClickOnSave() {
		return clickOnSave;
	}
	public void clickOnCreateOrganisation() {
		clickCreatePage.click();
	}
	public void createOrganisation(String org) {
		
		sendTextOrgName.sendKeys(org);
		clickOnSave.click();
	}
	@FindBy(className="dvHeaderText")
	private WebElement fetchText;

	public WebElement getFetchText() {
		return fetchText;
	}
	
}
