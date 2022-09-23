package org.tyss.rmb.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtilityClass 
{
	/**
	 * This method is used to launch the browsers
	 * @param browser
	 */
	WebDriver driver;
	Actions act;
	private JavascriptExecutor jsExecutor;

	public WebDriver BrowserLaunchingMethod( String browser)
	{

		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();//method chaining
			driver=new ChromeDriver();//abstraction 
		}

		else if(browser.equalsIgnoreCase("FireFox"))
		{
			WebDriverManager.firefoxdriver().setup();//method chaining
			driver=new FirefoxDriver();//abstraction 
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
		return driver;
	}   

	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void MaximizeTheBrowserWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

	/** 
	 * This method is used to wait until the webElement is loaded to the webPage 
	 * @param driver
	 * @param longTimeOuts
	 */
	public void waitTillPageGetLoaded(WebDriver driver, long longTimeOuts)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	}
	/** 
	 * This method is used to select the drop down by index
	 * @param element
	 * @param index
	 */
	public void selectByIndex( WebElement element, int index)
	{

		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/** 
	 * This method is used to select the drop down by visible text
	 * @param element
	 * @param index
	 */
	public void selectByVisibletext( WebElement element, String text)
	{

		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/** 
	 * This method is used to select the drop down by index
	 * @param element
	 * @param index
	 */
	public void selectByValue( WebElement element, String value)
	{

		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * This method is used to accept the pop-up
	 */
	public void alertPopUpAccept()
	{

		driver.switchTo().alert().accept();


	}
	/**
	 * This method is used to fetch text from alert pop up
	 * @return 
	 */

	public void alertPopUpGetText()
	{

		driver.switchTo().alert().getText();

	}

	/**
	 * This method is used to dismiss or cancel the alert pop up
	 * @return 
	 */

	public void alertPopUpDecline(WebDriver driver)
	{

		driver.switchTo().alert().dismiss();

	}

	public void navigatToApplication( String url)

	{
		driver.get(url);
	}

	/**
	 * This method is used to to close the browser
	 * @param driver
	 */
	public void closeBrowser(WebDriver driver)
	{
		driver.quit();

	}

	/** 
	 * This method is used to get text and accept the alert pop up
	 * @return
	 */
	public String alertPopUpGetTextAndAccept(WebDriver driver)
	{
		Alert alert = driver.switchTo().alert();
		String message=alert.getText();
		alert.accept();
		return message;
	}

	public WebDriver openBrowserWithApplication(String browser, long longTimeOuts, String url)

	{
		BrowserLaunchingMethod(browser);
		MaximizeTheBrowserWindow(driver);
		waitTillPageGetLoaded(driver,longTimeOuts );
		navigatToApplication(url);
		return driver;
	}

/**
 * This method is used to initialize the java script executor
 * @param driver
 */

	public void JscInitialization(WebDriver driver)

	{
		jsExecutor = (JavascriptExecutor)driver;

	}

/**
 * This method is used to open the application using java script 
 */
	public void openApplicationUsingJS(String url)
	{
		jsExecutor.executeScript("window.location=arguments[0]",url);
	}

/**
 * This method is used to perform sendKeys action using java script
 * @param element
 * @param data
 */
	public void sendKeysUsingJS(WebElement element, String data)
	{
		jsExecutor.executeScript("arguments[0].value=arguments[1]",element, data);

	} 

	public void clickUsingJsc(WebElement element)
	{
		jsExecutor.executeScript("arguments[0].click()",element);
	}

	public void scrollTillElementUsingJsc(WebElement element) 
	{
		jsExecutor.executeScript("arguments[0].scrollIntoView()",element);
	}


	public void initializeActions()
	{
		act = new Actions(driver);
	}
/**
 * This method is used to perform mouse hover action
 * @param element
 */
	public void moveToElement(WebElement element)
	{

		act.moveToElement(element).perform();
	}

	/** 
	 * This method is used to validate the test script
	 * @param actual
	 * @param expected
	 */
	public void testValidation(String actual, String expected)
	{
		SoftAssert soft=new SoftAssert();
		soft.assertTrue(actual.contains(expected));
		Reporter.log(expected,true);
		soft.assertAll();

	}
	
	/**
	 * This method is used to validate the account number
	 * @param driver
	 * @param Expected
	 */
	public void tesvalidation(WebDriver driver, String Expected)
	{
		 List<WebElement> accList = driver.findElements(By.xpath("//th[text()='#']/following::tr/td[4]"));
		for(WebElement element:accList)
		{
			String accnum = element.getText();
			System.out.println(accnum);
			Assert.assertEquals(accnum, Expected);
		}
		System.out.println("Account found in DB");
		
	}
	
/**
 * This method is used to take the screenshot
 * @param driver
 * @param javaUtility
 * @param className
 * @throws IOException
 */
	public void screenShot(WebDriver driver, JavaUtility javaUtility, String className) throws IOException
	{
		String currentTime = javaUtility.currentTime();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/"+className+"_"+currentTime+".png");
		FileUtils.copyFile(src, dst);



	}
/**This method is used to take the screenshot 
 * This method  
 * @param driver
 * @param javaUtility
 * @param className
 * @return
 * @throws IOException
 */
	public String screenShotAbsolute(WebDriver driver, JavaUtility javaUtility, String className) throws IOException
	{
		String currentTime = javaUtility.currentTime();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/"+className+"_"+currentTime+".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	}
	
/**
 * This method is used to take  screenshot in BASE64 Format 
 * @param driver
 * @return
 */
	public String screenShotBase64(WebDriver driver)
	{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		String tempPath = ts.getScreenshotAs(OutputType.BASE64);
		return tempPath;
	}

}








