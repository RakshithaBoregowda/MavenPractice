package org.Rmb.Automation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser 
{
public static void main(String[] args) {
	
	
String browser="chrome";
WebDriver driver=null;

//chrome browser
if(browser.equalsIgnoreCase("chrome"))
{
WebDriverManager.chromedriver().setup();
driver=new ChromeDriver();
}
//fireFox browser
else if(browser.equalsIgnoreCase("FireFox"))
{
WebDriverManager.firefoxdriver().setup();
driver=new FirefoxDriver();
}
else if(browser.equalsIgnoreCase("edge"))
{
WebDriverManager.edgedriver().setup();
driver=new EdgeDriver();
}
else
{
System.out.println("please enter valid browser key");	
}
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("http://rmgtestingserver/domain/Online_Banking_System/");
}
}
