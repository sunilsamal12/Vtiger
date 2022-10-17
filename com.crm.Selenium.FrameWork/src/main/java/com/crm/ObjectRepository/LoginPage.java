package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
   //declaration
	@FindBy(name="user_name")
	private WebElement userNameTextField;
	@FindBy(name="user_password")
	private WebElement passwordNameTextField;
	@FindBy(id="submitButton")
	private WebElement submitButton;
	//getter methods
	public WebElement getUserNameTextField() {
		return userNameTextField;
	}
	public WebElement getPasswordNameTextField() {
		return passwordNameTextField;
	}
	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	public void login(String userName,String passWord) {
		
		userNameTextField.sendKeys(userName);
		passwordNameTextField.sendKeys(passWord);
		submitButton.click();
		
	}
	
	
}
