package org.rmb.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffLoginPage 
{
//Declaration

	
	@FindBy(name ="staff_id")
	private WebElement staffIdTextField;
	
	@FindBy(name="password")
	private WebElement passwordTextFiled;
	
	@FindBy(name="staff_login-btn")
	private WebElement staffLoginButton;

//initialization

public StaffLoginPage(WebDriver driver)
{
PageFactory.initElements(driver, this);
}

//Business Library

public void staffLogin(String staffId, String password)
{
staffIdTextField.sendKeys(staffId);
passwordTextFiled.sendKeys(password);
staffLoginButton.click();
}
}
