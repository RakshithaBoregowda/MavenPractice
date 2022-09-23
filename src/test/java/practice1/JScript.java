package practice1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.tyss.rmb.genericUtility.WebDriverUtilityClass;

import io.github.bonigarcia.wdm.WebDriverManager;

	
		public class JScript 
		{
		public static void main(String[] args) 
		{
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			WebDriverUtilityClass webDriverUtility=new WebDriverUtilityClass();
			driver.manage().window().maximize();
			webDriverUtility.JscInitialization(driver);
			
			webDriverUtility.openApplicationUsingJS("http://rmgtestingserver/domain/Online_Banking_System/index.php");
			webDriverUtility.clickUsingJsc(driver.findElement(By.xpath("//li[text()='Open Account']")));
			webDriverUtility.sendKeysUsingJS(driver.findElement(By.cssSelector("[placeholder='Name']")),"Rakshitha");
			
			

		}
		}
			

