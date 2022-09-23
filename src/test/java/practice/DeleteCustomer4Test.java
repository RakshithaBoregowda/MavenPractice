
package practice;

import org.testng.annotations.Test;
import org.tyss.rmb.genericUtility.BaseClass;

public class DeleteCustomer4Test extends BaseClass
{

	@Test 
	public void deleteCustomer() 
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
		String custid = javaUtility.FetchCustid(accno);
		System.out.println(custid);

		adminCommonAct.homeButton();
		deleteCustomer.deleteCustomerAccount(accno, custid, "Inactive");


		String msg = webDriverUtility.alertPopUpGetTextAndAccept(driver);
		System.out.println(msg);

		webDriverUtility.testValidation(msg, "customer deleted successfully".concat("---->Test case passed"));


	}
}
