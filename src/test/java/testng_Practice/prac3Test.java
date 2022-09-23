package testng_Practice;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class prac3Test 
{
	@BeforeSuite
	public void script1()
	{
		System.out.println("before suite");
	}
	
	
	@BeforeClass
	public void script2()
	{
		System.out.println("before class");
	}
	
	
	@BeforeTest
	public void script3()
	{
		System.out.println("before test");
	}
	
	
	@BeforeMethod
	public void script4()
	{
		System.out.println("before method");
	}
	

	@BeforeMethod
	public void script5()
	{
		System.out.println("before method");
	}
	
	@Test
	public void script6()
	{
		System.out.println("after test");
	}
	
	@Test
	public void script7()
	{
		System.out.println("test2");
	}
	
	@Test
	public void script8()
	
	
	
	{
		System.out.println("test3");
	}
}
