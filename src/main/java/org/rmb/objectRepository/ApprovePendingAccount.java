package org.rmb.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.rmb.genericUtility.JavaUtility;
import org.tyss.rmb.genericUtility.WebDriverUtilityClass;

public class ApprovePendingAccount 
{
	//Declaration 
	@FindBy(name="application_no")
	private WebElement applicationNumberTextField;

	@FindBy(name="search_application")
	private WebElement searchButton;

	@FindBy(name="approve_cust")
	private WebElement approveButton;

	//Initialization
	public ApprovePendingAccount(WebDriver driver)

	{
		PageFactory.initElements(driver, this);
	}


	WebDriverUtilityClass webDriverUtility=new WebDriverUtilityClass();
	JavaUtility javaUtility=new JavaUtility();

	public void applicatioNumTextField(String appNo) 
	{

		applicationNumberTextField.sendKeys(appNo);
		searchButton.click();
		approveButton.click();
		
	
        
	}
}




