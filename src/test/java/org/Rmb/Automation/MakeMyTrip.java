package org.Rmb.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip 
{
public static void main(String[] args) 
{
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.get("https://www.makemytrip.com/");
	
	driver.findElement(By.xpath("//span[text()='From']")).click();
	driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
	
	driver.findElement(By.xpath("//span[text()='To']"));
	driver.findElement(By.xpath("//p[text()='New Delhi, India']")).click();

	
    driver.findElement(By.xpath("//p[text()='31']")).click();
	driver.findElement(By.xpath("//a[text()='Search']")).click();
	
	
	
	
}
}
