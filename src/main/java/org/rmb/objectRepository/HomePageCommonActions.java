package org.rmb.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageCommonActions 
{
	
//Declaration
@FindBy(xpath="//li[text()='Open Account']")
private WebElement openAccountButton;

@FindBy(xpath="//li[text()='Apply Debit Card']")
private WebElement applyDebitCardButton;

//@FindBy(xpath="//div[@class='ebanking']")      
//private WebElement internetBankingButton;


//initialization
public HomePageCommonActions(WebDriver driver)
{
PageFactory.initElements(driver, this);	
}
//Business Library 

public void openAccButton()
{
openAccountButton.click();
}

public void applyDebitCard()
{
applyDebitCardButton.click();
}

//public void internetBanking(WebElement element, WebDriverUtilityClass WebdriverUtility)
//{
//	new WebDriverUtilityClass();
//	WebdriverUtility.moveToElement(element);

//}


}