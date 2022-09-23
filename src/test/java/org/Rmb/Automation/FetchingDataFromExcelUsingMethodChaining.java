package org.Rmb.Automation;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingDataFromExcelUsingMethodChaining 
{
public static void main(String[] args) throws Exception
{
	FileInputStream fis =new FileInputStream("./src/test/resources/TestData.xlsx");
	
	Workbook wb=WorkbookFactory.create(fis);
	DataFormatter df=new DataFormatter();
	Sheet sheet = wb.getSheet("CommonData");
	String data = df.formatCellValue(sheet.getRow(1).getCell(1));
	System.out.println(data);
}
}
