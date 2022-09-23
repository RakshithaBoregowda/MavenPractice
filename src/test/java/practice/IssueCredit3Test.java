package practice;

import org.testng.annotations.Test;
import org.tyss.rmb.genericUtility.BaseClass;

public class IssueCredit3Test extends BaseClass
{
	
	@Test 
	public void issueCredit() throws InterruptedException
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
		String accno = javaUtility.FetchNumFromAlert(message1);
		System.out.println(accno);
		
		adminCommonAct.homeButton();
		creditCustomer.issueCredit(accno,"500");
		
		String message2 = webDriverUtility.alertPopUpGetTextAndAccept(driver);
		System.out.println(message2);
		
		webDriverUtility.testValidation(message2, "Amount credited Successfully to customer account");

}
}
