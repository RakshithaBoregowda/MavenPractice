package practice;
import org.testng.annotations.Test;
import org.tyss.rmb.genericUtility.BaseClass;


public class OpenAccount1Test extends BaseClass
{

	@Test

	public void OpenAccount() 
	{

		
		homePageAction.openAccButton();
        openAccountPage.createAccount(map, driver);
        
		String message = webDriverUtility.alertPopUpGetTextAndAccept(driver);
		System.out.println(message);
		
        String applicationNumber = javaUtility.FetchNumFromAlert(message);
		System.out.println(applicationNumber);

		
		commonAct.staffLoginLink();
		staffLogin.staffLogin(StaffID, password);
		adminCommonAct.approveCustomerButton();
		approveAccount.applicatioNumTextField(applicationNumber);
		
		
		String message1 = webDriverUtility.alertPopUpGetTextAndAccept(driver);
		System.out.println(message1);

		webDriverUtility.testValidation(message1, "Account Created Successfully");

	}
}





