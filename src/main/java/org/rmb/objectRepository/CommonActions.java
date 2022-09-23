package org.rmb.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonActions 
{
	//Declaration

	@FindBy(xpath="//a[text()='Home']")
	private WebElement homeLink;

	@FindBy(xpath="//a[text()='About Us']")
	private WebElement aboutUsLink;

	@FindBy(xpath="//a[text()='Contact Us']")
	private WebElement contactUsLink;

	@FindBy(xpath = "//a[text()='Staff Login']")
	private WebElement staffLoginLink;

	//Initialization 

	public CommonActions(WebDriver driver)
	{
		PageFactory.initElements(driver, this); 
	}

	//Business library 
	public void homeLink()
	{
		homeLink.click(); 
	}

	public void aboutUsLink()
	{
		aboutUsLink.click(); 
	}

	public void contactUsLink()
	{
		contactUsLink.click(); 
	}

	public void staffLoginLink()
	{
		staffLoginLink.click();
	}
}