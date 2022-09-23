package org.Rmb.Automation;

import org.testng.annotations.Test;
import org.tyss.rmb.genericUtility.WebDriverUtilityClass;

public class MavenPractice2Test
{
	@Test
	public void step1Test()
	{


		String browser=System.getProperty("b");
		String url=System.getProperty("u");

		System.out.println("Browser name is====>"+browser);
		System.out.println("url is ===>"+url);
		
		WebDriverUtilityClass webDriverUtility=new WebDriverUtilityClass();
		webDriverUtility.openBrowserWithApplication(browser, 10, url);
		

	}
}
