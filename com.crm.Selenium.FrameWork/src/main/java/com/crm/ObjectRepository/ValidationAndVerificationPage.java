package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ValidationAndVerificationPage {
    
	public ValidationAndVerificationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
public void verifyValidation(String actual_msg,String data) {
	if(actual_msg.contains(data)) {
		System.out.println("pass");
	}
	else {
		System.out.println("not pass");
	}

}
}