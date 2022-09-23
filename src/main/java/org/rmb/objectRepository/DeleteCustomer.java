package org.rmb.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomer 
{
	@FindBy(xpath="//input[@name='del_cust']")
	private WebElement deleteCustomerButton;
	
	@FindBy(xpath="//input[@name='Cust_ac_no']")
	private WebElement customerAccnoTextField;
	
	@FindBy(xpath="//input[@name='Cust_ac_Id']")
	private WebElement customerIdTextField;
	
	@FindBy(css="[placeholder='Reason']")
	private WebElement reasonTextField;
	
	@FindBy(xpath="//input[@name='delete']")
	private WebElement deleteButton;
	
	public DeleteCustomer(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void deleteCustomerAccount(String accno, String custid, String reason)
	{
		deleteCustomerButton.click();
		customerAccnoTextField.sendKeys(accno);
		customerIdTextField.sendKeys(custid);
		reasonTextField.sendKeys(reason);
		deleteButton.click();
	}
	
}
