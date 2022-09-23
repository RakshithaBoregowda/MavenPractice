package org.Rmb.Automation;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		
		FileInputStream fis =new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Ajio");
		
		String url = sheet.getRow(0).getCell(1).getStringCellValue();
		String category = sheet.getRow(1).getCell(1).getStringCellValue();
	    
		WebDriverManager.chromedriver().setup();
		//Handle the Notification
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-Notifications");
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get(url);
		driver.findElement(By.xpath("//input[@name='searchVal']")).sendKeys(category ,Keys.ENTER);
		
		
		
		}
	}
