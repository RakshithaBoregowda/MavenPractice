package org.Rmb.Automation;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcelSheet 
{
public static void main(String[] args) throws Exception 
{
FileInputStream fis =new FileInputStream("./src/test/resources/TestData.xlsx");

Workbook wb=WorkbookFactory.create(fis);

 Sheet sheet = wb.getSheet("CommonData");
 
 Row row = sheet.getRow(2);
 
 Cell cell = row.getCell(1);
 
 String value=cell.getStringCellValue();
 
 System.out.println(value);
 
 wb.close();
 
 

}
}
