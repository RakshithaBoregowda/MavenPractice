package practice;

import org.testng.annotations.Test;
import org.tyss.rmb.genericUtility.BaseClass;

public class ApplyDebitCard2Test extends BaseClass
{
	@Test 
	public void applyDebitCard() 
	
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
		
		

		
		commonActions.homeLink();
		homePageActions.applyDebitCard();
		debitCard.applyDebitCard(map, accno);
		
		webDriverUtility.testValidation(message1, "Debit Card issued successfully");

		  
}
}



