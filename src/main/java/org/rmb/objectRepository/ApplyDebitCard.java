package org.rmb.objectRepository;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplyDebitCard 
{
	//Declaration 
@FindBy(xpath="//input[@name='holder_name']")
private WebElement accountHolderNameTextField;

@FindBy(xpath="//input[@name='dob']")
private WebElement dateOfBirthTextField;

@FindBy(xpath="//input[@name='pan']")
private WebElement panNumTextField;

@FindBy(xpath ="//input[@name='mob']")
private WebElement mobileNumberTextField;

@FindBy(xpath="//input[@name='acc_no']")
private WebElement AccountNumberTextFiled;

@FindBy(xpath="//input[@name='dbt_crd_submit']")
private WebElement submitButton;

//Initialization
public ApplyDebitCard(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}

public void applyDebitCard(Map<String, String> map,String accno)
{
	accountHolderNameTextField.sendKeys(map.get("Name"));
	dateOfBirthTextField.click();
	dateOfBirthTextField.sendKeys(map.get("Dob"));
	panNumTextField.sendKeys(map.get("PAN"));
	mobileNumberTextField.sendKeys(map.get("Mobilenum"));
    AccountNumberTextFiled.sendKeys(accno);
	submitButton.click();
	
	
	
}

}
