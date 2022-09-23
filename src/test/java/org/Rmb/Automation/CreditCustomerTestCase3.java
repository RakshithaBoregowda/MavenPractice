
package org.Rmb.Automation;

import java.io.IOException;
import java.text.ParseException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.tyss.rmb.genericUtility.FetchDataFromExcelUtility;
import org.tyss.rmb.genericUtility.IConstExternalPath;
import org.tyss.rmb.genericUtility.JavaUtility;
import org.tyss.rmb.genericUtility.WebDriverUtilityClass;


public class CreditCustomerTestCase3
{
	public static void main(String[] args) throws ParseException, InterruptedException, EncryptedDocumentException, IOException 
{
		WebDriver driver=null;

		WebDriverUtilityClass webDriverUtility = new WebDriverUtilityClass();
		driver = webDriverUtility.BrowserLaunchingMethod("chrome");
		JavaUtility javaUtility =new JavaUtility();
		webDriverUtility.MaximizeTheBrowserWindow(driver);
		webDriverUtility.waitTillPageGetLoaded(driver, 10);



		//Excel file
		FetchDataFromExcelUtility excelUtility = new FetchDataFromExcelUtility();
		String url=excelUtility.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "CommonData", 1, 1);
		String Staffid=excelUtility.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "CommonData", 2, 1);
		String password=excelUtility.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "CommonData", 3, 1);

		String name=excelUtility.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "OpenAccount", 1, 0);
		String mobile=excelUtility.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "OpenAccount", 1, 1);
		String email=excelUtility.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "OpenAccount", 1, 2);
		String landline=excelUtility.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "OpenAccount", 1, 3);
		String pan=excelUtility.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "OpenAccount", 1, 4);
		String citizenship=excelUtility.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "OpenAccount", 1, 5);
		String homeadd=excelUtility.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "OpenAccount", 1, 6);
		String officeadd=excelUtility.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "OpenAccount", 1, 7);
		String pin=excelUtility.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "OpenAccount", 1, 8);
		String area=excelUtility.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "OpenAccount", 1, 9);
		String nominee=excelUtility.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "OpenAccount", 1, 10);
		String nomacc=excelUtility.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "OpenAccount", 1, 11);
		String amount=excelUtility.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "OpenAccount", 1, 13);



		driver.get(url);
		driver.findElement(By.xpath("//li[text()='Open Account']")).click();
		driver.findElement(By.cssSelector("[placeholder='Name']")).sendKeys(name);
		driver.findElement(By.cssSelector("[placeholder='Mobile no']")).sendKeys(mobile);
		driver.findElement(By.cssSelector("[placeholder='Email id']")).sendKeys(email);
		driver.findElement(By.cssSelector("[placeholder='Landline no']")).sendKeys(landline);
		driver.findElement(By.cssSelector("[placeholder='PAN Number']")).sendKeys(pan);
		driver.findElement(By.cssSelector("[placeholder='Citizenship Number']")).sendKeys(citizenship);
		driver.findElement(By.cssSelector("[placeholder='Home Address']")).sendKeys(homeadd);
		driver.findElement(By.cssSelector("[placeholder='Office Address']")).sendKeys(officeadd);
		//driver.findElement(By.name("country")).sendKeys("US");
		driver.findElement(By.cssSelector("[placeholder='Pin Code']")).sendKeys(pin);
		driver.findElement(By.cssSelector("[placeholder='Area/Locality']")).sendKeys(area);
		driver.findElement(By.name("nominee_name")).sendKeys(nominee);
		driver.findElement(By.name("nominee_ac_no")).sendKeys(nomacc);

		//fetch Gender from the drop down

		WebElement gender=driver.findElement(By.name("gender"));
		webDriverUtility.selectByIndex(gender, 2);


		WebElement state=driver.findElement(By.name("state"));
		webDriverUtility.selectByIndex(state, 2);


		WebElement city=driver.findElement(By.name("city"));
		webDriverUtility.selectByIndex(city, 2);

		WebElement acctype=driver.findElement(By.name("acctype"));
		webDriverUtility.selectByIndex(acctype, 2);

		WebElement dob=driver.findElement(By.name("dob"));
		dob.click();
		dob.sendKeys("18-07-1997");


		WebElement submit=driver.findElement(By.name("submit"));
		submit.click();
		WebElement cf=driver.findElement(By.name("cnfrm-submit"));
		cf.click();
	
	//Alert pop-up
		String alertmsg = webDriverUtility.alertPopUpGetTextAndAccept(driver);
		String appno = javaUtility.FetchNumFromAlert(alertmsg);
	
	driver.findElement(By.xpath("//a[.='Staff Login']")).click();
	driver.findElement(By.name("staff_id")).sendKeys(Staffid);
	driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.name("staff_login-btn")).click();
	driver.findElement(By.name("apprvac")).click();
	driver.findElement(By.name("application_no")).sendKeys(appno);
	driver.findElement(By.name("search_application")).click();
    driver.findElement(By.name("approve_cust")).click();
	
	
	//Account number alert pop-up
	String altmsg = webDriverUtility.alertPopUpGetTextAndAccept(driver);
	System.out.println(altmsg);
	String account = javaUtility.FetchNumFromAlert(altmsg);
	System.out.println(account);
	
	driver.findElement(By.xpath("//input[@name='home']")).click();
	driver.findElement(By.xpath("//input[@name='credit_cust_ac']")).click();
	driver.findElement(By.xpath("//input[@name='customer_account_no']")).sendKeys(account);
	driver.findElement(By.xpath("//input[@name='credit_amount']")).sendKeys(amount);
	driver.findElement(By.xpath("//input[@name='credit_btn']")).click();
	
	String credit = webDriverUtility.alertPopUpGetTextAndAccept(driver);
	System.out.println(credit);
	
	if(credit.equalsIgnoreCase("Amount credited Successfully to customer account"))
	{
		System.out.println("Test case passed");
	}
	else
	{
		System.out.println("Test case failed");
	}
	
    //driver.findElement(By.xpath("//input[@name='home']")).click();
   // driver.findElement(By.xpath("//input[@name='viewdet']")).click();
    
    //driver.findElement(By.xpath("//input[@name='logout_btn']")).click();
    
    webDriverUtility.closeBrowser(driver);
    

	}
}
