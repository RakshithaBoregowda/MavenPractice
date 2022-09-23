package org.tyss.rmb.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener
{
	private ExtentReports reports;
	private ExtentTest test;
	public static ExtentTest stests;

	@Override//@AM
	public void onFinish(ITestContext context) 
	{
		
		reports.flush();
	}

	@Override//@BT
	public void onStart(ITestContext context) {
		
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport/extentreport.html");
		spark.config().setDocumentTitle("Document Title -SDET 40");
		spark.config().setReportName("Report Name-SDET 40");
		spark.config().setTheme(Theme.STANDARD);
		
		reports=new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("Author", "Rakshitha");
		reports.setSystemInfo("OS", "Windows");
		reports.setSystemInfo("Browser", "Chrome");
	}
	

	@Override//@AM
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override//@AM
	public void onTestFailure(ITestResult result) 
	{
		

		test.fail(result.getMethod().getMethodName()+"fail");
		test.fail(result.getThrowable());
		System.out.println(Thread.currentThread().getId());
		
		WebDriverUtilityClass webdriverUtility =new WebDriverUtilityClass();
		String path = webdriverUtility.screenShotBase64(BaseClass.sdriver);
	    test.addScreenCaptureFromBase64String(path);
	     
	
	}

	@Override//@AM
	public void onTestSkipped(ITestResult result) 
	{
		
		
	}

	@Override//@BM
	public void onTestStart(ITestResult result) 
	{
		test=reports.createTest(result.getMethod().getMethodName()+"pass");
		stests=test;
		
	}

	@Override//@AM
	public void onTestSuccess(ITestResult result) 
	{
		test.pass(result.getMethod().getMethodName());	
		
	}

}
