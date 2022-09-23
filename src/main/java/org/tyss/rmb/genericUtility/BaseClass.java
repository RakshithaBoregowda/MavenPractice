package org.tyss.rmb.genericUtility;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.rmb.objectRepository.AdminPageCommonActions;
import org.rmb.objectRepository.ApplyDebitCard;
import org.rmb.objectRepository.ApprovePendingAccount;
import org.rmb.objectRepository.CommonActions;
import org.rmb.objectRepository.CreditCustomer;
import org.rmb.objectRepository.DeleteCustomer;
import org.rmb.objectRepository.HomePageCommonActions;
import org.rmb.objectRepository.OpenAccountPage;
import org.rmb.objectRepository.StaffLoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class BaseClass 
{

	protected WebDriver driver;
	protected WebDriverUtilityClass webDriverUtility;
	protected FetchDataFromExcelUtility excelUtility;
	protected HomePageCommonActions homePageAction;
	protected FetchDataFromPropertiesFileUtility propertyUtility;
	protected AdminPageCommonActions adminCommonAct;
	protected ApprovePendingAccount approveAccount;
	protected OpenAccountPage openAccountPage;
	protected JavaUtility javaUtility;
	protected CommonActions commonAct;
	protected StaffLoginPage staffLogin;
	
	protected CommonActions commonActions;
	protected HomePageCommonActions homePageActions;
	protected ApplyDebitCard debitCard;
	protected CreditCustomer creditCustomer;
	protected DeleteCustomer deleteCustomer;

	public static WebDriver sdriver;
	public  static JavaUtility sjavaUtility;



	protected Map<String, String> map;
	protected String StaffID;
	protected String password;
	protected String url;
/**
 * Initialize all the Utility class
 * Open the Excel, property file and read the common data
 * @throws EncryptedDocumentException
 * @throws IOException
 */

	@BeforeClass
	public void classSetUp() throws EncryptedDocumentException, IOException
	{

		//create instances for Generic utility 
		excelUtility = new FetchDataFromExcelUtility(); 
		propertyUtility=new FetchDataFromPropertiesFileUtility();
		webDriverUtility = new WebDriverUtilityClass();
		javaUtility=new JavaUtility();
		
		sjavaUtility= javaUtility;

		//initialize the property file and excel file

		excelUtility.openExcel(IConstExternalPath.EXCEL_PATH);
		StaffID=propertyUtility.getDataFromProprtiesFile("StaffID");
		password=propertyUtility.getDataFromProprtiesFile("password");
		url = propertyUtility.getDataFromProprtiesFile("url");

	}
	
	/**
	 * create the instance for browser(launch browser)
	 * maximize, implicit wait
	 * create instance for common object repository (driver)'Login to application
	 */
	@BeforeMethod
	public void MethodSetUp1()
	{
		map =excelUtility.getDataFromExcelInMap("OpenAcc1");
		driver=webDriverUtility.openBrowserWithApplication("chrome",10,url );
		
		sdriver=driver;
		
		// create object for POM 
		approveAccount = new ApprovePendingAccount(driver);
		homePageAction=new HomePageCommonActions(driver);
		adminCommonAct=new AdminPageCommonActions(driver);
		commonActions=new CommonActions(driver);
		homePageActions=new HomePageCommonActions(driver);
		debitCard=new ApplyDebitCard(driver);
		deleteCustomer=new DeleteCustomer(driver);

		creditCustomer=new CreditCustomer(driver); 
		openAccountPage=new OpenAccountPage(driver);
		staffLogin=new StaffLoginPage(driver);
		commonAct=new CommonActions(driver);
	}

	@AfterMethod //logout
	public void MethodTearDown()
	{

		webDriverUtility.closeBrowser(driver);
	}

	@AfterClass //close the browser
	public void classTearDown() throws IOException

	{

		excelUtility.closeExcel();

	}


}
