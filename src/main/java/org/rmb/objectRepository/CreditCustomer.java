package org.rmb.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCustomer 
{
//
	@FindBy(xpath="//input[@name='credit_cust_ac']")
	private WebElement creditCustomerButton;
	
	@FindBy(xpath="//input[@name='customer_account_no']")
	private WebElement customerAccNoTextField;
	
	@FindBy(xpath="//input[@name='credit_amount']")
	private WebElement amountTextField;
	
	@FindBy(xpath="//input[@name='credit_btn']")
	private WebElement creditButton;
	
	public CreditCustomer(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void issueCredit(String accno, String amount)
	{
		creditCustomerButton.click();
		customerAccNoTextField.sendKeys(accno);
		amountTextField.sendKeys(amount);
		creditButton.click();
	}
	
	
}
