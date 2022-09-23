package org.Rmb.Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.tyss.rmb.genericUtility.FetchDataFromExcelUtility;
import org.tyss.rmb.genericUtility.IConstExternalPath;
import org.tyss.rmb.genericUtility.WebDriverUtilityClass;

public class HandlingDynamicTable 
{
	public static void main(String[] args) 
	{
		WebDriverUtilityClass webDriverUtility =new WebDriverUtilityClass();


		FetchDataFromExcelUtility excelUtility=new FetchDataFromExcelUtility();
		String url=excelUtility.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "CommonData", 0, 1);
		String staffid=excelUtility.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "CommonData", 1, 1);
		String password=excelUtility.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "CommonData", 2, 1);
		
		
		WebDriver driver=webDriverUtility.openBrowserWithApplication("chrome", 10, url);
		

			driver.findElement(By.xpath("//a[.='Staff Login']")).click();
			driver.findElement(By.name("staff_id")).sendKeys(staffid);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.name("staff_login-btn")).click();
			driver.findElement(By.xpath("//input[@name='viewdet']")).click();
			
			String expName="Rakshitha";
			
			List<WebElement> nameList = driver.findElements(By.xpath("//td[text()='"+expName+"']"));
			
			for(WebElement name:nameList)
			{
			String name1 = name.getText();
			System.out.println(name1);
			
			if(name1.equalsIgnoreCase(expName))
			
				
			{
				System.out.println("Test case pass");
			}
			
			else
			{
				System.out.println("Test case fail");
			}
			
			
			
	}
			
			
}
}
