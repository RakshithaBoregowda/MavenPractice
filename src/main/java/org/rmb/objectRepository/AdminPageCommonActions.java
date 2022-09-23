package org.rmb.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPageCommonActions 

{
//Declaration
	
@FindBy(name="home")
private WebElement homeButton;

@FindBy(xpath="//input[@name='logout_btn']")
private WebElement logoutBotton;
	
@FindBy(name="viewdet")
private WebElement viewCustomerButton;

@FindBy(name="apprvac")
private WebElement approvePendingAcc ;



//Initialization
public AdminPageCommonActions(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

//Business Library 


public void homeButton()

{
	homeButton.click();
}

public void logOut()
{
	logoutBotton.click();
}


public void viewActiveCustomerButton()
{
	viewCustomerButton.click();
}

public void approveCustomerButton()
{
approvePendingAcc.click();
}


}