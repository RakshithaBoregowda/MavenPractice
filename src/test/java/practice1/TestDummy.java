package practice1;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.tyss.rmb.genericUtility.FetchDataFromExcelUtility;
import org.tyss.rmb.genericUtility.IConstExternalPath;

public class TestDummy {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{

       //Excel file
		FetchDataFromExcelUtility excelUtility = new FetchDataFromExcelUtility();
		excelUtility.openExcel(IConstExternalPath.EXCEL_PATH);
		List<Map<String, String>> list = excelUtility.getDataFromExcelInList("Sheet1");
		System.err.println(list.get(1).get("Name"));
		

		


		
}
}