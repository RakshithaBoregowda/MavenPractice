package testng_Practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Prac1Test 
{

	
	@Test
	public void script1()
	
	{
		System.out.println("class--1 script-1");
	}
	
	
	@Test
	public void script2()
	
	{
		Reporter.log("class--1 script-2");
		
	}
	
}
