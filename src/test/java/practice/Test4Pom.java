
package practice;
import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.rmb.objectRepository.AdminPageCommonActions;
import org.rmb.objectRepository.ApprovePendingAccount;
import org.rmb.objectRepository.CommonActions;
import org.rmb.objectRepository.DeleteCustomer;
import org.rmb.objectRepository.HomePageCommonActions;
import org.rmb.objectRepository.OpenAccountPage;
import org.rmb.objectRepository.StaffLoginPage;
import org.tyss.rmb.genericUtility.FetchDataFromExcelUtility;
import org.tyss.rmb.genericUtility.FetchDataFromPropertiesFileUtility;
import org.tyss.rmb.genericUtility.IConstExternalPath;
import org.tyss.rmb.genericUtility.JavaUtility;
import org.tyss.rmb.genericUtility.WebDriverUtilityClass;


public class Test4Pom
{
	public static void main(String[] args) throws ParseException, InterruptedException, IOException 
{
		WebDriverUtilityClass webDriverUtility = new WebDriverUtilityClass();
		JavaUtility javaUtility=new JavaUtility();

		//Excel file
		FetchDataFromExcelUtility excelUtility = new FetchDataFromExcelUtility();
		FetchDataFromPropertiesFileUtility propertyUtility=new FetchDataFromPropertiesFileUtility();

		String url = propertyUtility.getDataFromProprtiesFile("url");
		String staffid = propertyUtility.getDataFromProprtiesFile("StaffID");
		String password = propertyUtility.getDataFromProprtiesFile("password");


		excelUtility.openExcel(IConstExternalPath.EXCEL_PATH);
		Map<String, String> map = excelUtility.getDataFromExcelInMap("OpenAcc1");

		WebDriver driver = webDriverUtility.openBrowserWithApplication("chrome",10,url );


		HomePageCommonActions homePageAction=new HomePageCommonActions(driver);
		homePageAction.openAccButton();

		OpenAccountPage openAccountPage=new OpenAccountPage(driver);
		openAccountPage.createAccount(map, driver);
		//Alert
		String message = webDriverUtility.alertPopUpGetTextAndAccept(driver);
		String applicationNumber = javaUtility.FetchNumFromAlert(message);
		System.out.println(applicationNumber);

        CommonActions commonAct=new CommonActions(driver);
		commonAct.staffLoginLink();

		StaffLoginPage staffLogin=new StaffLoginPage(driver);
		staffLogin.staffLogin(staffid, password);


		//Approve account 
		AdminPageCommonActions adminCommonAct=new AdminPageCommonActions(driver);
		adminCommonAct.approveCustomerButton();

		ApprovePendingAccount approveAccount=new ApprovePendingAccount(driver);
		approveAccount.applicatioNumTextField(applicationNumber);

		//Alert account number
		String message1 = webDriverUtility.alertPopUpGetTextAndAccept(driver);
		String accno = javaUtility.FetchNumFromAlert(message1);
		System.out.println(accno);
		
		 String custid = javaUtility.FetchCustid(accno);
		 System.out.println(custid);

		 AdminPageCommonActions adminCommonAction=new AdminPageCommonActions(driver);
		 adminCommonAction.homeButton();
		
		 DeleteCustomer deleteCustomer=new DeleteCustomer(driver);
		 deleteCustomer.deleteCustomerAccount(accno, custid, "Inactive");
		 
		 String msg = webDriverUtility.alertPopUpGetTextAndAccept(driver);
		 System.out.println(msg);
		
		 webDriverUtility.testValidation(msg, "customer deleted successfully".concat("---->Test case passed"));
		 
    
	
	}
}



