package org.tyss.rmb.genericUtility;

/**
 * This interface consist all the file external paths 
 * @author Rakshitha
 *
 */

public interface IConstExternalPath 
{
	 String PROJECT_PATH=System.getProperty("user.dir");
     String EXCEL_PATH=PROJECT_PATH+"./src/test/resources/TestData.xlsx";
     String PROPERTY_PATH=PROJECT_PATH+"./src/test/resources/commanData.properties";
     String DB_URL="jdbc:mysql://localhost:3306/tyss";
     
}
