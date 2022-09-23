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


public class ApplyDebitCardTestcase2 
{
	public static void main(String[] args) throws ParseException, InterruptedException, EncryptedDocumentException, IOException 
	{
		{

			WebDriver driver=null;

			WebDriverUtilityClass webDriverUtility = new WebDriverUtilityClass();
			JavaUtility javaUtility=new JavaUtility();
			driver = webDriverUtility.BrowserLaunchingMethod("chrome");
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


			//Alert pop-up application numbers
			String msg = webDriverUtility.alertPopUpGetTextAndAccept(driver);
			String applicationno = javaUtility.FetchNumFromAlert(msg);

			driver.findElement(By.xpath("//a[.='Staff Login']")).click();
			driver.findElement(By.name("staff_id")).sendKeys(Staffid);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.name("staff_login-btn")).click();
			driver.findElement(By.name("apprvac")).click();
			driver.findElement(By.name("application_no")).sendKeys(applicationno);
			driver.findElement(By.name("search_application")).click();
			driver.findElement(By.name("approve_cust")).click();


			//Account number
			String alertmsg1 = webDriverUtility.alertPopUpGetTextAndAccept(driver);
			String accno = javaUtility.FetchNumFromAlert(alertmsg1);



			driver.findElement(By.xpath("//input[@name='logout_btn']")).click();
			driver.findElement(By.xpath("//img[@class='logo_img']")).click();
			driver.findElement(By.xpath("//li[text()='Apply Debit Card']")).click();


			driver.findElement(By.xpath("//input[@name='holder_name']")).sendKeys(name);
			WebElement dob1=driver.findElement(By.xpath("//input[@name='dob']"));
			dob1.click();
			dob1.sendKeys("18-07-1997");

			driver.findElement(By.xpath("//input[@name='pan']")).sendKeys(pan);
			driver.findElement(By.xpath("//input[@name='mob']")).sendKeys(mobile);
			driver.findElement(By.xpath("//input[@name='acc_no']")).sendKeys(accno);
			driver.findElement(By.xpath("//input[@name='dbt_crd_submit']")).click();

			//Debt card pop-up
			String debit = webDriverUtility.alertPopUpGetTextAndAccept(driver);
			System.out.println(debit);

			if(debit.contains("Debit Card issued successfully"))
			{
				System.out.println("Test case passed");	
			}
			else
			{
				System.out.println("Test case failed");
			}
			webDriverUtility.closeBrowser(driver);
		}
	}
}


