
package org.Rmb.Automation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromPropertyFile 
{
public static void main(String[] args) throws IOException
{
//step1 convert the physical file into java readable object
	
	FileInputStream fis =new FileInputStream("./src/test/resources/commanData.properties");
	
	// step2 create the object for properties
	Properties property=new	Properties(); 
	
	// step3 load all the keys
	property.load(fis);
	
	//Step4 fetch the data
	String url=property.getProperty("url").trim();
	String StaffID=property.getProperty("StaffID").trim();
	String password=property.getProperty("password").trim();
		
	
	System.out.println(url);
	
	System.out.println(StaffID);
	System.out.println(password);
	
}

}
