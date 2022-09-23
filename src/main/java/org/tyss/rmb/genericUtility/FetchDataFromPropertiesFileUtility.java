package org.tyss.rmb.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * 
 * @author Rakshitha
 *
 */
public class FetchDataFromPropertiesFileUtility

{
	public String getDataFromProprtiesFile( String key )
	{
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(IConstExternalPath.PROPERTY_PATH);
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		
		
		Properties property=new	Properties(); 
		
		try {
			property.load(fis);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		String value = property.getProperty(key);
		
	  return value;
}
}
