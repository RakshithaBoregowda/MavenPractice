package org.rmb.objectRepository;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.rmb.genericUtility.JavaUtility;
import org.tyss.rmb.genericUtility.WebDriverUtilityClass;

public class OpenAccountPage 
{
//Declaration 
	@FindBy(css ="[placeholder='Name']")
	private WebElement nameTextFiled;
	
	@FindBy(css ="[placeholder='Mobile no']")
	private WebElement mobileNumberTextField;
	
	@FindBy(css ="[placeholder='Email id']")
	private WebElement emailIdTextField;
	
	@FindBy(css ="[placeholder='Landline no']")
	private WebElement landLineTextField;
	
	@FindBy(css ="[placeholder='PAN Number']")
	private WebElement panNumberTextField;
	
	@FindBy(css ="[placeholder='Citizenship Number']")
	private WebElement citizenshipTextField;
	
	@FindBy(css ="[placeholder='Home Address']")
	private WebElement homeAddressTextFiled;
	
	@FindBy(css ="[placeholder='Office Address']")
	private WebElement officeAddressTextField;
	
	@FindBy(css ="[placeholder='Pin Code']")
	private WebElement pinCodeTextField;
	
	@FindBy(css ="[placeholder='Area/Locality']")
	private WebElement areaLocalityTextField;
	
	@FindBy(name= "nominee_name")
	private WebElement nomineeNameTextField;
	
	@FindBy(name ="nominee_ac_no")
	private WebElement nomineeAccNoTextField;
	
	@FindBy(name ="dob")
	private WebElement dateOfBirthTextField;
	
	@FindBy(name="gender")
	private WebElement genderDropdown;
	
	@FindBy(name="state")
	private WebElement stateDropdown;
	
	@FindBy(name="acctype")
	private WebElement accountTypeDropdown;
	
	@FindBy(name="city")
	private WebElement cityDropdown;
	
	@FindBy(name="submit")
	private WebElement submitButton;
	
	@FindBy(name="cnfrm-submit")
	private WebElement confirmSubmitButtom;
	
	
	
	//Initialization of all the element variables
	
	public OpenAccountPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	
	//Business Library 

	public void createAccount(Map<String, String> map, WebDriver driver) 
	{
		JavaUtility javaUtility=new JavaUtility();
		
		
		nameTextFiled.sendKeys(map.get("Name")+javaUtility.getRandomNumber(1000));
		
		mobileNumberTextField.sendKeys(map.get("Mobilenum"));
		emailIdTextField.sendKeys(map.get("Emailid"));
		landLineTextField.sendKeys(map.get("Landline"));
		panNumberTextField.sendKeys(map.get("PAN"));
		citizenshipTextField.sendKeys(map.get("Citizenshipno"));
		homeAddressTextFiled.sendKeys(map.get("Home address"));
		
		officeAddressTextField.sendKeys(map.get("Office address"));
		pinCodeTextField.sendKeys(map.get("Pincode"));
		areaLocalityTextField.sendKeys(map.get("Area"));
		nomineeNameTextField.sendKeys(map.get("NomineeName"));
		nomineeAccNoTextField.sendKeys(map.get("NomineeAcc"));
		dateOfBirthTextField.click();
		dateOfBirthTextField.sendKeys(map.get("Dob"));
		
		
		WebDriverUtilityClass webDriverUtility=new WebDriverUtilityClass();
		
		
		webDriverUtility.selectByVisibletext(genderDropdown, "Male");
		webDriverUtility.selectByVisibletext(stateDropdown, "Texas");
		webDriverUtility.selectByVisibletext(cityDropdown, "Fresno");
		webDriverUtility.selectByVisibletext(accountTypeDropdown, "Saving");
		
		submitButton.click();
		confirmSubmitButtom.click();
		
		
	
		
		
		
	}


}
	
	

