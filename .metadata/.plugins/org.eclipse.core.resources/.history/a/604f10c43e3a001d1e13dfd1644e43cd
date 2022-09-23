package Org_Automation_Test_NG;

import org.testng.annotations.Test;

import Org.GenericUtility.Base_Class;

public class DebitCardTest extends Base_Class
{
	@Test
	public void debitCard() throws InterruptedException
	{
		comAction.OpenAccount();

		openAccountPage.createAccount(map, driver);
		String message = webDriverUtility.alertHandle(driver);
		String applicationNumber = javaUtility.fetchNumFromAlert(message);

		comAction.StaffLoginButton();

		staffLoginPage.loginAction(staffid, password);

		adminCommonAction.approvePendingAcountButton();

		approvePendingAccountPage.approveAccount( applicationNumber);
		webDriverUtility.explicitWaitMethodForAlert(driver);
		String message1 = webDriverUtility.alertHandle(driver);
		String accountNumber = javaUtility.fetchNumFromAlert(message1);
		System.out.println(message1);
		webDriverUtility.verifyAccountNumber(driver, accountNumber);
		adminCommonAction.adminLogoutButton();
		comAction.HomeButton();
		comAction.ApplyDebitCardButton();
		applyDebitCardPage.applyDbCard(map, accountNumber);
		
		


		String dbmessage = webDriverUtility.alertHandle(driver);
	
		comAction.HomeButton();

		webDriverUtility.testCaseValidationUsingSoftAssert(dbmessage, "Debit Card issued successfully");

		

	}
}
